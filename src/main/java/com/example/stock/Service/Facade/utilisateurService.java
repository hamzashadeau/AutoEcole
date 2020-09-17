package com.example.stock.Service.Facade;

import com.example.stock.Bean.utlisateur;

public interface utilisateurService {
	public int save(utlisateur heureConduite);

	public int edit(utlisateur heureConduite);

	public int deleteById(Long id);

	public utlisateur findById(Long id);

	public utlisateur findByLogin(String login);

	public int seConnecter(String login, String mdp) throws Exception;

	public int resetPassword(String email, String oldPassword, String nvPassword) throws Exception;

	public int resetPasswordCodeVerification(String email, String nvpassword, Long code) throws Exception;

	public void getHashMotDePasse(String modPasse);
}
