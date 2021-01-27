package com.zhx.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author hongxue.zou @Date 2021-01-26 @Time 16:03
 */
@FeignClient(value = "eureka-client")
public interface HiService {
  /**
   * say hi
   * @param name name
   * @return return
   */
  @GetMapping(value = "/hi")
  String sayHi(@RequestParam(value = "name") String name);
}
