package com.inspiracode.generator.webapi.restControllers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.inspiracode.generator.services.GeneratorService;
import com.inspiracode.generator.webapi.model.Djson;

public class InspiraControllerTest {
	
	private InspiraController inspiraController;
	
	@Before
	public void setup(){
		inspiraController = new InspiraController();
		inspiraController.setGeneratorService(new MockGeneratorService());
	}
	
	@Test
	public void testDelegatesControlToService(){
		inspiraController.generate(new Djson());
		Assert.assertTrue(wasExecuted);
	}
	
	@Test
	public void testDJsonIsNotNull(){
		CommonJsonResponse commonJsonResponse = inspiraController.generate(null);
		Assert.assertTrue(commonJsonResponse.getError() == true);
	}
	
	private static boolean wasExecuted = false;
	private static class MockGeneratorService implements GeneratorService {

		@Override
		public void generate(Djson djson) {
			wasExecuted = true;
		}
		
	}
}