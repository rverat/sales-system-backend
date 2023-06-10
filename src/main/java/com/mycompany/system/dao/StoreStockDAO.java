/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.system.dao;

import com.mycompany.system.model.thirdparty.StoreStockDTO;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ro
 */
@Repository
public interface StoreStockDAO extends JpaRepository<StoreStockDTO, Integer>, JpaSpecificationExecutor<StoreStockDTO> {
 
    public Optional<StoreStockDTO> findByProductIdAndStoreId(int productId, int storeId);

    //@Query("SELECT p FROM StoreStockDTO p WHERE (p.product.id, p.store.id) IN :productIdAndStoreIdList")
    //Optional<List<StoreStockDTO>> findProductsByIdAndCategoryIdList(@Param("productIdAndStoreIdList") List<Tuple> productIdAndStoreIdList);


}
