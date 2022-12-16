package com.example.coreexceptionapi.config;

import com.example.coreexceptionapi.handler.ApiExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import static com.example.coreexceptionapi.constant.ExceptionApiConstant.UTF_8_ENCODING;

@Configuration
@ComponentScan(basePackages = {"com.example.coreexceptionapi"})
@Slf4j
public class ApiExceptionConfiguration {

  @Bean
  public ApiExceptionHandler apiExceptionHandler(MessageSource messageSource) {
    return new ApiExceptionHandler(messageSource);
  }

  @Bean
  public MessageSource messageSource(MessageSourcePropertiesConfiguration resource) {
    log.info("(messageSource)resource: {}", resource.getResources());
    var messageSource = new ReloadableResourceBundleMessageSource();
    messageSource.setBasenames(resource.getResources().toArray(String[]::new));
    messageSource.setDefaultEncoding(UTF_8_ENCODING);
    return messageSource;
  }
}
