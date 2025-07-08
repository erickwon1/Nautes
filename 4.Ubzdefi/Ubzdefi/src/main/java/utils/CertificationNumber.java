package utils;

import java.security.SecureRandom;

public class CertificationNumber {
	public int createCertification_Number(int length) {
		SecureRandom secureRandom = new SecureRandom();
		int upperLimit = (int) Math.pow(10, length);
		return secureRandom.nextInt(upperLimit - (upperLimit / 10)) + (upperLimit / 10);
	}
}