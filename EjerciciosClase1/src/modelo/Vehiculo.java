package modelo;

import java.time.LocalDate;

public class Vehiculo {
	
	private int id;
	private String matricula;
	private int marcaModelo;
	private LocalDate fechaMatricula;
	private float precioVehiculo;
	
	
	public Vehiculo(int id, String matricula, int marcaModelo, LocalDate fechaMatricula, float precioVehiculo) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.marcaModelo = marcaModelo;
		this.fechaMatricula = fechaMatricula;
		this.precioVehiculo = precioVehiculo;
	}



	public Vehiculo() {
		// TODO Auto-generated constructor stub
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}



	public int getMarcaModelo() {
		return marcaModelo;
	}

	public void setMarcaModelo(int marcaModelo) {
		this.marcaModelo = marcaModelo;
	}

	
	
	public LocalDate getFechaMatricula() {
		return fechaMatricula;
	}

	public void setFechaMatricula(LocalDate fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}



	public float getPrecioVehiculo() {
		return precioVehiculo;
	}

	public void setPrecioVehiculo(float precioVehiculo) {
		this.precioVehiculo = precioVehiculo;
	}


@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", matricula=" + matricula + ", marcaModelo=" + marcaModelo + ", fechaMatricula="
				+ fechaMatricula + ", precioVehiculo=" + precioVehiculo + "]";
	}
	

}
