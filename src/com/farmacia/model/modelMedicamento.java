package com.farmacia.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.farmacia.entidad.Medicamento;

public class modelMedicamento {
	EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("PE");
	EntityManager em = null;
	
	public void addMedicamento(Medicamento obj) {
		em = fabrica.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(obj);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
			fabrica.close();
		}
	}
}
