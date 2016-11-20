package com.buildsoftware.cursojsf2.financeiro.validator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("com.buildsoftware.VerificaTipoPessoa")
public class VerificaTipoPessoa implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		
		Boolean checado = (Boolean) component.getAttributes().get("checado");
		
		
		
		
	}

}
