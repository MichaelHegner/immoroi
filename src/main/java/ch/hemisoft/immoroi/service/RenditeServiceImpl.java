package ch.hemisoft.immoroi.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;

@Service
public class RenditeServiceImpl implements RenditeService {
	public double berechneRendite(double jahresNettoMiete, double kaufPreis, double... nebenKosten) {
		return jahresNettoMiete / (kaufPreis + Arrays.stream(nebenKosten).sum());
	}
}
