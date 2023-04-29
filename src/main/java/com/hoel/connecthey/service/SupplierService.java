package com.hoel.connecthey.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hoel.connecthey.enums.ErrorResponse;
import com.hoel.connecthey.exception.InvalidInput;
import com.hoel.connecthey.exception.ResourceNotFound;
import com.hoel.connecthey.model.SupplierModel;
import com.hoel.connecthey.model.postal.PostalModel;
import com.hoel.connecthey.repository.SupplierRepository;

@Service
public class SupplierService extends SharedService {

   @Autowired
   private SupplierRepository repository;

   private PostalModel postalModel;

   // create
   public SupplierModel create(SupplierModel supplier) {
      supplier.setCreatedAt(LocalDateTime.now());
      supplier.setUpdatedAt(LocalDateTime.now());
      
      supplier.setCnpjCpfSupplier(clear(supplier.getCnpjCpfSupplier()));
      supplier.setPostalSupplier(clear(supplier.getPostalSupplier()));
      supplier.setRgSupplier(clear(supplier.getRgSupplier()));

      // if supplier has CPF
      if (!supplier.getIsCnpjSupplier()) {

         // if rg is null, then throw exception
         if (supplier.getRgSupplier().isEmpty()
               || supplier.getBirthdaySupplier().toString().isEmpty()) {
            throw new InvalidInput(ErrorResponse.RgOrBirthdayNull.getText());
         }

         postalModel = getPostal(supplier.getPostalSupplier());

         // if supplier is postal UF = PR
         if (postalModel == null){
            throw new InvalidInput("Postal is null");
         } else if (postalModel.getUf() == "PR"
               && LocalDate.now().isBefore(supplier.getBirthdaySupplier().plusYears(18))) {
            throw new InvalidInput(ErrorResponse.Under18InPR.getText());
         }
      }

      return this.repository.save(supplier);

   }

   // read
   public List<SupplierModel> findAll() {
      return repository.findAll();
   }

   public SupplierModel findById(UUID id) {
      return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFound(ErrorResponse.SupplierNotFoundId.getText() + id));
   }

   // update
   public SupplierModel update(SupplierModel supplier) {
      hasId(supplier);

      supplier.setUpdatedAt(LocalDateTime.now());

      return repository.save(supplier);
   }

   // delete
   public void delete(SupplierModel supplier) {
      hasId(supplier);

      repository.delete(supplier);
   }

   // support
   private void hasId(SupplierModel supplier) {
      if (supplier.getIdSupplier() == null) {
         throw new InvalidInput(ErrorResponse.NoId.getText());
      }
   }

}
