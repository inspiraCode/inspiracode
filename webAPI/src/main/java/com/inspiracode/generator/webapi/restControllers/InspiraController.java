package com.inspiracode.generator.webapi.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inspiracode.generator.services.GeneratorService;
import com.inspiracode.generator.services.GeneratorServiceException;
import com.inspiracode.generator.webapi.model.Djson;

@Controller
@RequestMapping("/inspiracode")
public class InspiraController {

	@Autowired
	private GeneratorService generatorService;

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody CommonJsonResponse generate(@RequestBody Djson djson) {
		if (djson == null) {
			return new CommonJsonResponse("DJSON cannot be empty.");
		}
		try {
			generatorService.generate(djson);
		} catch (GeneratorServiceException e) {
			e.printStackTrace();
			return new CommonJsonResponse(e.getMessage());
		}
		return new CommonJsonResponse();
	}

	/**
	 * @return the generatorService
	 */
	public GeneratorService getGeneratorService() {
		return generatorService;
	}

	/**
	 * @param generatorService
	 *            the generatorService to set
	 */
	public void setGeneratorService(GeneratorService generatorService) {
		this.generatorService = generatorService;
	}
}
