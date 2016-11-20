package com.buildsoftware.openfinance.finance.view;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import com.buildsoftware.openfinance.finance.model.Lancamento;
import com.buildsoftware.openfinance.finance.repository.Lancamentos;
import com.buildsoftware.openfinance.finance.service.GestaoLancamentos;
import com.buildsoftware.openfinance.finance.service.RegraNegocioException;
import com.buildsoftware.openfinance.finance.util.FacesUtil;
import com.buildsoftware.openfinance.finance.util.Repositorios;

@ManagedBean
public class ConsultaLancamentoBean implements Serializable{

	
	private static final long serialVersionUID = -6040392949863933730L;
	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();
	private Lancamento lancamentoSelecionado;
	private Repositorios repositorios = new Repositorios();
	
	private BigDecimal totalDespesa;
	private BigDecimal totalReceita;
	
	@PostConstruct
	public void inicializar(){
		Lancamentos lancamentos = this.repositorios.getLancamentos();
		this.lancamentos = lancamentos.todos();
		this.setTotalDespesa(repositorios.totalDespesas());		
		this.setTotalReceita(repositorios.totalReceitas());
	}	
	
	public void excluir(){
		GestaoLancamentos gestaoLancamentos = new GestaoLancamentos(this.repositorios.getLancamentos());
		try {
			gestaoLancamentos.excluir(this.lancamentoSelecionado);
			this.inicializar();
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR,"Lancamento excluído com sucesso!");
		} catch (RegraNegocioException e) {
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR,e.getMessage());					
		}	
	}
	
	public List<Lancamento> getLancamentos(){
		return lancamentos;
	}

	public Lancamento getLancamentoSelecionado() {
		return lancamentoSelecionado;
	}

	public void setLancamentoSelecionado(Lancamento lancamentoSelecionado) {
		this.lancamentoSelecionado = lancamentoSelecionado;
	}

	public BigDecimal getTotalDespesa() {
		return totalDespesa;
	}

	public void setTotalDespesa(BigDecimal totalDespesa) {
		this.totalDespesa = totalDespesa;
	}

	public BigDecimal getTotalReceita() {
		return totalReceita;
	}

	public void setTotalReceita(BigDecimal totalReceita) {
		this.totalReceita = totalReceita;
	}
}
