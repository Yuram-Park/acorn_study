package com.exam.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.exam.domain.Board;

public interface BoardService {
	public List<Board> getList() throws Exception;
	public Board read(int bNo) throws Exception;
	public void write(Board board, MultipartHttpServletRequest mpRequest) throws Exception;
	public void update(Board board) throws Exception;
	public void delete(int bNo) throws Exception;
	public List<Map<String, Object>> insertFileInfo(Board board, MultipartHttpServletRequest mpRequest) throws Exception;
	public String getRandomString() throws Exception;
}
