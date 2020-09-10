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
public class Client {	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private byte[] image;
	private String imageName;
	private String imageType;
	private String gender;
	private String generatedcode;
	private String nomFR;
	private String nomAR;
	private String prenomFR;
	private String prenomAR;
	private String addresseFR;
	private String adresseAR;
	private String email;
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	@Temporal(TemporalType.DATE)
	private Date dateExamen;
	@Temporal(TemporalType.DATE)
	private Date dateInscription;
	private Boolean possedePermis;
	private String premisNumero;
	private String numeroDeSession;
	private String telephone;
	private String profession;
	private String niveauEtude;
	private String cin;
	private String permisDemande;
	private String langueExam;
	private String statusCondidat;
	private String moniteurTheorique;
	private String moniteurPratique;
	private String vehicule;
	private Double prixTotal;
	private Double prixRestantes;
	private Long totalHeureConduite;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
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
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public Date getDateExamen() {
		return dateExamen;
	}
	public void setDateExamen(Date dateExamen) {
		this.dateExamen = dateExamen;
	}
	public Date getDateInscription() {
		return dateInscription;
	}
	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
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
	public String getNumeroDeSession() {
		return numeroDeSession;
	}
	public void setNumeroDeSession(String numeroDeSession) {
		this.numeroDeSession = numeroDeSession;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getNiveauEtude() {
		return niveauEtude;
	}
	public void setNiveauEtude(String niveauEtude) {
		this.niveauEtude = niveauEtude;
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
	public String getLangueExam() {
		return langueExam;
	}
	public void setLangueExam(String langueExam) {
		this.langueExam = langueExam;
	}
	public String getStatusCondidat() {
		return statusCondidat;
	}
	public void setStatusCondidat(String statusCondidat) {
		this.statusCondidat = statusCondidat;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getImageType() {
		return imageType;
	}
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
	public Double getPrixTotal() {
		return prixTotal;
	}
	public void setPrixTotal(Double prixTotal) {
		this.prixTotal = prixTotal;
	}
	public Double getPrixRestantes() {
		return prixRestantes;
	}
	public void setPrixRestantes(Double prixRestantes) {
		this.prixRestantes = prixRestantes;
	}
	public Long getTotalHeureConduite() {
		return totalHeureConduite;
	}
	public void setTotalHeureConduite(Long totalHeureConduite) {
		this.totalHeureConduite = totalHeureConduite;
	}
	public Client(Long id, byte[] image, String imageName, String imageType, String gender, String generatedcode,
			String nomFR, String nomAR, String prenomFR, String prenomAR, String addresseFR, String adresseAR,
			String email, Date dateNaissance, Date dateExamen, Date dateInscription, Boolean possedePermis,
			String premisNumero, String numeroDeSession, String telephone, String profession, String niveauEtude,
			String cin, String permisDemande, String langueExam, String statusCondidat, String moniteurTheorique,
			String moniteurPratique, String vehicule, Double prixTotal, Double prixRestantes, Long totalHeureConduite) {
		super();
		this.id = id;
		this.image = image;
		this.imageName = imageName;
		this.imageType = imageType;
		this.gender = gender;
		this.generatedcode = generatedcode;
		this.nomFR = nomFR;
		this.nomAR = nomAR;
		this.prenomFR = prenomFR;
		this.prenomAR = prenomAR;
		this.addresseFR = addresseFR;
		this.adresseAR = adresseAR;
		this.email = email;
		this.dateNaissance = dateNaissance;
		this.dateExamen = dateExamen;
		this.dateInscription = dateInscription;
		this.possedePermis = possedePermis;
		this.premisNumero = premisNumero;
		this.numeroDeSession = numeroDeSession;
		this.telephone = telephone;
		this.profession = profession;
		this.niveauEtude = niveauEtude;
		this.cin = cin;
		this.permisDemande = permisDemande;
		this.langueExam = langueExam;
		this.statusCondidat = statusCondidat;
		this.moniteurTheorique = moniteurTheorique;
		this.moniteurPratique = moniteurPratique;
		this.vehicule = vehicule;
		this.prixTotal = prixTotal;
		this.prixRestantes = prixRestantes;
		this.totalHeureConduite = totalHeureConduite;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", image=" + Arrays.toString(image) + ", imageName=" + imageName + ", imageType="
				+ imageType + ", gender=" + gender + ", generatedcode=" + generatedcode + ", nomFR=" + nomFR
				+ ", nomAR=" + nomAR + ", prenomFR=" + prenomFR + ", prenomAR=" + prenomAR + ", addresseFR="
				+ addresseFR + ", adresseAR=" + adresseAR + ", email=" + email + ", dateNaissance=" + dateNaissance
				+ ", dateExamen=" + dateExamen + ", dateInscription=" + dateInscription + ", possedePermis="
				+ possedePermis + ", premisNumero=" + premisNumero + ", numeroDeSession=" + numeroDeSession
				+ ", telephone=" + telephone + ", profession=" + profession + ", niveauEtude=" + niveauEtude + ", cin="
				+ cin + ", permisDemande=" + permisDemande + ", langueExam=" + langueExam + ", statusCondidat="
				+ statusCondidat + ", moniteurTheorique=" + moniteurTheorique + ", moniteurPratique=" + moniteurPratique
				+ ", vehicule=" + vehicule + ", prixTotal=" + prixTotal + ", prixRestantes=" + prixRestantes
				+ ", totalHeureConduite=" + totalHeureConduite + "]";
	}
	
	}
