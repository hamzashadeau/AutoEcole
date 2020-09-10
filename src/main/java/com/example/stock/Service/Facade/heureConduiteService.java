package com.example.stock.Service.Facade;

import java.util.List;

import com.example.stock.Bean.heureConduite;

public interface heureConduiteService {
	List<heureConduite> findByClientCin(String cin);
	public int save(heureConduite heureConduite);
	public int edit(heureConduite heureConduite);
	public int deleteById(Long id);
	public heureConduite findById(Long id);
	
}
