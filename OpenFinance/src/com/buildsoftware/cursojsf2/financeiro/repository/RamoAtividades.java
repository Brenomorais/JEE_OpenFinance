package com.buildsoftware.cursojsf2.financeiro.repository;

import java.util.List;

import com.buildsoftware.cursojsf2.financeiro.model.RamoAtividade;

public interface RamoAtividades {
	
	//Interface de dominio
	public List<RamoAtividade> todosRamosAtvidades();
	public RamoAtividade porCodigo(Integer codigo);
}
