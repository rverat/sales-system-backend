/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.system.controller;

import com.mycompany.system.model.business.UserSystem;
import com.mycompany.system.service.UserService;
import com.mycompany.system.util.JwtTokenUtil;
import com.mycompany.system.util.PasswordUtils;
import com.nimbusds.jose.JOSEException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author ro
 */
@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_OCTET_STREAM_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<List<UserSystem>> findAll(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) throws ParseException, JOSEException {

        ResponseEntity HTTP_EXCEPTION = JwtTokenUtil.validateToken(token);
        if (HTTP_EXCEPTION != null) return HTTP_EXCEPTION;

        String userName = JwtTokenUtil.getUsernameFromToken(token);
        Optional<UserSystem> userSystem = service.findByUserName(userName);

        if (!userSystem.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if(userSystem.get().getTypeUser().equals("admin")){
            return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
        }else {
            List<UserSystem> userSystems = new ArrayList<>();
            userSystems.add(userSystem.get());
            return new ResponseEntity<>(userSystems, HttpStatus.OK);
        }

    }

    @PostMapping(path = "/login", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_OCTET_STREAM_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<UserSystem> login(@RequestBody UserSystem userSystem) {


        Optional<UserSystem> userSystemOptional = service.findByUserName(userSystem.getUserName());

        if (!userSystemOptional.isPresent()) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);


        } else {
            UserSystem userSystemRs = userSystemOptional.get();

            try {
                if (!(PasswordUtils.verifyPassword(userSystem.getUserPassword(), userSystemRs.getUserPassword()))) {
                    return new ResponseEntity<>(HttpStatus.FORBIDDEN);
                }
                String token = JwtTokenUtil.generateToken(userSystemRs.getUserName());
                System.out.println(token);
                userSystemRs.setToken(token);
                return new ResponseEntity<>(userSystemRs, HttpStatus.OK);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            } catch (InvalidKeySpecException e) {
                throw new RuntimeException(e);
            } catch (JOSEException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @PostMapping(path = "/logout", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_OCTET_STREAM_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<HttpStatus> logout(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) throws ParseException, JOSEException {

        ResponseEntity HTTP_EXCEPTION = JwtTokenUtil.validateToken(token);
        if (HTTP_EXCEPTION != null) return HTTP_EXCEPTION;

        return JwtTokenUtil.invalidateToken(token);
    }


    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestBody UserSystem userSystem) throws ParseException, JOSEException {


        Optional<UserSystem> existingUser = service.findByUserName(userSystem.getUserName());
        if (existingUser.isPresent()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        ResponseEntity HTTP_EXCEPTION = JwtTokenUtil.validateToken(token);
        if (HTTP_EXCEPTION != null) return HTTP_EXCEPTION;

        String hashedPassword;
        try {
            hashedPassword = PasswordUtils.hashPassword(userSystem.getUserPassword());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }

        userSystem.setUserPassword(hashedPassword);
        service.save(userSystem);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<HttpStatus> update(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestBody UserSystem userSystem) throws ParseException, JOSEException {

        Optional<UserSystem> existingUser = service.findByUserName(userSystem.getUserName());
        if (existingUser.isPresent() && !(existingUser.get().getId() == userSystem.getId())) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        ResponseEntity HTTP_EXCEPTION = JwtTokenUtil.validateToken(token);
        if (HTTP_EXCEPTION != null) return HTTP_EXCEPTION;

        String hashedPassword;
        try {
            hashedPassword = PasswordUtils.hashPassword(userSystem.getUserPassword());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }

        userSystem.setUserPassword(hashedPassword);
        service.update(userSystem);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @PathVariable int id) throws ParseException, JOSEException {

        ResponseEntity HTTP_EXCEPTION = JwtTokenUtil.validateToken(token);
        if (HTTP_EXCEPTION != null) return HTTP_EXCEPTION;

        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
