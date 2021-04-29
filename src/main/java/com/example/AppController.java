package com.example;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@Validated
public class AppController {

  /**
   * Debug request url and headers.
   *
   * @param request The http request
   * @param headers The http request headers
   * @return The http request url and headers
   */
  @GetMapping(
    value = "/app",
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<Map<String, Object>> debug(
    HttpServletRequest request,
    @RequestHeader Map<String, Object> headers
  ) {
    HashMap<String, Object> map = new HashMap<>();
    map.put("url", request.getRequestURL().toString());
    map.put("headers", headers);
    return ResponseEntity.ok(map);
  }
}
