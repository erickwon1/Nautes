package com.nautestech.www.util;

import java.io.IOException;
import java.util.Base64;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

	public static String encodeFileToBase64(MultipartFile file) {
		if (file == null || file.isEmpty()) {
			return null;
		}
		try {
			byte[] fileBytes = file.getBytes();
			return Base64.getEncoder().encodeToString(fileBytes);
		} catch (IOException e) {
			throw new RuntimeException("파일을 Base64로 변환하는 중 오류 발생", e);
		}
	}
}