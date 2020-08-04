package org.uit.ps.service;

import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uit.ps.dao.ParamDAO;

@Service
public class SecurityServiceImpl implements SecurityService {
	
	@Autowired
	private ParamDAO paramDAO;
	
	private final String PASSWORD_PARAM = "PASSWORD";
	private final String VALID_IP_PARAM = "VALID_IP";

	@Override
	public String getHash(String value) {
		String password = paramDAO.getParamValueByName(PASSWORD_PARAM);
		return md5Custom(value+password);
	}

	@Override
	public boolean isValidIP(String host) {
		try {
			String value = paramDAO.getParamValueByName(VALID_IP_PARAM);
			if (value == null)
				return false;
			
			String[] ips = value.split(",");
			InetAddress address = InetAddress.getByName(host);
			for (String validIP : ips) {
				try {
					InetAddress validAddress = InetAddress.getByName(validIP);
					if (validAddress.equals(address))
						return true;
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return false;
		}

		return false;
	}
	
	private String md5Custom(String st) {
	    MessageDigest messageDigest = null;
	    byte[] digest = new byte[0];
	 
	    try {
	        messageDigest = MessageDigest.getInstance("MD5");
	        messageDigest.reset();
	        messageDigest.update(st.getBytes());
	        digest = messageDigest.digest();
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    }
	 
	    BigInteger bigInt = new BigInteger(1, digest);
	    String md5Hex = bigInt.toString(16);
	 
	    while( md5Hex.length() < 32 ){
	        md5Hex = "0" + md5Hex;
	    }
	 
	    return md5Hex;
	}

	@Override
	public String getPassword() {
		return paramDAO.getParamValueByName("PASSWORD");
	}

}
