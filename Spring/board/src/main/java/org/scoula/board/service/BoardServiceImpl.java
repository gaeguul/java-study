package org.scoula.board.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.scoula.board.domain.BoardVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor // final 필드를 인자로 가지는 생성자 추가
public class BoardServiceImpl implements BoardService {

	// @Autowired 비권장
	// 생성자 1개인 경우 생성자 주입으로 초기화
	private final BoardMapper mapper;

	@Override
	public List<BoardDTO> getList() {
		log.info("getList........");
		return mapper.getList().stream() // List<BoardVO> -> Stream<BoardVO>
			.map(BoardDTO::of) //  Stream<BoardVO> -> Stream<BoardDTO>
			.toList(); // Stream<BoardDTO> -> List<BoardDTO>
	}

	@Override
	public BoardDTO get(Long no) {
		log.info("get........" + no);

		BoardVO vo = mapper.get(no); // DB에서 VO 조회
		BoardDTO dto = BoardDTO.of(vo); // VO -> DTO 변환

		// 데이터가 없으면 null을 던지지 않고 예외 발생시킨다
		// null 던지면 처리하기 어려워짐
		return Optional.ofNullable(dto) // null 안전성 처리
			.orElseThrow(NoSuchElementException::new); // 없으면 예외 발생
	}

	@Override
	public void create(BoardDTO dto) {
		log.info("create........." + dto);

		BoardVO vo = dto.toVo(); // DTO -> VO
		mapper.create(vo); // DB에 저장
		dto.setNo(vo.getNo()); // 생성된 PK를 DTO에 설정한다
	}

	@Override
	public boolean update(BoardDTO dto) {
		log.info("update........." + dto);

		BoardVO vo = dto.toVo();
		int affectedRows = mapper.update(vo);
		return affectedRows == 1;
	}

	@Override
	public boolean delete(Long no) {
		log.info("delete........." + no);

		int affectedRows = mapper.delete(no);
		return affectedRows == 1;
	}
}
