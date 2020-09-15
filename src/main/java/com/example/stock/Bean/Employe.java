package com.example.stock.Bean;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Employe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nomFR;
	private String nomAR;
	private String prenomFR;
	private byte[] image;
	private String imageName;
	private String imageType;
	private String prenomAR;
	private String addresseFR;
	private String adresseAR;
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	private String cin;
	private Double salaire;
	private String gender;
	private String telephone;
	private String lieuNaissance;
	private String email;
	private String situationFamiliale;
	private int nbrEnfant;
	private Date dateEmbauche;
	
	public String getSituationFamiliale() {
		return situationFamiliale;
	}
	
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public void setSituationFamiliale(String situationFamiliale) {
		this.situationFamiliale = situationFamiliale;
	}
	public int getNbrEnfant() {
		return nbrEnfant;
	}
	public void setNbrEnfant(int nbrEnfant) {
		this.nbrEnfant = nbrEnfant;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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

	public Double getSalaire() {
		return salaire;
	}
	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}
	public String getLieuNaissance() {
		return lieuNaissance;
	}
	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}
	public Date getDateEmbauche() {
		return dateEmbauche;
	}
	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employe(Long id, String nomFR, String nomAR, String prenomFR, byte[] image, String imageName,
			String imageType, String prenomAR, String addresseFR, String adresseAR, Date dateNaissance, String cin,
			Double salaire, String gender, String telephone, String lieuNaissance, String email,
			String situationFamiliale, int nbrEnfant, Date dateEmbauche) {
		super();
		this.id = id;
		this.nomFR = nomFR;
		this.nomAR = nomAR;
		this.prenomFR = prenomFR;
		this.image = image;
		this.imageName = imageName;
		this.imageType = imageType;
		this.prenomAR = prenomAR;
		this.addresseFR = addresseFR;
		this.adresseAR = adresseAR;
		this.dateNaissance = dateNaissance;
		this.cin = cin;
		this.salaire = salaire;
		this.gender = gender;
		this.telephone = telephone;
		this.lieuNaissance = lieuNaissance;
		this.email = email;
		this.situationFamiliale = situationFamiliale;
		this.nbrEnfant = nbrEnfant;
		this.dateEmbauche = dateEmbauche;
	}
	@Override
	public String toString() {
		return "Employe [id=" + id + ", nomFR=" + nomFR + ", nomAR=" + nomAR + ", prenomFR=" + prenomFR + ", image="
				+ Arrays.toString(image) + ", imageName=" + imageName + ", imageType=" + imageType + ", prenomAR="
				+ prenomAR + ", addresseFR=" + addresseFR + ", adresseAR=" + adresseAR + ", dateNaissance="
				+ dateNaissance + ", cin=" + cin + ", salaire=" + salaire + ", gender=" + gender + ", telephone="
				+ telephone + ", lieuNaissance=" + lieuNaissance + ", email=" + email + ", situationFamiliale="
				+ situationFamiliale + ", nbrEnfant=" + nbrEnfant + ", dateEmbauche=" + dateEmbauche + "]";
	}
	
}
