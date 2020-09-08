package com.example.stock.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class etatFinanciereParMois {	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long monantRestantes;
	private int mois;
	private Long annee;
	@OneToMany
	private List<etatFinanciere> etatFinancieres = new ArrayList<etatFinanciere>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getMonantRestantes() {
		return monantRestantes;
	}
	public void setMonantRestantes(Long monantRestantes) {
		this.monantRestantes = monantRestantes;
	}
	public int getMois() {
		return mois;
	}
	public void setMois(int mois) {
		this.mois = mois;
	}
	public Long getAnnee() {
		return annee;
	}
	public void setAnnee(Long annee) {
		this.annee = annee;
	}
	public List<etatFinanciere> getEtatFinancieres() {
		return etatFinancieres;
	}
	public void setEtatFinancieres(List<etatFinanciere> etatFinancieres) {
		this.etatFinancieres = etatFinancieres;
	}
	@Override
	public String toString() {
		return "etatFinanciereParMois [id=" + id + ", monantRestantes=" + monantRestantes + ", mois=" + mois
				+ ", annee=" + annee + ", etatFinancieres=" + etatFinancieres + "]";
	}
	public etatFinanciereParMois(Long id, Long monantRestantes, int mois, Long annee,
			List<etatFinanciere> etatFinancieres) {
		super();
		this.id = id;
		this.monantRestantes = monantRestantes;
		this.mois = mois;
		this.annee = annee;
		this.etatFinancieres = etatFinancieres;
	}
	public etatFinanciereParMois() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	}
