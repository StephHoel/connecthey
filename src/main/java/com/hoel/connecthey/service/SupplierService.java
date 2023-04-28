package com.hoel.connecthey.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoel.connecthey.exception.InvalidInput;
import com.hoel.connecthey.exception.ResourceNotFound;
import com.hoel.connecthey.model.SupplierModel;
import com.hoel.connecthey.repository.SupplierRepository;

@Service
public class SupplierService {
   @Autowired
   private SupplierRepository repository;

   // create
   public SupplierModel create(SupplierModel supplier) {
      supplier.setCreatedAt(LocalDateTime.now());
      supplier.setUpdatedAt(LocalDateTime.now());

      return this.repository.save(supplier);
   }

   // read
   public List<SupplierModel> findAll() {
      return repository.findAll();
   }

   public SupplierModel findById(UUID id) {
      return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFound("Supplier not found with ID: " + id));
   }

   // update
   public SupplierModel update(SupplierModel supplier) {
      hasId(supplier);

      supplier.setUpdatedAt(LocalDateTime.now());

      return repository.save(supplier);
   }

   // delete
   public void delete(SupplierModel supplier) {
      hasId(supplier);

      repository.delete(supplier);
   }

   // support
   private void hasId(SupplierModel supplier) {
      if (supplier.getIdSupplier() == null) {
         throw new InvalidInput("There is no ID");
      }
   }

   
}
