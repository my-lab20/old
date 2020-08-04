package org.uit.ps.service;

public interface SecurityService {
	public String getHash(String value);
	public boolean isValidIP(String ip);
	public String getPassword();
}
