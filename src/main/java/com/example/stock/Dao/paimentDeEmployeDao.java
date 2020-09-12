package com.example.stock.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stock.Bean.paimentDeEmploye;

@Repository
public interface paimentDeEmployeDao extends JpaRepository<paimentDeEmploye, Long>{
	List<paimentDeEmploye> findByEmployeCin(String cin);
}
