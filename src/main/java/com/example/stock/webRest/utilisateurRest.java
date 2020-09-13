package com.example.stock.webRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stock.Bean.paimentDeEmploye;
import com.example.stock.Bean.utlisateur;
import com.example.stock.Service.Facade.paimentDeEmployeService;
import com.example.stock.Service.Facade.utilisateurService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/autoEcole-Api/utilisateur/")
public class utilisateurRest {
@Autowired
private utilisateurService utilisateurService;

@GetMapping("findByLogin/login/{login}")
public utlisateur findByLogin(@PathVariable String login) {
	return utilisateurService.findByLogin(login);
}
@PostMapping("save")
public int save(@RequestBody utlisateur heureConduite) {
	return utilisateurService.save(heureConduite);
}
@PostMapping("edit")
public int edit(@RequestBody utlisateur heureConduite) {
	return utilisateurService.edit(heureConduite);
}

public int deleteById(Long id) {
	return utilisateurService.deleteById(id);
}

public utlisateur findById(Long id) {
	return utilisateurService.findById(id);
}


}
