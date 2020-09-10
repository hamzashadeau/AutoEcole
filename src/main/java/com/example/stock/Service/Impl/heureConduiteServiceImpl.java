package com.example.stock.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.Bean.Client;
import com.example.stock.Bean.heureConduite;
import com.example.stock.Dao.heureConduiteDao;
import com.example.stock.Service.Facade.ClientService;
import com.example.stock.Service.Facade.heureConduiteService;

@Service
public class heureConduiteServiceImpl implements heureConduiteService {
@Autowired
private heureConduiteDao heureConduiteDao;
@Autowired
private ClientService clientService;
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
		client.setTotalHeureConduite(client.getTotalHeureConduite() + heureConduite.getDuree());
			heureConduiteDao.save(heureConduite);
		 return 1;
	}
	}

	@Override
	public int edit(heureConduite heureConduite) {
		if(heureConduite.getId()== null) {
			return -1;
		}else {
			heureConduiteDao.save(heureConduite);
		 return 1;
	}
	}

	@Override
	public int deleteById(Long id) {
		heureConduiteDao.deleteById(id);
		heureConduite heureConduite = findById(id);
		if(heureConduite== null) {
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
