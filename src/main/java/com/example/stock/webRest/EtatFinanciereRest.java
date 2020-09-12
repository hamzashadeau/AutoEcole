package com.example.stock.webRest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stock.Bean.etatFinanciere;
import com.example.stock.Service.Facade.EtatFinanciereService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/autoEcole-Api/EtatFinanciere/")
public class EtatFinanciereRest {
@Autowired
private EtatFinanciereService etatFinanciereService;


@GetMapping("findByTypeAndDate/type/{type}/date/{date}")
public List<etatFinanciere> findByTypeAndDate(@PathVariable String type,@PathVariable Date date) {
	return etatFinanciereService.findByTypeAndDate(type, date);
}

@GetMapping("findByDate/{date}")
public List<etatFinanciere> findByDate(@PathVariable Date date) {
	return etatFinanciereService.findByDate(date);
}

public List<etatFinanciere> findAll() {
	return etatFinanciereService.findAll();
}

public int save(etatFinanciere employe) {
	return etatFinanciereService.save(employe);
}

public int edit(etatFinanciere employe) {
	return etatFinanciereService.edit(employe);
}

public int deleteById(Long id) {
	return etatFinanciereService.deleteById(id);
}

public etatFinanciere findById(Long id) {
	return etatFinanciereService.findById(id);
}

public List<etatFinanciere> findByType(String type) {
	return etatFinanciereService.findByType(type);
}
@GetMapping("findAllGainsByTypeAndmois/{mois}")
public List<etatFinanciere> findAllGainsByTypeAndmois(@PathVariable int mois) {
	return etatFinanciereService.findAllGainsByTypeAndmois("gains", mois);
}
@GetMapping("findAllDespensesByTypeAndmois/{mois}")
public List<etatFinanciere> findAllDespensesByTypeAndmois(@PathVariable int mois) {
	return etatFinanciereService.findAllDespensesByTypeAndmois("despenses", mois);
}

}
