package com.example.stock.Service.Impl;

import java.security.MessageDigest;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.Bean.utlisateur;
import com.example.stock.Dao.UtilisateurDao;
import com.example.stock.Service.Facade.ClientService;
import com.example.stock.Service.Facade.utilisateurService;

@Service
public class utilisateurServiceImpl implements utilisateurService{
	@Autowired
	private UtilisateurDao utilisateurDao;
	@Autowired
	private ClientService clientService;
	
	@Override
	public int save(utlisateur heureConduite) {
		if(heureConduite.getId()!= null) {
			return -1;
		}else {
			utilisateurDao.save(heureConduite);
		 return 1;
	}
	}
	@Override
	public int edit(utlisateur heureConduite) {
		if(heureConduite.getId() == null) {
			return -1;
		}else {
			utilisateurDao.save(heureConduite);
			return 1;
		}
	}
	@Override
	public int deleteById(Long id) {
		utilisateurDao.deleteById(id);
		utlisateur heureConduite = findById(id);
		if(heureConduite== null) {
			return 1;
		}else {
		return -1;
	}
	}
	@Override
	public utlisateur findById(Long id) {
		return utilisateurDao.findById(id).get();
	}
	@Override
	public utlisateur findByLogin(String login) {
		return utilisateurDao.findByLogin(login);
	}
	public static String hash(String mdp) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(mdp.getBytes());
		byte byteData[] = md.digest();
StringBuffer hexString = new StringBuffer();
for (int i = 0; i < byteData.length; i++) {
	String hex = Integer.toHexString(0xff & byteData[i]);
	if(hex.length()==1) hexString.append('0');
	hexString.append(hex);
}
	System.out.println("En format hexa:" + hexString.toString());
	return hexString.toString();
	}
	
	public static Long generateRandomIntIntRange(int min, int max) {
	    Random r = new Random();
	    	Long l=new Long(r.nextInt((max - min) + 1) + min);
	    		return  l;
	}
	
	public int resetPasswordCodeVerification(String email, String nvpassword,Long code ) throws Exception {
		utlisateur user = utilisateurDao.findByLogin(email);
		if(code.equals(user.getEmploye().getCin()) ) {
		user.setModDePasse(hash(nvpassword));
		utilisateurDao.save(user);
		return 1;
		} else {
			return -2;
		}
	}
	public int resetPassword(String email, String nvPassword) throws Exception {
		utlisateur user = utilisateurDao.findByLogin(email);
		if(!user.getModDePasse().equals(hash(nvPassword))) {
			user.setModDePasse(hash(nvPassword));
			utilisateurDao.save(user);
			return 1;
		} else {
			return -2;
		}
	}
	public static boolean debloquer(Date date) {
		Date date1 = new Date();
		long milliSeconde1 = date.getTime();
		long milliSeconde2 = date1.getTime();
		return milliSeconde2 - milliSeconde1 > 15* 60*1000 ? true: false;
		}
	public int seConnecter(String login, String mdp) throws Exception {
	    utlisateur loadedUser = findByLogin(login);  
	    if (loadedUser == null) {
	        return -1;
	    } else if (!loadedUser.getModDePasse().equalsIgnoreCase(hash(mdp))) {
	            return -2;
	        } else {
	        return 1;
	    }
	}
	@Override
	public void getHashMotDePasse(String modPasse) {
try {
	System.out.println(hash(modPasse));
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}		
	}

}
