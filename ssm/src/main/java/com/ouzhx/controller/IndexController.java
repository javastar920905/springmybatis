package com.ouzhx.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/4/15.
 */
@RestController
@RequestMapping("index")
public class IndexController {
  @Value("${application.message:Hello World}")
  private String message = "Hello World";

  @GetMapping(value = "/")
  public ModelAndView pageIndex() {
    ModelAndView modelAndView = new ModelAndView("welcome");
    modelAndView.addObject("time", new Date());
    modelAndView.addObject("message", message);
    return modelAndView;
  }

  @GetMapping(value = "/hello")
  public String hello() {
    return "hello" + "hot33";
  }
}
