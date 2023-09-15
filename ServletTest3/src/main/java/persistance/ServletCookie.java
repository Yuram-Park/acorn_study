package persistance;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletCookie extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("euc-kr");

		String name = req.getParameter("name");
		String addr = req.getParameter("addr");

		System.out.println(name + ", " + addr);

		// 사용자에게 보여주는게 아니라 사용자 컴퓨터에 심어 놓겠다.
		if (req.getMethod().equals("POST")) {
			// 쿠키 객체로 먼저 포장을 해야해
			Cookie nameCook = new Cookie("name", name);
			Cookie addrCook = new Cookie("addr", addr);

			
			// 언제까지 저장할 것인지 만료기간
			nameCook.setMaxAge(60 * 60 * 24);
			addrCook.setMaxAge(60 * 60 * 24);

			// 사용자에게 전송해야할거아니여
			resp.addCookie(nameCook);
			resp.addCookie(addrCook);

			resp.getWriter().println("쿠키가 저장되었습니다.");
		} else {
			Cookie[] cooks = req.getCookies();
			for(Cookie c: cooks) {
				resp.getWriter().println(c.getName() + ", " + c.getValue());
			}
		}
	}

}
