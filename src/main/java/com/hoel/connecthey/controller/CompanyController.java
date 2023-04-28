package com.hoel.connecthey.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hoel.connecthey.model.CompanyModel;
import com.hoel.connecthey.service.CompanyService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/api")
@Tag(name = "Connect Hey API")
@CrossOrigin(origins = "*")
public class CompanyController {
   @Autowired
   private CompanyService service;

   // create
   @PostMapping("/company")
   @Operation(summary = "company", description = "create a new company")
   public ResponseEntity<CompanyModel> create(@RequestBody CompanyModel company) {
      return new ResponseEntity<CompanyModel>(service.create(company), HttpStatus.CREATED);
   }

   // read
   @GetMapping("/company")
   @Operation(summary = "company", description = "find all companies registred")
   public ResponseEntity<List<CompanyModel>> getAll() {
      return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
   }

   @GetMapping("/company/{id}")
   @Operation(summary = "company", description = "find a company by it's id")
   public ResponseEntity<CompanyModel> getById(@PathVariable(value = "id") UUID id) {
      return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
   }

   // update
   @PutMapping("/company")
   @Operation(summary = "company", description = "update a company")
   public ResponseEntity<CompanyModel> update(@RequestBody CompanyModel company) {
      return new ResponseEntity<>(service.update(company), HttpStatus.OK);
   }

   // delete
   @DeleteMapping("/company")
   @Operation(summary = "company", description = "delete a company")
   public ResponseEntity<HttpStatus> delete(@RequestHeader UUID id) {
      CompanyModel company = getById(id).getBody();
      service.delete(company);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }

}
