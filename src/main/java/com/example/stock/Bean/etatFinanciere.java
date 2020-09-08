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
public class etatFinanciere {	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	private String type;
	private Long monant;
	@Temporal(TemporalType.DATE)
	private Date date;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getMonant() {
		return monant;
	}
	public void setMonant(Long monant) {
		this.monant = monant;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "etatFinanciere [id=" + id + ", nom=" + nom + ", type=" + type + ", monant=" + monant + ", date=" + date
				+ "]";
	}
	public etatFinanciere(Long id, String nom, String type, Long monant, Date date) {
		super();
		this.id = id;
		this.nom = nom;
		this.type = type;
		this.monant = monant;
		this.date = date;
	}
	public etatFinanciere() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	}
