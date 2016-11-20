package com.buildsoftware.openfinance.finance.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import com.buildsoftware.openfinance.finance.model.Pessoa;
import com.buildsoftware.openfinance.finance.repository.Pessoas;
import com.buildsoftware.openfinance.finance.service.GestaoPessoas;
import com.buildsoftware.openfinance.finance.service.RegraNegocioException;
import com.buildsoftware.openfinance.finance.util.FacesUtil;
import com.buildsoftware.openfinance.finance.util.Repositorios;

@ManagedBean
public class ConsultaPessoaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	private Pessoa pessoaSelecionada;
	private Pessoa pessoa = new Pessoa();
	private Repositorios repositorios = new Repositorios();
	
	@PostConstruct
	public void inicializar(){
		Pessoas pessoas = this.repositorios.getPessoas();
		this.pessoas = pessoas.todasPessoas();
	}
	
	
	public void excluir(){
		GestaoPessoas gestaoPessoas = new GestaoPessoas(this.repositorios.getPessoas());
		try {
			gestaoPessoas.excluir(this.pessoaSelecionada);
			this.inicializar();
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR,"Pessoa excluída com sucesso!");
		} catch (RegraNegocioException e) {
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR,e.getMessage());					
		}				
	}
	
	
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	public Pessoa getPessoaSelecionada() {
		return pessoaSelecionada;
	}
	public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
		this.pessoaSelecionada = pessoaSelecionada;
	}
	public Repositorios getRepositorios() {
		return repositorios;
	}
	public void setRepositorios(Repositorios repositorios) {
		this.repositorios = repositorios;
	}
	
	public void setPessoa(Pessoa pessoa){
		this.pessoa = pessoa;
	}
	
	public Pessoa getPessoa(){
		return pessoa;
	}

}
