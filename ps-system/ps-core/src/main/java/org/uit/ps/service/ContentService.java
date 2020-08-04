package org.uit.ps.service;

import java.io.IOException;

import org.uit.ps.domain.Client;

public interface ContentService {
	public String getTagContent(String tagName, String value);
	public String getResponse(Client client, int errCode, String errText) throws Exception;
	public String getContentForSign(String value);
}
