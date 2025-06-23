package org.scoula.security.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Configuration
@EnableWebSecurity
@Log4j2
@MapperScan(basePackages = {"org.scoula.security.account.mapper"})
@ComponentScan(basePackages = {"org.scoula.security"})
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final UserDetailsService userDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// 문자셋 필터
	public CharacterEncodingFilter encodingFilter() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		encodingFilter.setForceEncoding(true);
		return encodingFilter;
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.addFilterBefore(encodingFilter(), CsrfFilter.class);

		// 경로별 접근 권한 설정
		http.authorizeRequests()
			// 모두 허용
			.antMatchers("/security/all").permitAll()
			// ADMIN만 허용
			.antMatchers("/security/admin").access("hasRole('ROLE_ADMIN')")
			// MEMBER 또는 ADMIN만 허용
			.antMatchers("/security/member").access("hasAnyRole('ROLE_MEMBER', 'ROLE_ADMIN')");

		// 로그인
		// form 기반 로그인 활성화, 나머지는 모두 디폴트
		http.formLogin() // 로그인 설정 시작
			.loginPage("/security/login") // 로그인 페이지 GET URL -> sercurity/login 뷰(jsp) 정의
			.loginProcessingUrl("/security/login") // 로그인 초라 POST 요청 URL -> login form의 action에 지정
			.defaultSuccessUrl("/"); // 로그인 성공 시 이동(redirect)할 페이지

		// 로그아웃
		http.logout() // 로그아웃 설정 시작
			.logoutUrl("/security/logout") // POST: 로그아웃 호출 url <-- POST!!!
			.invalidateHttpSession(true) // 세션 invalidate
			.deleteCookies("remember-me", "JSESSION-ID")// 삭제할 쿠키 목록
			.logoutSuccessUrl("/security/logout"); // GET: 로그아웃 이후 이동할 페이지
	}

	// 메소드명은 같은데 매개변수만 다르다
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
		throws Exception {
		log.info("configure .........................................");

		// in memory user 정보 삭제 → UserDetailsService와 같이 사용 불가
		auth
			.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder());

		// // ROLE_ADMIN
		// auth.inMemoryAuthentication()
		// 	.withUser("admin") // username
		// 	.password("{noop}1234") // 비밀번호, {noop}은 암호화 없다는 뜻
		// 	.password("$2a$10$Ne4Qq8/9Th5DPvc3nWptfeLcc.dCsxxyfPlsvJ8O8UA1YcYC5N7d2")
		// 	.roles("ADMIN", "MEMBER"); // 권한이 높을수록 그보다 낮은 권한을 모두 가지도록 설정한다

		// // ROLE_MEMBER
		// auth.inMemoryAuthentication()
		// 	.withUser("member")
		// 	.password("$2a$10$Ne4Qq8/9Th5DPvc3nWptfeLcc.dCsxxyfPlsvJ8O8UA1YcYC5N7d2")
		// 	.password("{noop}1234")
		// 	.roles("MEMBER");

	}

}
