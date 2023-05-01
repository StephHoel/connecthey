package com.hoel.connecthey.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hoel.connecthey.model.CompanyModel;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyModel, UUID> {

@Query(value = "SELECT * FROM COMPANY WHERE LOWER(FANTASY_NAME_COMPANY) LIKE '%' || ?1 || '%'", nativeQuery = true)
   List<CompanyModel> findAllByName(String name);

   @Query(value = "select * from COMPANY where LOWER(CNPJ_COMPANY) LIKE '%' || ?1 || '%'", nativeQuery = true)
   List<CompanyModel> findAllByDoc(String doc);
}
