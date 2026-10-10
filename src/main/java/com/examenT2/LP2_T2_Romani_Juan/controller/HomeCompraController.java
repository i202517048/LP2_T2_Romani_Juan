package com.examenT2.LP2_T2_Romani_Juan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.examenT2.LP2_T2_Romani_Juan.service.OrdenCompraService;

import lombok.RequiredArgsConstructor;

@Controller
public class HomeCompraController {
		
	@GetMapping("/")
	public String home(Model model) {
			return "redirect:/ordencompra/listadoRJ";
	}
	
	
}
