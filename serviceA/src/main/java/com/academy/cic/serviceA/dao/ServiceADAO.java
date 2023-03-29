package com.academy.cic.serviceA.dao;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.academy.cic.serviceA.entity.IBM;
import com.academy.cic.serviceA.util.JpaUtil;

@Repository
public class ServiceADAO {
	
	private static final Logger logger = Logger.getLogger(ServiceADAO.class.getName());

	public String getIBM() {
		
		logger.info("getIBM");
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
		IBM ibm = null;
		
		try {
			TypedQuery<IBM> query = entityManager.createQuery("SELECT i FROM IBM i WHERE i.description = 'IBM'", IBM.class);
			query.setMaxResults(1);
			ibm = query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close(); 
		}
		
		return ibm.getDescription();
	}
}
