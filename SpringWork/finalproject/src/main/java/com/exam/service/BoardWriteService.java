package com.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.domain.Board;
import com.exam.repository.BoardDao;

@Service("bws")
public class BoardWriteService {
	private BoardDao boardDao;
	
	public BoardWriteService() {}
	
	@Autowired
	public BoardWriteService(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	// 글쓰기
	public void boardWrite(Board board) {
		boardDao.setWrite(board);
	}
}
