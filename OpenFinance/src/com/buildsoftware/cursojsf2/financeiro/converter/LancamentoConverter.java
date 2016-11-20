package com.buildsoftware.cursojsf2.financeiro.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.buildsoftware.cursojsf2.financeiro.model.Lancamento;
import com.buildsoftware.cursojsf2.financeiro.repository.Lancamentos;
import com.buildsoftware.cursojsf2.financeiro.util.FacesUtil;
import com.buildsoftware.cursojsf2.financeiro.util.Repositorios;

@FacesConverter(forClass=Lancamento.class)
public class LancamentoConverter implements Converter {

	private Repositorios repositorios = new Repositorios();
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Lancamento retorno = null;
		Lancamentos lancamentos = repositorios.getLancamentos();
		
		if(value != null && !value.equals("")){			
			retorno = lancamentos.porCodio(new Integer(value));
			
			if(retorno ==  null){
				String descricaoErro = FacesUtil.getMensagemI18n("entry_does_not_exist");
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					descricaoErro, descricaoErro);
				throw new ConverterException(message);
			}
		}		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {	
		if(value != null){
			Integer codigo = ((Lancamento) value).getCodigo();
			return codigo == null ? "" : codigo.toString();
		}
		return null;
	}

}
