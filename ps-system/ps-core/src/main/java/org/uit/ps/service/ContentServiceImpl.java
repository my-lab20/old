package org.uit.ps.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uit.ps.domain.Client;
import org.uit.ps.service.beans.Params;
import org.uit.ps.service.beans.Response;
import org.uit.ps.util.ResourceLoader;

@Service
public class ContentServiceImpl implements ContentService {
	
	@Autowired
	private SecurityService securityService;

	@Override
	public String getTagContent(String tagName, String value) {
		Pattern pattern = Pattern.compile(MessageFormat.format("<{0}>([\\s\\S]+?)</{0}>", tagName));
		Matcher matcher = pattern.matcher(value);
		if (matcher.find())
			return matcher.group(1);
		return null;
	}

	@Override
	public String getResponse(Client client, int errCode, String errText) throws Exception {
		Response response = new Response();
		Params params = new Params();
		response.setParams(params);
		params.setErrorCode(errCode);
		params.setErrorText(errText);
		if (client != null) {
			params.setAccount(client.getAccount());
			params.setLastName(client.getLastName());
			params.setFirstName(client.getFirstName());
			params.setMiddleName(client.getMiddleName());
			params.setPayerAddress(client.getAddress());
			params.setPayments(client.getPayments());
		}
		
		JAXBContext context = JAXBContext.newInstance(Response.class);
		Marshaller marshaller = context.createMarshaller();    
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.FALSE);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "Windows-1251");
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		outputStream.write(new String("<?xml version=\"1.0\" encoding=\"Windows-1251\"?>\n").getBytes("Windows-1251"));
		marshaller.marshal(response, outputStream);
		String res = outputStream.toString("windows-1251");
		
		String content = getContentForSign(res);
		String sign = securityService.getHash(content);
		return MessageFormat.format(res, sign);
		
//		String responseTemplate = ResourceLoader.getTextFileContent(this.getClass().getClassLoader(), "response.xml");
//		return MessageFormat.format(responseTemplate, errCode, errText, client.getAccount(), 
//				client.getClientName(), client.getBalance(), sign);
	}

	@Override
	public String getContentForSign(String value) {
		return getTagContent("params", value);
	}

}
