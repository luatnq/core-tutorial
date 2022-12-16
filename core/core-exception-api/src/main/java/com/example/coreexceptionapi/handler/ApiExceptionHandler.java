package com.example.coreexceptionapi.handler;

import com.example.coreexception.BaseException;
import com.example.coreexceptionapi.model.ErrorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Locale;
import java.util.Map;

@RequiredArgsConstructor
@ControllerAdvice
@Slf4j
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

  private final MessageSource messageSource;

  @ExceptionHandler(BaseException.class)
  public ResponseEntity<ErrorResponse> handleException(BaseException ex, WebRequest webRequest) {
    log.info("(handleException)ex: {}, locale: {}", ex.getCode(), webRequest.getLocale());

    return new ResponseEntity<>(
        getError(ex.getStatus(), ex.getCode(), webRequest.getLocale(), ex.getParams()),
        HttpStatus.valueOf(ex.getStatus())
    );
  }

  private ErrorResponse getError(int status, String code, Locale locale, Map<String, String > params) {
    return ErrorResponse.of(status, code, getMessage(code, locale, params));
  }

  private String getMessage(String code, Locale locale, Map<String, String> params) {
    var message = messageSource.getMessage(code, null, locale);
    if (params != null && !params.isEmpty()) {
      for (var param: params.entrySet()) {
        message = message.replace(getMessageParamsKey(param.getKey()), param.getValue());
      }
    }
    return message;
  }

  private String getMessageParamsKey(String key) {
    return "%" + key + "%";
  }
}
