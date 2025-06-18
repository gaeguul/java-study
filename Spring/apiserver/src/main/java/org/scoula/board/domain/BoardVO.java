package org.scoula.board.domain;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// VO는 데이터베이스 구조와 동일하게 생김
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
	private List<BoardAttachmentVO> attaches;
}

