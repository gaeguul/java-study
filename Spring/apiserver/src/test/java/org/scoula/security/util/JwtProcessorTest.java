package org.scoula.security.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.scoula.security.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.log4j.Log4j2;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
	RootConfig.class,
	SecurityConfig.class
})
@Log4j2
class JwtProcessorTest {

	@Autowired
	JwtProcessor jwtProcessor;

	@Test
	void generateToken() {
		String username = "user0";
		String token = jwtProcessor.generateToken(username);
		log.info(token);
		assertNotNull(token);
	}

	@Test
	void getUsername() {
		String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMCIsImlhdCI6MTc1MDcyOTYxNSwiZXhwIjoxNzUwNzI5OTE1fQ.As_Ug50SN3xOj2U9wzn2oUVv8KVp8X06AXnylctkZUk";
		String username = jwtProcessor.getUsername(token);
		log.info(username);
		assertNotNull(username);
	}

	// 5분 경과 후 테스트
	@Test
	void validateToken() {
		String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMCIsImlhdCI6MTc1MDcyOTYxNSwiZXhwIjoxNzUwNzI5OTE1fQ.As_Ug50SN3xOj2U9wzn2oUVv8KVp8X06AXnylctkZUk";
		boolean isValid = jwtProcessor.validateToken(token); // 5분 경과 후면 예외 발생
		log.info(isValid);
		assertTrue(isValid); // 5분 전이면 true
	}
}