package services.traitement;

import java.math.BigInteger;
import java.security.SecureRandom;

public class GenerateKey {
	public static String generateSessionKey(){
		SecureRandom random = new SecureRandom();
		String key = new BigInteger(130,random).toString(32); 
		return key ; 
	}
}
