package com.example.coreexception;

public class ConflictException extends BaseException {
  public ConflictException() {
    super();
    setStatus(409);
  }
}
