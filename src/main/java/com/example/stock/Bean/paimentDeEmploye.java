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
public class paimentDeEmploye {	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long montantRestantes;
	private Long monatantpaye;
	private Long montantTotal;
	@Temporal(TemporalType.DATE)
	private Date date;
	@JsonProperty(access = Access.WRITE_ONLY)
@ManyToOne
private Employe employe;
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

public paimentDeEmploye() {
	super();
	// TODO Auto-generated constructor stub
}
public Employe getEmploye() {
	return employe;
}
public void setEmploye(Employe employe) {
	this.employe = employe;
}
public paimentDeEmploye(Long id, Long montantRestantes, Long monatantpaye, Long montantTotal, Date date,
		Employe employe) {
	super();
	this.id = id;
	this.montantRestantes = montantRestantes;
	this.monatantpaye = monatantpaye;
	this.montantTotal = montantTotal;
	this.date = date;
	this.employe = employe;
}
@Override
public String toString() {
	return "paimentDeEmploye [id=" + id + ", montantRestantes=" + montantRestantes + ", monatantpaye=" + monatantpaye
			+ ", montantTotal=" + montantTotal + ", date=" + date + ", employe=" + employe + "]";
}


	}
