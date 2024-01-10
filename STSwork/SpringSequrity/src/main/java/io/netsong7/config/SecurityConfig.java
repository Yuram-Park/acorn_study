package io.netsong7.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import io.netsong7.auth.PrincipalOauth2UserService;

@Configuration // 환경설정 파일 annotation(이전 xml)
@EnableWebSecurity // spring sequrity 설정을 하겠다
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig {
	
	@Autowired
	private PrincipalOauth2UserService principalOauth2UserService;
	
	@Bean
	public BCryptPasswordEncoder encodePwd(){
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(requests -> 
			requests.requestMatchers("/user/**").hasRole("USER")
			.requestMatchers("/admin/**").hasRole("ADMIN")
			.requestMatchers("/manager/**").hasAnyRole("MANAGER", "ADMIN")
			.requestMatchers("/", "/joinForm", "/loginForm", "/join", "/login").permitAll()
			.anyRequest().authenticated()
		)
		.formLogin(login -> login
			.loginPage("/loginForm")
			.loginProcessingUrl("/login")
			.defaultSuccessUrl("/"))
		.oauth2Login(login -> login
				.loginPage("/loginForm")
				.userInfoEndpoint(uie -> uie.userService(principalOauth2UserService)))
		.logout(logout -> logout
		.logoutSuccessUrl("/loginForm")
		.invalidateHttpSession(true))
		.csrf(csrf -> csrf.disable())
		.cors(cors -> cors.disable());
				
		return http.build();
	}
}


/*
 * 구글 로그인을 하고 나면
 * 구글로부터 코드를 받아온다.(=인증을 받았다)
 * 그 코드를 가지고 다시 구글에게 요청을 하면 구글로부터 Access Token을 받아온다.
 * 우리의 Security Server가 구글의 사용자정보에 접근할 수 있는 권한이 생긴 것이다.
 * 우리의 서버는 구글로부터 사용자정보를 가져와서 그것을 토대로 회원가입을 진행
 * OAuth-Client 라이브러리를 쓰면 토큰 받아오는거까지 알아서 해줌
*/