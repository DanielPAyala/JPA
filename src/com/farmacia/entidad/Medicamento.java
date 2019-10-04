package com.farmacia.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_medicamento")
public class Medicamento implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_med")
	private int codMedicamento;
	
	@Column(name = "nom_med")
	private String nomMedicamento;
	
	@Column(name = "stock_med")
	private int stockMedicamento;
	
	@Column(name = "pre_med")
	private double preMedicamento;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fec_ven_med")
	private Date fechaMedicamento; // java.util.Date
	
	// relacion muchos a uno
	@ManyToOne
	@JoinColumn(name = "cod_lab")
	private Laboratorio laboratorio;
	
	// relation one to many 
	@OneToMany(mappedBy = "medicamento")
	private List<MedicamentoBoleta> medicamentoBoleta;
	
	// constructor
	public Medicamento() {
		laboratorio = new Laboratorio();
	}
	
	// getters and setters

	public int getCodMedicamento() {
		return codMedicamento;
	}

	public void setCodMedicamento(int codMedicamento) {
		this.codMedicamento = codMedicamento;
	}

	public String getNomMedicamento() {
		return nomMedicamento;
	}

	public void setNomMedicamento(String nomMedicamento) {
		this.nomMedicamento = nomMedicamento;
	}

	public int getStockMedicamento() {
		return stockMedicamento;
	}

	public void setStockMedicamento(int stockMedicamento) {
		this.stockMedicamento = stockMedicamento;
	}

	public double getPreMedicamento() {
		return preMedicamento;
	}

	public void setPreMedicamento(double preMedicamento) {
		this.preMedicamento = preMedicamento;
	}

	public Date getFechaMedicamento() {
		return fechaMedicamento;
	}

	public void setFechaMedicamento(Date fechaMedicamento) {
		this.fechaMedicamento = fechaMedicamento;
	}

	public Laboratorio getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}
}
