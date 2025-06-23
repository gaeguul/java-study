package org.scoula.security.account.domain;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
	private String username;
	private String password;
	private String email;
	private Date regDate;
	private Date updateDate;

	// 권한 목록 (join 처리 필요함)
	// 모든 유저는 1개 이상의 권한을 가져야 함
	private List<AuthVO> authList;
}
