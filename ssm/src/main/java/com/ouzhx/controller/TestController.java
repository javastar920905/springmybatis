package com.ouzhx.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/4/15.
 */
@RestController
@RequestMapping("test")
public class TestController {

  @GetMapping(value = "/")
  public String test() {
    return "test ";
  }
}
