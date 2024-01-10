package io.netsong7.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import io.netsong7.model.Users;
import io.netsong7.repository.UsersRepository;

// 소셜 로그인 이후에 정보를 받아서 처리
@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService{

	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		System.out.println("getClientRegistration:" + userRequest.getClientRegistration());
		System.out.println("getAccessToken:" + userRequest.getAccessToken().getTokenValue());
		System.out.println("getAttributes:" + super.loadUser(userRequest).getAttributes());
		
		OAuth2User oauth2User = super.loadUser(userRequest);
		// 회원 가입을 강제로 진행
		String provider = userRequest.getClientRegistration().getRegistrationId(); // google
		String providerId = oauth2User.getAttribute("sub");
		String email = oauth2User.getAttribute("email");
		String role = "ROLE_USER";
		String username = provider + "_" + providerId; // 중복 방지를 위해
		
		Users userEntity = usersRepository.findByUsername(username);
		if(userEntity == null) {
			userEntity = Users.builder()
							.username(username)
							.email(email)
							.role(role)
							.provider(provider)
							.providerId(providerId)
							.build();
			usersRepository.save(userEntity);
		}
		
		return new PrincipalDetails(userEntity, oauth2User.getAttributes());
	}


}
