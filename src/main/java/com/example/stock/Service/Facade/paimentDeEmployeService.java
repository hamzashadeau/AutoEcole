package com.example.stock.Service.Facade;

import java.util.List;

import com.example.stock.Bean.paimentDeEmploye;

public interface paimentDeEmployeService {
	public int save(paimentDeEmploye heureConduite);
	public int edit(paimentDeEmploye heureConduite);
	public int deleteById(Long id);
	public paimentDeEmploye findById(Long id);
	public List<paimentDeEmploye> findByEmployeCinAndMois(String cin, int mois);

}
