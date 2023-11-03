package io.netsong7.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import io.netsong7.domain.Member;
import io.netsong7.repository.MemberDao;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("/list")
	public String list(Model model) {
		ArrayList<Member> list = (ArrayList<Member>) memberDao.getDataAll();
		model.addAttribute("members", list);
		return "/list";
	}
	
	@GetMapping("/insert")
	public String insert() {
		return "/insert";
	}
	
	@PostMapping("/insert")
	public String insert(Member mem) {
		boolean result = memberDao.insertData(mem);
		if(result) {
			return "redirect:/list";
		}
		else {return "redirect:/error";}
	}
	
	@GetMapping("/update/{num}")
	public String update(@PathVariable int num, Model model) {
		Member mem = memberDao.readData(num);
		model.addAttribute("num", num);
		model.addAttribute("name", mem.getName());
		model.addAttribute("addr", mem.getAddr());
		return "update";
	}
	
	@PostMapping("/update")
	public String update(Member mem) {
		boolean result = memberDao.updateData(mem);
		if(result) {
			return "redirect:/list";
		}
		else {return "redirect:/error";}
	}
	
	@GetMapping("/delete/{num}")
	public String delete(@PathVariable int num) {
		memberDao.deleteData(num);
		return "redirect:/list";
	}
}
