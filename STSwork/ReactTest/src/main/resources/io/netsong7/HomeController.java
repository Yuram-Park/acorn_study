package io.netsong7;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


class LoginDto{
	private String userid;
	private String passwd;
	
	public String getUserid() {
		return userid;
	}

	public String getPasswd() {
		return passwd;
	}

	public LoginDto(String userid, String passwd) {
		this.userid = userid;
		this.passwd = passwd;
	}
	
}

@Controller
@RestController
public class HomeController {
	
	@RequestMapping("/")
	@ResponseBody
	public LoginDto test1() {
		return new LoginDto("hong", "1111");
	}
	
	@RequestMapping("/map")
	public HashMap<String, String> test2(){
		HashMap<String, String> map = new HashMap<>();
		map.put("userid", "kim");
		map.put("address", "Seoul");
		return map;
	}
	
	@RequestMapping("/list")
	public ArrayList<LoginDto> test3(){
		ArrayList<LoginDto> list = new ArrayList<LoginDto>();
		list.add(new LoginDto("hong", "1234"));
		list.add(new LoginDto("Ram", "5678"));
		list.add(new LoginDto("Sol", "9101"));
		
		
		return list;
	}
	
}
