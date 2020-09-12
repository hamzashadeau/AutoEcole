package com.example.stock.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stock.Bean.etatFinanciere;

@Repository
public interface EtatFinanciereDao extends JpaRepository<etatFinanciere, Long> {
	public Optional<etatFinanciere> findById(Long id);
	public List<etatFinanciere> findByType(String type);

}
