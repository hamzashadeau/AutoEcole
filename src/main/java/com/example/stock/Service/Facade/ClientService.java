package com.example.stock.Service.Facade;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.stock.Bean.Client;
import com.example.stock.Bean.Employe;

public interface ClientService {
	Client findByGeneratedcode(String generatedCode);
	Client findByNomFR(String nomFR);
	Client findByPrenomFR(String prenomFR);
	Client findByPrenomFRAndNomFR(String prenomFR,String nomFR);
	List<Client> findAll();
	public int save(Client client);
	public int edit(Client client);
	public int deleteById(Long id);
	public Client findById(Long id);
	public int storeFile(MultipartFile file) throws Exception;
	public Client findByImageName(String image);
	public List<Client> findByDateExamen(Date dateExamen);
	public List<Client> findByDateAujourdHui();
	public List<Client> findByDateAvant();
	public List<Client> findByDateSuivant();
}
