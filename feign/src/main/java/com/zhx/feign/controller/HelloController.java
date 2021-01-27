package com.zhx.feign.controller;

import com.zhx.feign.service.HiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hongxue.zou @Date 2021-01-26 @Time 17:07
 */
@RestController
public class HelloController {

  private HiService hiService;

  HelloController(HiService hiService) {
    this.hiService = hiService;
  }

  @GetMapping("/hi")
  public String hi(@RequestParam String name) {
    return hiService.sayHi(name);
  }
}
