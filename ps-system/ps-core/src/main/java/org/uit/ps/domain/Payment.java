package org.uit.ps.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
public class Payment {
	@XmlTransient
	public long id;
	public String payeeName;
	public String personalAcc;
	public String bankName;
	public String bic;
	public String correspAcc;
	public Integer sum;
	public String purpose;
	public String payeeINN;
	public String payerINN;
	public Integer drawerStatus;
	public String kpp;
	public String cbc;
	public String oktmo;
	public String taxPeriod;
	public String taxPaytkind;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public String getPersonalAcc() {
		return personalAcc;
	}
	public void setPersonalAcc(String personalAcc) {
		this.personalAcc = personalAcc;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBic() {
		return bic;
	}
	public void setBic(String bic) {
		this.bic = bic;
	}
	public String getCorrespAcc() {
		return correspAcc;
	}
	public void setCorrespAcc(String correspAcc) {
		this.correspAcc = correspAcc;
	}
	public Integer getSum() {
		return sum;
	}
	public void setSum(Integer sum) {
		this.sum = sum;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getPayeeINN() {
		return payeeINN;
	}
	public void setPayeeINN(String payeeINN) {
		this.payeeINN = payeeINN;
	}
	public String getPayerINN() {
		return payerINN;
	}
	public void setPayerINN(String payerINN) {
		this.payerINN = payerINN;
	}
	public Integer getDrawerStatus() {
		return drawerStatus;
	}
	public void setDrawerStatus(Integer drawerStatus) {
		this.drawerStatus = drawerStatus;
	}
	public String getKpp() {
		return kpp;
	}
	public void setKpp(String kpp) {
		this.kpp = kpp;
	}
	public String getCbc() {
		return cbc;
	}
	public void setCbc(String cbc) {
		this.cbc = cbc;
	}
	public String getOktmo() {
		return oktmo;
	}
	public void setOktmo(String oktmo) {
		this.oktmo = oktmo;
	}
	public String getTaxPeriod() {
		return taxPeriod;
	}
	public void setTaxPeriod(String taxPeriod) {
		this.taxPeriod = taxPeriod;
	}
	public String getTaxPaytkind() {
		return taxPaytkind;
	}
	public void setTaxPaytkind(String taxPaytkind) {
		this.taxPaytkind = taxPaytkind;
	}
}



