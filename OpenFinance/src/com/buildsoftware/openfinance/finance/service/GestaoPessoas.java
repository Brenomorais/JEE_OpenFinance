package com.buildsoftware.openfinance.finance.service;

import com.buildsoftware.openfinance.finance.model.Pessoa;
import com.buildsoftware.openfinance.finance.repository.Pessoas;

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
