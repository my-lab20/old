package org.uit.ps.ws.servlet;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.uit.ps.domain.Client;
import org.uit.ps.service.ClientService;
import org.uit.ps.service.ContentService;
import org.uit.ps.service.SecurityService;

@RestController
//@RequestMapping("/balance")
public class GetBalanceController {

	@Autowired
	private ClientService clientService;
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private ContentService contentService;
	
	@RequestMapping(value="/balance/{account}", 
			method = RequestMethod.GET,  
			produces={"application/json"})
	public Client getBalance(@PathVariable String account) {
		Client client = clientService.getClientByAccount(account);
        return client;
    }
	
	@RequestMapping(value="/findClient", 
			method = RequestMethod.POST,  
			produces={"text/xml;charset=UTF-8"})
	public String getClient(@RequestBody String input, HttpServletRequest request) throws Exception {
		try {
			String clientIP = request.getRemoteHost();
			if (!securityService.isValidIP(clientIP)) {
				return contentService.getResponse(null, 10, "Запрос выполнен с неразрешенного адреса");
			}
			
			String account = contentService.getTagContent("account", input);
			String content = contentService.getContentForSign(input);
			String sign = contentService.getTagContent("sign", input);
			String signContent = securityService.getHash(content);
			
			if (signContent.equalsIgnoreCase(sign)) {
				Client client = clientService.getClientByAccount(account);
				return contentService.getResponse(client, 0, "Успешное выполнение операции");
			}
			else {
				return contentService.getResponse(null, 13, "Неверная цифровая подпись");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

		//return null;
	}
}