package org.scoula.controller;

import java.util.*;
import lombok.*;
import lombok.extern.log4j.*;
import org.scoula.todo.domain.*;
import org.scoula.todo.service.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
@RequiredArgsConstructor
public class HomeController {

  // TodoService를 상속받아 구현한 TodoServiceImpl Bean 의존성 주입(DI)
  private final TodoService todoService;


  // 메인 페이지
  @GetMapping("/")
  public String home(Model model) {

    // Spring Model 객체: 데이터를 Controller에서 View로 전달하기 위한 객체

    // 전체 할 일 조회 서비스 호출
    List<TodoDTO> todos = todoService.selectAll();

    // 조회 결과를 Model에 담아서 View로 전달한다
    // index에서 todos라는 이름으로 사용 가능
    model.addAttribute("todos", todos);

    log.info("===============> HomeController");
    return "index"; // view 이름
  }
}
