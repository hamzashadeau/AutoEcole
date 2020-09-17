package com.example.stock.Service.Impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.stock.Bean.Client;
import com.example.stock.Bean.ClientHeureAjoute;
import com.example.stock.Bean.HistoriqueApplication;
import com.example.stock.Dao.ClientDao;
import com.example.stock.Dao.ClientHeureAjouteDao;
import com.example.stock.Dao.HistoriqueApplicationDao;
import com.example.stock.Service.Facade.ClientHeureAjouteService;
import com.example.stock.Service.Facade.ClientService;
import com.example.stock.Service.Facade.HistoriqueApplicationService;

@Service
public class ClientHeureAjouteServiceImpl implements ClientHeureAjouteService {
	@Autowired
	private ClientHeureAjouteDao clientDao;
	@Autowired
	private HistoriqueApplicationDao historiqueApplicationDao;

	@Override
	public ClientHeureAjoute findByGeneratedcode(String generatedCode) {
		return clientDao.findByGeneratedcode(generatedCode);
	}

	@Override
	public ClientHeureAjoute findByNomFR(String nomFR) {
		return clientDao.findByNomFR(nomFR);
	}

	@Override
	public ClientHeureAjoute findByPrenomFR(String prenomFR) {
		return clientDao.findByPrenomFR(prenomFR);
	}

	@Override
	public ClientHeureAjoute findByPrenomFRAndNomFR(String prenomFR, String nomFR) {
		return clientDao.findByPrenomFRAndNomFR(prenomFR, nomFR);
	}

	@Override
	public List<ClientHeureAjoute> findAll() {
		return clientDao.findAll();
	}

	@Override
	public int save(ClientHeureAjoute client) {
		if (client.getId() != null) {
			return -1;
		} else {
			clientDao.save(client);
			HistoriqueApplication historiqueApplication = new HistoriqueApplication();
			historiqueApplication.setDate(new Date());
			historiqueApplication.setDescription("sauvgarder le client :" + client.getNomFR() + " " + client.getPrenomFR()+" qui a ajoute une séance de conduite derée de "+ client.getDuree());
			this.historiqueApplicationDao.save(historiqueApplication);
			return 1;
		}
	}

	@Override
	public int edit(ClientHeureAjoute client) {
		if (client.getId() == null) {
			return -1;
		} else {
			//client.setImage(this.data);
			clientDao.save(client);
			HistoriqueApplication historiqueApplication = new HistoriqueApplication();			
			historiqueApplication.setDate(new Date());
			historiqueApplication.setDescription("modifier le client Heure Ajoute :" + client.getNomFR() + " " + client.getPrenomFR());
			this.historiqueApplicationDao.save(historiqueApplication);
			return 1;
		}
	}

	@Override
	public int deleteById(Long id) {
		ClientHeureAjoute client = findById(id);
		HistoriqueApplication historiqueApplication = new HistoriqueApplication();			
		historiqueApplication.setDate(new Date());
		historiqueApplication.setDescription("supprimer le client Heure Ajoute :" + client.getNomFR() + " " + client.getPrenomFR());
		this.historiqueApplicationDao.save(historiqueApplication);
		clientDao.deleteById(id);;
		if (clientDao.findById(id) == null) {
			return 1;
		} else {
			return -1;
		}
	}

	@Override
	public ClientHeureAjoute findById(Long id) {
		return clientDao.findById(id).get();
	}



	@Override
	public List<ClientHeureAjoute> findByDate(Date date) {
		return clientDao.findByDate(date);	
		}
Date date;
	@Override
	public List<ClientHeureAjoute> findByDateAujourdHui() {
		this.date = new Date();
		return clientDao.findByDate(date);
	}
	public List<ClientHeureAjoute> findByDateSuivant(){
		Long milliseconde = this.date.getTime() + 24*60*60*1000;
		this.date = new Date(milliseconde);
		return clientDao.findByDate(date);
	}
	public List<ClientHeureAjoute> findByDateAvant(){
		Long milliseconde = this.date.getTime() - 24*60*60*1000;
		this.date = new Date(milliseconde);
		return clientDao.findByDate(date);
	}
}
