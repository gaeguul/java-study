package org.scoula.board.service;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.domain.BoardVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.mapper.BoardMapper;
import org.scoula.common.util.UploadFiles;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor // final 필드를 인자로 가지는 생성자 추가
public class BoardServiceImpl implements BoardService {

	private final static String BASE_DIR = "/Users/jiham/Desktop/board";

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

	// 2개 이상의 insert 문이 실행될 수 있으므로 트랜잭션 처리가 필요하다
	// RuntimeException인 경우에만 자동 Rollback
	@Transactional
	@Override
	public BoardDTO create(BoardDTO dto) {
		log.info("create........." + dto);

		BoardVO vo = dto.toVo(); // DTO -> VO
		mapper.create(vo); // DB에 저장
		dto.setNo(vo.getNo()); // 생성된 PK를 DTO에 설정한다

		// 파일업로드 처리
		List<MultipartFile> files = dto.getFiles();
		if (files != null && !files.isEmpty()) { // 첨부파일이 존재하는 경우
			upload(vo.getNo(), files);
		}

		return get(vo.getNo());
	}

	@Override
	public BoardDTO update(BoardDTO dto) {
		log.info("update........." + dto);

		BoardVO vo = dto.toVo();
		int affectedRows = mapper.update(vo);
		return get(vo.getNo());
	}

	@Override
	public BoardDTO delete(Long no) {
		log.info("delete........." + no);
		BoardDTO board = get(no); // 리턴을 위해 임시 저장
		int affectedRows = mapper.delete(no);
		return board;
	}

	// 클라이언트가 서버로 제출한 파일은 바로 서버 hdd에 저장되지 않고
	// 임시 RAM에 저장됨
	private void upload(Long bno, List<MultipartFile> files) {
		for (MultipartFile part : files) {
			if (part.isEmpty())
				continue;
			try {
				// 파일을 서버에 저장
				String uploadPath = UploadFiles.upload(BASE_DIR, part);
				// 첨부파일 정보를 DB에 저장
				BoardAttachmentVO attach = BoardAttachmentVO.of(part, bno, uploadPath);
				mapper.createAttachment(attach); // 예외 발생하면 아래 RuntimeException으로 바꿈
			} catch (IOException e) {
				// @Transactional에서 감지할 수 있도록 RuntimeException으로 변환
				throw new RuntimeException(e); // @Transactional에서 감지, 자동 rollback
			}
		}

	}

	// 첨부파일 한 개 얻기
	@Override
	public BoardAttachmentVO getAttachment(Long no) {
		return mapper.getAttachment(no);
	}

	// 첨부파일 삭제
	@Override
	public boolean deleteAttachment(Long no) {
		return mapper.deleteAttachment(no) == 1;
	}

}
