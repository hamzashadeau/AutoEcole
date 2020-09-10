package com.example.stock.Bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class paimentDeClient {	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Double montantRestantes;
	private Double montantpaye;
	private Double montantTotal;
	@Temporal(TemporalType.DATE)
	private Date date;
@ManyToOne
private Client client;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Double getMontantRestantes() {
	return montantRestantes;
}
public void setMontantRestantes(Double montantRestantes) {
	this.montantRestantes = montantRestantes;
}

public Double getMontantTotal() {
	return montantTotal;
}
public void setMontantTotal(Double montantTotal) {
	this.montantTotal = montantTotal;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public Client getClient() {
	return client;
}
public void setClient(Client client) {
	this.client = client;
}
public paimentDeClient() {
	super();
	// TODO Auto-generated constructor stub
}
public Double getMontantpaye() {
	return montantpaye;
}
public void setMontantpaye(Double montantpaye) {
	this.montantpaye = montantpaye;	
}
public paimentDeClient(Long id, Double montantRestantes, Double montantpaye, Double montantTotal, Date date,
		Client client) {
	super();
	this.id = id;
	this.montantRestantes = montantRestantes;
	this.montantpaye = montantpaye;
	this.montantTotal = montantTotal;
	this.date = date;
	this.client = client;
}
@Override
public String toString() {
	return "paimentDeClient [id=" + id + ", montantRestantes=" + montantRestantes + ", montantpaye=" + montantpaye
			+ ", montantTotal=" + montantTotal + ", date=" + date + ", client=" + client + "]";
}

	}
