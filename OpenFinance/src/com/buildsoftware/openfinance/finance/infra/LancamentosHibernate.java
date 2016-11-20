package com.buildsoftware.openfinance.finance.infra;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.buildsoftware.openfinance.finance.model.Lancamento;
import com.buildsoftware.openfinance.finance.model.TipoLancamento;
import com.buildsoftware.openfinance.finance.repository.Lancamentos;

public class LancamentosHibernate implements Lancamentos{

	public Session session;
	public LancamentosHibernate(Session session){
		this.session = session;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Lancamento> todos() {
		return session.createCriteria(Lancamento.class)
				.addOrder(Order.desc("dataVencimento"))
				.list();
	}

	@Override
	public Lancamento porCodio(Integer codigo) {
		return (Lancamento) this.session.get(Lancamento.class, codigo);
	}

	@Override
	public Lancamento guardar(Lancamento lancamento) {
		return (Lancamento) session.merge(lancamento);	
	}

	@Override
	public void remover(Lancamento lancamento) {
		this.session.delete(lancamento);
		
	}

	@Override
	public Lancamento comDadosIguais(Lancamento lancamento) {
		return (Lancamento) this.session.createCriteria(Lancamento.class)
				.add(Restrictions.eq("tipo", lancamento.getTipo()))
				.add(Restrictions.eq("pessoa", lancamento.getPessoa()))
				.add(Restrictions.ilike("descricao", lancamento.getDescricao()))
				.add(Restrictions.eq("valor", lancamento.getValor()))
				.add(Restrictions.eq("dataVencimento", lancamento.getDataVencimento()))
				.uniqueResult();
	}

	@Override
	public BigDecimal totalDespesas() {
		BigDecimal total = (BigDecimal) this.session.createCriteria(Lancamento.class)
				.add(Restrictions.eq("tipo", TipoLancamento.DESPESA))
				.setProjection(Projections.sum("valor")).uniqueResult();
		return total;
	}

	@Override
	public BigDecimal totalReceitas() {
		BigDecimal total = (BigDecimal) this.session.createCriteria(Lancamento.class)
				.add(Restrictions.eq("tipo", TipoLancamento.RECEITA))
				.setProjection(Projections.sum("valor")).uniqueResult();
		return total;
	}

}
