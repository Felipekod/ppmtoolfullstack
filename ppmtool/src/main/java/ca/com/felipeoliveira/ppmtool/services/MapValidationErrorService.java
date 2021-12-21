package ca.com.felipeoliveira.ppmtool.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Service
public class MapValidationErrorService {

	public ResponseEntity<?> MapValidationService(BindingResult result){
		
		//Si existe erro no request a gente cria um MAP de erros
		if(result.hasErrors()) {	
			Map<String, String> errorMap =  new HashMap<>();
			//Para cada erro do resultado a gente coloca o campo e a mensagem de erro
			for(FieldError error: result.getFieldErrors()) {
					errorMap.put(error.getField(), error.getDefaultMessage());
				}
					
			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST) ;
		}
		
		return null;
	}
}
