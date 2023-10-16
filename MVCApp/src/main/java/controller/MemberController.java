package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FactoryBean;
import model.ICommand;



@WebServlet("/mem")
public class MemberController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String command = req.getParameter("command");
		String url = "";
		
		ICommand cmd = null;
		
		
		//// 1) Factory 패턴 안쓸때
//		if (command.equals("REGISTER")) {
//			//url = (String)new RegisterCommand().processCommand(req, resp);
//			// 코드 중복 줄이기
//			cmd = new RegisterCommand();
//		} else if (command.equals("CONFIRM")) {
//			// 입력값 전달 받기 -> bean으로 만들기(ConfirmCommand)
//			// 아이디 중복 여부, 패스워드 일치 여부(DB 연동) -> bean으로 만들기(ConfirmCommand)
//			//url = (String)new ConfirmCommand().processCommand(req, resp);
//			cmd = new ConfirmCommand();
//		} else if (command.equals("COMPLETE")) {
//			// DB 저장 -> CompleteCommand
//			//url = (String)new CompleteCommand().processCommand(req, resp);
//			cmd = new CompleteCommand();
//		} else if (command.equals("MAIN")) {
//			//url = (String)new MainCommand().processCommand(req, resp);
//			cmd = new MainCommand();
//		} else { 
//			// 잘못된 접근에 대한 처리
//		}
		
		
		//// 2) Factory 패턴 쓸때
		FactoryBean factory = FactoryBean.newInstance();
		cmd = factory.createInstance(command);
		
		
		url = (String) cmd.processCommand(req, resp);
		RequestDispatcher view = req.getRequestDispatcher(url);
		view.forward(req, resp);
		
	}
	
}
