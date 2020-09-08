package com.example.stock.Bean;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class paimentDeEmploye {	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long montantRestantes;
	private Long monatantpaye;
	private Long montantTotal;
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
public Long getMontantRestantes() {
	return montantRestantes;
}
public void setMontantRestantes(Long montantRestantes) {
	this.montantRestantes = montantRestantes;
}
public Long getMonatantpaye() {
	return monatantpaye;
}
public void setMonatantpaye(Long monatantpaye) {
	this.monatantpaye = monatantpaye;
}
public Long getMontantTotal() {
	return montantTotal;
}
public void setMontantTotal(Long montantTotal) {
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
@Override
public String toString() {
	return "paimentDeEmploye [id=" + id + ", montantRestantes=" + montantRestantes + ", monatantpaye=" + monatantpaye
			+ ", montantTotal=" + montantTotal + ", date=" + date + ", client=" + client + "]";
}
public paimentDeEmploye(Long id, Long montantRestantes, Long monatantpaye, Long montantTotal, Date date,
		Client client) {
	super();
	this.id = id;
	this.montantRestantes = montantRestantes;
	this.monatantpaye = monatantpaye;
	this.montantTotal = montantTotal;
	this.date = date;
	this.client = client;
}
public paimentDeEmploye() {
	super();
	// TODO Auto-generated constructor stub
}


	}
