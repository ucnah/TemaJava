package com.scaietii.PaymentSystem.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contract {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Provider provider;
	private Client client;
	private Service service;
	private Boolean automaticPayment;
	private int billsNotPayed;
	
	
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Boolean getAutomaticPayment() {
		return automaticPayment;
	}
	public void setAutomaticPayment(Boolean automaticPayment) {
		this.automaticPayment = automaticPayment;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public int getBillsNotPayed() {
		return billsNotPayed;
	}
	public void setBillsNotPayed(int billsNotPayed) {
		this.billsNotPayed = billsNotPayed;
	}
}
