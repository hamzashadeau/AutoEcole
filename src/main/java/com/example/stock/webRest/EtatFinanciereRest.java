package com.example.stock.webRest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stock.Bean.etatFinanciere;
import com.example.stock.Service.Facade.EtatFinanciereService;

@RestController
@CrossOrigin("https://auto-ecole.herokuapp.com")
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
@PostMapping("save")
public int save(@RequestBody etatFinanciere employe) {
	return etatFinanciereService.save(employe);
}
@PostMapping("edit")
public int edit(@RequestBody etatFinanciere employe) {
	return etatFinanciereService.edit(employe);
}
@DeleteMapping("deleteById/{id}")
public int deleteById(@PathVariable Long id) {
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
@GetMapping("findAllGainsByTypeAndmoisAndAnnee/mois/{mois}/annee/{annee}")
public List<etatFinanciere> findAllGainsByTypeAndmoisAndAnnee(@PathVariable Integer mois,@PathVariable Integer annee) {
	return etatFinanciereService.findAllGainsByTypeAndmoisAndAnnee("gains", mois, annee);
}
@GetMapping("findAllDespensesByTypeAndmoisAndAnnee/mois/{mois}/annee/{annee}")
public List<etatFinanciere> findAllDespensesByTypeAndmoisAndAnnee(@PathVariable Integer mois,@PathVariable Integer annee) {
	return etatFinanciereService.findAllDespensesByTypeAndmoisAndAnnee("despenses", mois, annee);
}
}
