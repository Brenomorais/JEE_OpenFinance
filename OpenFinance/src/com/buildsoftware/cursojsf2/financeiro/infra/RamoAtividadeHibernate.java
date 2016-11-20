package com.buildsoftware.cursojsf2.financeiro.infra;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.buildsoftware.cursojsf2.financeiro.model.RamoAtividade;
import com.buildsoftware.cursojsf2.financeiro.repository.RamoAtividades;

public class RamoAtividadeHibernate implements RamoAtividades{

	private Session session;
	
	public RamoAtividadeHibernate(Session session){
		this.session = session;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RamoAtividade> todosRamosAtvidades() {
		return session.createCriteria(RamoAtividade.class)
				.add(Restrictions.ne("codigo",0))
				.addOrder(Order.asc("descricao"))				
				.list();
	}

	@Override
	public RamoAtividade porCodigo(Integer codigo) {
		return (RamoAtividade) session.get(RamoAtividade.class,codigo);
	}

}
