package org.scoula.security.dto;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.BadCredentialsException;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {
	private String username;
	private String password;

	public static LoginDTO of(HttpServletRequest request) {
		ObjectMapper om = new ObjectMapper(); // Jackson 객체
		try {
			return om.readValue(request.getInputStream(), LoginDTO.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BadCredentialsException("username 또는 password가 없습니다.");
		}
	}
}
