package com.example.stock.webRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.stock.Bean.Employe;
import com.example.stock.Service.Facade.EmployeService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/autoEcole-Api/Employe/")
public class EmployeRest {
	@Autowired
private EmployeService employeService;
	@DeleteMapping("deleteById/id/{id}")
	public int deleteById(@PathVariable Long id) {
		return employeService.deleteById(id);
	}
	@GetMapping("findById/id/{id}")
	public Employe findById(@PathVariable Long id) {
		return employeService.findById(id);
	}
	@PostMapping("uploadFile")
	public int storeFile(@RequestParam("file") MultipartFile file) throws Exception {
		return employeService.storeFile(file);
	}
	@PostMapping("edit")
public int edit(Employe employe) {
		return employeService.edit(employe);
	}
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
@PostMapping("save")
public int save(@RequestBody Employe employe) {
	return employeService.save(employe);
}

}
