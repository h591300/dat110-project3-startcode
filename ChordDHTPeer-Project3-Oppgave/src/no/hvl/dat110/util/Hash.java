package no.hvl.dat110.util;

/**
 * project 3
 * @author tdoy
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	private static BigInteger hashint; 
	
	public static BigInteger hashOf(String entity) {		
		
		// Task: Hash a given string using MD5 and return the result as a BigInteger.
		
		// we use MD5 with 128 bits digest
		MessageDigest m;
		
		try {
			m = MessageDigest.getInstance("MD5");
			m.update(entity.getBytes());
			byte[] d = m.digest();
			
			String hf = toHex(d);
			hashint = new BigInteger(hf, 16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		// compute the hash of the input 'entity'
		
		// convert the hash into hex format
		
		// convert the hex into BigInteger
		
		// return the BigInteger
		
		return hashint;
	}
	
	public static BigInteger addressSize() {
		
		// Task: compute the address size of MD5
		MessageDigest m;
		int mLen = 0;
		try {
			m = MessageDigest.getInstance("MD5");
			mLen = m.getDigestLength();
		}catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		int nBits = mLen *8;
		BigInteger B = new BigInteger("2");
		BigInteger adressSize = B.pow(nBits);
		// get the digest length
		// compute the number of bits = digest length * 8
		// compute the address size = 2 ^ number of bits
		// return the address size
		
		return adressSize;
	}
	
	public static int bitSize() {
		
		int digestlen = 0;
		
		// find the digest length
		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			digestlen = m.getDigestLength();
			
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		
		return digestlen*8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
