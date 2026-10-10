package com.examenT2.LP2_T2_Romani_Juan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examenT2.LP2_T2_Romani_Juan.dto.ResultadoResponse;
import com.examenT2.LP2_T2_Romani_Juan.model.OrdenCompraRJ;
import com.examenT2.LP2_T2_Romani_Juan.repository.OrdenCompraRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrdenCompraService {
	
	private final OrdenCompraRepository ordenCompraRepository;
	
	public List<OrdenCompraRJ> getAll() {
		return ordenCompraRepository.findAll();
	}
	
	
	
	
	// Método crear
		@Transactional
		public ResultadoResponse create(OrdenCompraRJ ordenCompraRJ) {
			try {
				var registrado = ordenCompraRepository.save(ordenCompraRJ);

				var mensaje = String.format("Orden de compra Nro. %s registrado.", registrado.getNroOrden());

				return new ResultadoResponse(true, mensaje);

			} catch (Exception e) {
				e.printStackTrace();
				return new ResultadoResponse(false, "Hubo un error en la trasacción");
			}
		}

}
