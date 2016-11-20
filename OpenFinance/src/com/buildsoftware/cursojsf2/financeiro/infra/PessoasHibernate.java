package com.buildsoftware.cursojsf2.financeiro.infra;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.buildsoftware.cursojsf2.financeiro.model.Pessoa;
import com.buildsoftware.cursojsf2.financeiro.repository.Pessoas;

public class PessoasHibernate  implements Pessoas{

	//Camda mais técnica implementa o repositorio Interface Pessoas
	
	private Session session;	
	public PessoasHibernate(Session session){
		this.session = session;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pessoa> todasPessoas() {
		return session.createCriteria(Pessoa.class)
		.addOrder(Order.asc("nome"))
		.list();	
	}

	@Override
	public Pessoa guardar(Pessoa pessoa) {
		return (Pessoa) session.merge(pessoa);
	}

	@Override
	public void remover(Pessoa pessoa) {
		this.session.delete(pessoa);
	}

	@Override
	public Pessoa porCodigo(Integer codigo) {
		return (Pessoa) this.session.get(Pessoa.class, codigo);
	}
	
}
