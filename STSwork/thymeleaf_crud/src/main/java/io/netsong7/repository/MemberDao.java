package io.netsong7.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.netsong7.domain.Member;

@Repository
public class MemberDao {
	
	@Autowired
	private DataMappingInterface dataInterface;
	
	public List<Member> getDataAll(){
		List<Member> list = dataInterface.selectAll();
		return list;
	}
	
	public boolean insertData(Member mem) {
		int result = dataInterface.insertData(mem);
		if(result > 0)
			return true;
		else
			return false;
	}
	
	public boolean updateData(Member mem) {
		int result = dataInterface.updateData(mem);
		if(result>0)
			return true;
		else
			return false;
	}
	
	public Member readData(int num) {
		Member mem = dataInterface.selectOne(num);
		return mem;
	}
	
	public boolean deleteData(int num) {
		int result = dataInterface.deleteData(num);
		if(result>0)
			return true;
		else
			return false;
	}
}
