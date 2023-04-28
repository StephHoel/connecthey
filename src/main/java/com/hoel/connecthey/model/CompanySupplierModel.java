package com.hoel.connecthey.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "COMPANY_SUPPLIER")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CompanySupplierModel implements Serializable {
   private static final long serialVersionUID = 1L;

   @Id
   @Column(name = "ID_COMPANY_SUPPLIER")
   @GeneratedValue(strategy = GenerationType.AUTO)
   private UUID idCompanySupplier;

   @ManyToMany
   @JoinColumn(name = "ID_SUPPLIER")
   private UUID idSupplier;

   @ManyToMany
   @JoinColumn(name = "ID_COMPANY")
   private UUID idCompany;

   @Column(name = "CREATED_AT", nullable = false)
   private LocalDateTime createdAt;

   // para criar relacionamentos:
   // @ManyToOne
   // @JoinColumn(name = "forumId")
   // private Forum forum;
}
