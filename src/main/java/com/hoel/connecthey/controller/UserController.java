package com.hoel.connecthey.controller;

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

import com.hoel.connecthey.model.UserModel;
import com.hoel.connecthey.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/api")
@Tag(name = "Connect Hey API")
@CrossOrigin(origins = "*")
public class UserController {
   @Autowired
   private UserService service;

   // create
   @PostMapping("/user/new")
   @Operation(summary = "user", description = "create a new user")
   public ResponseEntity<UserModel> create(@RequestBody UserModel user) {
      return new ResponseEntity<UserModel>(service.create(user), HttpStatus.CREATED);
   }

   @GetMapping("/user/{id}")
   @Operation(summary = "supplier", description = "find a supplier by it's id")
   public ResponseEntity<UserModel> getById(@PathVariable(value = "id") UUID id) {
      return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
   }

   // read
   @PostMapping("/user")
   @Operation(summary = "user", description = "find a user registred")
   public ResponseEntity<UserModel> findByLogin(@RequestBody String user, String pass) {
      return new ResponseEntity<>(service.findByLogin(user, pass), HttpStatus.OK);
   }

   // update
   @PutMapping("/user")
   @Operation(summary = "user", description = "update a user")
   public ResponseEntity<UserModel> update(@RequestBody UserModel user) {
      return new ResponseEntity<>(service.update(user), HttpStatus.OK);
   }

   // delete
   @DeleteMapping("/user")
   @Operation(summary = "user", description = "delete a user")
   public ResponseEntity<HttpStatus> delete(@RequestHeader UUID id) {
      UserModel user = getById(id).getBody();
      service.delete(user);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }
   
}
