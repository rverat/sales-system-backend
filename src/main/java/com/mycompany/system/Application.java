/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author ro
 */
@SpringBootApplication(scanBasePackages = "com.mycompany.system")
public class Application {
    
     public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
     }
    
}
