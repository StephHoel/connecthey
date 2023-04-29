package com.hoel.connecthey.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import com.google.gson.Gson;
import com.hoel.connecthey.enums.ErrorResponse;
import com.hoel.connecthey.exception.InvalidInput;
import com.hoel.connecthey.model.postal.PostalModel;

@Service
public class SharedService {

   private String uri = "http://cep.la/";

   public PostalModel getPostal(String zipCode) {

      PostalModel postalModel = null;

      try {
         uri += zipCode;
         URL url = new URL(uri);

         HttpURLConnection conn = (HttpURLConnection) url.openConnection();

         conn.setRequestMethod("GET");
         conn.setRequestProperty("Accept", "application/json");

         BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

         String inputLine;
         StringBuffer response = new StringBuffer();

         while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
         }
         in.close();

         Gson gson = new Gson();

         String r = response.toString().replace("[", "").replace("]", "");

         if (r == "") {
            throw new InvalidInput(ErrorResponse.PostalNotValid.getText());
         }

         postalModel = gson.fromJson(r, PostalModel.class);

      } catch (Exception ex) {
         ex.printStackTrace();

         if (ex.getMessage() == "") {
            throw new RestClientException(ErrorResponse.ApiError.getText());
         } else {
            throw new InvalidInput(ex.getMessage());
         }
      }

      return postalModel;
   }

   public String clear(String cnpjCpf) {

      cnpjCpf = cnpjCpf.replace("/", "");
      cnpjCpf = cnpjCpf.replace(".", "");
      cnpjCpf = cnpjCpf.replace("-", "");

      return cnpjCpf;
   }
}
