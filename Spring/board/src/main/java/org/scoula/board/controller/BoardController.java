package org.scoula.board.controller;

import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller // Bean 등록
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

	final private BoardService service;

	@GetMapping("/list") // GET /board/list
	public void list(Model model) { // 리턴타입이 void이므로 요청 url로 주소 지정하겠다는 뜻 -> view 이름: board/list
		log.info("list");
		model.addAttribute("list", service.getList());
	}

	@GetMapping("/create")
	public void create() {
		log.info("create");
	}

	@PostMapping("/create")
	public String create(BoardDTO board) {
		log.info("create: " + board);
		service.create(board);
		return "redirect:/board/list";
	}

	@GetMapping({"/get"}) // GET /board/get & GET /board/update
	public void get(@RequestParam("no") Long no, Model model) {
		log.info("/get or update");
		model.addAttribute("board", service.get(no));
	}

	@PostMapping("/update")
	public String update(BoardDTO board) {
		log.info("update: " + board);
		service.update(board);
		return "redirect:/board/list";
	}

	@PostMapping("/delete")
	public String delete(@RequestParam("no") Long no) {
		log.info("delete..." + no);
		service.delete(no);
		return "redirect:/board/list";
	}
}
