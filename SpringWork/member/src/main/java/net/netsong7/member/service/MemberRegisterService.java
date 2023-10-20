package net.netsong7.member.service;
import java.util.Date;

import net.netsong7.member.model.Member;
import net.netsong7.member.model.RegisterRequest;
import net.netsong7.member.repository.MemberDao;

public class MemberRegisterService {
	private MemberDao memberDao;

	public MemberRegisterService() {}
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void regist(RegisterRequest req) {
		// 같은 이메일이 있는지 여부 검사
		
		Member member = memberDao.selectByEmail(req.getEmail());
		if(member != null) {
			System.out.println("같은 이메일이 있습니다.");
			return;
		}
		Member newMem = new Member(req.getEmail(), req.getName(), req.getPassword(), new Date());
		memberDao.insert(newMem);
	}
}
