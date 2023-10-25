package controller;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.User;


// annotation 사용

@Controller
public class SecondController {
	
	@RequestMapping("/first")
	public String firstPage() {
		return "/WEB-INF/views/first.jsp";
	}
	
	@RequestMapping("/second")
	public ModelAndView secondPage(HttpServletRequest req) {
		String p1 = req.getParameter("p1");
		String p2 = req.getParameter("p2");
		
		ModelAndView mv = new ModelAndView("/WEB-INF/views/second.jsp"); //데이터를 담아서 보내줌
		mv.addObject("param1", p1);
		mv.addObject("param2", p2);
		return mv;
	}
	
	//@RequestMapping(value="/third", method=RequestMethod.POST)
	@PostMapping("/third")
	public String thirdPage(
			String name, //@RequestParam -> 넘길때 name과 받을때 변수 이름 같으면 생략 가능
			@RequestParam("age") int nai, 
			@RequestParam double point) { // 자동 변환됨
		
		System.out.println(name+","+nai+","+point);
		return "/WEB-INF/views/third.jsp";
	}
	
	/*
	@GetMapping("/fourth")
	public String fourthPage(String name, int age, double point, Model model) {
		User dto = new User();
		dto.setName(name);
		dto.setAge(age);
		dto.setPoint(point);
		
		model.addAttribute(dto);
		
		return "/WEB-INF/views/fourth.jsp";
	}
	*/
	
	
	/*
	@GetMapping("/fourth")
	public ModelAndView fourthPage(String name, int age, double point) {
		User user = new User();
		user.setName(name);
		user.setAge(age);
		user.setPoint(point);
		
		ModelAndView mv = new ModelAndView("/WEB-INF/views/fourth.jsp");
		mv.addObject("user", user);
		
		return mv;
	}
	*/
	
	@GetMapping("/fourth")
	public ModelAndView fourthPage(@ModelAttribute User dto, @RequestParam String chk) { // 자동으로 dto에 셋팅 & 인자 추가 가능
		ModelAndView mv = new ModelAndView("/WEB-INF/views/fourth.jsp");
		mv.addObject("user", dto);
		//System.out.println("check: " + chk);
		return mv;
	}
	
	@RequestMapping("/fifth")
	public ModelAndView fifthPage() {
		List list = new ArrayList();
		list.add("삼계탕");
		list.add("반계탕");
		list.add("추어탕");
		list.add("갈비탕");
		
		
		Map map = new HashMap<String, String>();
		map.put("f1", "사과"); // map은 키로 접근
		map.put("f2", "포도");
		map.put("f3", "수박");
		
		
		List listDay = new ArrayList<String>();
		listDay.add("월요일");
		listDay.add("화요일");
		listDay.add("수요일");
		listDay.add("목요일");
		
		Map mapDay = new HashMap<String, List>();
		mapDay.put("day", listDay);
		
		
		ModelAndView mv = new ModelAndView("/WEB-INF/views/fifth.jsp");
		mv.addObject("tang", list);
		mv.addAllObjects(map);
		mv.addAllObjects(mapDay);
		
		return mv;
	}
	
	

}
