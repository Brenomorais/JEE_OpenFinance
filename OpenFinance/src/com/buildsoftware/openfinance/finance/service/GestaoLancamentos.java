package com.buildsoftware.openfinance.finance.service;

import com.buildsoftware.openfinance.finance.model.Lancamento;
import com.buildsoftware.openfinance.finance.repository.Lancamentos;

public class GestaoLancamentos {

	// Numa classe de negocio nao deve acesso direto a API do JSF camada de view,
	// a camada de negocio n�o precisa saber que o JSF faz a camada de vis�o
	
	private Lancamentos lancamentos;
	public GestaoLancamentos(Lancamentos lancamentos){
		this.lancamentos = lancamentos;
	}
	
	public void salvar(Lancamento lancamento) throws RegraNegocioException{
		if(existeLancamentoSemelhante(lancamento)){
			throw new RegraNegocioException("existing_entry");
		}		
		this.lancamentos.guardar(lancamento);
	}
	
	private boolean existeLancamentoSemelhante(Lancamento lancamento){
		Lancamento lancamentoSemelhante = this.lancamentos.comDadosIguais(lancamento);
		
		return lancamentoSemelhante != null && !lancamentoSemelhante.equals(lancamento);
		
	}
	
	public void excluir(Lancamento lancamento) throws RegraNegocioException{
		if(lancamento.isPago()){
			throw new RegraNegocioException("Lan�amento pago n�o pode ser excluido!");
		}
		this.lancamentos.remover(lancamento);
	}
}
