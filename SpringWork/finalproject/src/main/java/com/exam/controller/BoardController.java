package com.exam.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.exam.domain.Board;
import com.exam.service.BoardService;


@Controller
@RequestMapping("/board")
public class BoardController{
	
	private BoardService boardSvc;
	
	@Autowired
	public BoardController(BoardService boardSvc) {
		super();
		this.boardSvc = boardSvc;
	}


	public BoardController() {}
	

	@GetMapping("/list")
	public ModelAndView list() throws Exception {
		Collection<Board> list = boardSvc.getList();
		ModelAndView mv = new ModelAndView("/board/list");
		mv.addObject("list", list);
		return mv;
	}
	
	@GetMapping("/write")
	public String write() {
		return "board/write";
	}
	
	@PostMapping("/write")
	public String write(@ModelAttribute Board board) throws Exception {
		boardSvc.write(board);	
		return "redirect:/board/list";
	}
	
	@RequestMapping("/read/${bNo}")
	public String read(int bNo) {
		return null;
	}
	
	@RequestMapping("/delete")
	public String delete() {
		return null;
	}
	
	
}
