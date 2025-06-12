package org.scoula.board.mapper;

import java.util.*;
import org.scoula.board.domain.*;

public interface BoardMapper {

  public List<BoardVO> getList();

  public BoardVO get(Long no);

  public void create(BoardVO board);

  public int update(BoardVO board);

  public int delete(Long no);
}
