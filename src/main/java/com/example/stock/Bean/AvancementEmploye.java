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
public class AvancementEmploye {	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Double montant;
	@Temporal(TemporalType.DATE)
	private Date date;
	@ManyToOne
	private Employe employe;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public AvancementEmploye(Long id, Double montant, Date date, Employe employe) {
		super();
		this.id = id;
		this.montant = montant;
		this.date = date;
		this.employe = employe;
	}
	@Override
	public String toString() {
		return "AvancementEmploye [id=" + id + ", montant=" + montant + ", date=" + date + ", employe=" + employe + "]";
	}
	public AvancementEmploye() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	}
