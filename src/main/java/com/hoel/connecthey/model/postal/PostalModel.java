package com.hoel.connecthey.model.postal;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PostalModel implements Serializable {
   private static final long serialVersionUID = 1L;

   private String cep;
   private String uf;
   private String cidade;
   private String bairro;
   private String logradouro;
   private String aux;

}
