package com.example.stock.Service.Facade;

import java.util.Date;
import java.util.List;

import com.example.stock.Bean.Client;
import com.example.stock.Bean.HistoriqueApplication;

public interface HistoriqueApplicationService {
	public int save(HistoriqueApplication heureConduite);
	public int edit(HistoriqueApplication heureConduite);
	public int deleteById(Long id);
	public HistoriqueApplication findById(Long id);
	public List<HistoriqueApplication> findByDate(Date date);
	public List<HistoriqueApplication> findAll();
}
