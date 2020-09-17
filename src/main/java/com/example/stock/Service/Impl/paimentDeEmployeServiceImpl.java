package com.example.stock.Service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.Bean.Client;
import com.example.stock.Bean.HistoriqueApplication;
import com.example.stock.Bean.paimentDeClient;
import com.example.stock.Bean.paimentDeEmploye;
import com.example.stock.Dao.HistoriqueApplicationDao;
import com.example.stock.Dao.paimentDeEmployeDao;
import com.example.stock.Service.Facade.ClientService;
import com.example.stock.Service.Facade.paimentDeEmployeService;

@Service
public class paimentDeEmployeServiceImpl implements paimentDeEmployeService{
	@Autowired
	private paimentDeEmployeDao paimentClientDao;
	@Autowired
	private HistoriqueApplicationDao historiqueApplicationDao;
	@Override
	public List<paimentDeEmploye> findByEmployeCinAndMois(String cin, int mois) {
		List<paimentDeEmploye> paimentsEmploye = this.paimentClientDao.findByEmployeCin(cin);
		List<paimentDeEmploye> resultat = new ArrayList<paimentDeEmploye>();
		for (paimentDeEmploye paimentDeEmploye : paimentsEmploye) {
			if((paimentDeEmploye.getDate().getMonth()+1)== mois) {
				resultat.add(paimentDeEmploye);
			}
			
		}
		return resultat;
	}
	@Autowired
	private ClientService clientService;
	
	@Override
	public int save(paimentDeEmploye heureConduite) {
		if(heureConduite.getId()!= null) {
			return -1;
		}else {
			paimentClientDao.save(heureConduite);
			HistoriqueApplication historiqueApplication = new HistoriqueApplication();			
			historiqueApplication.setDate(new Date());
			historiqueApplication.setDescription("employé :" + heureConduite.getEmploye().getNomFR() + " " + heureConduite.getEmploye().getPrenomFR() + "est pris un avancement de" + heureConduite.getMonatant());
			this.historiqueApplicationDao.save(historiqueApplication);
		 return 1;
	}
	}
	@Override
	public int edit(paimentDeEmploye heureConduite) {
		if(heureConduite.getId() == null) {
			return -1;
		}else {
			paimentClientDao.save(heureConduite);
			HistoriqueApplication historiqueApplication = new HistoriqueApplication();			
			historiqueApplication.setDate(new Date());
			historiqueApplication.setDescription("modification a un avancement de employé :" + heureConduite.getEmploye().getNomFR() + " " + heureConduite.getEmploye().getPrenomFR());
			this.historiqueApplicationDao.save(historiqueApplication);
			return 1;
		}
	}
	@Override
	public int deleteById(Long id) {
		paimentDeEmploye heureConduite = findById(id);
		HistoriqueApplication historiqueApplication = new HistoriqueApplication();			
		historiqueApplication.setDate(new Date());
		historiqueApplication.setDescription("suppression de un avancement de employé :" + heureConduite.getEmploye().getNomFR() + " " + heureConduite.getEmploye().getPrenomFR());
		this.historiqueApplicationDao.save(historiqueApplication);
		paimentClientDao.deleteById(id);
		if(paimentClientDao.findById(id)== null) {
			return 1;
		}else {
		return -1;
	}
	}
	@Override
	public paimentDeEmploye findById(Long id) {
		return paimentClientDao.findById(id).get();
	}
}
