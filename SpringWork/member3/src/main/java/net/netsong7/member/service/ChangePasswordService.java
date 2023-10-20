package net.netsong7.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.netsong7.member.model.Member;
import net.netsong7.member.repository.MemberDao;

@Service("memberPwdSvc")
public class ChangePasswordService {
	private MemberDao memberDao;

	public ChangePasswordService() {}
	
	@Autowired
	public ChangePasswordService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void changePassword(String email, String oldPass, String newPass) {
		// 해당 이메일이 존재하는지 여부 검사
		Member member = memberDao.selectByEmail(email);
		if(member == null) {
			System.out.println("해당 멤버가 없습니다.");
			return;
		}
		
		// 현재 비밀번호가 맞는지 확인
		member.changePassword(oldPass, newPass);
		
		memberDao.update(member);
	}
}
