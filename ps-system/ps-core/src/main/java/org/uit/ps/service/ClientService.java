package org.uit.ps.service;

import org.uit.ps.domain.Client;

public interface ClientService {
	public Client getClientByAccount(String account);
}
