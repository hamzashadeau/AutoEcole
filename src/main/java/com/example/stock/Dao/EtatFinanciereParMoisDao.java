package com.example.stock.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stock.Bean.etatFinanciereParMois;

@Repository
public interface EtatFinanciereParMoisDao extends JpaRepository<etatFinanciereParMois, Long>{
}
