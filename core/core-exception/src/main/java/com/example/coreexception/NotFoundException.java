package com.example.coreexception;

public class NotFoundException extends BaseException {
  public NotFoundException() {
    super();
    setStatus(404);
  }
}
