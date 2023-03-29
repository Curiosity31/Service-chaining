package com.academy.cic.serviceA.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	 private static EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();
	    
	    private static EntityManagerFactory buildEntityManagerFactory() {
	        return Persistence.createEntityManagerFactory("service_a");
	    }

	    public static EntityManagerFactory getEntityManagerFactory() {
	        return entityManagerFactory;
	    }
	    
}
