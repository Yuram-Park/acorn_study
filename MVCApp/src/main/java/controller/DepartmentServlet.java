package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DepartmentBean;

public class DepartmentServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String depart = req.getParameter("depart");
		
		/*//controller에게 model일을 시킨 상황
		ArrayList list = new ArrayList();
		if(depart.equals("kor")) {
			list.add("1.국어를 잘해야 한다.");
			list.add("2.국어를 사랑해야 한다.");
		} else if(depart.equals("eng")) {
			list.add("1.영어를 잘해야 한다.");
			list.add("2.영어를 사랑해야 한다.");
		} else if(depart.equals("com")) {
			list.add("1.컴퓨터를 잘해야 한다.");
			list.add("2.컴퓨터를 사랑해야 한다.");
		} else if(depart.equals("bus")) {
			list.add("1.경영을 잘해야 한다.");
			list.add("2.경영을 사랑해야 한다.");
		}
		*/
		
		DepartmentBean bean = new DepartmentBean();
		ArrayList list = bean.getAdvice(depart);
		
		req.setAttribute("advice", list);
		
		RequestDispatcher view = req.getRequestDispatcher("views/depart_proc.jsp");
		view.forward(req, resp);
		
	}
	
}
