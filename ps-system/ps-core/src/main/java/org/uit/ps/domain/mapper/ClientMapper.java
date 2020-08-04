package org.uit.ps.domain.mapper;

import org.uit.ps.domain.Client;

public interface ClientMapper {
	public Client getClientByAccount(String account);
}
