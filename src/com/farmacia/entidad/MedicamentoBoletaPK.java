package com.farmacia.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MedicamentoBoletaPK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "num_bol")
	private int numBoleta;
	
	@Column(name = "cod_med")
	private int codMedicamento;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codMedicamento;
		result = prime * result + numBoleta;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		MedicamentoBoletaPK other = (MedicamentoBoletaPK)obj;
		if(codMedicamento != other.codMedicamento)
			return false;
		if(numBoleta != other.numBoleta)
			return false;
		return true;
	}

	public int getNumBoleta() {
		return numBoleta;
	}

	public void setNumBoleta(int numBoleta) {
		this.numBoleta = numBoleta;
	}

	public int getCodMedicamento() {
		return codMedicamento;
	}

	public void setCodMedicamento(int codMedicamento) {
		this.codMedicamento = codMedicamento;
	}
	
}
