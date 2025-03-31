package com.example.demo.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class SampleController4 {
  @GetMapping("/add")
  public ModelAndView addInput() {
    return new ModelAndView("add/input");
  }
  @PostMapping("/add/output")
  public ModelAndView addOutput(int a, int b) {
    int result = a + b;
    String message = a + "+" + b + "=" + result;
    return new ModelAndView("add/output").addObject("message", message);
  }
}
