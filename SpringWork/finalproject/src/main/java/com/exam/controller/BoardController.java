package com.exam.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.exam.domain.Board;
import com.exam.service.BoardListService;
import com.exam.service.BoardWriteService;

@Controller
@RequestMapping("/board")
public class BoardController{
	@Autowired
	private BoardWriteService bws;
	
	@Autowired
	private BoardListService bls;
	
	public BoardController() {}
	

	@GetMapping("/list")
	public ModelAndView list() {
		Collection<Board> list = bls.boardList();
		ModelAndView mv = new ModelAndView("/WEB-INF/views/board/list.jsp");
		mv.addObject("list", list);
		return mv;
	}
	
	@GetMapping("/write")
	public String write() {
		return "/WEB-INF/views/board/write.jsp";
	}
	
	@RequestMapping("/read")
	public String read() {
		return null;
	}
	
	@RequestMapping("/delete")
	public String delete() {
		return null;
	}
	
	@PostMapping("/write.proc")
	public ModelAndView write_proc(String bTitle, String bWriter, String bContent) {
		Board board = new Board(bTitle, bContent, bWriter);
		bws.boardWrite(board);
		ModelAndView mv = new ModelAndView("redirect:/board/list");
		return mv;
	}
}
