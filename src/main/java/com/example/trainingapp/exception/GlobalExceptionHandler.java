package com.example.trainingapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.trainingapp.dto.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ApiResponse<Object>> handleNotFound(ResourceNotFoundException ex) {
      ApiResponse<Object> response = new ApiResponse<>(404, ex.getMessage(), null);
      return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ApiResponse<Object>> handleGeneric(Exception ex) {
      ApiResponse<Object> response = new ApiResponse<>(500, "Internal Server Error", null);
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}

