package model;

import java.io.IOException;

import javax.crypto.SecretKey;

public class MainTest {
	public static void main(String[] args) {
		AESEncryption aes = new AESEncryption();
		
		String password = "Libranix123";
		String saltpassword = "";
		
		aes.generateKey();
		
		String key = aes.getKey();
		System.out.println("AESKey:"+key);
		//SecretKey aesKey = aes.getSecretKey();
		
		try {
			//saltpassword = aes.encrypt(password, aesKey);
			System.out.println("Password succesfully salted!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Password: "+password);
		System.out.println("SaltedPassword: "+saltpassword);
		
		WriteFile write = new WriteFile("Libranix.data");
		write.writeProperties(key);
		
		try {
			//System.out.println("Decrypted"+ aes.decrypt(saltpassword, aesKey));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		try {
//			//System.out.println("AESKeylatest:"+aes.convertKey(aesKey));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
