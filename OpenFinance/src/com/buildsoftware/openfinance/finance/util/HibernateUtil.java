package com.buildsoftware.openfinance.finance.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	
	static {
		try {
			Configuration configuration = new Configuration();
			configuration.configure();  //Faz a leitura do arquivo hibernate.cfg.xml
			
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).buildServiceRegistry();
			
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			
		} catch (Throwable ex) {
			//Exceção para lançar qualquer erro na inicialização.
			//Atenção : A exceção é gerada quando a configurado hibernate.cfg.xml está errada 
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static Session getSession() {
		return sessionFactory.openSession();
	}
	
}