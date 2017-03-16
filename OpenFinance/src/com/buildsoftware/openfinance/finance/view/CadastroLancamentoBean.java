package com.buildsoftware.openfinance.finance.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import com.buildsoftware.openfinance.finance.model.Lancamento;
import com.buildsoftware.openfinance.finance.model.Pessoa;
import com.buildsoftware.openfinance.finance.model.TipoLancamento;
import com.buildsoftware.openfinance.finance.repository.Pessoas;
import com.buildsoftware.openfinance.finance.service.GestaoLancamentos;
import com.buildsoftware.openfinance.finance.service.RegraNegocioException;
import com.buildsoftware.openfinance.finance.util.FacesUtil;
import com.buildsoftware.openfinance.finance.util.Repositorios;

@ManagedBean
@ViewScoped
public class CadastroLancamentoBean implements Serializable{

	private static final long serialVersionUID = 2785649428415995185L;
	
	private Repositorios repositorios = new Repositorios();
	private Lancamento lancamento = new Lancamento();
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	//executa metodo se pagamento ja esta pago
	public String init(){	
		
		if(this.lancamento.isPago()){
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR,
					"Lançamento já pago e não pode ser editado!");
			return "ConsultaLancamento";
		}
		
		Pessoas pessoas = this.repositorios.getPessoas();		
		this.pessoas = pessoas.todasPessoas(); 	
		
		return null;
	}	
	
	public void salvar(){
		GestaoLancamentos gestaoLancamento = new GestaoLancamentos(this.repositorios.getLancamentos());
		try {
			gestaoLancamento.salvar(lancamento);
			this.lancamento = new Lancamento();
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, FacesUtil.getMensagemI18n("entry_saved"));
		} catch (RegraNegocioException e) {		
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, FacesUtil.getMensagemI18n(e.getMessage()));
		}				
	}
	
	public void lancamentoPagoModificado(ValueChangeEvent event){
		this.lancamento.setPago((Boolean) event.getNewValue());
		this.lancamento.setDataPagamento(null);
		FacesContext.getCurrentInstance().renderResponse();
	}

	public boolean isEditando(){
		return this.lancamento.getCodigo() != null;
	}
	
	public TipoLancamento[] getTiposLancamentos(){
		return TipoLancamento.values();
	}

	public Lancamento getLancamento() {
		return lancamento;
	}
	
	public void setLancamento(Lancamento lancamento) throws CloneNotSupportedException {
		this.lancamento = lancamento;
		if (this.lancamento == null) {
			this.lancamento = new Lancamento();
		} else {
			this.lancamento = (Lancamento) lancamento.clone();
		}
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}	
	
}
