package com.example.stock.Dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stock.Bean.HistoriqueApplication;

@Repository
public interface HistoriqueApplicationDao extends JpaRepository<HistoriqueApplication, Long>{
public List<HistoriqueApplication> findByDate(Date date);
}
