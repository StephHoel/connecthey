package com.hoel.connecthey.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class OpenApiConfig {

   @Bean
   public OpenAPI customOpenAPI(@Value("${application-description}") String appDesciption,
         @Value("${application-version}") String appVersion,
         @Value("${application-title}") String appTitle) {
      return new OpenAPI()
            .info(new Info()
                  .title(appTitle)
                  .version(appVersion)
                  .description(appDesciption)
                  .contact(new Contact()
                        .name("Stephanye Hoelbriegel")
                        .url("https://github.com/stephhoel")
                        .email("steph.hoel@gmail.com"))
                  .termsOfService("http://swagger.io/terms/")
                  .license(new License().name("Apache 2.0").url("http://springdoc.org")));
   }

}