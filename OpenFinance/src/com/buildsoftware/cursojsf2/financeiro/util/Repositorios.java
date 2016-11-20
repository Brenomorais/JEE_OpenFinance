package com.buildsoftware.cursojsf2.financeiro.util;

import java.io.Serializable;
import java.math.BigDecimal;

import org.hibernate.Session;

import com.buildsoftware.cursojsf2.financeiro.infra.LancamentosHibernate;
import com.buildsoftware.cursojsf2.financeiro.infra.PessoasHibernate;
import com.buildsoftware.cursojsf2.financeiro.infra.RamoAtividadeHibernate;
import com.buildsoftware.cursojsf2.financeiro.repository.Lancamentos;
import com.buildsoftware.cursojsf2.financeiro.repository.Pessoas;
import com.buildsoftware.cursojsf2.financeiro.repository.RamoAtividades;

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
