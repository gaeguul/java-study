package org.scoula.board.domain;

import java.util.Date;

import org.scoula.common.util.UploadFiles;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardAttachmentVO {
	private Long no; // PK
	private Long bno; // FK: Board의 no
	private String filename; // 원본 파일명
	private String path; // 서버에 저장된 파일 경로
	private String contentType; // 파일 mime-type(content-type)
	private Long size; // 파일의 크기
	private Date regDate; // 등록일

	// 팩토리 메서드
	// path: 업로드된 파일 경로
	// bno: foreign key
	// path: 실제 업로드 경로
	public static BoardAttachmentVO of(MultipartFile part, Long bno, String path) {
		return builder()
			.bno(bno)
			.filename(part.getOriginalFilename())
			.path(path)
			.contentType(part.getContentType())
			.size(part.getSize())
			.build();
	}

	/**
	 * 파일 크기를 사용자 친화적 형태로 변환
	 * 필드가 존재하지 않고 계산된 속성
	 * @return 포맷된 파일 크기 (예: 1.2 MB)
	 */
	public String getFileSize() {
		return UploadFiles.getFormatSize(size);
	}
}
