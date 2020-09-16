package com.example.stock.Service.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.Bean.Client;
import com.example.stock.Bean.HistoriqueApplication;
import com.example.stock.Bean.heureConduite;
import com.example.stock.Dao.HistoriqueApplicationDao;
import com.example.stock.Dao.heureConduiteDao;
import com.example.stock.Service.Facade.ClientService;
import com.example.stock.Service.Facade.heureConduiteService;

@Service
public class heureConduiteServiceImpl implements heureConduiteService {
@Autowired
private heureConduiteDao heureConduiteDao;
@Autowired
private ClientService clientService;
@Autowired
private HistoriqueApplicationDao historiqueApplicationDao;
	@Override
	public List<heureConduite> findByClientCin(String cin) {
		return heureConduiteDao.findByClientCin(cin);
	}
	@Override
	public int save(heureConduite heureConduite) {
		if(heureConduite.getId()!= null) {
			return -1;
		}else {
		Client client = clientService.findById(heureConduite.getClient().getId());
		client.setNbrSeanceDeConduite(client.getNbrSeanceDeConduite()+1);
		client.setTotalHeureConduite(client.getTotalHeureConduite() + heureConduite.getDuree());
			heureConduiteDao.save(heureConduite);
			HistoriqueApplication historiqueApplication = new HistoriqueApplication();			
			historiqueApplication.setDate(new Date());
			historiqueApplication.setDescription("le client :" + heureConduite.getClient().getNomFR() + " " + heureConduite.getClient().getPrenomFR() + "avait une séance de conduite de" + heureConduite.getDuree());
			this.historiqueApplicationDao.save(historiqueApplication);
		 return 1;
	}
	}

	@Override
	public int edit(heureConduite heureConduite) {
		if(heureConduite.getId()== null) {
			return -1;
		}else {
			heureConduiteDao.save(heureConduite);
			HistoriqueApplication historiqueApplication = new HistoriqueApplication();			
			historiqueApplication.setDate(new Date());
			historiqueApplication.setDescription("une modification a une séance de conduite de client :" + heureConduite.getClient().getNomFR() + " " + heureConduite.getClient().getPrenomFR());
			this.historiqueApplicationDao.save(historiqueApplication);
		 return 1;
	}
	}

	@Override
	public int deleteById(Long id) {
		heureConduite heureConduite = findById(id);
		HistoriqueApplication historiqueApplication = new HistoriqueApplication();			
		historiqueApplication.setDate(new Date());
		historiqueApplication.setDescription("une suppression de une séance de conduite de client :" + heureConduite.getClient().getNomFR() + " " + heureConduite.getClient().getPrenomFR());
		this.historiqueApplicationDao.save(historiqueApplication);
		heureConduiteDao.deleteById(id);
		heureConduite heureConduite1 = findById(id);
		if(heureConduite1 == null) {
			return 1;
		}else {
		return -1;
	}
	}
	@Override
	public heureConduite findById(Long id) {
		return heureConduiteDao.findById(id).get();
	}

}
