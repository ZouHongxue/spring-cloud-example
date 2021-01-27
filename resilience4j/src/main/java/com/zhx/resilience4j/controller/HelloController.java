package com.zhx.resilience4j.controller;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author hongxue.zou @Date 2021-01-26 @Time 17:41
 */
@RestController
public class HelloController {

  @Value("${spring.application.name}")
  private String service;

  private final RestTemplate restTemplate;
  private final CircuitBreakerFactory circuitBreakerFactory;

  HelloController(RestTemplate restTemplate, CircuitBreakerFactory circuitBreakerFactory) {
    this.restTemplate = restTemplate;
    this.circuitBreakerFactory = circuitBreakerFactory;
  }

  @GetMapping("/hi")
  public String hi() {
    return circuitBreakerFactory.create("circuitBreaker").run(() ->
        this.restTemplate.getForObject("http://EUREKA-CLIENT/hi?name=" + service, String.class),
        throwable -> "The service is down");
  }
}
