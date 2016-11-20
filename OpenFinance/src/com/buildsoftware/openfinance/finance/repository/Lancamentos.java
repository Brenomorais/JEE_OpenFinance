package com.buildsoftware.openfinance.finance.repository;

import java.math.BigDecimal;
import java.util.List;

import com.buildsoftware.openfinance.finance.model.Lancamento;

public interface Lancamentos {
	
	public List<Lancamento> todos();
	public Lancamento porCodio(Integer codigo);
	public Lancamento guardar(Lancamento lancamento);	
	public void remover(Lancamento lancamento);
	public Lancamento comDadosIguais(Lancamento lancamento);
	public BigDecimal totalDespesas();
	public BigDecimal totalReceitas();
}