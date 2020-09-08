package com.example.stock.Service.Facade;

import com.example.stock.Bean.Client;

public interface ClientService {
	Client findByGeneratedcode(String generatedCode);
	Client findByNomFR(String nomFR);
	Client findByPrenomFR(String prenomFR);
	Client findByPrenomFRAndNomFR(String prenomFR,String nomFR);
}
