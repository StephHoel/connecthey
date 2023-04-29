package com.hoel.connecthey.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "COMPANY_SUPPLIER")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CompanySupplierModel implements Serializable {
   private static final long serialVersionUID = 1L;

   @Id
   @Column(name = "ID_COMPANY_SUPPLIER")
   @GeneratedValue(strategy = GenerationType.AUTO)
   private UUID idCompanySupplier;

   @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "ID_SUPPLIER", referencedColumnName = "ID_SUPPLIER")
   private SupplierModel idSupplier;

   @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "ID_COMPANY", referencedColumnName = "ID_COMPANY")
   private CompanyModel idCompany;

   @Column(name = "CREATED_AT", nullable = false)
   private LocalDateTime createdAt;

   // para criar relacionamentos:
   // @ManyToOne
   // @JoinColumn(name = "forumId")
   // private Forum forum;
}
