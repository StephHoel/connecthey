package com.hoel.connecthey.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hoel.connecthey.enums.ErrorResponse;
import com.hoel.connecthey.exception.InvalidInput;
import com.hoel.connecthey.exception.ResourceNotFound;
import com.hoel.connecthey.model.UserModel;
import com.hoel.connecthey.repository.UserRepository;

@Service
public class UserService extends SharedService {

   @Autowired
   private UserRepository repository;

   // create
   public UserModel create(UserModel user) {
      user.setCreatedAt(LocalDateTime.now());
      user.setUpdatedAt(LocalDateTime.now());
      user.setIdUser(UUID.randomUUID());

      user.setNameUser(user.getNameUser().toLowerCase().trim());
      user.setUsernameUser(user.getUsernameUser().toLowerCase().trim());
      user.setPasswordUser(user.getPasswordUser().toLowerCase().trim());
      user.setEmailUser(user.getEmailUser().toLowerCase().trim());
      user.setDocUser(clear(user.getDocUser().trim()));

      return this.repository.save(user);

   }

   // read
   public List<UserModel> findAll() {
      return repository.findAll();
   }

   public UserModel findByLogin(String name, String pass) {
      return repository.findByLogin(name, pass);
   }

   public UserModel findById(UUID id) {
      return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFound(ErrorResponse.SupplierNotFoundId.getText() + id));
   }

   // update
   public UserModel update(UserModel user) {
      hasId(user);

      user.setUpdatedAt(LocalDateTime.now());

      return repository.save(user);
   }

   // delete
   public void delete(UserModel user) {
      hasId(user);

      repository.delete(user);
   }

   // support
   private void hasId(UserModel user) {
      if (user.getIdUser() == null) {
         throw new InvalidInput(ErrorResponse.NoId.getText());
      }
   }
}
