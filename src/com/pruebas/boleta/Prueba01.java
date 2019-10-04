package com.pruebas.boleta;

import java.util.ArrayList;
import java.util.List;

import com.farmacia.entidad.Boleta;
import com.farmacia.entidad.Cliente;
import com.farmacia.entidad.Empleado;
import com.farmacia.entidad.MedicamentoBoleta;
import com.farmacia.entidad.MedicamentoBoletaPK;
import com.farmacia.model.modelBoleta;

public class Prueba01 {

	public static void main(String[] args) {
		Boleta b = new Boleta();
		Cliente c = new Cliente();
		c.setCodCliente(2);
		b.setCliente(c);
		Empleado e = new Empleado();
		e.setCodEmpleado(1);
		b.setEmpleado(e);
		b.setMontoBoleta(150.30);
		List<MedicamentoBoleta> lista = new ArrayList<MedicamentoBoleta>();
			MedicamentoBoleta mb1 = new MedicamentoBoleta();
			MedicamentoBoletaPK pk1 = new MedicamentoBoletaPK();
			pk1.setCodMedicamento(1);
			mb1.setId(pk1);
			mb1.setCantidad(5);
			mb1.setPrecio(20);
		lista.add(mb1);
			MedicamentoBoleta mb2 = new MedicamentoBoleta();
			MedicamentoBoletaPK pk2 = new MedicamentoBoletaPK();
			pk2.setCodMedicamento(2);
			mb2.setId(pk2);
			mb2.setCantidad(7);
			mb2.setPrecio(30);
		lista.add(mb2);
		b.setMedicamentoBoleta(lista);
		new modelBoleta().addBoleta(b);
	}

}
