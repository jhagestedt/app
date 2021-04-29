package com.example;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = App.class)
public class OpenApiTest {

  @Test
  public void json() throws IOException {
    try (BufferedInputStream in = new BufferedInputStream(new URL("http://localhost:8080/openapi").openStream());
         FileOutputStream fileOutputStream = new FileOutputStream("target/openapi.json")) {
      byte[] dataBuffer = new byte[1024];
      int bytesRead;
      while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
        fileOutputStream.write(dataBuffer, 0, bytesRead);
      }
    } catch (IOException e) {
      Assertions.fail();
    }
  }
}
