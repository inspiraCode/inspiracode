package com.inspiracode.generator.services;

import com.inspiracode.generator.webapi.model.Djson;

public interface GeneratorService {
	void generate(Djson djson) throws GeneratorServiceException;	
}
