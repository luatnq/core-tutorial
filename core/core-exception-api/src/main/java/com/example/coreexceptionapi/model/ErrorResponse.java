package com.example.coreexceptionapi.model;

import lombok.Data;

@Data
public class ErrorResponse {
  private int status;
  private String code;
  private String message;

  public static ErrorResponse of (int status, String code, String message) {
    var error = new ErrorResponse();
    error.setStatus(status);
    error.setCode(code);
    error.setMessage(message);
    return error;
  }
}
