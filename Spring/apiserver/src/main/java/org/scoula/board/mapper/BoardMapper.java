package org.scoula.board.mapper;

import java.util.List;

import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.domain.BoardVO;

public interface BoardMapper {

	public List<BoardVO> getList();

	public BoardVO get(Long no);

	public void create(BoardVO board);

	public int update(BoardVO board);

	public int delete(Long no);

	// Attachment 관련 CRUD (update는 없음)
	public void createAttachment(BoardAttachmentVO attach);

	public List<BoardAttachmentVO> getAttachmentList(Long bno);

	public BoardAttachmentVO getAttachment(Long no);

	public int deleteAttachment(Long no);
}
