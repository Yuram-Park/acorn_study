package com.exam.controller;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.WebUtils;

import com.exam.domain.Member;
import com.exam.domain.RegisterRequest;
import com.exam.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberSvc;
	
	@GetMapping("/add")
	public String step1() {
		return "member/step1";
	}
	
	@PostMapping("/step2")
	public String step2(@RequestParam(value="agree", defaultValue="false") boolean agree) {
		if(!agree) {
			return "member/step1";
		}
		return "member/step2";// 요청하려는 페이지와 요청한 경로가 같으면 없어도 됨
	}
	
	@PostMapping("/step3")
	public String step3(@ModelAttribute RegisterRequest dto) throws Exception {
		memberSvc.registerMember(dto);
		return "member/step3";
	}
	
	@GetMapping("/index")
	public String main() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("/login")
    public String login(String email, String password, HttpServletRequest req) {
        String msg = null;
        try {
            msg = URLEncoder.encode("id 또는 password가 일치하지 않습니다.", "utf-8");
            Member member = memberSvc.selectWithPass(email, password);
            
            // HttpSession session = req.getSession();
            // session.setAttribute("id", member.getEmail());
            WebUtils.setSessionAttribute(req, "id", member.getName());
        } catch (Exception e) {
            return "redirect:/member/login?msg=" + msg;
        }
        return "redirect:/";
    }
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
