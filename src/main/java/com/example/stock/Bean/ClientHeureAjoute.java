package com.example.stock.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class ClientHeureAjoute {	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String gender;
	private String generatedcode;
	private String nomFR;
	private String nomAR;
	private String prenomFR;
	private String prenomAR;
	private String addresseFR;
	private String adresseAR;
	private String email;
	private Boolean possedePermis;
	private String premisNumero;
	private String telephone;
	private String cin;
	private String permisDemande;
	private String moniteurTheorique;
	private String moniteurPratique;
	private String vehicule;
	private Double montant;
	@Temporal(TemporalType.DATE)
	private Date date;
	private Long duree;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGeneratedcode() {
		return generatedcode;
	}
	public void setGeneratedcode(String generatedcode) {
		this.generatedcode = generatedcode;
	}
	public String getNomFR() {
		return nomFR;
	}
	public void setNomFR(String nomFR) {
		this.nomFR = nomFR;
	}
	public String getNomAR() {
		return nomAR;
	}
	public void setNomAR(String nomAR) {
		this.nomAR = nomAR;
	}
	public String getPrenomFR() {
		return prenomFR;
	}
	public void setPrenomFR(String prenomFR) {
		this.prenomFR = prenomFR;
	}
	public String getPrenomAR() {
		return prenomAR;
	}
	public void setPrenomAR(String prenomAR) {
		this.prenomAR = prenomAR;
	}
	public String getAddresseFR() {
		return addresseFR;
	}
	public void setAddresseFR(String addresseFR) {
		this.addresseFR = addresseFR;
	}
	public String getAdresseAR() {
		return adresseAR;
	}
	public void setAdresseAR(String adresseAR) {
		this.adresseAR = adresseAR;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getPossedePermis() {
		return possedePermis;
	}
	public void setPossedePermis(Boolean possedePermis) {
		this.possedePermis = possedePermis;
	}
	public String getPremisNumero() {
		return premisNumero;
	}
	public void setPremisNumero(String premisNumero) {
		this.premisNumero = premisNumero;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getPermisDemande() {
		return permisDemande;
	}
	public void setPermisDemande(String permisDemande) {
		this.permisDemande = permisDemande;
	}
	public String getMoniteurTheorique() {
		return moniteurTheorique;
	}
	public void setMoniteurTheorique(String moniteurTheorique) {
		this.moniteurTheorique = moniteurTheorique;
	}
	public String getMoniteurPratique() {
		return moniteurPratique;
	}
	public void setMoniteurPratique(String moniteurPratique) {
		this.moniteurPratique = moniteurPratique;
	}
	public String getVehicule() {
		return vehicule;
	}
	public void setVehicule(String vehicule) {
		this.vehicule = vehicule;
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
	public Long getDuree() {
		return duree;
	}
	public void setDuree(Long duree) {
		this.duree = duree;
	}
	public ClientHeureAjoute(Long id, String gender, String generatedcode, String nomFR, String nomAR, String prenomFR,
			String prenomAR, String addresseFR, String adresseAR, String email, Boolean possedePermis,
			String premisNumero, String telephone, String cin, String permisDemande, String moniteurTheorique,
			String moniteurPratique, String vehicule, Double montant, Date date, Long duree) {
		super();
		this.id = id;
		this.gender = gender;
		this.generatedcode = generatedcode;
		this.nomFR = nomFR;
		this.nomAR = nomAR;
		this.prenomFR = prenomFR;
		this.prenomAR = prenomAR;
		this.addresseFR = addresseFR;
		this.adresseAR = adresseAR;
		this.email = email;
		this.possedePermis = possedePermis;
		this.premisNumero = premisNumero;
		this.telephone = telephone;
		this.cin = cin;
		this.permisDemande = permisDemande;
		this.moniteurTheorique = moniteurTheorique;
		this.moniteurPratique = moniteurPratique;
		this.vehicule = vehicule;
		this.montant = montant;
		this.date = date;
		this.duree = duree;
	}
	public ClientHeureAjoute() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ClientHeureAjoute [id=" + id + ", gender=" + gender + ", generatedcode=" + generatedcode + ", nomFR="
				+ nomFR + ", nomAR=" + nomAR + ", prenomFR=" + prenomFR + ", prenomAR=" + prenomAR + ", addresseFR="
				+ addresseFR + ", adresseAR=" + adresseAR + ", email=" + email + ", possedePermis=" + possedePermis
				+ ", premisNumero=" + premisNumero + ", telephone=" + telephone + ", cin=" + cin + ", permisDemande="
				+ permisDemande + ", moniteurTheorique=" + moniteurTheorique + ", moniteurPratique=" + moniteurPratique
				+ ", vehicule=" + vehicule + ", montant=" + montant + ", date=" + date + ", duree=" + duree + "]";
	}
	}
