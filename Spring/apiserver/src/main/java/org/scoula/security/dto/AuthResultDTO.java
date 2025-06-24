package org.scoula.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/// 로그인 성공 결과를 나타내는 응답 (인증 토큰과 UserInfoDTO로 구성)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResultDTO {
	String token;
	UserInfoDTO user;
}
