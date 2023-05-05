package com.hoel.connecthey.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hoel.connecthey.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {

   @Query(value = "select * from USERS where NAME_USER = ?1 and PASSWORD_USER = ?2", nativeQuery = true)
   UserModel findByLogin(String name, String pass);

   // @Query(value = "select * from USER where LOWER(NAME_USER) LIKE '%' || ?1 ||
   // '%'", nativeQuery = true)
   // List<UserModel> findAllByName(String name);

   // @Query(value = "select * from USER where LOWER(CNPJ_CPF_USER) LIKE '%' || ?1
   // || '%'", nativeQuery = true)
   // List<UserModel> findAllByDoc(String doc);

}