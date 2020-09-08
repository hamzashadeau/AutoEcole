package com.example.stock.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.Bean.Client;
import com.example.stock.Dao.ClientDao;
import com.example.stock.Service.Facade.ClientService;
@Service
public class ClientServiceImpl implements ClientService {
@Autowired
private ClientDao clientDao;
	@Override
	public Client findByGeneratedcode(String generatedCode) {
		return clientDao.findByGeneratedcode(generatedCode);
	}

	@Override
	public Client findByNomFR(String nomFR) {
		return clientDao.findByNomFR(nomFR);
	}

	@Override
	public Client findByPrenomFR(String prenomFR) {
		return clientDao.findByPrenomFR(prenomFR);
	}

	@Override
	public Client findByPrenomFRAndNomFR(String prenomFR, String nomFR) {
		return clientDao.findByPrenomFRAndNomFR(prenomFR, nomFR);
	}

}
