package com.exam.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.domain.Board;
import com.exam.repository.BoardDao;

@Service("bls")
public class BoardListService {
	private BoardDao boardDao;
	
	public BoardListService() {}
	
	@Autowired
	public BoardListService(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	public Collection<Board> boardList() {
		Collection<Board> list = boardDao.getList();
		return list;
	}
}
