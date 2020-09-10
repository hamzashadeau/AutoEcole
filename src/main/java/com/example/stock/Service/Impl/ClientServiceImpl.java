package com.example.stock.Service.Impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.stock.Bean.Client;
import com.example.stock.Dao.ClientDao;
import com.example.stock.Service.Facade.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
@Autowired
private ClientDao clientDao;
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
		if(client.getId()!= null) {
			return -1;
		}else {
			client.setImageType(this.type);
			client.setImage(this.data);
		 clientDao.save(client);
		 return 1;
	}
	}

	@Override
	public int edit(Client client) {
		if(client.getId()== null) {
			return -1;
		}else {
			client.setImage(this.data);
		 clientDao.save(client);
		 return 1;
	}
	}

	@Override
	public int deleteById(Long id) {
		clientDao.deleteById(id);
		Client client = findById(id);
		if(client== null) {
			return 1;
		}else {
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
						//  try {
			  //    Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
			    //} catch (Exception e) {
			      //throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
			    //}
//			LettreModel dbFile = new LettreModel(fileName, file.getContentType(), file.getBytes());
	//		modelLettreDao.save(dbFile);
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

}
