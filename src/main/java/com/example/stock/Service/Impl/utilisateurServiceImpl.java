package com.example.stock.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.Bean.Client;
import com.example.stock.Bean.paimentDeClient;
import com.example.stock.Bean.paimentDeEmploye;
import com.example.stock.Bean.utlisateur;
import com.example.stock.Dao.UtilisateurDao;
import com.example.stock.Dao.paimentDeEmployeDao;
import com.example.stock.Service.Facade.ClientService;
import com.example.stock.Service.Facade.paimentDeEmployeService;
import com.example.stock.Service.Facade.utilisateurService;

@Service
public class utilisateurServiceImpl implements utilisateurService{
	@Autowired
	private UtilisateurDao utilisateurDao;
	@Autowired
	private ClientService clientService;
	
	@Override
	public int save(utlisateur heureConduite) {
		if(heureConduite.getId()!= null) {
			return -1;
		}else {
			utilisateurDao.save(heureConduite);
		 return 1;
	}
	}
	@Override
	public int edit(utlisateur heureConduite) {
		if(heureConduite.getId() == null) {
			return -1;
		}else {
			utilisateurDao.save(heureConduite);
			return 1;
		}
	}
	@Override
	public int deleteById(Long id) {
		utilisateurDao.deleteById(id);
		utlisateur heureConduite = findById(id);
		if(heureConduite== null) {
			return 1;
		}else {
		return -1;
	}
	}
	@Override
	public utlisateur findById(Long id) {
		return utilisateurDao.findById(id).get();
	}
	@Override
	public utlisateur findByLogin(String login) {
		return utilisateurDao.findByLogin(login);
	}
}
