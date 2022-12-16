package com.example.coreexception;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class BaseException extends RuntimeException {

  private static final long serialVersionUID = 128763123L;

  private String code = "";
  private String message = "";
  private int status = 0;
  private Map<String, String> params;

  public void addParam(String key, String value) {
    if (params == null) {
      params = new HashMap<>();
    }
    params.put(key, value);
  }
}
