package com.buildsoftware.cursojsf2.financeiro.repository;

import java.math.BigDecimal;
import java.util.List;

import com.buildsoftware.cursojsf2.financeiro.model.Lancamento;

public interface Lancamentos {
	
	public List<Lancamento> todos();
	public Lancamento porCodio(Integer codigo);
	public Lancamento guardar(Lancamento lancamento);	
	public void remover(Lancamento lancamento);
	public Lancamento comDadosIguais(Lancamento lancamento);
	public BigDecimal totalDespesas();
	public BigDecimal totalReceitas();
}