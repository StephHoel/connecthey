package com.hoel.connecthey;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

import com.hoel.connecthey.model.CompanyModel;
import com.hoel.connecthey.repository.CompanyRepository;
import com.hoel.connecthey.service.CompanyService;
import com.hoel.connecthey.service.SharedService;

@SpringBootTest
public class CompanyServiceTest extends SharedService {
   List<CompanyModel> list = new ArrayList<>();

   @InjectMocks
   private CompanyService service;

   @Mock
   private CompanyRepository repository;

   @BeforeEach
   void setUp() {
      MockitoAnnotations.openMocks(this);

      LocalDateTime dateTimeNow = LocalDateTime.now();

      CompanyModel companyPF = new CompanyModel(UUID.randomUUID(),
            "37344853791", "Steph Hoel",
            "89.812-675", "steph@hoel.com",
            dateTimeNow, dateTimeNow);

      CompanyModel companyPF2 = new CompanyModel(UUID.randomUUID(),
            "373.448.537-01", "Mariah Hoel",
            "21.320-090", "mariah@hoel.com",
            dateTimeNow, dateTimeNow);

      CompanyModel companyPF3 = new CompanyModel(UUID.randomUUID(),
            "373.448.537-21", "Senna Andrade",
            "87.860-970", "Senna@Andrade.com",
            dateTimeNow, dateTimeNow);

      CompanyModel companyPF4 = new CompanyModel(UUID.randomUUID(),
            "373.448.537-31", "Senna Andrade",
            "89.812-675", "Senna@Andrade.com",
            dateTimeNow, dateTimeNow);

      CompanyModel companyPJ = new CompanyModel(UUID.randomUUID(),
            "37.344/8537-11", "Hoel Company",
            "89.812-675", "steph@hoel.com",
            dateTimeNow, dateTimeNow);

      list.add(companyPF);
      list.add(companyPF2);
      list.add(companyPF3);
      list.add(companyPF4);
      list.add(companyPJ);
   }

   @Test
   void create() {

      CompanyModel company = list.get(0);

      CompanyModel expected = company;
      expected.setCnpjCompany(clear(company.getCnpjCompany()));
      expected.setPostalCompany(clear(company.getPostalCompany()));

      when(repository.save(company)).thenReturn(company);
      CompanyModel response = service.create(company);

      Assertions.assertEquals(expected.getCnpjCompany(), response.getCnpjCompany());
      verify(repository, times(1)).save(any());
   }

   @Test
   void findAll() {
      when(repository.findAll()).thenReturn(list);
      List<CompanyModel> companies = service.findAll();
      Assertions.assertEquals(companies, list);
      verify(repository, times(1)).findAll();
   }

   @Test
   void findById() {
      when(repository.findById(any())).thenReturn(Optional.ofNullable(list.get(0)));
      CompanyModel task = service.findById(list.get(0).getIdCompany());
      Assertions.assertEquals(task, list.get(0));
      verify(repository, times(1)).findById(any());
   }

   @Test
   void findAllByName() {
      when(repository.findAllByName(any())).thenReturn(list);
      List<CompanyModel> company = service.findAllByName(list.get(0).getFantasyNameCompany());
      Assertions.assertEquals(company, list);
      verify(repository, times(1)).findAllByName(any());
   }

   @Test
   void findAllByDoc() {
      when(repository.findAllByDoc(any())).thenReturn(list);
      List<CompanyModel> company = service.findAllByDoc(list.get(0).getCnpjCompany());
      Assertions.assertEquals(company, list);
      verify(repository, times(1)).findAllByDoc(any());
   }

   @Test
   void delete() {
      doNothing().when(repository).delete(any());
      service.delete(list.get(0));
      verify(repository, times(1)).delete(any());
   }

   @Test
   void update() {
      CompanyModel company = list.get(0);
      company.setUpdatedAt(LocalDateTime.now());
      when(repository.save(company)).thenReturn(company);
      CompanyModel response = service.update(company);
      Assertions.assertEquals(company.getUpdatedAt(), response.getUpdatedAt());
      verify(repository, times(1)).save(any());
   }

}
