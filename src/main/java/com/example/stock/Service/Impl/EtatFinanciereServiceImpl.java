package com.example.stock.Service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.Bean.etatFinanciere;
import com.example.stock.Dao.EtatFinanciereDao;
import com.example.stock.Service.Facade.EtatFinanciereService;

@Service
public class EtatFinanciereServiceImpl implements EtatFinanciereService{
	
	@Autowired
	private EtatFinanciereDao etatFinancereDao;
	@Override
	public List<etatFinanciere> findAll() {
		return etatFinancereDao.findAll();
	}

	@Override
	public int save(etatFinanciere employe) {
		if(employe.getId() != null) {
			return -1;
		} else {
			this.etatFinancereDao.save(employe);
			return 1;
		}
	}

	@Override
	public int edit(etatFinanciere employe) {
		if(employe.getId() == null) {
			return -1;
		} else {
			this.etatFinancereDao.save(employe);
			return 1;
		}
	}

	@Override
	public int deleteById(Long id) {
		this.etatFinancereDao.deleteById(id);
		if(this.findById(id) != null) {
			return -1;
		} else {
			return 1;			
		}
	}

	@Override
	public etatFinanciere findById(Long id) {
		return this.etatFinancereDao.findById(id).get();
	}

	@Override
	public List<etatFinanciere> findByType(String type) {
		return this.etatFinancereDao.findByType(type);
	}

	@Override
	public List<etatFinanciere> findAllGainsByTypeAndmois(String type, int mois) {
		List<etatFinanciere> etats = this.findByType(type);
		List<etatFinanciere> resultats = new ArrayList<etatFinanciere>();
		for (etatFinanciere etat : etats) {
			if((etat.getDate().getMonth()+1) == mois) {
				resultats.add(etat);
			}
		}
		return resultats;
	}

	@Override
	public List<etatFinanciere> findAllDespensesByTypeAndmois(String type, int mois) {
		List<etatFinanciere> etats = this.findByType(type);
		List<etatFinanciere> resultats = new ArrayList<etatFinanciere>();
		for (etatFinanciere etat : etats) {
			if((etat.getDate().getMonth()+1) == mois) {
				resultats.add(etat);
			}
		}
		return resultats;
	}

	@Override
	public List<etatFinanciere> findByDate(Date date) {
		return this.etatFinancereDao.findByDate(date);
	}

	@Override
	public List<etatFinanciere> findByTypeAndDate(String type, Date date) {
		return this.etatFinancereDao.findByTypeAndDate(type, date);
	}

	@Override
	public List<etatFinanciere> findAllGainsByTypeAndmoisAndAnnee(String type, int mois, int annee) {
		List<etatFinanciere> etats = this.findByType(type);
		List<etatFinanciere> resultats = new ArrayList<etatFinanciere>();
		for (etatFinanciere etat : etats) {
			if((etat.getDate().getMonth()+1) == mois && (etat.getDate().getYear()) == annee) {
				resultats.add(etat);
			}
		}
		return resultats;
	}

	@Override
	public List<etatFinanciere> findAllDespensesByTypeAndmoisAndAnnee(String type, int mois, int annee) {
		List<etatFinanciere> etats = this.findByType(type);
		List<etatFinanciere> resultats = new ArrayList<etatFinanciere>();
		for (etatFinanciere etat : etats) {
			if((etat.getDate().getMonth()+1) == mois && (etat.getDate().getYear()) == annee) {
				resultats.add(etat);
			}
		}
		return resultats;	}

}
