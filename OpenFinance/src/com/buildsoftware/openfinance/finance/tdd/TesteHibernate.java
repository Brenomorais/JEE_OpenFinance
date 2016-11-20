package com.buildsoftware.openfinance.finance.tdd;

import java.util.List;

import org.hibernate.Session;

import com.buildsoftware.openfinance.finance.model.RamoAtividade;
import com.buildsoftware.openfinance.finance.util.HibernateUtil;

public class TesteHibernate {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		//Sempre que precisar de uma sessão com o banco, é feita uma sessão com atraves da HibernateUtil
		Session session = HibernateUtil.getSession();
		
		List<RamoAtividade> ratv = session.createCriteria(RamoAtividade.class).list();
		
		System.out.println(">>Consulta buscando codigo e nome");
		for(RamoAtividade p : ratv){
			System.out.println(p.getCodigo()+" - "+p.getDescricao());
		}

//		//Utilizando filtro na consulta com criteria
//		List<Pessoa> pessoasSelecionadas = session.createCriteria(Pessoa.class)
//				.add(Restrictions.gt("codigo", 3))
//				.list();
//		
//		System.out.println(">>Consulta buscando codigo e nome, filtrando codigo > 3");
//		for(Pessoa p : pessoasSelecionadas){
//			System.out.println(p.getCodigo()+" - "+p.getNome());
//		}		
		
		//fechando sessão com o banco.
		session.close();
		
		
	}

}
