package com.example.stock.webRest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

import com.example.stock.Bean.Client;
import com.example.stock.Bean.ClientHeureAjoute;
import com.example.stock.Service.Facade.ClientHeureAjouteService;
import com.example.stock.Service.Facade.ClientService;


@RestController
@CrossOrigin("https://gifted-yalow-41f4d8.netlify.app/")
@RequestMapping("/autoEcole-Api/ClientHeureAjoute/")
public class ClientHeureAjouteRest {
@Autowired
private ClientHeureAjouteService clientService;
@GetMapping("findByDateAujourdHui")
public List<ClientHeureAjoute> findByDateAujourdHui() {
	return clientService.findByDateAujourdHui();
}
@GetMapping("findByDateAvant")
public List<ClientHeureAjoute> findByDateAvant() {
	return clientService.findByDateAvant();
}
@GetMapping("findByDateSuivant")
public List<ClientHeureAjoute> findByDateSuivant() {
	return clientService.findByDateSuivant();
}
@GetMapping("findByDate/date/{date}")
public List<ClientHeureAjoute> findByDate(@PathVariable Date date) {
	return clientService.findByDate(date);
}
@PostMapping("save")
public int save(@RequestBody ClientHeureAjoute client) {
	return clientService.save(client);
}
@PostMapping("edit")
public int edit(@RequestBody ClientHeureAjoute client) {
	return clientService.edit(client);
}
@DeleteMapping("deleteById/{id}")
public int deleteById(@PathVariable Long id) {
	return clientService.deleteById(id);
}
@GetMapping("findById/{id}")
public ClientHeureAjoute findById(@PathVariable Long id) {
	return clientService.findById(id);
}

@GetMapping("findAll")
public List<ClientHeureAjoute> findAll() {
	return clientService.findAll();
}

public ClientHeureAjoute findByGeneratedcode(String generatedCode) {
	return clientService.findByGeneratedcode(generatedCode);
}

public ClientHeureAjoute findByNomFR(String nomFR) {
	return clientService.findByNomFR(nomFR);
}

public ClientHeureAjoute findByPrenomFR(String prenomFR) {
	return clientService.findByPrenomFR(prenomFR);
}

public ClientHeureAjoute findByPrenomFRAndNomFR(String prenomFR, String nomFR) {
	return clientService.findByPrenomFRAndNomFR(prenomFR, nomFR);
}

}
