package org.scoula.todo.mapper;

import java.util.*;
import org.apache.ibatis.annotations.*;
import org.scoula.todo.domain.*;


public interface TodoMapper {

  @Select("SELECT * FROM todo ORDER BY id DESC ")
  List<TodoDTO> selectAll();

  int insertTodo(TodoDTO todo);

  int updateTodo(Long id);

  int deleteTodo(Long id);

}
