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

import com.hoel.connecthey.model.SupplierModel;
import com.hoel.connecthey.service.SupplierService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/api")
@Tag(name = "Connect Hey API")
@CrossOrigin(origins = "*")
public class SupplierController {
   @Autowired
   private SupplierService service;

   // create
   @PostMapping("/supplier")
   @Operation(summary = "supplier", description = "create a new supplier")
   public ResponseEntity<SupplierModel> create(@RequestBody SupplierModel supplier) {
      return new ResponseEntity<SupplierModel>(service.create(supplier), HttpStatus.CREATED);
   }

   // read
   @GetMapping("/supplier")
   @Operation(summary = "supplier", description = "find all companies registred")
   public ResponseEntity<List<SupplierModel>> getAll() {
      return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
   }

   @GetMapping("/supplier/{id}")
   @Operation(summary = "supplier", description = "find a supplier by it's id")
   public ResponseEntity<SupplierModel> getById(@PathVariable(value = "id") UUID id) {
      return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
   }

   // update
   @PutMapping("/supplier")
   @Operation(summary = "supplier", description = "update a supplier")
   public ResponseEntity<SupplierModel> update(@RequestBody SupplierModel supplier) {
      return new ResponseEntity<>(service.update(supplier), HttpStatus.OK);
   }

   // delete
   @DeleteMapping("/supplier")
   @Operation(summary = "supplier", description = "delete a supplier")
   public ResponseEntity<HttpStatus> delete(@RequestHeader UUID id) {
      SupplierModel supplier = getById(id).getBody();
      service.delete(supplier);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }
   
}
