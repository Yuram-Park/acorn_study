package myservlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybean.Dog;
import mybean.Person;

public class ELTestServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get방식과 post방식을 따로따로 처리하게 되면 중복되는 코드가 많아 한 쪽으로 모아서 사용한다.		
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		
		// 방문자 수를 보여주고 싶음
		req.setAttribute("visitCount", 100);
		
		String[] favoriteFood = {"냉면", "돼지갈비", "순대국", "콩국수"};
		req.setAttribute("foods", favoriteFood);
		
		ArrayList<String> movies = new ArrayList<String>();
		movies.add("영웅본색1");
		movies.add("영웅본색2");
		movies.add("영웅본색3");
		movies.add("어벤져스");
		req.setAttribute("movies", movies);
		
		Person hong = new Person();
		Dog popee = new Dog();
		
		hong.setName("홍길동");
		popee.setName("뽀삐");
		
		hong.setDog(popee);
		req.setAttribute("hong", hong);
		
		// core/test04.jsp에서 사용할 데이터
		String[] movie1 = {"매트릭스", "캐러비언의 해적", "마션", "007 스펙터"};
		String[] movie2 = {"넘버3", "관상", "명량"};
		
		ArrayList list = new ArrayList();
		list.add(movie1);
		list.add(movie2);
		req.setAttribute("movieList", list);
		
		// 댓글 데이터
		String[] comment = {"이 사이트는 편리합니다.", "정말 좋은 사이트인듯,,,", "자주 찾는 사이트가 될 것 같아요!"};
		req.setAttribute("comments", comment);
		
		// MEMBER 변수에 guest와 member값을 번갈아서 사용
		req.getSession().setAttribute("MEMBER", "guest");
		
		
		// 내가 요청받은 정보를 다른 페이지에 맡기겠다. (내가 전달할 페이지)
		RequestDispatcher view = req.getRequestDispatcher("test08_proc.jsp");
		
		view.forward(req, resp);
	}
	
}