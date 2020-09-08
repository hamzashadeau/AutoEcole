package com.example.stock.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stock.Bean.heureConduite;

@Repository
public interface heureConduiteDao extends JpaRepository<heureConduite, Long>{
}
