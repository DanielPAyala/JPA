package com.farmacia.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.farmacia.entidad.Laboratorio;

public class modelLaboratorio {
	// vincular con la unidad de persistencia
	// clases y conex bd
	EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("PE");
	
	// Objeto para manipular una coneccion con la unidad de persistencia
	EntityManager em = null;
	
	public void addLaboratorio(Laboratorio obj) {
		// crear el objeto manager
		em = fabrica.createEntityManager();
		try {
			// iniciar transaccion
			em.getTransaction().begin();
			// insertar registro
			em.persist(obj);
			// confirmar transaccion
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
			fabrica.close();
		}
	}
	
	public void updateLaboratorio(Laboratorio obj) {
		// crear el objeto manager
		em = fabrica.createEntityManager();
		try {
			// iniciar transaccion
			em.getTransaction().begin();
			// actualizar registro
			em.merge(obj);
			// confirmar transaccion
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
			fabrica.close();
		}
	}
	
	public void deleteLaboratorio(int cod) {
		// crear el objeto manager
		em = fabrica.createEntityManager();
		try {
			// iniciar transaccion
			em.getTransaction().begin();
			// buscar el objeto a eliminar por su llave primaria
			Laboratorio obj = em.find(Laboratorio.class, cod);
			// eliminar registro
			em.remove(obj);
			// confirmar transaccion
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
			fabrica.close();
		}
	}
	
	public Laboratorio findLaboratorio(int cod) {
		em = fabrica.createEntityManager();
		Laboratorio obj = null;
		try {
			// iniciar transaccion
			em.getTransaction().begin();
			// buscar el objeto a eliminar por su llave primaria
			obj = em.find(Laboratorio.class, cod);
			// confirmar transaccion
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
			fabrica.close();
		}
		return obj;
	}
}
