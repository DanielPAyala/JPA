package com.farmacia.model;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.farmacia.entidad.Boleta;
import com.farmacia.entidad.Cliente;
import com.farmacia.entidad.Empleado;
import com.farmacia.entidad.MedicamentoBoleta;
import com.farmacia.entidad.MedicamentoBoletaPK;

public class modelBoleta {
	EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("PE");
	EntityManager manager = null;
	
	public void addBoleta(Boleta bol) {
		manager = fabrica.createEntityManager();
		try {
			Boleta b = new Boleta();
			Cliente c = manager.find(Cliente.class, bol.getCliente().getCodCliente());
			b.setCliente(c);
			Empleado e = manager.find(Empleado.class, bol.getEmpleado().getCodEmpleado());
			b.setEmpleado(e);
			b.setFecEmision(new Date());
			b.setMontoBoleta(bol.getMontoBoleta());
			manager.getTransaction().begin();
			manager.persist(b);
			manager.flush();
			for (MedicamentoBoleta m: bol.getMedicamentoBoleta()) {
				MedicamentoBoletaPK pk = new MedicamentoBoletaPK();
				pk.setNumBoleta(b.getNumBoleta());
				pk.setCodMedicamento(m.getId().getCodMedicamento());
				m.setId(pk);
				manager.persist(m);
				manager.flush();
			}
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			manager.close();
			fabrica.close();
		}
	}
}
