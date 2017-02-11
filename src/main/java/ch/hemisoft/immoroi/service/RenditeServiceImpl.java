package ch.hemisoft.immoroi.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class RenditeServiceImpl implements RenditeService {
	public double berechneRendite(double jahresNettoMiete, double kaufPreis, double... nebenKosten) {
		return jahresNettoMiete / berechneAnschaffungsKosten(kaufPreis, nebenKosten);
	}

	private double berechneAnschaffungsKosten(double kaufPreis, double... nebenKosten) {
		final double summeNebenkosten;
		if(null != nebenKosten)
			summeNebenkosten = Arrays.stream(nebenKosten).sum();
		else 	
			summeNebenkosten = 0;
		return kaufPreis + summeNebenkosten;
	}
}
