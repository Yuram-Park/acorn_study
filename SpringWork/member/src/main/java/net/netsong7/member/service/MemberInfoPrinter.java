package net.netsong7.member.service;

import net.netsong7.member.common.MemberPrinter;
import net.netsong7.member.model.Member;
import net.netsong7.member.repository.MemberDao;

public class MemberInfoPrinter {
	private MemberDao memDao;
	private MemberPrinter printer;
	
	
	public void setMemDao(MemberDao memDao) {
		this.memDao = memDao;
	}
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	
	public void printMemberInfo(String email) {
		Member member = memDao.selectByEmail(email);
		
		if(member == null) {
			System.out.println("데이터 없음\n");
			return;
		}
		printer.print(member);
		System.out.println();
	}
}
