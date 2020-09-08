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
public class heureConduite {	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long duree;
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
	public Long getDuree() {
		return duree;
	}
	public void setDuree(Long duree) {
		this.duree = duree;
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
		return "heureConduite [id=" + id + ", duree=" + duree + ", date=" + date + ", client=" + client + "]";
	}
	public heureConduite(Long id, Long duree, Date date, Client client) {
		super();
		this.id = id;
		this.duree = duree;
		this.date = date;
		this.client = client;
	}
	public heureConduite() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	}
