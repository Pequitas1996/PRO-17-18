package examen;

import java.util.Random;
import auxiliar.Practicas;
import modelo.Vehiculo;


public class Metodos {

	// ejercicio 1



	public boolean[] metodo1(String[] nifs) {
		boolean[] resultado = new boolean[nifs.length];
		Practicas practicas = new Practicas()
		;
		for (int i = 0; i < resultado.length; i++) {
			resultado[i] = practicas.validarNif(nifs[i]);
			
		}
		
		return resultado;
	
	}

	

	// ejercicio 2

	public Vehiculo[] metodo(String[] vehiculo) {
		Vehiculo[]resultado = new Vehiculo[vehiculo.length];
		for (int i = 0; i < resultado.length; i++) {
			
			try {
				String[]vehiculoLista = vehiculo[i].split("@");
				Vehiculo vehi= new Vehiculo();
				vehi.setId(Integer.parseInt(vehiculoLista[0]));
				vehi.setMarca(vehiculoLista[1]);
				vehi.setModelo(vehiculoLista[2]);
				vehi.setPrecio(Float.parseFloat(vehiculoLista[3]));
				resultado[i]=vehi;
			}catch(NumberFormatException e) {
				resultado[i] = null;
			}
			
		}
		return resultado;
		
	}
	// ejercicio 3
	
	public int[][] metodo3(int partidas, int participantes){
		
		int[][] resultado = new int [partidas][participantes];
	
		Random partido = new Random();
		
		for (int i = 0; i < partidas; i++) {
			for (int j = 0; j < participantes; j++) {
				resultado[i][j] = 1 + partido.nextInt(6);	
			}
		}
		
		return resultado;
		
	}

}	
		

	

