package com.qotsa.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application launch method.
 */
@SpringBootApplication
public class Main {

  /**
   * The entry point of the Queens of the Stone Age API application.
   *
   * <p>
   * This method starts the Spring Boot application by invoking the
   * {@link SpringApplication#run(Class, String...)}
   * method with the {@link Main} class and command-line arguments.
   * It initializes the application and starts the embedded server
   * to handle HTTP requests.
   * </p>
   *
   * @param args The command-line arguments passed to the application.
   */
  public final void main(final String[] args) {
    SpringApplication.run(Main.class, args);
  }
}
