package com.robert.myschool.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author robert zhao
 * @since 2020/5/25
 */
@RestController
@RequestMapping("data")
public class RedisController {

  @RequestMapping("t1")
  @Cacheable("t1")
  public String getData() {
    return "hello redis";
  }

}
