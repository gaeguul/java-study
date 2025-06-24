package org.scoula.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.scoula.security.account.domain.CustomUser;
import org.scoula.security.dto.AuthResultDTO;
import org.scoula.security.dto.UserInfoDTO;
import org.scoula.security.util.JsonResponse;
import org.scoula.security.util.JwtProcessor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
@RequiredArgsConstructor
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
	private final JwtProcessor jwtProcessor;

	private AuthResultDTO makeAuthResult(CustomUser user) {
		String username = user.getUsername();

		// 토큰 생성
		String token = jwtProcessor.generateToken(username);

		// 토큰, 사용자기본정보 묶어서 AuthResultDTO 구성
		return new AuthResultDTO(token, UserInfoDTO.of(user.getMember()));
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
		Authentication authentication) throws IOException, ServletException {
		// 인증 결과 Principal
		CustomUser user = (CustomUser)authentication.getPrincipal();

		// 인증 성공 결과를 JSON으로 직접 응답
		AuthResultDTO result = makeAuthResult(user);
		JsonResponse.send(response, result);
	}
}
