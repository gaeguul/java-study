package org.scoula.common.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

public class UploadFiles {
	/// baseDir: 저장위치
	public static String upload(String baseDir, MultipartFile part) throws IOException {
		File base = new File(baseDir);
		if (!base.exists()) {
			base.mkdirs();
		}

		String fileName = part.getOriginalFilename();
		File dest = new File(baseDir, UploadFileName.getUniqueName(fileName));
		part.transferTo(dest); // 지정한 경로로 업로드 파일 이동
		return dest.getPath(); // 저장된 파일 경로 리턴
	}

	/**
	 * 파일 크기를 사용자 친화적 형태로 변환
	 * @param size 바이트 단위 파일 크기
	 * @return 포맷된 문자열 (예: 1.2 MB)
	 */
	public static String getFormatSize(Long size) {
		if (size <= 0)
			return "0";

		final String[] units = new String[] {"Bytes", "KB", "MB", "GB", "TB"};
		int digitGroups = (int)(Math.log10(size) / Math.log10(1024));

		return new DecimalFormat("#,##0.#")
			.format(size / Math.pow(1024, digitGroups)) + " " + units[digitGroups];
	}

	public static void download(HttpServletResponse response, File file, String orgName) throws Exception {
		response.setContentType("application/download");
		response.setContentLength((int)file.length());
		String filename = URLEncoder.encode(orgName, "UTF-8"); // 한글 파일명인 경우 인코딩 필수
		response.setHeader("Content-disposition", "attachment;filename=\"" + filename + "\"");
		try (OutputStream os = response.getOutputStream();
			 BufferedOutputStream bos = new BufferedOutputStream(os)) {
			// bos 스트림을 사용해서 해당 경로의 파일의 원본을 copy해서 클라이언트에 보낸다
			Files.copy(Paths.get(file.getPath()), bos);
		}
	}
}
