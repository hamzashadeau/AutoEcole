package com.example.stock.webRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stock.Bean.Client;
import com.example.stock.Service.Facade.ClientService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/autoEcole-Api/client/")
public class ClientRest {
@Autowired
private ClientService clientService;

public Client findByGeneratedcode(String generatedCode) {
	return clientService.findByGeneratedcode(generatedCode);
}

public Client findByNomFR(String nomFR) {
	return clientService.findByNomFR(nomFR);
}

public Client findByPrenomFR(String prenomFR) {
	return clientService.findByPrenomFR(prenomFR);
}

public Client findByPrenomFRAndNomFR(String prenomFR, String nomFR) {
	return clientService.findByPrenomFRAndNomFR(prenomFR, nomFR);
}
}
