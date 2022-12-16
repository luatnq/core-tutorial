package com.example.coreexception;

public class BadRequestException extends BaseException {
  public BadRequestException() {
    super();
    setStatus(400);
  }
}
