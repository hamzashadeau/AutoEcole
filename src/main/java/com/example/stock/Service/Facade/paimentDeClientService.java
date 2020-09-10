package com.example.stock.Service.Facade;

import java.util.List;

import com.example.stock.Bean.paimentDeClient;

public interface paimentDeClientService {
	List<paimentDeClient> findByclientCin(String cin);
	public int save(paimentDeClient heureConduite);
	public int edit(paimentDeClient heureConduite);
	public int deleteById(Long id);
	public paimentDeClient findById(Long id);
}
