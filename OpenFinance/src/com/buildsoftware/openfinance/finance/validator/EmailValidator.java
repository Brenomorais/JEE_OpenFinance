package com.buildsoftware.openfinance.finance.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.sun.faces.util.MessageFactory;

@FacesValidator("com.buildsoftware.EmailValidator")
public class EmailValidator implements Validator {

    private Pattern pattern;
    private Matcher matcher;
    
    private static final String EMAIL_PATTERN = "^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$";
    
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value)
            throws ValidatorException {

        if (value != null){
            pattern = Pattern.compile(EMAIL_PATTERN);
            matcher = pattern.matcher(value.toString());

            Object label = MessageFactory.getLabel(facesContext,uiComponent);
             if (!matcher.matches()){
                 String descricaoErro = " E-mail inválido: "+value  ;
                 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,descricaoErro,descricaoErro);
                 throw new ValidatorException(message);
             }
        }
    }
}