package ch.hemisoft.immoroi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ch.hemisoft.immoroi.dto.Rendite;
import ch.hemisoft.immoroi.service.RenditeService;

@RestController
@RequestMapping("rendite")
public class RenditeController {
	@Autowired RenditeService service;

	@GetMapping
	public Rendite berechneRendite(
			@RequestParam("jahresnettomiete") double jahresNettoMiete, 
			@RequestParam("kaufpreis") double kaufPreis, 
			@RequestParam(value="nebenkosten", required=false) double[] nebenKosten
	) {
		Assert.isTrue(jahresNettoMiete > 0);
		Assert.isTrue(kaufPreis > 0);
		return new Rendite(service.berechneRendite(jahresNettoMiete, kaufPreis, nebenKosten));
	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public RuntimeException handleException(IllegalArgumentException e) {
	    return new IllegalArgumentException(e);
	}
	
}
