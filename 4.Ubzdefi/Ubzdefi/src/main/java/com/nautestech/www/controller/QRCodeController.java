package com.nautestech.www.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.WriterException;
import com.nautestech.www.serviceImpl.QRCodeService;

@RestController
public class QRCodeController {

	@Autowired
	private QRCodeService qrCodeService;

	@GetMapping("/generateQRCode")
	public ResponseEntity<byte[]> generateQRCode(@RequestParam String text) {
		try {
			byte[] qrCodeImage = qrCodeService.generateQRCode(text, 350, 350);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.IMAGE_PNG);
			return ResponseEntity.ok().headers(headers).body(qrCodeImage);
		} catch (WriterException | IOException e) {
			return ResponseEntity.status(500).body(null);
		}
	}
}