package com.academy.cic.serviceC.dao;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.academy.cic.serviceC.entity.Academy;
import com.academy.cic.serviceC.util.JpaUtil;

@Repository
public class ServiceCDAO {

	private static final Logger logger = Logger.getLogger(ServiceCDAO.class.getName());

	public String getAcademy() {
		
		logger.info("getAcademy");
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
		Academy academy = null;
		
		try {
			TypedQuery<Academy> query = entityManager.createQuery("SELECT a FROM Academy a WHERE a.description = 'Academy'", Academy.class);
			query.setMaxResults(1);
			academy = query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close(); 
		}
		
		return academy.getDescription();
	}
}
