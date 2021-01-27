package com.zhx.loadbalance.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author hongxue.zou @Date 2021-01-26 @Time 15:31
 */
@RestController
public class HelloController {

  @Value("${spring.application.name}")
  private String name;

  private final RestTemplate restTemplate;

  HelloController(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @GetMapping("/hi")
  public String hi() {
    return restTemplate.getForObject("http://EUREKA-CLIENT/hi?name=" + name, String.class);
  }
}
