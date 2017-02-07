package ch.hemisoft.immoroi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ch.hemisoft.immoroi.service.RenditeService;

@RestController
@RequestMapping("rendite")
public class RenditeController {
	@Autowired RenditeService service;

	@GetMapping
	public double berechneRendite(
			@RequestParam("jahresnettomiete") double jahresNettoMiete, 
			@RequestParam("kaufpreis") double kaufPreis, 
			@RequestParam(value="nebenkosten", required=false) double[] nebenKosten
	) {
			return service.berechneRendite(jahresNettoMiete, kaufPreis, nebenKosten);
	}

	@ExceptionHandler(ArithmeticException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public RuntimeException handleException(ArithmeticException e) {
	    return new RuntimeException("Kaufpreis darf nicht 0 sein.");
	}
	
}
