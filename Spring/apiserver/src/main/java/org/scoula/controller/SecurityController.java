package org.scoula.controller;

import java.util.Collection;

import org.scoula.security.account.domain.CustomUser;
import org.scoula.security.account.domain.MemberVO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/security")
@Log4j2
public class SecurityController {
	@GetMapping("/all")
	public void doAll() {
		log.info("do all can access everybody");
	}

	@GetMapping("/member")
	public void doMember(Authentication authentication) {
		// Principal에서 UserDetails 추출
		UserDetails userDetails = (UserDetails)authentication.getPrincipal();

		String username = userDetails.getUsername();           // 사용자 ID
		Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities(); // 권한 목록

		log.info("사용자 ID: {}", username);
		log.info("권한 목록: {}", authorities);
	}

	@GetMapping("/admin")
	public void doAdmin(@AuthenticationPrincipal CustomUser customUser) {
		// CustomUser에서 MemberVO 정보 추출
		MemberVO member = customUser.getMember();

		log.info("사용자 정보: {}", member);
		log.info("사용자 이메일: {}", member.getEmail());
		log.info("등록일: {}", member.getRegDate());

		// 권한 정보도 접근 가능
		Collection<? extends GrantedAuthority> authorities = customUser.getAuthorities();
		log.info("보유 권한: {}", authorities);
	}

	@GetMapping("/login")
	public void login() {
		log.info("login page");
	}

	@GetMapping("/logout")
	public void logout() {
		log.info("logout page");
	}

}
