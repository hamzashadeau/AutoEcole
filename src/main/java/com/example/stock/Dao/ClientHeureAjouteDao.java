package com.example.stock.Dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stock.Bean.Client;
import com.example.stock.Bean.ClientHeureAjoute;

@Repository
public interface ClientHeureAjouteDao extends JpaRepository<ClientHeureAjoute, Long> {
	ClientHeureAjoute findByGeneratedcode(String generatedCode);
	ClientHeureAjoute findByNomFR(String nomFR);
	ClientHeureAjoute findByPrenomFR(String prenomFR);
	ClientHeureAjoute findByPrenomFRAndNomFR(String prenomFR,String nomFR);
List<ClientHeureAjoute> findAll();
public void deleteById(Long id);
public Optional<ClientHeureAjoute> findById(Long id);
public List<ClientHeureAjoute> findByDate(Date date);
}
