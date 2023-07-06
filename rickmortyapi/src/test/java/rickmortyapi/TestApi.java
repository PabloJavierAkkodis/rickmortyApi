package rickmortyapi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
public class TestApi {
	
	@Test
	public void TestsApi() {
		
		//assertEquals para validar que el tiempo de respuesta sea 200.
		assertEquals(200, ApiRepo.connectApi());
		
		//assertTrue para validar que el tiempo de respuesta sea mayor a 0
		assertTrue(ApiRepo.connectApi() > 0);
	}

}
