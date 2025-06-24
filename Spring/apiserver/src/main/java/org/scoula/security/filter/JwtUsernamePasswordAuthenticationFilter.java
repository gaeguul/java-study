package org.scoula.security.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.scoula.security.dto.LoginDTO;
import org.scoula.security.handler.LoginFailureHandler;
import org.scoula.security.handler.LoginSuccessHandler;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class JwtUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	// 스프링 생성자 주입을 통해 전달
	public JwtUsernamePasswordAuthenticationFilter(
		AuthenticationManager authenticationManager, // SecurityConfig가 생성된 이후에 등록됨
		LoginSuccessHandler loginSuccessHandler,
		LoginFailureHandler loginFailureHandler
	) {
		super(authenticationManager);
		setFilterProcessesUrl("/api/auth/login"); // POST 로그인 요청 url
		setAuthenticationSuccessHandler(loginSuccessHandler);
		setAuthenticationFailureHandler(loginFailureHandler);
	}

	// 로그인 요청 URL인 경우 로그인 작업 처리
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
		throws AuthenticationException {
		// 요청 BODY의 JSON에서 username, password -> LoginDTO
		LoginDTO login = LoginDTO.of(request);

		// 인증 토큰 구성
		UsernamePasswordAuthenticationToken authenticationToken =
			new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword());

		// 토큰을 담아서 AuthenticationManager에게 인증 요청
		return getAuthenticationManager().authenticate(authenticationToken);
	}

}
