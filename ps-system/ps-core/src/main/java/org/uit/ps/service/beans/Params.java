package org.uit.ps.service.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import org.uit.ps.domain.Payment;

@XmlAccessorType(XmlAccessType.FIELD)
public class Params {
	@XmlElement(name="err_code")
	private int errorCode;
	@XmlElement(name="err_text")
	private String errorText;
	@XmlElement(name="account")
	private String account;
	@XmlElement(name="lastName")
	private String lastName;
	@XmlElement(name="firstName")
	private String firstName;
	@XmlElement(name="middleName")
	private String middleName;
	@XmlElement(name="payerAddress")
	private String payerAddress;
	@XmlElement(name="payment")
	private List<Payment> payments;
	
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorText() {
		return errorText;
	}
	public void setErrorText(String errorText) {
		this.errorText = errorText;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getPayerAddress() {
		return payerAddress;
	}
	public void setPayerAddress(String payerAddress) {
		this.payerAddress = payerAddress;
	}
	public List<Payment> getPayments() {
		return payments;
	}
	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}
}
