/*
 * https://shengwangi.blogspot.de/2016/03/how-to-separate-integration-test-from-unit-test.html
 */

package ch.hemisoft.immoroi.controller;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.mockito.internal.matchers.GreaterThan;
import org.springframework.http.HttpStatus;

public class RenditeControllerIT {

	/*
	 * GOOD CASE ... closeTo(1, 0.03)
	 */
	
	@Test
	public void testeBerechneRendite_wennJahresNettoUndKaufpreisUndNebenKostenGegeben_dannBerechneRendite() {
		get("/rendite?jahresnettomiete=10000&kaufpreis=99500&nebenkosten=500").then()
			.statusCode(HttpStatus.OK.value())
			.body("value", is(equalTo(0.1F)));
	}
	
	@Test
	public void testeBerechneRendite_wennJahresNettoUndKaufpreisGegeben_dannBerechneRendite() throws Exception {
		 get("/rendite?jahresnettomiete=10000&kaufpreis=100000").then()
//			.statusCode(HttpStatus.OK.value())
			.body("value", is(equalTo(0.1F)));
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
		get("/rendite?jahresnettomiete=10000&kaufpreis=0").then()
		.statusCode(HttpStatus.BAD_REQUEST.value());
	}
	
	@Test
	public void testeBerechneRendite_wennKeinKaufpreis_dannWerfeClientFehler() throws Exception {
		get("/rendite?jahresnettomiete=10000").then()
		.statusCode(HttpStatus.BAD_REQUEST.value());
	}
	
	@Test
	public void testeBerechneRendite_wennKeinJahresNettoGegeben_dannWerfeClientFehler() throws Exception {
		get("/rendite?kaufpreis=100000").then()
		.statusCode(HttpStatus.BAD_REQUEST.value());
	}

	
	
	/*
	 * ... BAD CASE
	 */
}
