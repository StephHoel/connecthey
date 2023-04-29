package com.hoel.connecthey.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoel.connecthey.enums.ErrorResponse;
import com.hoel.connecthey.exception.InvalidInput;
import com.hoel.connecthey.exception.ResourceNotFound;
import com.hoel.connecthey.model.CompanyModel;
import com.hoel.connecthey.repository.CompanyRepository;

@Service
public class CompanyService extends SharedService {
   @Autowired
   private CompanyRepository repository;

   // create
   public CompanyModel create(CompanyModel company) {
      company.setCreatedAt(LocalDateTime.now());
      company.setUpdatedAt(LocalDateTime.now());
      
      getPostal(company.getPostalCompany());

      return this.repository.save(company);
   }

   // read
   public List<CompanyModel> findAll() {
      return repository.findAll();
   }

   public List<CompanyModel> findAllByName(String name) {
      return repository.findAllByName(name);
   }

   public List<CompanyModel> findAllByDoc(String doc) {
      return repository.findAllByDoc(doc);
   }

   public CompanyModel findById(UUID id) {
      return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFound(ErrorResponse.CompanyNotFoundId.getText() + id));
   }

   // update
   public CompanyModel update(CompanyModel company) {
      hasId(company);

      company.setUpdatedAt(LocalDateTime.now());

      return repository.save(company);
   }

   // delete
   public void delete(CompanyModel company) {
      hasId(company);

      repository.delete(company);
   }

   // support
   private void hasId(CompanyModel company) {
      if (company.getIdCompany() == null) {
         throw new InvalidInput(ErrorResponse.NoId.getText());
      }
   }

}
