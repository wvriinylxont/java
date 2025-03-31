package com.example.demo.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import java.util.*;

@Controller
public class SampleController5 {
  // GET /numbers/list : 루트 페이지(합계, 평균 출력)
  // POST /numbers/add : 숫자 추가하고 루트 페이지 이동

  // 정수를 저장하는 ArrayList를 생성
  // 자바에서 참조변수는 항상 부모
  private List<Integer> numbers = new ArrayList<>();

  // numbers에 값을 3개 추가 -> 생성자는 스프링이 사용
  // 우리가 컨트롤러의 객체를 생성한 적이 있나? 없다 -> @Controller의 객체는 스프링이 생성(제어의 역전)
  @PostMapping
  private void init() {
    numbers.add(10);
    numbers.add(20);
    numbers.add(30);
  }

  @GetMapping("/numbers/list")
  public ModelAndView list() {
    int hap = 0;
    // 파이썬에서 for i in numbers -> 자바에서는 향상된 for문
    for (int i : numbers) {
      hap += i;
    }
    double avg = (double) hap / numbers.size();
    return new ModelAndView("numbers/list").addObject("hap", hap).addObject("avg", avg);
  }

  @PostMapping("/numbers/add")
  public ModelAndView add(int num) {
    numbers.add(num);
    return new ModelAndView("redirect:/numbers/list");
  }
}
