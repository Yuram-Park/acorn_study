package com.exam.repository;

import java.util.List;
import java.util.Map;

import com.exam.domain.Board;
import com.exam.domain.BoardImageDto;
import com.exam.domain.Mp_File;

public interface BoardDao {
	public List<Board> getList() throws Exception;
	public Board read(int bNo) throws Exception;
	public int write(Board board) throws Exception;
	public int update(Board board) throws Exception;
	public int delete(int bNo) throws Exception;
	public void insertFile(BoardImageDto boardImageDto) throws Exception;
	public List<BoardImageDto> selectBoardImage(int bNo) throws Exception;
}
