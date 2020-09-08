package com.example.stock.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.Bean.Employe;
import com.example.stock.Dao.EmployeDao;
import com.example.stock.Service.Facade.EmployeService;
@Service
public class EmployeServiceImpl implements EmployeService {
@Autowired
private EmployeDao employeDao;
	@Override
	public Employe findByNomFR(String nomFR) {
		return employeDao.findByNomFR(nomFR);
	}

	@Override
	public Employe findByPrenomFR(String prenomFR) {
		return employeDao.findByPrenomFR(prenomFR);
	}

	@Override
	public Employe findByPrenomFRAndNomFR(String prenomFR, String nomFR) {
		return employeDao.findByPrenomFRAndNomFR(prenomFR, nomFR);
	}

	@Override
	public List<Employe> findAll() {
		return employeDao.findAll();
	}

}
