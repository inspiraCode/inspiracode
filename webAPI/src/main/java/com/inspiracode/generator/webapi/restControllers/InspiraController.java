package com.inspiracode.generator.webapi.restControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inspiracode.generator.webapi.model.Djson;

@Controller
@RequestMapping("/inspiracode")
public class InspiraController {

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody CommonJsonResponse generate(@RequestBody Djson djson) {
		System.out.println(djson);
		return new CommonJsonResponse();
	}
}
