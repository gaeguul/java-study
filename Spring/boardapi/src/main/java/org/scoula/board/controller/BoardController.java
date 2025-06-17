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

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/board") // 관례상 api로 시작한다
@RequiredArgsConstructor
@Log4j2
public class BoardController {
	private final BoardService service;

	// @GetMapping("")
	// public List<BoardDTO> getList() {
	// 	return service.getList();
	// }

	@GetMapping("")
	public ResponseEntity<List<BoardDTO>> getList() {
		return ResponseEntity.ok(service.getList());
	}

	@GetMapping("/{no}")
	public ResponseEntity<BoardDTO> get(@PathVariable Long no) {
		return ResponseEntity.ok(service.get(no));
	}

	@PostMapping("")
	public ResponseEntity<BoardDTO> create(@RequestBody BoardDTO board) {
		// 새 게시글 생성 후 결과 반환
		BoardDTO createdBoard = service.create(board);
		return ResponseEntity.ok(createdBoard);
	}

	@PutMapping("/{no}")
	public ResponseEntity<BoardDTO> update(@PathVariable Long no, @RequestBody BoardDTO board) {
		// 게시글 번호 설정 (안전성을 위해)
		board.setNo(no);
		BoardDTO updatedBoard = service.update(board);
		return ResponseEntity.ok(updatedBoard);
	}

	@DeleteMapping("/{no}")
	public ResponseEntity<BoardDTO> delete(@PathVariable Long no) {
		log.info("============> 게시글 삭제: " + no);

		// 삭제된 게시글 정보를 반환
		BoardDTO deletedBoard = service.delete(no);
		return ResponseEntity.ok(deletedBoard);
	}
}
