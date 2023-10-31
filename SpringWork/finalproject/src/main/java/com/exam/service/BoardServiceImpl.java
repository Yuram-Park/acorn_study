package com.exam.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.exam.domain.Board;
import com.exam.repository.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDao boardDao; //setter메서드가 자동으로 만들어짐
	
	private static final String filePath="C:\\netsong7\\img";

	@Override
	public List<Board> getList() throws Exception {
		List<Board> list = boardDao.getList();
		return list;
	}

	@Override
	public Board read(int bNo) throws Exception {
		Board board = boardDao.read(bNo);
		return board;
	}

	@Override
	public void write(Board board, MultipartFile file) throws Exception {
		boardDao.write(board);

	}

	@Override
	public void update(Board board) throws Exception {
		

	}

	@Override
	public void delete(int bNo) throws Exception {
		

	}

	@Override
	public List<Map<String, Object>> insertFileInfo(Board board, MultipartHttpServletRequest mpRequest)
			throws Exception {
		
		Iterator<String> iterator = mpRequest.getFileNames();
		
		MultipartFile multipartFile = null;
		String originalFileName = null;
		String originalFileExtension = null;
		String storedFileName = null;
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> listMap = null;
		
		int bNo = board.getbNo();
		
		File file = new File(filePath);
		if(file.exists() == false) {
			file.mkdirs();
		}
		
		while(iterator.hasNext()) {
			multipartFile = mpRequest.getFile(iterator.next());
			if(multipartFile.isEmpty() == false) {
				originalFileName = multipartFile.getOriginalFilename();
				originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
				storedFileName = getRandomString() + originalFileExtension;
				
				file = new File(filePath + storedFileName);
				multipartFile.transferTo(file);
				listMap = new HashMap<String, Object>();
				listMap.put("BNO", bNo);
				listMap.put("ORG_FILE_NAME", originalFileName);
				listMap.put("STORED_FILE_NAME", storedFileName);
				listMap.put("FILE_SIZE", multipartFile.getSize());
				list.add(listMap);
			}
		}
		return list;
	}

	@Override
	public String getRandomString() throws Exception {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	
	
	

}
