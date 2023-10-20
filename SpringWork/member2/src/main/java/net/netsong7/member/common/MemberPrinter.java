package net.netsong7.member.common;

import org.springframework.stereotype.Component;

import net.netsong7.member.model.Member;

@Component
public class MemberPrinter {
	// 회원정보 보여주기
	public void print(Member member) {
		System.out.printf("회원정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n", member.getId(), 
				member.getEmail(), member.getName(), member.getRegisterDate());
	}
}
