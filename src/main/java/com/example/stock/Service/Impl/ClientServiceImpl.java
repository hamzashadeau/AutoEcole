package com.example.stock.Service.Impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.stock.Bean.Client;
import com.example.stock.Bean.HistoriqueApplication;
import com.example.stock.Bean.etatFinanciere;
import com.example.stock.Bean.heureConduite;
import com.example.stock.Bean.paimentDeClient;
import com.example.stock.Dao.ClientDao;
import com.example.stock.Dao.HistoriqueApplicationDao;
import com.example.stock.Dao.heureConduiteDao;
import com.example.stock.Dao.paimentDeClientDao;
import com.example.stock.Service.Facade.ClientService;
import com.example.stock.webRest.MediaTypeUtils;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

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
	String fullname = null;
	public byte[] exportContrat(String reportFormat, String cin,HttpServletResponse response) throws FileNotFoundException, JRException {
	    //String path = "C:\Users\basan\Desktop\Report";
	    List<Client> employees = clientDao.findByCin(cin);
	    employees.forEach(emp ->{
	    	fullname = emp.getNomFR()+emp.getPrenomFR();
	    });
	    //load file and compile it
	    java.io.File file = ResourceUtils.getFile("src/main/resources/contrat-test.jrxml");
	    JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
	    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
	    Map<String, Object> parameters = new HashMap<>();
	    parameters.put("createdBy", "Java Techie");
	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
	    if (reportFormat.equalsIgnoreCase("html")) {
	        JasperExportManager.exportReportToHtmlFile(jasperPrint,"\\employees.html");
	    }
	    if (reportFormat.equalsIgnoreCase("pdf")) {
	         JasperExportManager.exportReportToPdfFile(jasperPrint,cin+"contratTest.pdf");
	    }
	  //  return "report generated in path : " ;

	    MediaType mediaType = MediaTypeUtils.getMediaTypeForFileName(this.servletContext, file.getName());
	    InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
	    byte[] bytes = null;
	    try {
			 bytes = Files.readAllBytes(Paths.get(cin+"contratTest.pdf"));
			 this.fullname = null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println(bytes);
	    return bytes;
	}
	public byte[] exportAttestationdeformation(String reportFormat, String cin,HttpServletResponse response) throws FileNotFoundException, JRException {
	    //String path = "C:\Users\basan\Desktop\Report";
	    List<Client> employees = clientDao.findByCin(cin);
	    employees.forEach(emp ->{
	    	fullname = emp.getPermisDemande();
	    });
	    byte[] bytes = null;
	    if(fullname.equals("B")) {
		    java.io.File file = ResourceUtils.getFile("classpath:Namodaj-Chahada-TakwinB.jrxml");
		    JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
		    Map<String, Object> parameters = new HashMap<>();
		    parameters.put("createdBy", "Java Techie");
		    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		    if (reportFormat.equalsIgnoreCase("html")) {
		        JasperExportManager.exportReportToHtmlFile(jasperPrint,"\\employees.html");
		    }
		    if (reportFormat.equalsIgnoreCase("pdf")) {
		         JasperExportManager.exportReportToPdfFile(jasperPrint,cin +"Attestationdeformation.pdf");
		    }
		    MediaType mediaType = MediaTypeUtils.getMediaTypeForFileName(this.servletContext, file.getName());
		    InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		    try {
				 bytes = Files.readAllBytes(Paths.get(cin +"Attestationdeformation.pdf"));
				 this.fullname = null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    System.out.println(bytes);

	    }else  if(fullname.equals("A")) {
		    java.io.File file = ResourceUtils.getFile("classpath:Namodaj-Chahada-TakwinA.jrxml");
		    JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
		    Map<String, Object> parameters = new HashMap<>();
		    parameters.put("createdBy", "Java Techie");
		    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		    if (reportFormat.equalsIgnoreCase("html")) {
		        JasperExportManager.exportReportToHtmlFile(jasperPrint,"\\employees.html");
		    }
		    if (reportFormat.equalsIgnoreCase("pdf")) {
		         JasperExportManager.exportReportToPdfFile(jasperPrint,cin +"Attestationdeformation.pdf");
		    }
		    MediaType mediaType = MediaTypeUtils.getMediaTypeForFileName(this.servletContext, file.getName());
		    InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		    try {
				 bytes = Files.readAllBytes(Paths.get(cin +"Attestationdeformation.pdf"));
				 this.fullname = null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    System.out.println(bytes);
	    }
	    //load file and compile it
	  //  return "report generated in path : " ;

	    return bytes;
	}
	public byte[] exportcertificatMedicalAptitud(String reportFormat, String cin,HttpServletResponse response) throws FileNotFoundException, JRException {
	    //String path = "C:\Users\basan\Desktop\Report";
	    List<Client> employees = clientDao.findByCin(cin);
	    employees.forEach(emp ->{
	    	fullname = emp.getNomFR()+emp.getPrenomFR();
	    });
	    //load file and compile it
	    java.io.File file = ResourceUtils.getFile("classpath:certificatMedicalAptitud.jrxml");
	    JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
	    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
	    Map<String, Object> parameters = new HashMap<>();
	    parameters.put("createdBy", "Java Techie");
	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
	    if (reportFormat.equalsIgnoreCase("html")) {
	        JasperExportManager.exportReportToHtmlFile(jasperPrint,"\\employees.html");
	    }
	    if (reportFormat.equalsIgnoreCase("pdf")) {
	         JasperExportManager.exportReportToPdfFile(jasperPrint,cin+"certificatMedicalAptitud.pdf");
	    }
	  //  return "report generated in path : " ;

	    MediaType mediaType = MediaTypeUtils.getMediaTypeForFileName(this.servletContext, file.getName());
	    InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
	    byte[] bytes = null;
	    try {
			 bytes = Files.readAllBytes(Paths.get(cin+"certificatMedicalAptitud.pdf"));
			 this.fullname = null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println(bytes);
	    return bytes;
	}
	public byte[] exportInformationDuDemandeur(String reportFormat, String cin,HttpServletResponse response) throws FileNotFoundException, JRException {
	    //String path = "C:\Users\basan\Desktop\Report";
	    List<Client> employees = clientDao.findByCin(cin);
	    //load file and compile it
	    java.io.File file = ResourceUtils.getFile("classpath:informationDuDemandeur.jrxml");
	    JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
	    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
	    Map<String, Object> parameters = new HashMap<>();
	    parameters.put("createdBy", "Java Techie");
	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
	    if (reportFormat.equalsIgnoreCase("html")) {
	        JasperExportManager.exportReportToHtmlFile(jasperPrint,"\\employees.html");
	    }
	    if (reportFormat.equalsIgnoreCase("pdf")) {
	         JasperExportManager.exportReportToPdfFile(jasperPrint,"informationDuDemandeur.pdf");
	    }
	  //  return "report generated in path : " ;

	    MediaType mediaType = MediaTypeUtils.getMediaTypeForFileName(this.servletContext, file.getName());
	    InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
	    byte[] bytes = null;
	    try {
			 bytes = Files.readAllBytes(Paths.get("informationDuDemandeur.pdf"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println(bytes);
	    return bytes;
	}
	@Autowired
	private ServletContext servletContext;
	@Override
	public int save(Client client) {
		if (client.getId() != null || this.data == null) {
			return -1;
		} else {
			if(client.getPrixRestantes() == null) {
				client.setPrixRestantes(client.getPrixTotal());				
			}
			client.setTotalHeureConduite((long) 0);
			client.setNbrSeanceDeConduite(0);
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
@Autowired
private paimentDeClientDao paimentDeClientDao;
@Autowired
private heureConduiteDao heureConduiteDao;
	@Override
	public int deleteById(Long id) {
		Client client = findById(id);
		HistoriqueApplication historiqueApplication = new HistoriqueApplication();			
		historiqueApplication.setDate(new Date());
		historiqueApplication.setDescription("supprimer le client :" + client.getNomFR() + " " + client.getPrenomFR());
		this.historiqueApplicationDao.save(historiqueApplication);
		List<paimentDeClient> paimentDeClients = paimentDeClientDao.findByClientCin(client.getCin());
		for (paimentDeClient paimentDeClient : paimentDeClients) {
			paimentDeClientDao.deleteById(paimentDeClient.getId());
		}
		List<heureConduite> heureConduites = heureConduiteDao.findByClientCin(client.getCin());
		for (heureConduite heureConduite : heureConduites) {
			heureConduiteDao.deleteById(heureConduite.getId());
		}
		clientDao.deleteById(id);
		if (clientDao.findById(id) == null) {
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

	@Override
	public List<Client> findByCin(String cin) {
		return clientDao.findByCin(cin);
	}

	@Override
	public List<Client> findByDateInscription(Date dateInscription) {
		return clientDao.findByDateInscription(dateInscription);
	}
	

	@Override
	public List<Client> findAllClientsBymoisAndAnnee(int mois, int annee) {
		List<Client> etats = this.findAll();
		List<Client> resultats = new ArrayList<Client>();
		for (Client etat : etats) {
			if((etat.getDateInscription().getMonth()+1) == mois && (etat.getDateInscription().getYear()) == annee) {
				resultats.add(etat);
			}
		}
		return resultats;	
		}

	@Override
	public List<Client> findByPermisDemande(String permisDemande) {
		return clientDao.findByPermisDemande(permisDemande);
	}
}
