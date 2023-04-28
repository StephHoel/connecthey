package com.hoel.connecthey.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hoel.connecthey.model.SupplierModel;

@Repository
public interface SupplierRepository extends JpaRepository<SupplierModel, UUID> {
   
}
