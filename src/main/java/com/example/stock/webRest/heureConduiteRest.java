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

import com.example.stock.Bean.Client;
import com.example.stock.Bean.heureConduite;
import com.example.stock.Service.Facade.heureConduiteService;

@RestController
@CrossOrigin("https://auto-ecole.herokuapp.com/")
@RequestMapping("/autoEcole-Api/heureConduite/")
public class heureConduiteRest {
@Autowired
private heureConduiteService heureConduiteService;
@GetMapping("findByClientCin/{cin}")
public List<heureConduite> findByClientCin(@PathVariable String cin) {
	return heureConduiteService.findByClientCin(cin);
}
@PostMapping("/save")
public int save(@RequestBody heureConduite client) {
	return heureConduiteService.save(client);
}
@PostMapping("/edit")
public int edit(@RequestBody heureConduite client) {
	return heureConduiteService.edit(client);
}

public int deleteById(Long id) {
	return heureConduiteService.deleteById(id);
}

public heureConduite findById(Long id) {
	return heureConduiteService.findById(id);
}
}
