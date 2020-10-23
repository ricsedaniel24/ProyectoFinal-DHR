package com.everis.reniec.services;


import org.json.JSONObject;
import org.springframework.stereotype.Service;
import com.everis.reniec.model.Reniec;


@Service
public class ReniecServiceImpl implements IReniecServices{


	@Override
	public Reniec getValidate(String document) {
	
		Reniec 	 reniecResponse = new Reniec();
		
		JSONObject jsonDni = new JSONObject(document);
		String documentNum  = jsonDni.getString("document");
		System.out.println("document - reniec : "+documentNum);
	
		reniecResponse = Reniec.builder().entityName("Reniec").sucess(true).build();
		
		return reniecResponse;
	}
	
	
	
}
