package com.example.stock.Service.Impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.stock.Bean.Employe;
import com.example.stock.Bean.HistoriqueApplication;
import com.example.stock.Bean.paimentDeEmploye;
import com.example.stock.Dao.EmployeDao;
import com.example.stock.Dao.HistoriqueApplicationDao;
import com.example.stock.Dao.paimentDeEmployeDao;
import com.example.stock.Service.Facade.EmployeService;
import com.example.stock.Service.Facade.paimentDeEmployeService;
@Service
public class EmployeServiceImpl implements EmployeService {
@Autowired
private EmployeDao employeDao;
@Autowired
private HistoriqueApplicationDao historiqueApplicationDao;
	@Override
	public Employe findByNomFR(String nomFR) {
		return employeDao.findByNomFR(nomFR);
	}

	@Override
	public Employe findByPrenomFR(String prenomFR) {
		return employeDao.findByPrenomFR(prenomFR);
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
	public Employe findByPrenomFRAndNomFR(String prenomFR, String nomFR) {
		return employeDao.findByPrenomFRAndNomFR(prenomFR, nomFR);
	}

	@Override
	public List<Employe> findAll() {
		return employeDao.findAll();
	}

	@Override
	public int save(Employe employe) {
		if(employe.getId()!= null) {
			return -1;
		}else {
			employe.setImageType(this.type);
			employe.setImage(this.data);
			employeDao.save(employe);
			HistoriqueApplication historiqueApplication = new HistoriqueApplication();			
			historiqueApplication.setDate(new Date());
			historiqueApplication.setDescription("sauvgarder employe :" + employe.getNomFR() + " " + employe.getPrenomFR());
			this.historiqueApplicationDao.save(historiqueApplication);
		 return 1;
	}
	}
	@Override
	public int edit(Employe employe) {
		if(employe.getId()== null) {
			return -1;
		}else {
		 employeDao.save(employe);
			HistoriqueApplication historiqueApplication = new HistoriqueApplication();			
			historiqueApplication.setDate(new Date());
			historiqueApplication.setDescription("modifier employe :" + employe.getNomFR() + " " + employe.getPrenomFR());
			this.historiqueApplicationDao.save(historiqueApplication);
		
		 return 1;
	}
	}
@Autowired
private paimentDeEmployeDao paimentDeEmployeDao;
	@Override
	public int deleteById(Long id) {
		Employe employe = findById(id);
		HistoriqueApplication historiqueApplication = new HistoriqueApplication();			
		historiqueApplication.setDate(new Date());
		historiqueApplication.setDescription("supprimr employe :" + employe.getNomFR() + " " + employe.getPrenomFR());
		this.historiqueApplicationDao.save(historiqueApplication);
		List<paimentDeEmploye> paimentDeEmployes = paimentDeEmployeDao.findByEmployeCin(employe.getCin());
		for (paimentDeEmploye paimentDeEmploye : paimentDeEmployes) {
			paimentDeEmployeDao.deleteById(paimentDeEmploye.getId());
		}
		employeDao.deleteById(id);
		if(employeDao.findById(id)== null) {
			return 1;
		}else {
		return -1;
	}
	}

	@Override
	public Employe findById(Long id) {
		return employeDao.findById(id).get();
	}

}
