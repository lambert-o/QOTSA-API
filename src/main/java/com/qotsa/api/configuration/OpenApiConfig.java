package com.qotsa.api.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for customizing OpenAPI documentation.
 */
@Configuration
public class OpenApiConfig {

  @Value("${openapi.info.title}")
  private String title;

  @Value("${openapi.info.description}")
  private String description;

  @Value("${openapi.info.version}")
  private String version;

  /**
   * Creates a custom OpenAPI object with specified title, description, and version.
   *
   * @return The custom OpenAPI object.
   */
  @Bean
  public OpenAPI customOpenApi() {
    return new OpenAPI()
            .info(new Info()
                    .title(title)
                    .description(description)
                    .version(version));
  }
}
