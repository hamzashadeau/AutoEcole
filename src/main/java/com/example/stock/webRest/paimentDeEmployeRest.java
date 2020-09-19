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
import com.example.stock.Service.Facade.paimentDeEmployeService;

@RestController
@CrossOrigin("https://auto-ecole.herokuapp.com/")
@RequestMapping("/autoEcole-Api/paimentDeEmploye/")
public class paimentDeEmployeRest {
@Autowired
private paimentDeEmployeService paimentDeEmployeService;
@PostMapping("save")
public int save(@RequestBody paimentDeEmploye heureConduite) {
	return paimentDeEmployeService.save(heureConduite);
}
@PostMapping("edit")
public int edit(@RequestBody paimentDeEmploye heureConduite) {
	return paimentDeEmployeService.edit(heureConduite);
}

public int deleteById(Long id) {
	return paimentDeEmployeService.deleteById(id);
}

public paimentDeEmploye findById(Long id) {
	return paimentDeEmployeService.findById(id);
}
@GetMapping("findByEmployeCinAndMois/cin/{cin}/mois/{mois}")
public List<paimentDeEmploye> findByEmployeCinAndMois(@PathVariable String cin, @PathVariable int mois) {
	return paimentDeEmployeService.findByEmployeCinAndMois(cin, mois);
}

}
