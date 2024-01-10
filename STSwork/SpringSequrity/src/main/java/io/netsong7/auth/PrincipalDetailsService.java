package io.netsong7.auth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.netsong7.model.Users;
import io.netsong7.repository.UsersRepository;

@Service
public class PrincipalDetailsService implements UserDetailsService { // 직접 회원정보를 입력받아서 처리
	@Autowired
	private UsersRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users userEntity = userRepository.findByUsername(username); //DB에서 가져오기
		System.out.println("userEntity : " + userEntity);
		if(userEntity != null) {
			return new PrincipalDetails(userEntity); // sequrity에게 찾아낸 사용자 넘겨줘서 관리하게
		}
		return null;
	}

}