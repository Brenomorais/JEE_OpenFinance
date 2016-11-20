package com.buildsoftware.openfinance.finance.util;

import java.io.Serializable;
import java.math.BigDecimal;

import org.hibernate.Session;

import com.buildsoftware.openfinance.finance.infra.LancamentosHibernate;
import com.buildsoftware.openfinance.finance.infra.PessoasHibernate;
import com.buildsoftware.openfinance.finance.infra.RamoAtividadeHibernate;
import com.buildsoftware.openfinance.finance.repository.Lancamentos;
import com.buildsoftware.openfinance.finance.repository.Pessoas;
import com.buildsoftware.openfinance.finance.repository.RamoAtividades;

public class Repositorios implements Serializable{

	private static final long serialVersionUID = -8654376523129412957L;
	
	//Implementação pessoas
	public Pessoas getPessoas(){
		return new PessoasHibernate(this.getSession());
	}

	private Session getSession(){
		return (Session)FacesUtil.getRequestAttribute("session");
	}
	
	public Lancamentos getLancamentos(){
		return new LancamentosHibernate(this.getSession());
	}
	
	//Implementação ramoatvidades
	public RamoAtividades getRamoAtividades(){
		return new RamoAtividadeHibernate(this.getSession());
	}	
	
	public BigDecimal totalDespesas(){
		return getLancamentos().totalDespesas();		
	}
	public BigDecimal totalReceitas(){
		return getLancamentos().totalReceitas();		
	}
	
}
