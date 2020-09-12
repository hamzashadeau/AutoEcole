package com.example.stock.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.Bean.Client;
import com.example.stock.Bean.heureConduite;
import com.example.stock.Bean.paimentDeClient;
import com.example.stock.Bean.paimentDeEmploye;
import com.example.stock.Dao.paimentDeClientDao;
import com.example.stock.Service.Facade.ClientService;
import com.example.stock.Service.Facade.paimentDeClientService;

@Service
public class paimentDeClientServiceImpl implements paimentDeClientService{
	@Autowired
	private paimentDeClientDao paimentClientDao;
	@Autowired
	private ClientService clientDervice;

	@Override
	public List<paimentDeClient> findByclientCin(String cin) {
		return paimentClientDao.findByClientCin(cin);
	}
	@Override
	public int save(paimentDeClient heureConduite) {
		if(heureConduite.getId()!= null) {
			return -1;
		}else {
			Client paimentDeClient = this.clientDervice.findById(heureConduite.getClient().getId());
			Double montantRestantes = paimentDeClient.getPrixRestantes()-heureConduite.getMontantpaye();
			paimentDeClient.setPrixRestantes(montantRestantes);
			heureConduite.setMontantRestantes(montantRestantes);
			heureConduite.setMontantTotal(paimentDeClient.getPrixTotal());
			this.clientDervice.edit(paimentDeClient);
			paimentClientDao.save(heureConduite);
		 return 1;
	}
	}

	@Override
	public int edit(paimentDeClient heureConduite) {
		if(heureConduite.getId()== null) {
			return -1;
		}else {
			paimentClientDao.save(heureConduite);
		 return 1;
	}
	}

	@Override
	public int deleteById(Long id) {
		paimentClientDao.deleteById(id);
		paimentDeClient heureConduite = findById(id);
		if(heureConduite== null) {
			return 1;
		}else {
		return -1;
	}
	}
	@Override
	public paimentDeClient findById(Long id) {
		return paimentClientDao.findById(id).get();
	}

}
