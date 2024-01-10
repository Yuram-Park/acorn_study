package io.netsong7.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.netsong7.auth.PrincipalDetails;
import io.netsong7.model.Users;
import io.netsong7.repository.UsersRepository;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class IndexController {
	private final UsersRepository usersRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/user")
	@ResponseBody
	public String user(@AuthenticationPrincipal PrincipalDetails principalDetails) {
		System.out.println("principalDetails: " + principalDetails.getUser());
		return "user";
	}
	
	@GetMapping("/admin")
	@ResponseBody
	public String admin() {
		return "admin";
	}
	
	@GetMapping("/manager")
	@ResponseBody
	public String manager() {
		return "manager";
	}
	
	@GetMapping("/joinForm")
	public String joinForm() {
		return "joinForm";
	}
	
	@PostMapping("/join")
	public String join(Users user) {
		user.setRole("ROLE_USER");
		
		String rawPassword = user.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
		user.setPassword(encPassword);
		
		usersRepository.save(user);
		
		return "redirect:/loginForm";
	}
	
	@GetMapping("/joinProc")
	@ResponseBody
	public String joinProc(@AuthenticationPrincipal PrincipalDetails principalDetails) {
		System.out.println("principalDetails: " + principalDetails.getUser());
		return "인증된 사람만 올 수 있는곳";
	}
	
	@GetMapping("/loginForm")
	public String loginForm() {
		return "loginForm";
	}
	
	@PostMapping("/login")
	public String login() {
		System.out.println("login");
		return "index";
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
	@GetMapping("/data")
	public @ResponseBody String data() {
		return "데이터정보";
	}
	
	@GetMapping("/test/login")
	@ResponseBody
	public String testLogin(Authentication auth, @AuthenticationPrincipal UserDetails userDetails) {
		System.out.println("/test/login ================");
		//System.out.println(auth.getPrincipal());
		PrincipalDetails principalDetails = (PrincipalDetails)auth.getPrincipal(); //일반로그인은 가능하지만 소셜로그인은 안됨..
		System.out.println(principalDetails.getUser());
		System.out.println(userDetails.getUsername());
		return "세션 정보 확인하기";
	}
	
	@GetMapping("/test/oauth/login")
	@ResponseBody
	public String testOAuthLogin(Authentication auth, @AuthenticationPrincipal OAuth2User oauth) {
		System.out.println("/test/oauth/login ================");
		OAuth2User oauth2User = (OAuth2User)auth.getPrincipal();
		System.out.println(oauth2User.getAttributes());
		return "OAuth 세션 정보 확인하기";
	}
}