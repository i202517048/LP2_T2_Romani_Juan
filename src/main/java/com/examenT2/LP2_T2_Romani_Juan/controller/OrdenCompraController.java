package com.examenT2.LP2_T2_Romani_Juan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.examenT2.LP2_T2_Romani_Juan.model.OrdenCompraRJ;
import com.examenT2.LP2_T2_Romani_Juan.service.OrdenCompraService;
import com.examenT2.LP2_T2_Romani_Juan.service.ProveedorService;
import com.examenT2.LP2_T2_Romani_Juan.util.Alert;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("ordencompra")
@RequiredArgsConstructor
public class OrdenCompraController {
	private final OrdenCompraService ordenCompraService;
	private final ProveedorService proveedorService;
	
	@GetMapping("listadoRJ")
	public String listado(Model model) {
		model.addAttribute("lstOrdenCompras", ordenCompraService.getAll());
		return "ordencompra/listadoRJ";
	}
	
	// Controller que consume Service create
		@GetMapping("nuevoRJ")
		public String nuevo(Model model) {
			model.addAttribute("lstProveedores",proveedorService.getAll() );
			// Inicializar el objeto del formulario.
			model.addAttribute("ordencompra", new OrdenCompraRJ());
			return "ordencompra/nuevoRJ";
		}
		
		
		@PostMapping("registrar")
		public String registrar(@ModelAttribute OrdenCompraRJ ordenCompraRJ, RedirectAttributes flash) {
			var response = OrdenCompraService.create(ordenCompraRJ);

			var alert = Alert.sweetToast(response.mensaje(), "success", 5000);
			flash.addFlashAttribute("alert", alert);
			return "redirect:/ordencompra/listadoRJ";
		}

	
}
