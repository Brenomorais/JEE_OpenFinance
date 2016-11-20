package com.buildsoftware.cursojsf2.financeiro.service;

import com.buildsoftware.cursojsf2.financeiro.model.Pessoa;
import com.buildsoftware.cursojsf2.financeiro.repository.Pessoas;

public class GestaoPessoas {
	private Pessoas pessoas;
	public GestaoPessoas(Pessoas pessoas){
		this.pessoas = pessoas;
	}
	
	public void salvar(Pessoa pessoa) throws RegraNegocioException{		
		this.pessoas.guardar(pessoa);
	}
	
	public void excluir(Pessoa pessoa) throws RegraNegocioException{
		this.pessoas.remover(pessoa);
	}
	
}
