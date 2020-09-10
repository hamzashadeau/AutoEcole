package com.example.stock.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stock.Bean.Employe;

@Repository
public interface EmployeDao extends JpaRepository<Employe, Long>{
Employe findByNomFR(String nomFR);
Employe findByPrenomFR(String prenomFR);
Employe findByPrenomFRAndNomFR(String prenomFR,String nomFR);
List<Employe> findAll();
Optional<Employe> findById(Long id);
}
