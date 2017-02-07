package ch.hemisoft.immoroi.service;

import static java.lang.Double.POSITIVE_INFINITY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RenditeServiceTest {
	@Autowired RenditeService sut;
	
	@Test
	public void testeBerechneRendite_wennKaufPreisUndJahresNettoMieteUndNebenkostenGegeben_dannBerechneRendite() throws Exception {
		assertThat(sut.berechneRendite(8000, 100000, 500)).isCloseTo(0.07, within(0.01));
	}
	
	@Test
	public void testeBerechneRendite_wennKaufPreisUndJahresNettoMieteGegeben_dannBerechneRendite() throws Exception {
		assertThat(sut.berechneRendite(8000, 100000)).isCloseTo(0.07, within(0.01));
	}
	
	//
	
	@Test
	public void testeBerechneRendite_wennNullAlsKaufPreisGegeben_dannLiefereUnendlich() throws Exception {
		assertThat(sut.berechneRendite(8000, 0)).isCloseTo(POSITIVE_INFINITY, within(0.01));
	}

}
