package com.examenT2.LP2_T2_Romani_Juan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examenT2.LP2_T2_Romani_Juan.model.OrdenCompraRJ;

public interface OrdenCompraRepository extends JpaRepository<OrdenCompraRJ, Integer> {
	
	List<OrdenCompraRJ> findAll();
}
