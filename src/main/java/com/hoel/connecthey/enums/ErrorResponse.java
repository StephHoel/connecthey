package com.hoel.connecthey.enums;

public enum ErrorResponse {

   // Generic Errors
   ApiError("Invalid response from API"),
   NoId("There is no ID"),
   PostalNotValid("This Zip Code is not valid"),

   // Supplier Errors
   Under18InPR("The person providing is in PR and is under 18 years old"),
   RgOrBirthdayNull("Supplier document or birthday not recorded"),
   SupplierNotFoundId("Supplier not found with ID: "),

   // Company Errors
   CompanyNotFoundId("Company not found with ID: "),
   
   // Finish - Not Use Please
   NoError("");

   ErrorResponse(String text){
      this.text=text;
   }

   private String text;

   public String getText() {
      return this.text;
   }

}
