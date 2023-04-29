package com.hoel.connecthey;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.hoel.connecthey.model.SupplierModel;
import com.hoel.connecthey.repository.SupplierRepository;
import com.hoel.connecthey.service.SharedService;
import com.hoel.connecthey.service.SupplierService;

@SpringBootTest
public class SupplierServiceTest extends SharedService {
   List<SupplierModel> list = new ArrayList<>();

   @InjectMocks
   private SupplierService service;

   @Mock
   private SupplierRepository repository;

   @BeforeEach
   void setUp() {
      MockitoAnnotations.openMocks(this);

      LocalDate dateNow = LocalDate.now();
      LocalDateTime dateTimeNow = LocalDateTime.now();

      SupplierModel supplierPF = new SupplierModel(UUID.randomUUID(),
            "37344853791", false,
            "Steph Hoel", "89.812-675",
            "steph@hoel.com", "60.038.436-6",
            dateNow.minusYears(20), dateTimeNow, dateTimeNow);

      SupplierModel supplierPF2 = new SupplierModel(UUID.randomUUID(),
            "373.448.537-01", false,
            "Mariah Hoel", "21.320-090",
            "mariah@hoel.com", "60.038.436-6",
            dateNow.minusYears(13), dateTimeNow, dateTimeNow);

      SupplierModel supplierPF3 = new SupplierModel(UUID.randomUUID(),
            "373.448.537-21", false,
            "Senna Andrade", "87.860-970",
            "Senna@Andrade.com", "",
            dateNow.minusYears(13), dateTimeNow, dateTimeNow);

      SupplierModel supplierPF4 = new SupplierModel(UUID.randomUUID(),
            "373.448.537-31", false,
            "Senna Andrade", "89.812-675",
            "Senna@Andrade.com", "",
            dateNow.minusYears(18), dateTimeNow, dateTimeNow);

      SupplierModel supplierPJ = new SupplierModel(UUID.randomUUID(),
            "37.344/8537-11", true,
            "Hoel Company", "89.812-675", "steph@hoel.com", "",
            null, dateTimeNow, dateTimeNow);

      list.add(supplierPF);
      list.add(supplierPF2);
      list.add(supplierPF3);
      list.add(supplierPF4);
      list.add(supplierPJ);
   }

   @Test
   void create() {

      SupplierModel supplier = list.get(0);

      SupplierModel expected = supplier;
      expected.setCnpjCpfSupplier(clear(supplier.getCnpjCpfSupplier()));
      expected.setPostalSupplier(clear(supplier.getPostalSupplier()));
      expected.setRgSupplier(clear(supplier.getRgSupplier()));

      // doReturn(supplier).when(repository).save(supplier);

      when(repository.save(supplier)).thenReturn(supplier);
      SupplierModel response = service.create(supplier);

      Assertions.assertEquals(expected.getCnpjCpfSupplier(), response.getCnpjCpfSupplier());
      verify(repository, times(1)).save(any());
   }

   @Test
   void findAll() {
      when(repository.findAll()).thenReturn(list);
      List<SupplierModel> suppliers = service.findAll();
      Assertions.assertEquals(suppliers, list);
      verify(repository, times(1)).findAll();
   }

   @Test
   void findById() {
      when(repository.findById(any())).thenReturn(Optional.ofNullable(list.get(0)));
      SupplierModel task = service.findById(list.get(0).getIdSupplier());
      Assertions.assertEquals(task, list.get(0));
      verify(repository, times(1)).findById(any());
   }

   @Test
   void delete() {
      doNothing().when(repository).delete(any());
      service.delete(list.get(0));
      verify(repository, times(1)).delete(any());
   }

   @Test
   void update() {
   SupplierModel supplier = list.get(0);
   supplier.setUpdatedAt(LocalDateTime.now());
   when(repository.save(supplier)).thenReturn(supplier);
   SupplierModel response = service.update(supplier);
   Assertions.assertEquals(supplier.getUpdatedAt(), response.getUpdatedAt());
   verify(repository, times(1)).save(any());
   }

}
