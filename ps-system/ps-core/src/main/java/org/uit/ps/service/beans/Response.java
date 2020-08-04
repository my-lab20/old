package org.uit.ps.service.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="response")
@XmlAccessorType(XmlAccessType.FIELD)
public class Response {
	@XmlElement(name="params")
	private Params params;
	@XmlElement(name="sign")
	private String sign = "{0}";

	public Params getParams() {
		return params;
	}

	public void setParams(Params params) {
		this.params = params;
	}
}
