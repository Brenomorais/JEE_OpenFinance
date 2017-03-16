package com.buildsoftware.openfinance.finance.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.buildsoftware.openfinance.finance.model.RamoAtividade;
import com.buildsoftware.openfinance.finance.repository.RamoAtividades;
import com.buildsoftware.openfinance.finance.util.Repositorios;

@FacesConverter(forClass=RamoAtividade.class)
public class RamoAtividadeConverter implements Converter{

	private Repositorios repositorios = new Repositorios();
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		RamoAtividade retorno = null;
		if(value != null){
			RamoAtividades ramosAtividades = repositorios.getRamoAtividades();
			retorno = ramosAtividades.porCodigo(new Integer(value));
		}		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(value != null){
			return ((RamoAtividade)value).getCodigo().toString();
		}		
		return null;
	}

}
