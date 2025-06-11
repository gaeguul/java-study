package org.scoula.todo.service;

import java.util.*;
import lombok.*;
import lombok.extern.log4j.*;
import org.scoula.todo.domain.*;
import org.scoula.todo.mapper.*;
import org.springframework.stereotype.*;

@Log4j2
@Service // 서비스 계층임을 명시, Bean 등록
@RequiredArgsConstructor // final 필드 초기화
public class TodoServiceImpl implements TodoService {

  private final TodoMapper todoMapper;

  @Override
  public List<TodoDTO> selectAll() {
    // todo 테이블의 모든 내용을 조회하는 Mapper 호출 -> 결과 반환
    List<TodoDTO> todos = todoMapper.selectAll();
    log.info("조회된 todo 개수: {}", todos.size());
    return todos;
  }

  @Override
  public int insertTodo(TodoDTO todo) {
    int count = todoMapper.insertTodo(todo); // INSERT 수행 후 결과 행 개수 반환
    log.info("삽입된 행의 개수: {}", count);
    return count;
  }

  @Override
  public int updateTodo(Long id) {
    int count = todoMapper.updateTodo(id);
    log.info("수정된 행의 개수: {}", count);
    return count;
  }

  @Override
  public int deleteTodo(Long id) {
    int count = todoMapper.deleteTodo(id);
    log.info("삭제된 행의 개수: {}", count);
    return count;
  }
}
