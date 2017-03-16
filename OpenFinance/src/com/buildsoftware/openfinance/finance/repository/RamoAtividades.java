package com.buildsoftware.openfinance.finance.repository;

import java.util.List;

import com.buildsoftware.openfinance.finance.model.RamoAtividade;

public interface RamoAtividades {
	
	//Interface de dominio
	public List<RamoAtividade> todosRamosAtvidades();
	public RamoAtividade porCodigo(Integer codigo);
}
