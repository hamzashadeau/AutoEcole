package com.example.stock.Service.Facade;

import java.util.Date;
import java.util.List;

import com.example.stock.Bean.Employe;
import com.example.stock.Bean.etatFinanciere;

public interface EtatFinanciereService {
	List<etatFinanciere> findAll();
	public int save(etatFinanciere employe);
	public int edit(etatFinanciere employe);
	public int deleteById(Long id);
	public etatFinanciere findById(Long id);
	public List<etatFinanciere> findByType(String type);
	public List<etatFinanciere> findAllGainsByTypeAndmois(String type, int mois);
	public List<etatFinanciere> findAllDespensesByTypeAndmois(String type, int mois);
	public List<etatFinanciere> findByDate(Date date);
	public List<etatFinanciere> findByTypeAndDate(String type,Date date);

}
