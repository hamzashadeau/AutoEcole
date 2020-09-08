package com.example.stock.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stock.Bean.etatFinanciere;

@Repository
public interface EtatFinanciereDao extends JpaRepository<etatFinanciere, Long> {
}
