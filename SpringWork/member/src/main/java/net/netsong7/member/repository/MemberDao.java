package net.netsong7.member.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import net.netsong7.member.model.Member;

public class MemberDao {
	private Map<String, Member> map = new HashMap<String, Member>(); // DB 대신 데이터 저장
	private static long nextId = 0;
	
	// 조회 기능
	public Member selectByEmail(String email) {
		return map.get(email);
	}
	
	public Collection<Member> selectAll(){
		return map.values();
	}
	
	// 삽입
	public void insert(Member member) {
		member.setId(++nextId);
		map.put(member.getEmail(), member); //email이 기본키
		System.out.println("test: "+ map);
	}
	
	// 수정
	public void update(Member member) {
		map.put(member.getEmail(), member);
	}
}
