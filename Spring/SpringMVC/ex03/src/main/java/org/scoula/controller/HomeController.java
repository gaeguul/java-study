package org.scoula.controller;

import lombok.extern.log4j.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
public class HomeController {
  @GetMapping("/")
  public String home(Model model) {
    // Controller에서 View로 데이터 전달할 때 Model 사용한다
    model.addAttribute("title", "Spring 2일차");
    model.addAttribute("name", "홍길동");
    return "index"; // view 이름
  }
}
