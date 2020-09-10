package com.example.stock.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stock.Bean.heureConduite;
import com.example.stock.Bean.paimentDeClient;

@Repository
public interface heureConduiteDao extends JpaRepository<heureConduite, Long>{
	List<heureConduite> findByClientCin(String cin);

}
