package com.example.stock.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stock.Bean.Observation;

@Repository
public interface ObservationDao extends JpaRepository<Observation, Long>{
}
