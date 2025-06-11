package org.scoula.todo.service;

import java.util.*;
import org.scoula.todo.domain.*;

public interface TodoService {
  List<TodoDTO> selectAll();

  int insertTodo(TodoDTO todo);

  int updateTodo(Long id);

  int deleteTodo(Long id);
}
