package org.scoula.security;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.scoula.security.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.log4j.Log4j2;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
	RootConfig.class,
	SecurityConfig.class
})
@Log4j2
class PasswordEncoderTest {
	@Autowired
	private PasswordEncoder pwEncoder;

	@Test
	public void testEncode() {
		String str = "1234";
		String enStr = pwEncoder.encode(str); // 암호화
		String enStr2 = pwEncoder.encode(str); // 암호화

		// 같은 문자열이지만 매번 다르게 encoding된다
		log.info("password: " + enStr);
		log.info("password: " + enStr2);

		// 인코딩된 암호의 동일성 확인할 때는 matches 사용한다
		log.info("match :" + pwEncoder.matches(str, enStr));
		log.info("match :" + pwEncoder.matches(str, enStr2));

	}
}