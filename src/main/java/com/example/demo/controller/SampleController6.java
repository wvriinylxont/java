package com.example.demo.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import java.util.*;

@Controller
public class SampleController6 {
  // 마지막 했던 예제를 double형으로 바꿔서 재작성
  // List<Double>list = new ArrayList<>();
  private List<Double> list = new ArrayList<>();

  public SampleController6() {
    list.add(0.0);
    list.add(0.0);
    list.add(0.0);
  }
  @GetMapping("/list/list")
  public ModelAndView list() {
    double hap = 0.0;
    for(double num:list) {
      hap += num;
    }
    double avg = list.isEmpty() ? 0.0 : hap / list.size();
    return new ModelAndView("list/list").addObject("hap", hap).addObject("avg", avg);
  }
  @PostMapping("/list/add")
  public ModelAndView add(double num) {
    list.add(num);
    return new ModelAndView("redirect:/list/list");
  }
}
