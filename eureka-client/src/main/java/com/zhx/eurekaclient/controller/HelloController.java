package com.zhx.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hongxue.zou @Date 2021-01-26 @Time 14:27
 */
@RestController
public class HelloController {

  @Value("${server.port}")
  String port;

  @GetMapping("/hi")
  public String home(@RequestParam String name) {
    return "hi " + name + ", I am from port " + port;
  }
}
