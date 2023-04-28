package com.hoel.connecthey.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.hoel.connecthey.exception.ErrorMessage;
import com.hoel.connecthey.exception.InvalidInput;
import com.hoel.connecthey.exception.ResourceNotFound;

import java.time.LocalDateTime;

@RestControllerAdvice
public class RestExceptionHandler {
   public ResponseEntity<ErrorMessage> handle(Exception ex, HttpStatus statusCode, String description) {
      ErrorMessage message = new ErrorMessage(statusCode, LocalDateTime.now(), ex.getMessage(), description);
      //statusCode, LocalDateTime.now(), ex.getMessage(), description
      ex.printStackTrace();
      return new ResponseEntity<>(message, message.getStatusCode());
   }

   @ExceptionHandler({ InvalidInput.class })
   public ResponseEntity<ErrorMessage> invalidInputHandler(Exception ex, WebRequest request) {
      return handle(ex, HttpStatus.BAD_REQUEST, request.getDescription(false));
   }

   @ExceptionHandler(ResourceNotFound.class)
   public ResponseEntity<ErrorMessage> resourceNotFoundHandler(Exception ex, WebRequest request) {
      return handle(ex, HttpStatus.NOT_FOUND, request.getDescription(false));
   }
}
