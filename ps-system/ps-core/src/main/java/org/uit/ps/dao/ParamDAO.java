package org.uit.ps.dao;

import org.uit.ps.domain.Param;

public interface ParamDAO {
	public Param getParam(int id);
	public String getParamValueByName(String name);
}
