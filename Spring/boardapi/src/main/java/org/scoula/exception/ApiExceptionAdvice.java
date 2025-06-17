package org.scoula.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.log4j.Log4j2;

@RestControllerAdvice
@Log4j2
public class ApiExceptionAdvice {
	// 404 에러 - 리소스를 찾을 수 없음
	@ExceptionHandler(NoSuchElementException.class)
	protected ResponseEntity<String> handleIllegalArgumentException(NoSuchElementException e) {
		return ResponseEntity
			.status(HttpStatus.NOT_FOUND)
			.header("Content-Type", "text/plain;charset=UTF-8")
			.body("해당 ID의 요소가 없습니다.");
	}

	// 500 에러 - 일반적인 서버 오류
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<String> handleException(Exception e) {
		return ResponseEntity
			.status(HttpStatus.INTERNAL_SERVER_ERROR)
			.header("Content-Type", "text/plain;charset=UTF-8")
			.body(e.getMessage());
	}

	// 400 에러 - 잘못된 요청 (추가 예시)
	@ExceptionHandler(IllegalArgumentException.class)
	protected ResponseEntity<String> handleIllegalArgumentException(
		IllegalArgumentException e
	) {
		log.warn("잘못된 요청: " + e.getMessage());

		return ResponseEntity
			.status(HttpStatus.BAD_REQUEST)                  // 400 상태
			.header("Content-Type", "text/plain;charset=UTF-8")
			.body("잘못된 요청입니다: " + e.getMessage());
	}
}