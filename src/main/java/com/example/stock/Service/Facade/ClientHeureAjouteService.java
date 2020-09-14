package com.example.stock.Service.Facade;

import java.util.Date;
import java.util.List;

import com.example.stock.Bean.ClientHeureAjoute;

public interface ClientHeureAjouteService {
	ClientHeureAjoute findByGeneratedcode(String generatedCode);
	ClientHeureAjoute findByNomFR(String nomFR);
	ClientHeureAjoute findByPrenomFR(String prenomFR);
	ClientHeureAjoute findByPrenomFRAndNomFR(String prenomFR,String nomFR);
	List<ClientHeureAjoute> findAll();
	public int save(ClientHeureAjoute client);
	public int edit(ClientHeureAjoute client);
	public int deleteById(Long id);
	public ClientHeureAjoute findById(Long id);
	public List<ClientHeureAjoute> findByDate(Date date);
	public List<ClientHeureAjoute> findByDateAujourdHui();
	public List<ClientHeureAjoute> findByDateAvant();
	public List<ClientHeureAjoute> findByDateSuivant();
}
