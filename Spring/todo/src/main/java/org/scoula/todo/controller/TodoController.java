package org.scoula.todo.controller;


import lombok.*;
import org.scoula.todo.domain.*;
import org.scoula.todo.service.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller // 컨트롤러 명시 + Bean 등록
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

  private final TodoService todoService; // 의존성 주입

  /// 할일 todo 삽입
  /// todo 커맨드 객체 -> 전달된 파라미터 필드에 저장
  @PostMapping("/insert")
  public String insertTodo(TodoDTO todo) {
    todoService.insertTodo(todo); // 해당 비지니스 로직 호출
    return "redirect:/"; // 메인으로 리다이렉트
  }

  @PostMapping("/update")
  public String updateTodo(@RequestParam("id") Long id) {
    todoService.updateTodo(id);
    return "redirect:/"; // 메인으로 리다이렉트
  }

  @PostMapping("/delete")
  public String deleteTodo(@RequestParam("id") Long id) {
    todoService.deleteTodo(id);
    return "redirect:/"; // 메인으로 리다이렉트
  }

}
