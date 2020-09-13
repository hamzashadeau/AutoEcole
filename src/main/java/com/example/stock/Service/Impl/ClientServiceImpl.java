package com.example.stock.Service.Impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.stock.Bean.Client;
import com.example.stock.Bean.HistoriqueApplication;
import com.example.stock.Dao.ClientDao;
import com.example.stock.Dao.HistoriqueApplicationDao;
import com.example.stock.Service.Facade.ClientService;
import com.example.stock.Service.Facade.HistoriqueApplicationService;

@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
	private ClientDao clientDao;
	@Autowired
	private HistoriqueApplicationDao historiqueApplicationDao;

	@Override
	public Client findByGeneratedcode(String generatedCode) {
		return clientDao.findByGeneratedcode(generatedCode);
	}

	@Override
	public Client findByNomFR(String nomFR) {
		return clientDao.findByNomFR(nomFR);
	}

	@Override
	public Client findByPrenomFR(String prenomFR) {
		return clientDao.findByPrenomFR(prenomFR);
	}

	@Override
	public Client findByPrenomFRAndNomFR(String prenomFR, String nomFR) {
		return clientDao.findByPrenomFRAndNomFR(prenomFR, nomFR);
	}

	@Override
	public List<Client> findAll() {
		return clientDao.findAll();
	}

	@Override
	public int save(Client client) {
		if (client.getId() != null || this.data == null) {
			return -1;
		} else {
			if(client.getPrixRestantes() == null) {
				client.setPrixRestantes(client.getPrixTotal());				
			}
			client.setImageType(this.type);
			client.setImage(this.data);
			clientDao.save(client);
			HistoriqueApplication historiqueApplication = new HistoriqueApplication();
			historiqueApplication.setDate(new Date());
			historiqueApplication.setDescription("sauvgarder le client :" + client.getNomFR() + " " + client.getPrenomFR());
			this.historiqueApplicationDao.save(historiqueApplication);
			this.data = null;
			return 1;
		}
	}

	@Override
	public int edit(Client client) {
		if (client.getId() == null) {
			return -1;
		} else {
			//client.setImage(this.data);
			clientDao.save(client);
			HistoriqueApplication historiqueApplication = new HistoriqueApplication();			
			historiqueApplication.setDate(new Date());
			historiqueApplication.setDescription("modifier le client :" + client.getNomFR() + " " + client.getPrenomFR());
			this.historiqueApplicationDao.save(historiqueApplication);
			return 1;
		}
	}

	@Override
	public int deleteById(Long id) {
		Client client = findById(id);
		HistoriqueApplication historiqueApplication = new HistoriqueApplication();			
		historiqueApplication.setDate(new Date());
		historiqueApplication.setDescription("supprimer le client :" + client.getNomFR() + " " + client.getPrenomFR());
		this.historiqueApplicationDao.save(historiqueApplication);
		clientDao.deleteById(id);
		Client client1 = findById(id);
		if (client1 == null) {
			return 1;
		} else {
			return -1;
		}
	}

	private byte[] data;
	private String type;

	public int storeFile(MultipartFile file) throws Exception {
		// Normalize file name
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		try {
			// Check if the file's name contains invalid characters
			if (fileName.contains("..")) {
				throw new Exception("Sorry! Filename contains invalid path sequence " + fileName);
			}
			this.data = file.getBytes();
			this.type = file.getContentType();
			return 1;
		} catch (IOException ex) {
			throw new Exception("Could not store file " + fileName + ". Please try again!", ex);
		}
	}

	@Override
	public Client findById(Long id) {
		return clientDao.findById(id).get();
	}

	@Override
	public Client findByImageName(String image) {
		return clientDao.findByImageName(image);
	}

	@Override
	public List<Client> findByDateExamen(Date dateExamen) {
		return clientDao.findByDateExamen(dateExamen);	
		}
Date date;
	@Override
	public List<Client> findByDateAujourdHui() {
		this.date = new Date();
		return clientDao.findByDateExamen(date);
	}
	public List<Client> findByDateSuivant(){
		Long milliseconde = this.date.getTime() + 24*60*60*1000;
		this.date = new Date(milliseconde);
		return clientDao.findByDateExamen(date);
	}
	public List<Client> findByDateAvant(){
		Long milliseconde = this.date.getTime() - 24*60*60*1000;
		this.date = new Date(milliseconde);
		return clientDao.findByDateExamen(date);
	}
}
