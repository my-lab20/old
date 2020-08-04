package org.uit.ps.dao;

import org.uit.ps.domain.Client;

public interface ClientDAO {
	public Client getClientByAccount(String account);
}
