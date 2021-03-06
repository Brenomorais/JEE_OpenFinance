package com.buildsoftware.openfinance.finance.validator;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.buildsoftware.openfinance.finance.util.FacesUtil;
import com.sun.faces.util.MessageFactory;

@FacesValidator("com.buildsoftware.DataFutura")
public class DataFaturaValidator implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		
		Date data = (Date) value;
		
		if (data != null && data.after(new Date())){
			Object label = MessageFactory.getLabel(context, component);
			
			String descricaoErro = label + " " +FacesUtil.getMensagemI18n("cannot_be_a_future_date");
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					descricaoErro, descricaoErro);
			throw new ValidatorException(message);
		}
		
	}

}
