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
public class utlisateur {	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private Employe employe;
	private String login;
	private String modDePasse;

    

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getModDePasse() {
		return modDePasse;
	}
	public void setModDePasse(String modDePasse) {
		this.modDePasse = modDePasse;
	}
	public utlisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public utlisateur(Long id, Employe employe, String login, String modDePasse) {
		super();
		this.id = id;
		this.employe = employe;
		this.login = login;
		this.modDePasse = modDePasse;
	}
	
	@Override
	public String toString() {
		return "utlisateur [id=" + id + ", employe=" + employe + ", login=" + login + ", modDePasse=" + modDePasse
				+ "]";
	}
	
		}
