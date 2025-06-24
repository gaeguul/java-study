package org.scoula.security.dto;

import java.util.List;

import org.scoula.security.account.domain.MemberVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/// 로그인 성공 시 응답에 포함시킬 사용자 정보
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDTO {
	String username;
	String email;
	List<String> roles;

	public static UserInfoDTO of(MemberVO member) {
		return new UserInfoDTO(
			member.getUsername(),
			member.getEmail(),
			member.getAuthList().stream()
				.map(a -> a.getAuth())
				.toList()
		);
	}
}
