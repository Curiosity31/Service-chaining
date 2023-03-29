package com.academy.cic.serviceB.dao;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.academy.cic.serviceB.entity.Cloud;
import com.academy.cic.serviceB.util.JpaUtil;

@Repository
public class ServiceBDAO {

	private static final Logger logger = Logger.getLogger(ServiceBDAO.class.getName());

	public String getCloud() {
		
		logger.info("getCloud");
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
		Cloud cloud = null;
		
		try {
			TypedQuery<Cloud> query = entityManager.createQuery("SELECT c FROM Cloud c WHERE c.description = 'Cloud'", Cloud.class);
			query.setMaxResults(1);
			cloud = query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close(); 
		}
		
		return cloud.getDescription();
	}

}
