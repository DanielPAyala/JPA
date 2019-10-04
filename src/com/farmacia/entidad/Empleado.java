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
@Table(name = "tb_empleado")
public class Empleado implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_emp")
	private int codEmpleado;
	
	@Column(name = "nom_emp")
	private String nomEmpleado;
	
	@Column(name = "ape_emp")
	private String apeEmpleado;
	
	@Column(name = "sex_emp")
	private String sexoEmpleado;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fec_reg_emp")
	private Date fechaRegistro;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fec_nac_emp")
	private Date fecNacimiento;
	
	@Column(name = "dir_emp")
	private String dirEmpleado;
	
	@OneToMany(mappedBy = "empleado")
	private List<Boleta> boletas;
	
	@ManyToOne
	@JoinColumn(name = "cod_dis_emp")
	private Distrito distrito;

	// getters and setters
	
	public int getCodEmpleado() {
		return codEmpleado;
	}

	public void setCodEmpleado(int codEmpleado) {
		this.codEmpleado = codEmpleado;
	}

	public String getNomEmpleado() {
		return nomEmpleado;
	}

	public void setNomEmpleado(String nomEmpleado) {
		this.nomEmpleado = nomEmpleado;
	}

	public String getApeEmpleado() {
		return apeEmpleado;
	}

	public void setApeEmpleado(String apeEmpleado) {
		this.apeEmpleado = apeEmpleado;
	}

	public String getSexoEmpleado() {
		return sexoEmpleado;
	}

	public void setSexoEmpleado(String sexoEmpleado) {
		this.sexoEmpleado = sexoEmpleado;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFecNacimiento() {
		return fecNacimiento;
	}

	public void setFecNacimiento(Date fecNacimiento) {
		this.fecNacimiento = fecNacimiento;
	}

	public String getDirEmpleado() {
		return dirEmpleado;
	}

	public void setDirEmpleado(String dirEmpleado) {
		this.dirEmpleado = dirEmpleado;
	}

	public List<Boleta> getBoletas() {
		return boletas;
	}

	public void setBoletas(List<Boleta> boletas) {
		this.boletas = boletas;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}
}
