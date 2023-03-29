package com.academy.cic.serviceD.dao;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.academy.cic.serviceD.entity.Marzo2023;
import com.academy.cic.serviceD.util.JpaUtil;

@Repository
public class ServiceDDAO {

	private static final Logger logger = Logger.getLogger(ServiceDDAO.class.getName());

	public String getAcademy() {
		
		logger.info("getMarzo2023");
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
		Marzo2023 marzo2023 = null;
		
		try {
			TypedQuery<Marzo2023> query = entityManager.createQuery("SELECT m FROM Marzo2023 m WHERE m.description = 'Marzo 2023'", Marzo2023.class);
			query.setMaxResults(1);
			marzo2023 = query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close(); 
		}
		
		return marzo2023.getDescription();
	}
}
