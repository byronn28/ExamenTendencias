package com.examenTendencias.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="empleado")
public class Empleado implements Serializable{


	private static final long serialVersionUID = -8921519368401374574L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_empleado")
	private Long id_empleado;
	
	@Column(name="nombre",nullable =false,length = 45)
	private String nombre;
	
	@Column(name="apellido",nullable =false,length = 45)
	private String apellido;
	
	@Column(name="telefono",nullable =false,length = 15)
	private String telefono;
	
	@Column(name="direccion",nullable =false,length = 45)
	private String direccion;
	
	@Column(name="fecha_nacimiento",nullable =false)
	private Date fecha_nacimiento;
	
	
	@Column(name="observacion",nullable =false,length = 45)
	private String observacion;
	
	@Column(name="dias_trabajo",nullable =false)
	private Integer dias_trabajo;
	
	@Column(name="sueldo",nullable =false)
	private Double sueldo;

	public Long getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(Long id_empleado) {
		this.id_empleado = id_empleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Integer getDias_trabajo() {
		return dias_trabajo;
	}

	public void setDias_trabajo(Integer dias_trabajo) {
		this.dias_trabajo = dias_trabajo;
	}

	public Double getSueldo() {
		return sueldo;
	}

	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
