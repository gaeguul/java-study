package org.scoula.board.domain;

import java.util.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardVO {
  private Long no;
  private String title;
  private String content;
  private String writer;
  private Date regDate;
  private Date updateDate;
}