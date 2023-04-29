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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Table(name = "COMPANY")
@AllArgsConstructor
@Entity
public class CompanyModel implements Serializable {
   private static final long serialVersionUID = 1L;

   @Id
   @Column(name = "ID_COMPANY")
   @GeneratedValue(strategy = GenerationType.AUTO)
   private UUID idCompany;

   @Column(name = "CNPJ_COMPANY", unique = true, nullable = false)
   @NotNull
   @Pattern(regexp = "^([0-9]{2}[.]?[0-9]{3}[.]?[0-9]{3}[/]?[0-9]{4}[-]?[0-9]{2})$|^([0-9]{3}[.]?[0-9]{3}[.]?[0-9]{3}[-]?[0-9]{2})$")
   private String cnpjCompany;

   @Column(name = "FANTASY_NAME_COMPANY", nullable = false)
   private String fantasyNameCompany;

   @NotNull
   @Pattern(regexp = "^[0-9]{2}[.]?[0-9]{3}[-]?[0-9]{3}$")
   @Column(name = "POSTAL_COMPANY", nullable = false)
   private String postalCompany;

   @Email
   @Column(name = "EMAIL_COMPANY")
   private String emailCompany;

   @Column(name = "CREATED_AT", nullable = false)
   private LocalDateTime createdAt;

   @Column(name = "UPDATED_AT", nullable = false)
   private LocalDateTime updatedAt;
}
