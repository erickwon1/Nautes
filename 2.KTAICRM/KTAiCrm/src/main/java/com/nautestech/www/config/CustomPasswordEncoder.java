package com.nautestech.www.config;

import java.io.UnsupportedEncodingException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomPasswordEncoder implements PasswordEncoder {
	@Override
	public String encode(CharSequence rawPassword) {	
		String ret = "";
		try {
			final Cipher encryptCipher = Cipher.getInstance("AES");
			encryptCipher.init(Cipher.ENCRYPT_MODE, generateMySQLAESKey("nautes123!", "UTF-8"));
			ret = new String(Hex.encodeHex(encryptCipher.doFinal(rawPassword.toString().getBytes("UTF-8"))))
					.toUpperCase();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {		
//		String pass = encode(rawPassword);
//		System.err.println(pass);
		
		boolean ret = false;
		try {
			final Cipher decryptCipher = Cipher.getInstance("AES");
			decryptCipher.init(Cipher.DECRYPT_MODE, generateMySQLAESKey("nautes123!", "UTF-8"));
			String decodedPassword = new String(decryptCipher.doFinal(Hex.decodeHex(encodedPassword.toCharArray())));
			if (rawPassword.toString().equals(decodedPassword))
				ret = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public static SecretKeySpec generateMySQLAESKey(final String key, final String encoding) {
		try {
			final byte[] finalKey = new byte[16];
			int i = 0;
			for (byte b : key.getBytes(encoding))
				finalKey[i++ % 16] ^= b;
			return new SecretKeySpec(finalKey, "AES");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}
}
