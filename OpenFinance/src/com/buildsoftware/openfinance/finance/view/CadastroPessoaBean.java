package com.buildsoftware.openfinance.finance.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import com.buildsoftware.openfinance.finance.model.Pessoa;
import com.buildsoftware.openfinance.finance.model.RamoAtividade;
import com.buildsoftware.openfinance.finance.model.TipoPessoa;
import com.buildsoftware.openfinance.finance.repository.RamoAtividades;
import com.buildsoftware.openfinance.finance.service.GestaoPessoas;
import com.buildsoftware.openfinance.finance.service.RegraNegocioException;
import com.buildsoftware.openfinance.finance.util.FacesUtil;
import com.buildsoftware.openfinance.finance.util.Repositorios;

@ManagedBean
@ViewScoped
public class CadastroPessoaBean  implements Serializable {
		
	private static final long serialVersionUID = 8004157101424153255L;		
	
	private Repositorios repositorios = new Repositorios();	
	private List<RamoAtividade> ramoAtividades = new ArrayList<RamoAtividade>();
	private Pessoa pessoa = new Pessoa();

	
	@PostConstruct
	public void init(){
		RamoAtividades ramoAtividades = this.repositorios.getRamoAtividades();
		this.ramoAtividades = ramoAtividades.todosRamosAtvidades();
	}
	
	public void cadastrar(){		
		testeRamo();
		GestaoPessoas gestaoPessoa = new GestaoPessoas(this.repositorios.getPessoas());
		try {
			gestaoPessoa.salvar(pessoa);
			this.pessoa = new Pessoa();
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Cadastro efetuado com sucesso!");
		} catch (RegraNegocioException e) {		
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, e.getMessage());
		}
	}	
	
	public void verificaTipo(ValueChangeEvent event){
		this.pessoa.setTipoPessoa((TipoPessoa) event.getNewValue());
		this.pessoa.setDataNascimento(null);
		this.pessoa.setRamoAtividade(new RamoAtividade());
				
		//pula todasa as validações e rederiza tela
        FacesContext.getCurrentInstance().renderResponse();
	}	
	
	public TipoPessoa[] getTiposPessoas(){
		return TipoPessoa.values();
	}

	public List<RamoAtividade> getRamoAtividades() {
		return ramoAtividades;
	}
	
	public boolean pessoaJuridica() {
		return this.pessoa.getTipoPessoa() == TipoPessoa.JURIDICA ? true : false;
	}

	public boolean pessoaFisica() {
		return this.pessoa.getTipoPessoa() == TipoPessoa.FISICA ? true : false;
	}
	
	public Repositorios getRepositorios() {
		return repositorios;
	}

	public void setRepositorios(Repositorios repositorios) {
		this.repositorios = repositorios;
	}
	
	private void testeRamo(){
		if(pessoa.getDataNascimento() !=  null){
			RamoAtividade ra = new RamoAtividade();
			ra.setCodigo(0);
			this.pessoa.setRamoAtividade(ra);
		}
	}
	
	public boolean isEditando(){
		return this.pessoa.getCodigo() != null;
	}	
	
	public void setPessoa(Pessoa pessoa) throws CloneNotSupportedException {
		this.pessoa = pessoa;
		if (this.pessoa == null) {
			this.pessoa = new Pessoa();
		} else {
			this.pessoa = (Pessoa) pessoa.clone();
		}
	}	
	
	public Pessoa getPessoa(){
		return pessoa;
	}
}
