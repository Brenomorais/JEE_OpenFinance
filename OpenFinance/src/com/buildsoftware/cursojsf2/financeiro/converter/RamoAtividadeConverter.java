package com.buildsoftware.cursojsf2.financeiro.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.buildsoftware.cursojsf2.financeiro.model.RamoAtividade;
import com.buildsoftware.cursojsf2.financeiro.repository.RamoAtividades;
import com.buildsoftware.cursojsf2.financeiro.util.Repositorios;

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
