package com.exam.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.exam.domain.Board;
import com.exam.domain.BoardImageDto;


@Component("fileUtils")
public class FileUtils {
	// 파일 저장할 경로 지정
	private static final String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files\\";
	
	public List<BoardImageDto> parseInsertFileInfo(Board board, MultipartFile[] boardFiles) throws Exception{
		
		List<BoardImageDto> boardImageDtoList = new ArrayList<>();
		System.out.println(filePath);
		if(boardFiles != null) {
			for(MultipartFile multipartFile : boardFiles) {
				// 이미지가 존재하지 않을 때
				if(multipartFile.isEmpty()) {
					continue;
				}
				
				String rootFolder = "C:/uploadFiles/";
				
				// 날짜별 폴더 생성
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				String today = sdf.format(new Date());
				File targetFolder = new File(rootFolder + today);
				
				if(!targetFolder.exists())
					targetFolder.mkdirs();
				
				// 저장 파일명 만들기
				String fileName = UUID.randomUUID().toString();
				fileName += "_" + System.currentTimeMillis();
				
				String originalFileName = multipartFile.getOriginalFilename();
				String ext = originalFileName.substring(originalFileName.lastIndexOf(".")); //.의 위치 찾아서 자름
				
				String saveFileName = rootFolder + today + "/" + fileName + ext;
				
				try {
					multipartFile.transferTo(new File(saveFileName));
				} catch(Exception e){
					System.out.println("parseInsertFileInfo :" + e);
				}
				saveFileName = today + "/" + fileName + ext;
				BoardImageDto boardImageDto = new BoardImageDto();
				boardImageDto.setOriginal_filename(originalFileName);
				boardImageDto.setLink(saveFileName);
				
				boardImageDtoList.add(boardImageDto);
			}
		}
		
		return boardImageDtoList;
	}
		
		
		
		
		
		
		
		
		
		
//		System.out.println(filePath);
//		/*
//			Iterator은 데이터들의 집합체? 에서 컬렉션으로부터 정보를 얻어올 수 있는 인터페이스입니다.
//			List나 배열은 순차적으로 데이터의 접근이 가능하지만, Map등의 클래스들은 순차적으로 접근할 수가 없습니다.
//			Iterator을 이용하여 Map에 있는 데이터들을 while문을 이용하여 순차적으로 접근합니다.
//		*/
//		
//		Iterator<String> iterator = mpRequest.getFileNames();
//		
//		MultipartFile multipartFile = null;
//		String originalFileName = null;
//		String originalFileExtension = null;
//		String storedFileName = null;
//		
//		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
//		Map<String, Object> listMap = null;
//		
//		int bno = board.getbNo();
//		
//		File file = new File(filePath);
//		if(file.exists() == false) {
//			file.mkdirs();
//		}
//		
//		while(iterator.hasNext()) {
//			multipartFile = mpRequest.getFile(iterator.next());
//			if(multipartFile.isEmpty() == false) {
//				originalFileName = multipartFile.getOriginalFilename();
//				originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
//				storedFileName = getRandomString() + originalFileExtension;
//				
//				// File을 생성할건데, filePath경로에 storedFileName으로 생성
//				file = new File(filePath, storedFileName);
//				multipartFile.transferTo(file);
//				listMap = new HashMap<String, Object>();
//				listMap.put("BNO", bno);
//				listMap.put("ORG_FILE_NAME", originalFileName);
//				listMap.put("STORED_FILE_NAME", storedFileName);
//				listMap.put("FILE_SIZE", multipartFile.getSize());
//				list.add(listMap);
//			}
//		}
//		return list;
//	}
	
//	public static String getRandomString() {
//		// 식별자. 랜덤으로 이름 만들어줌
//		return UUID.randomUUID().toString().replaceAll("-", "");
//	}
}