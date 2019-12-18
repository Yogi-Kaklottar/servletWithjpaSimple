package com.main.test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

public class JpaModule extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		
		return Guice.createInjector(new ServletModule(){
			@Override
			protected void configureServlets() {
				install(new JpaPersistModule("PERSISTENCE_UNIT_NAME"));
				serve("/AddPersonServlet").with(AddPersonServlet.class);
				serve("/AddPersonData").with(AddPersonData.class);
				bind(ServicePerson.class).to(PersonDao.class);
				filter("/*").through(PersistFilter.class);
			}
		});
	}
	

}
