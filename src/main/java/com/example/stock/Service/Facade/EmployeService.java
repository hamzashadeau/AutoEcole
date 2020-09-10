package com.example.stock.Service.Facade;

import java.util.List;

import com.example.stock.Bean.Employe;

public interface EmployeService {
	Employe findByNomFR(String nomFR);
	Employe findByPrenomFR(String prenomFR);
	Employe findByPrenomFRAndNomFR(String prenomFR,String nomFR);
	List<Employe> findAll();
	public int save(Employe employe);
	public int edit(Employe employe);
	public int deleteById(Long id);
	public Employe findById(Long id);

}
