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

import com.example.stock.Bean.paimentDeClient;
import com.example.stock.Service.Facade.paimentDeClientService;

@RestController
@CrossOrigin("https://auto-ecole.herokuapp.com/")
@RequestMapping("/autoEcole-Api/paimentDeClient/")
public class paimentDeClientRest {
@Autowired
private paimentDeClientService paimentDeClientService;
@PostMapping("save")
public int save(@RequestBody paimentDeClient heureConduite) {
	return paimentDeClientService.save(heureConduite);
}
@PostMapping("edit")
public int edit(paimentDeClient heureConduite) {
	return paimentDeClientService.edit(heureConduite);
}

public int deleteById(Long id) {
	return paimentDeClientService.deleteById(id);
}

public paimentDeClient findById(Long id) {
	return paimentDeClientService.findById(id);
}

@GetMapping("findByclientCin/{cin}")
public List<paimentDeClient> findByclientCin(@PathVariable String cin) {
		return paimentDeClientService.findByclientCin(cin);
}


}
