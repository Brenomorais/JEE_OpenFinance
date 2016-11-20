package com.buildsoftware.cursojsf2.financeiro.repository;

import java.util.List;

import com.buildsoftware.cursojsf2.financeiro.model.Pessoa;

public interface Pessoas {
	
	//Interface faz parte do dominio	
	public List<Pessoa> todasPessoas();
	public Pessoa porCodigo(Integer codigo);
	public Pessoa guardar(Pessoa pessoa);
	public void remover(Pessoa pessoa);	
}
