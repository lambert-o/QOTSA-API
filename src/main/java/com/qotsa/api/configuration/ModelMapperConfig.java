package com.qotsa.api.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for creating a ModelMapper bean.
 */
@Configuration
public class ModelMapperConfig {

  /**
   * Creates a ModelMapper bean.
   *
   * @return The ModelMapper instance.
   */
  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }
}
