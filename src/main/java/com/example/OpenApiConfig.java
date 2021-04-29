package com.example;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import lombok.Generated;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Generated
@Configuration
@RequiredArgsConstructor
public class OpenApiConfig {

  @Value("${spring.application.name}")
  private String title;
  private final BuildProperties buildProperties;

  /**
   * Configure the OpenApi bean.
   *
   * @return the OpenApi bean.
   */
  @Bean
  public OpenAPI openApi() {
    return new OpenAPI()
      .info(new Info()
        .title(title)
        .version(buildProperties.getVersion())
        .license(new License()
          .name("Apache 2.0")
          .url("http://www.apache.org/licenses/LICENSE-2.0")));
  }
}
