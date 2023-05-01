package com.hoel.connecthey.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hoel.connecthey.model.SupplierModel;

@Repository
public interface SupplierRepository extends JpaRepository<SupplierModel, UUID> {
   
   @Query(value = "select * from SUPPLIER where LOWER(NAME_SUPPLIER) LIKE '%' || ?1 || '%'", nativeQuery = true)
 List<SupplierModel> findAllByName(String name);

   @Query(value = "select * from SUPPLIER where LOWER(CNPJ_CPF_SUPPLIER) LIKE '%' || ?1 || '%'", nativeQuery = true)
   List<SupplierModel> findAllByDoc(String doc);
}
