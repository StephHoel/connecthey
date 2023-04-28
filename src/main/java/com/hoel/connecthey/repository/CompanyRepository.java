package com.hoel.connecthey.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hoel.connecthey.model.CompanyModel;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyModel, UUID> {
   
}
