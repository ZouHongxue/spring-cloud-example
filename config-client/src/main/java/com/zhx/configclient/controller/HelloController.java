package com.zhx.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hongxue.zou @Date 2021-01-27 @Time 15:18
 */
@RestController
public class HelloController {

  @Value("${eureka.client.serviceUrl.defaultZone}")
  private String port;

  @GetMapping("/hi")
  public String hi() {
    return "remote host is " + port;
  }
}
