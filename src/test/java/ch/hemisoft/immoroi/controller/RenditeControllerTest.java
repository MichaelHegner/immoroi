package ch.hemisoft.immoroi.controller;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import ch.hemisoft.immoroi.service.RenditeService;


@RunWith(SpringRunner.class)
@WebMvcTest(RenditeController.class)
public class RenditeControllerTest {
	@Autowired private MockMvc mockMvc;
	@MockBean private RenditeService mockService;

	/*
	 * GOOD CASE ...
	 */
	
	@Test
	public void testeBerechneRendite_wennKaufPreisUndJahresNettoMieteUndNebenkostenGegeben_dannDelegiereAnServiceKlasse() throws Exception {
		 given(mockService.berechneRendite(8000, 100000, 500)).willReturn(0.43);
		 mockMvc.perform(get("/rendite?jahresnettomiete=8000&kaufpreis=100000&nebenkosten=500"))
			 .andExpect(status().isOk())
			 .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			 .andExpect(content().json("{value: 0.43}"))
		 ;
		 verify(mockService).berechneRendite(8000, 100000, 500);
	}
	
	@Test
	public void testeBerechneRendite_wennKaufPreisUndJahresNettoMieteGegeben_dannDelegiereAnServiceKlasse() throws Exception {
		 given(mockService.berechneRendite(8000, 100000, null)).willReturn(0.43);
		 mockMvc.perform(get("/rendite?jahresnettomiete=8000&kaufpreis=100000"))
			 .andExpect(status().isOk())
			 .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			 .andExpect(content().json("{value: 0.43}"))
		 ;
		 verify(mockService).berechneRendite(8000, 100000, null);
	}

	/*
	 * ... GOOD CASE
	 */
	
	//
	
	/*
	 * BAD CASE ...
	 */
	
	@Test
	public void testeBerechneRendite_wennNullAlsKaufpreis_dannWerfeClientFehler() throws Exception {
		 given(mockService.berechneRendite(8000, 0, null)).willThrow(new ArithmeticException());
		 mockMvc.perform(get("/rendite?jahresnettomiete=8000&kaufpreis=0"))
		 .andExpect(status().is4xxClientError());
		
	}
	
	@Test
	public void testeBerechneRendite_wennKeinKaufPreisGegeben_dannWerfeClientFehler() throws Exception {
		mockMvc.perform(get("/rendite?nebenkosten=100&jahresnettomiete=8000"))
		.andExpect(status().is4xxClientError());
	}
	
	@Test
	public void testeBerechneRendite_wennKeineJahresNettoMieteGegeben_dannWerfeClientFehler() throws Exception {
		mockMvc.perform(get("/rendite?nebenkosten=100&kaufpreis=100000"))
		.andExpect(status().is4xxClientError());
	}

	/*
	 * ... BAD CASE
	 */
}
