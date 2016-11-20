package com.buildsoftware.openfinance.finance.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.buildsoftware.openfinance.finance.model.RamoAtividade;

public class GestaoRamosAtividades {

	private static Map<Integer, RamoAtividade> ramoAtividades = new HashMap<Integer, RamoAtividade>();  
	
	static{
		ramoAtividades.put(1, new RamoAtividade(1, "Desenvolmento Desktop"));
		ramoAtividades.put(2, new RamoAtividade(2, "Desenvolmento Web"));
		ramoAtividades.put(3, new RamoAtividade(3, "Desenvolmento Mobile"));
		ramoAtividades.put(4, new RamoAtividade(4, "Arquitetura de Software"));
		ramoAtividades.put(5, new RamoAtividade(5, "Gerência de Projeto"));		
	}
	
	public List<RamoAtividade> listarTodas(){
		List<RamoAtividade> ramoAtividade = new ArrayList<RamoAtividade>();
		ramoAtividade.addAll(GestaoRamosAtividades.ramoAtividades.values());
		return ramoAtividade;
	}
	
	public RamoAtividade buscarPorCodigo(Integer codigo){
		return ramoAtividades.get(codigo);
	}
}
