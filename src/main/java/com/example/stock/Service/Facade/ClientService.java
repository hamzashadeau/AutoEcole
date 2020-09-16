package com.example.stock.Service.Facade;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.example.stock.Bean.Client;
import com.example.stock.Bean.Employe;

import net.sf.jasperreports.engine.JRException;

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
	public List<Client> findByCin(String cin);
	public byte[] exportInformationDuDemandeur(String reportFormat, String cin,HttpServletResponse response) throws JRException, IOException;
	public byte[] exportContrat(String reportFormat, String cin,HttpServletResponse response) throws FileNotFoundException, JRException;
	public byte[] exportAttestationdeformation(String reportFormat, String cin,HttpServletResponse response) throws FileNotFoundException, JRException;
	public byte[] exportcertificatMedicalAptitud(String reportFormat, String cin,HttpServletResponse response) throws FileNotFoundException, JRException;
	public List<Client> findByDateInscription(Date dateInscription);
}
