package com.example.stock.webRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stock.Bean.Employe;
import com.example.stock.Service.Facade.EmployeService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/autoEcole-Api/Employe/")
public class EmployeRest {
	@Autowired
private EmployeService employeService;
@GetMapping("findAll")
public List<Employe> findAll(){
	return employeService.findAll();
}
public Employe findByNomFR(String nomFR) {
	return employeService.findByNomFR(nomFR);
}

public Employe findByPrenomFR(String prenomFR) {
	return employeService.findByPrenomFR(prenomFR);
}

public Employe findByPrenomFRAndNomFR(String prenomFR, String nomFR) {
	return employeService.findByPrenomFRAndNomFR(prenomFR, nomFR);
}

}
