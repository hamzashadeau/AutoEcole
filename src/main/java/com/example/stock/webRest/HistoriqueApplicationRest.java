package com.example.stock.webRest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stock.Bean.HistoriqueApplication;
import com.example.stock.Bean.paimentDeEmploye;
import com.example.stock.Bean.utlisateur;
import com.example.stock.Service.Facade.HistoriqueApplicationService;
import com.example.stock.Service.Facade.paimentDeEmployeService;
import com.example.stock.Service.Facade.utilisateurService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/autoEcole-Api/historiqueApplication/")
public class HistoriqueApplicationRest {
@Autowired
private HistoriqueApplicationService historiqueApplicationService;
@PostMapping("save")
public int save(HistoriqueApplication heureConduite) {
	return historiqueApplicationService.save(heureConduite);
}
@PostMapping("edit")
public int edit(HistoriqueApplication heureConduite) {
	return historiqueApplicationService.edit(heureConduite);
}
public HistoriqueApplication findById(Long id) {
	return historiqueApplicationService.findById(id);
}
@GetMapping("findByDate/date/{date}")
public List<HistoriqueApplication> findByDate(@PathVariable Date date) {
	return historiqueApplicationService.findByDate(date);
}



}
