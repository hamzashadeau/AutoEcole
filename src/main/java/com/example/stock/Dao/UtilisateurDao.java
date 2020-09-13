package com.example.stock.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stock.Bean.paimentDeEmploye;
import com.example.stock.Bean.utlisateur;

@Repository
public interface UtilisateurDao extends JpaRepository<utlisateur, Long>{
public utlisateur findByLogin(String login);
}
