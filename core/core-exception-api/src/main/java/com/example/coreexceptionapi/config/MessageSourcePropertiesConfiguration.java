package com.example.coreexceptionapi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "application.i18n")
@Data
public class MessageSourcePropertiesConfiguration {
  private List<String> resources;
}
