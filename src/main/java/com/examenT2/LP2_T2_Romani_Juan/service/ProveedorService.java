package com.examenT2.LP2_T2_Romani_Juan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examenT2.LP2_T2_Romani_Juan.model.ProveedorRJ;
import com.examenT2.LP2_T2_Romani_Juan.repository.ProveedorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProveedorService {
	private final ProveedorRepository proveedorRepository;
	
	public List<ProveedorRJ> getAll() {
		return proveedorRepository.findAll();
	}
}

