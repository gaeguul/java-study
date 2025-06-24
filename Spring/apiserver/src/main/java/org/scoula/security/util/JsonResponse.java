package org.scoula.security.util;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonResponse {

	public static <T> void send(HttpServletResponse response, T result) throws IOException {

		// 1) Jackson 객체 준비
		ObjectMapper om = new ObjectMapper();

		// 2) 응답 헤더 설정
		response.setContentType("application/json;charset=UTF-8");

		// 3) 직렬화 및 쓰기
		Writer out = response.getWriter();
		out.write(om.writeValueAsString(result));

		// 버퍼 비우기
		out.flush();
	}

	public static void sendError(HttpServletResponse response, HttpStatus status, String message) throws IOException {
		// 1) 상태 코드 설정
		response.setStatus(status.value());

		// 2) 응답 헤더 설정
		response.setContentType("application/json;charset=UTF-8");

		// 3) 에러 메시지 출력
		Writer out = response.getWriter();
		out.write(message);
		out.flush();
	}
}
