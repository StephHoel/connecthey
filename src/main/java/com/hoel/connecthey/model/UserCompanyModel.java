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
@Table(name = "USER_COMPANY")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserCompanyModel implements Serializable {
   private static final long serialVersionUID = 1L;

   @Id
   @Column(name = "ID_USER_COMPANY")
   @GeneratedValue(strategy = GenerationType.AUTO)
   private UUID idUserCompany;

   @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
   private UserModel user;

   @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "ID_COMPANY", referencedColumnName = "ID_COMPANY")
   private CompanyModel company;

   @Column(name = "CREATED_AT", nullable = false)
   private LocalDateTime createdAt;
   
}
