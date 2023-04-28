package com.hoel.connecthey.model;

import java.io.Serializable;
import java.time.LocalDate;
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
import lombok.NoArgsConstructor;

@Data
@Table(name = "SUPPLIER")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SupplierModel implements Serializable {
   private static final long serialVersionUID = 1L;

   @Id
   @Column(name = "ID_SUPPLIER")
   @GeneratedValue(strategy = GenerationType.AUTO)
   private UUID idSupplier;

   @Column(name = "CNPJ_CPF_SUPPLIER", unique = true, nullable = false)
   @NotNull
   @Pattern(regexp = "^([0-9]{2}[.]?[0-9]{3}[.]?[0-9]{3}[/]?[0-9]{4}[-]?[0-9]{2})$|^([0-9]{3}[.]?[0-9]{3}[.]?[0-9]{3}[-]?[0-9]{2})$")
   private String cnpjCpfSupplier;

   @Column(name = "IS_CNPJ_SUPPLIER")
   private Boolean isCnpjSupplier;

   @Column(name = "NAME_SUPPLIER", nullable = false)
   private String nameSupplier;

   @NotNull
   @Pattern(regexp = "^[0-9]{2}[.]?[0-9]{3}[-]?[0-9]{3}$")
   @Column(name = "POSTAL_SUPPLIER", nullable = false)
   private String postalSupplier;

   @Email
   @Column(name = "EMAIL_SUPPLIER", nullable = false)
   private String emailSupplier;

   @Pattern(regexp = "^[0-9]{2}[.]?[0-9]{3}[.]?[0-9]{3}[-]?[0-9]{1}$")
   @Column(name = "RG_SUPPLIER")
   private String rgSupplier;

   @Column(name = "BRITHDAY_SUPPLIER")
   private LocalDate birthdaySupplier;

   @Column(name = "CREATED_AT", nullable = false)
   private LocalDateTime createdAt;

   @Column(name = "UPDATED_AT", nullable = false)
   private LocalDateTime updatedAt;

}
