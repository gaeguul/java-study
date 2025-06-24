package org.scoula.security.util;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtProcessor {
	static private final long TOKEN_VALID_MILISECOND = 1000L * 60 * 5; // 5분

	// private Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256); // -- 운영시 사용

	private String secretKey = "fsdfdsfsddffsdfsdfsdfsfsdfsdffdfsdfsfd";
	private Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

	// JWT 생성
	public String generateToken(String subject) {
		return Jwts.builder()
			.setSubject(subject)
			.setIssuedAt(new Date())
			.setExpiration(new Date(new Date().getTime() + TOKEN_VALID_MILISECOND))
			.signWith(key)
			.compact();
	}

	// JWT Subject(username) 추출- 해석 불가인 경우 예외 발생
	// 예외 ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException,
	// IllegalArgumentException
	public String getUsername(String token) {
		return Jwts.parserBuilder()
			.setSigningKey(key)
			.build()
			.parseClaimsJws(token)
			.getBody()
			.getSubject();
	}

	// JWT 검증(유효 기간 검증) - 해석 불가인 경우 예외 발생
	// 리프레시 토큰 검증할 때 사용
	public boolean validateToken(String token) {
		Jws<Claims> claims = Jwts.parserBuilder()
			.setSigningKey(key)
			.build()
			.parseClaimsJws(token);
		return true;
	}
}
