package com.example.stock.Bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Observation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String numeroSession;
	private String status;
	private Long score;
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
	public String getNumeroSession() {
		return numeroSession;
	}
	public void setNumeroSession(String numeroSession) {
		this.numeroSession = numeroSession;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getScore() {
		return score;
	}
	public void setScore(Long score) {
		this.score = score;
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
	public Observation(Long id, String numeroSession, String status, Long score, Date date, Employe employe) {
		super();
		this.id = id;
		this.numeroSession = numeroSession;
		this.status = status;
		this.score = score;
		this.date = date;
		this.employe = employe;
	}
	@Override
	public String toString() {
		return "Observation [id=" + id + ", numeroSession=" + numeroSession + ", status=" + status + ", score=" + score
				+ ", date=" + date + ", employe=" + employe + "]";
	}


	
	}
