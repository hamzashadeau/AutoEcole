package com.example.stock.Service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.Bean.Client;
import com.example.stock.Bean.HistoriqueApplication;
import com.example.stock.Bean.paimentDeClient;
import com.example.stock.Bean.paimentDeEmploye;
import com.example.stock.Bean.utlisateur;
import com.example.stock.Dao.HistoriqueApplicationDao;
import com.example.stock.Dao.UtilisateurDao;
import com.example.stock.Dao.paimentDeEmployeDao;
import com.example.stock.Service.Facade.ClientService;
import com.example.stock.Service.Facade.HistoriqueApplicationService;
import com.example.stock.Service.Facade.paimentDeEmployeService;
import com.example.stock.Service.Facade.utilisateurService;

@Service
public class HistoriqueApplicationServiceImpl implements HistoriqueApplicationService{
	@Autowired
	private HistoriqueApplicationDao historiqueApplicationDao;
	@Autowired
	private ClientService clientService;
	
	@Override
	public int save(HistoriqueApplication heureConduite) {
		if(heureConduite.getId()!= null) {
			return -1;
		}else {
			historiqueApplicationDao.save(heureConduite);
		 return 1;
	}
	}
	@Override
	public int edit(HistoriqueApplication heureConduite) {
		if(heureConduite.getId() == null) {
			return -1;
		}else {
			historiqueApplicationDao.save(heureConduite);
			return 1;
		}
	}
	@Override
	public int deleteById(Long id) {
		historiqueApplicationDao.deleteById(id);
		HistoriqueApplication heureConduite = findById(id);
		if(heureConduite== null) {
			return 1;
		}else {
		return -1;
	}
	}
	@Override
	public HistoriqueApplication findById(Long id) {
		return historiqueApplicationDao.findById(id).get();
	}
	@Override
	public List<HistoriqueApplication> findByDate(Date date) {
		return historiqueApplicationDao.findByDate(date);
	}

}
