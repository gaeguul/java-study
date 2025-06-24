package org.scoula.security.service;

import org.scoula.security.account.domain.CustomUser;
import org.scoula.security.account.domain.MemberVO;
import org.scoula.security.account.mapper.UserDetailsMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component // 빈 등록
@RequiredArgsConstructor // DI용 생성자
public class CustomUserDetailsService implements UserDetailsService {
	private final UserDetailsMapper mapper;

	// DB로부터 사용자 정보 추출해서 User 객체로 리턴
	// 일치하는 유저 정보 없으면 exception 발생시키기
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVO vo = mapper.get(username);
		if (vo == null) {
			throw new UsernameNotFoundException(username + "은 없는 id입니다.");
		}
		return new CustomUser(vo);
	}
}
