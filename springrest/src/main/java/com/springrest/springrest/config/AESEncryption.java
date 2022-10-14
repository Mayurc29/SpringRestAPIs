package com.springrest.springrest.config;

import java.security.GeneralSecurityException;
import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.AttributeConverter;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.SerializationUtils;

import lombok.SneakyThrows;

@Configuration
public class AESEncryption implements AttributeConverter<Object, String>
{

	private final String encryptionKey = "this-is-test-key";
	private final String encryptionCipher = "AES";
	
	private Key key;
	private Cipher cipher;
	
	
	
	private Key getKey() 
	{
		if(key ==null)
			key = new SecretKeySpec(encryptionKey.getBytes(),encryptionCipher);
		
		return key;
	}

	

	private Cipher getCipher() throws GeneralSecurityException
	{
		if(cipher == null)
			cipher = Cipher.getInstance(encryptionCipher);
		return cipher;
	}

	private void initCipher(int encryptMode) throws GeneralSecurityException
	{
		getCipher().init(encryptMode, getKey());
	}

	@SneakyThrows
	@Override
	public String convertToDatabaseColumn(Object attribute)
	{
		if(attribute == null)
			return null;
		try {
			initCipher(Cipher.ENCRYPT_MODE);
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		byte[] bytes = SerializationUtils.serialize(attribute);
		try {
			return Base64.getEncoder().encodeToString(getCipher().doFinal(bytes));
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return encryptionCipher;
		
	}

	@Override
	public Object convertToEntityAttribute(String dbData)
	{
		if(dbData == null)
			return null;
		try {
			initCipher(Cipher.DECRYPT_MODE);
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] bytes = null;
		try {
			bytes = getCipher().doFinal(Base64.getDecoder().decode(dbData));
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SerializationUtils.deserialize(bytes);
	}

	
}
