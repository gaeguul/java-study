package org.scoula.board.controller;

import java.util.List;

import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/board") // 관례상 api로 시작한다
@RequiredArgsConstructor
@Log4j2
@Api(tags = "게시글 관리")
public class BoardController {
	private final BoardService service;

	@GetMapping("")
	@ApiOperation(value = "게시글 목록", notes = "게시글 목록을 얻는 API")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "성공적으로 요청이 처리되었습니다.", response = BoardDTO.class),
		@ApiResponse(code = 400, message = "잘못된 요청입니다."),
		@ApiResponse(code = 500, message = "서버에서 오류가 발생했습니다.")
	})
	public ResponseEntity<List<BoardDTO>> getList() {
		return ResponseEntity.ok(service.getList());
	}

	@GetMapping("/{no}")
	@ApiOperation(value = "게시글 상세정보", notes = "게시글 상세정보 얻는 API")
	public ResponseEntity<BoardDTO> get(
		@ApiParam(value = "게시글 ID", required = true, example = "1")
		@PathVariable Long no) {
		return ResponseEntity.ok(service.get(no));
	}

	@PostMapping("")
	@ApiOperation(value = "게시글 생성", notes = "게시글 생성 API")
	public ResponseEntity<BoardDTO> create(
		@ApiParam(value = "게시글 객체", required = true)
		@RequestBody BoardDTO board) {
		// 새 게시글 생성 후 결과 반환
		BoardDTO createdBoard = service.create(board);
		return ResponseEntity.ok(createdBoard);
	}

	@PutMapping("/{no}")
	@ApiOperation(value = "게시글 수정", notes = "게시글 수정 API")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "성공적으로 요청이 처리되었습니다.", response = BoardDTO.class),
		@ApiResponse(code = 400, message = "잘못된 요청입니다."),
		@ApiResponse(code = 500, message = "서버에서 오류가 발생했습니다.")
	})
	public ResponseEntity<BoardDTO> update(
		@ApiParam(value = "게시글 ID", required = true, example = "1")
		@PathVariable Long no,
		@ApiParam(value = "게시글 객체", required = true)
		@RequestBody BoardDTO board) {
		// 게시글 번호 설정 (안전성을 위해)
		board.setNo(no);
		BoardDTO updatedBoard = service.update(board);
		return ResponseEntity.ok(updatedBoard);
	}

	@DeleteMapping("/{no}")
	@ApiOperation(value = "게시글 삭제", notes = "게시글 삭제 API")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "성공적으로 요청이 처리되었습니다."),
		@ApiResponse(code = 400, message = "잘못된 요청입니다."),
		@ApiResponse(code = 500, message = "서버에서 오류가 발생했습니다.")
	})
	public ResponseEntity<BoardDTO> delete(
		@ApiParam(value = "게시글 ID", required = true, example = "1")
		@PathVariable Long no) {
		log.info("============> 게시글 삭제: " + no);

		// 삭제된 게시글 정보를 반환
		BoardDTO deletedBoard = service.delete(no);
		return ResponseEntity.ok(deletedBoard);
	}
}
