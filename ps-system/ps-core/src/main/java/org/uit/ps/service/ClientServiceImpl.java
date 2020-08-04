package org.uit.ps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uit.ps.dao.ClientDAO;
import org.uit.ps.domain.Client;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDAO clientDAO;
	
	@Override
	public Client getClientByAccount(String account) {
		return clientDAO.getClientByAccount(account);
	}
	
}
