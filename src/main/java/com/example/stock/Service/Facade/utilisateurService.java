package com.example.stock.Service.Facade;

import com.example.stock.Bean.utlisateur;

public interface utilisateurService {
	public int save(utlisateur heureConduite);
	public int edit(utlisateur heureConduite);
	public int deleteById(Long id);
	public utlisateur findById(Long id);
	public utlisateur findByLogin(String login);
}
