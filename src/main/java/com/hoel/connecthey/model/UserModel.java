package com.hoel.connecthey.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "USERS")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserModel implements Serializable {
   private static final long serialVersionUID = 1L;

   @Id
   @Column(name = "ID_USER")
   @GeneratedValue(strategy = GenerationType.AUTO)
   private UUID idUser;

   @Column(name = "NAME_USER", nullable = false)
   private String nameUser;

   @Column(name = "USERNAME_USER", nullable = false)
   private String usernameUser;

   @Column(name = "PASSWORD_USER", nullable = false)
   private String passwordUser;

   @Column(name = "DOC_USER", nullable = false, unique = true)
   @Pattern(regexp = "^([0-9]{2}[.]?[0-9]{3}[.]?[0-9]{3}[/]?[0-9]{4}[-]?[0-9]{2})$|^([0-9]{3}[.]?[0-9]{3}[.]?[0-9]{3}[-]?[0-9]{2})$")
   private String docUser;

   @Column(name = "IS_CPF_USER", nullable = false)
   private Boolean isCpfUser;

   @Email
   @Column(name = "EMAIL_USER", nullable = false)
   private String emailUser;

   @Column(name = "CREATED_AT", nullable = false)
   private LocalDateTime createdAt;

   @Column(name = "UPDATED_AT", nullable = false)
   private LocalDateTime updatedAt;

}
