package model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ICommand {
	// 모든 클래스에서 공통적으로 사용하는 기능을 interface에
	
	// 페이지 이동
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
