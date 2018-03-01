package auxiliar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

import javax.swing.SingleSelectionModel;

import modelo.Datos;
import modelo.Equipo;
import modelo.Estudiante;
import modelo.Venta;
import modelo.Vehiculo;

public class Practicas {

	// SEGUNDA EVALUACION

	public ArrayList<Estudiante> introListas() {
		ArrayList<Estudiante> listaE;
		listaE = new ArrayList<Estudiante>();
		Estudiante est1 = new Estudiante(123);
		listaE.add(est1);
		listaE.add(est1);
		listaE.add(est1);
		listaE.add(est1);
		listaE.add(est1);
		int tam = listaE.size();
		Estudiante est2 = new Estudiante(321);
		listaE.add(0, est2);
		listaE.remove(listaE.size() - 1);
		// listaE.set(0, est1);
		for (Estudiante estudiante : listaE) {
			// System.out.println(estudiante.getCodGrupo());
		}
		for (int i = 0; i < listaE.size(); i++) {
			// System.out.println(listaE.get(i).getCodGrupo());
		}

		// System.out.println("fin introListas");
		return listaE;

	}

	// 11 enero 2018
	// Leer una matriz de int y devolverla como ArrayList

	public ArrayList<ArrayList<Integer>> convierteMatrizArrayLista(int[][] matriz) {

		ArrayList<ArrayList<Integer>> resultado = new ArrayList<ArrayList<Integer>>();
		for (int[] filaMatriz : matriz) {
			// crear alist
			ArrayList<Integer> filaLista = new ArrayList<Integer>();
			for (int numero : filaMatriz)
				filaLista.add(numero);
			resultado.add(filaLista);
		}
		return resultado;
	}

	// Mapas, clase HashMap

	public HashMap<String, Estudiante> introMapas() {
		// la clave representa el nif del Estudiante
		HashMap<String, Estudiante> resultado = new HashMap<String, Estudiante>();
		Estudiante est = new Estudiante(123, "435G", "Paco", 'M', null, 180, null, null);
		resultado.put(est.getNif(), est);
		Estudiante estudiante = resultado.get("435G");
		Estudiante est2 = new Estudiante(321, "435G", "Carlos", 'M', null, 180, null, null);

		resultado.put("435G", est2);
		resultado.put("123T", new Estudiante(123, "123T", "Pepe", 'M', null, 180, null, null));
		Set<String> claves = resultado.keySet();
		for (String clave : claves) {
			// System.out.println(resultado.get(clave).getNombre());
		}

		return resultado;
	}

	public static void grabarObjetosEnFichero(String fichero) { // forma de grabar objetos dentro de un fichero.
		Estudiante est = new Estudiante(123, "435G", "Paco1", 'M', null, 181, null, null);
		Estudiante est1 = new Estudiante(123, "222G", "Paco2", 'M', null, 180, null, null);
		Estudiante est2 = new Estudiante(123, "365G", "Paco3", 'M', null, 180, null, null);
		// creamos el array list
		ArrayList<Estudiante> lista = new ArrayList<Estudiante>();

		// añadir los tres estudiantes a la lita:

		lista.add(est);
		lista.add(est1);
		lista.add(est2);

		// abrir el fichero de objeto....

		try {
			FileOutputStream fIs = new FileOutputStream(fichero);
			ObjectOutputStream fObj = new ObjectOutputStream(fIs);

			// guardar los objetos de estudiantes en los ficheros...

			fObj.writeObject(lista);

			/*
			 * fObj.writeObject(est); fObj.writeObject(est1); fObj.writeObject(est2);
			 */
			fObj.close();
			fIs.close();

		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		} catch (IOException e) {
			System.out.println("Error IO");
		}

		System.out.println("Fichero Creado");

	}

	public void leeObjetosDesdeFichero(String fichero) {
		// metodo para poder leer un fichero que el formato .obj
		try {
			FileInputStream FIs = new FileInputStream(fichero);// crear otra variable para poder leer y recorrer el
																// fichero
			ObjectInputStream fObj = new ObjectInputStream(FIs);

			// recorre el fichero.
			Estudiante est = null;
			ArrayList<Estudiante> lista = null; // es para leer las listas con el formato .obj.

			while (FIs.available() > 0) {
				// leer el fichero
				// est = (Estudiante) fObj.readObject(); // devuelve un object.
				// forma de conseguir un casting para el read object.
				lista = (ArrayList<Estudiante>) fObj.readObject(); // forma de añadir un casting a un arraylisy.

				// System.out.println(est.getNombre());
			}
			System.out.println(lista.get(0).getNombre());
			FIs.close();
			fObj.close();
			// hay que cerrar los dos ficheros .

		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		} catch (IOException e) {
			System.out.println("Error IO");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFound");
		}
	}

	public void generaDadosAleatorios(int cuantos, String rutaFichero) { // forma de grabar informacion y creacion de un
																			// fichero.
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(rutaFichero));

			Random rnd = new Random();
			for (int i = 0; i < cuantos; i++) {
				int numero = 1 + rnd.nextInt(6);
				String registro = System.currentTimeMillis() + "&" + i + "&" + numero + "\n";

				bw.close();

			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("EOF");
		}

	}

	public void leerFicheroTexto() { // forma de leer un fichero para sacar informacion.
		try {
			// Abrir el fichero
			FileReader fr = new FileReader("ficheros/personas.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea;
			LocalDate fechaHoy;
			// System.out.println(LocalDate.now());
			// Leer el fichero linea a linea
			while (true) {

				while ((linea = br.readLine()) != null) {
					String[] campos = linea.split("&&");
					System.out.println(linea);
					System.out.println(calculaEdad(campos[2]));
					linea.length();
				}
				// Cerrar fichero
				fr.close();
				br.close();
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("EOF");
		}
	}

	public int calculaEdad(String fechaNacimiento) { // ddmmaaaa
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("ddMMyyyy");
		LocalDate fechaNac = LocalDate.parse(fechaNacimiento, fmt);
		LocalDate ahora = LocalDate.now();
		Period periodo = Period.between(fechaNac, ahora);
		System.out.printf("Tu edad es: %s años, %s meses y %s días", periodo.getYears(), periodo.getMonths(),
				periodo.getDays());
		return periodo.getYears();
	}

	// private static String[] diasSemana = { "lunes", "martes", "miercoles",
	// "jueves", "viernes", "sábado", "domingo" };

	public ArrayList<String> LeerFicherpoArrayList(String fichero) {
		ArrayList<String> resultado = new ArrayList<String>();
		try {
			// Abrir el fichero
			FileReader fr = new FileReader("ficheros/personas.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea;
			LocalDate fechaHoy;
			// System.out.println(LocalDate.now());
			// Leer el fichero linea a linea

			while ((linea = br.readLine()) != null) {
				resultado.add(linea);
			}
			// Cerrar fichero
			fr.close();
			br.close();

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("EOF");
		}
		return resultado;
	}

	public ArrayList<Vehiculo> leerFicheroconArrayList(String fichero) {
		ArrayList<Vehiculo> resultado = new ArrayList<Vehiculo>();
		try {
			// Abrir el fichero
			FileReader fr = new FileReader("ficheros/Vehiculos.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea;
			// Leer el fichero linea a linea

			while ((linea = br.readLine()) != null) {
				String[] campos = linea.split("#");
				// System.out.println("---" + Integer.parseInt(campos[0])); forma de saber si
				// funciona una linea;
				int id = Integer.parseInt(campos[0]);
				String matricula = campos[1];
				int marcaModelo = Integer.parseInt(campos[2]);
				int dia = Integer.parseInt(campos[3].split("/")[0]);
				int mes = Integer.parseInt(campos[3].split("/")[1]);
				int year = Integer.parseInt(campos[3].split("/")[2]);
				LocalDate fechaMatricula = LocalDate.of(year, mes, dia);
				float precio = Float.parseFloat(campos[4]);
				Vehiculo veh1 = new Vehiculo(id, matricula, marcaModelo, fechaMatricula, precio);
				resultado.add(veh1);
				System.out.println(veh1);
			}
			// Cerrar fichero
			fr.close();
			br.close();

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("EOF");
		}
		return resultado;

	}

	public static void grabarObjetosEnFicheroDeVehiculos(String fichero) { // forma de grabar objetos dentro de un
																			// fichero.
		Vehiculo vehi = new Vehiculo(001, "GC78454", 1575, null, 18 / 07 / 2000);
		Vehiculo vehi1 = new Vehiculo(80, "7851VKM", 9874, null, 12 / 12 / 1996);
		Vehiculo vehi2 = new Vehiculo(120, "3581JDN", 2581, null, 9 / 01 / 2016);
		Vehiculo vehi3 = new Vehiculo(003, "7788POL", 3212, null, 11 / 11 / 2011);

		// creamos el array list
		ArrayList<Vehiculo> vehiculo = new ArrayList<Vehiculo>();

		// añadir los cuatros vehiculos a la lita:
		vehiculo.add(vehi);
		vehiculo.add(vehi1);
		vehiculo.add(vehi2);
		vehiculo.add(vehi3);

		// abrir el fichero de objeto....

		try {
			FileOutputStream fIs = new FileOutputStream(fichero);
			ObjectOutputStream fObj = new ObjectOutputStream(fIs);

			// guardar los objetos de estudiantes en los ficheros...

			fObj.writeObject(vehiculo);

			/*
			 * fObj.writeObject(est); fObj.writeObject(est1); fObj.writeObject(est2);
			 */
			fObj.close();
			fIs.close();

		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		} catch (IOException e) {
			System.out.println("Error IO");
		}

		System.out.println("Fichero Creado");

	}

	public HashMap<String, String> LeerFicherpoHashMap(String fichero) {
		HashMap<String, String> resultado = new HashMap<String, String>();
		try {
			// Abrir el fichero
			FileReader fr = new FileReader("ficheros/personas.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea;
			LocalDate fechaHoy;
			// System.out.println(LocalDate.now());
			// Leer el fichero linea a linea

			while ((linea = br.readLine()) != null) {
				resultado.put(linea.split("&&")[0], linea);
			}
			// Cerrar fichero
			fr.close();
			br.close();

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("EOF");
		}
		return resultado;
	}

	public HashMap<String, ArrayList<Float>> resumenventasVendedor(String ficheroVentas) {
		HashMap<String, ArrayList<Float>> resultado = new HashMap<String, ArrayList<Float>>();

		try {
			FileReader fr = new FileReader("ficheros/ventaDep.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea;

			while ((linea = br.readLine()) != null) {
				String fecha = linea.split("%")[0];
				String idVendedor = linea.split("%")[1];
				float importe = Float.parseFloat(linea.split("%")[2]);
				if (resultado.get(idVendedor) == null) {
					ArrayList<Float> listaVenta = new ArrayList<Float>();
					listaVenta.add(importe);
					resultado.put(idVendedor, listaVenta);
				} else {
					ArrayList<Float> listaVenta = resultado.get(idVendedor);
					listaVenta.add(importe);
					resultado.put(idVendedor, listaVenta);
				}

			}
			fr.close();
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("EOF");
		}

		return resultado;

	}

	public HashMap<String, Float> resumenVentasPorVendedor(HashMap<String, ArrayList<Float>> ventas) {
		HashMap<String, Float> resultado = new HashMap<String, Float>();
		// recorrer mapa1 de entrada creando el de salida
		Set<String> claves = ventas.keySet();
		for (String clave : claves) {
			ArrayList<Float> listaVentas = ventas.get(clave);
			float acumuladoVendedor = 0;
			for (Float importe : listaVentas)
				acumuladoVendedor += importe;
			resultado.put(clave, acumuladoVendedor);
		}
		return resultado;
	}

	///////////////////////////////// 20/02/2018//////////////////////////////////////////

	public void inicializaVisitantesIsla(HashMap<Integer, ArrayList<Float>> resultado) {// forma de crear un metodo con los meses y islas a 0

		ArrayList<Float> visitantesMeses;
		for (int isla = 0; isla < 7; isla++) {// recorre cada isla
			visitantesMeses = new ArrayList<Float>();
			for (int mes = 0; mes < 12; mes++) {// poner a 0 cada uno de los meses
				visitantesMeses.add(0f);
			}
			resultado.put(isla, visitantesMeses);
		}

	}

	public HashMap<Integer, ArrayList<Float>> visitantesIslaMes(String rutaFicherovisitantesIslas) {
		HashMap<Integer, ArrayList<Float>> resultado = new HashMap<Integer, ArrayList<Float>>();
		try {
			// Abrir el fichero
			FileReader fr = new FileReader("ficheros/visitantesIslaMes.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea;
			LocalDate fechaHoy;
			// Leer el fichero linea a linea
			// vamos a inizializar las islas a 0 en un metodo aparte, y mandamos la llamada
			// al metodo, que sera el valor del HashMap
			inicializaVisitantesIsla(resultado);
			while (true) {

				while ((linea = br.readLine()) != null) {
					String[] campos = linea.split("@");
					int isla = Integer.parseInt(campos[0]);
					int mes = Integer.parseInt(campos[1]);
					float numeroVisitantes = Float.parseFloat(campos[2]);
					resultado.get(isla - 1).set(mes - 1, numeroVisitantes);
				}
				// Cerrar fichero
				fr.close();
				br.close();
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("EOF");
		}
		return resultado;
	}

	/////////////////////////////////////// 22/02/2018///////////////TIENE QUE VER CON EL METODO DE ARRIBA/////////////////////////
	public void listadoIslasMeses( String rutaFicherovisitantesIslas) {
		ArrayList<Float> visitantesisla;
		HashMap<Integer, ArrayList<Float>>  hm = visitantesIslaMes(rutaFicherovisitantesIslas);
		 
		 String[] islas = { "GRAN CANARIA", "LANZAROTE", "FUERTEVENTURA", "TENERIFE", "LA PALMA", "LA GOMERA", "EL HIERRO" };
		 String[] meses = { "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTRE", "OCTUBRE", "NOVRE", "DICIEMBRE" };

		 //recorre el hm
		 float acumuladoMes [] = new float[12];
		 Set<Integer> claves = hm.keySet();
		 System.out.print("\t\t");
		 //clave en singular es para acceder al arraylist de cada isla//
		for (int i = 0; i < meses.length; i++) {
			System.out.print(meses[i]+"\t");
		}
		System.out.println();
		  for (Integer clave : claves) {
			//islas[clave];
			  visitantesisla = hm.get(clave);
			System.out.print(islas[clave]+ "\t"); //imprimir el nombre de la isla
			float acumuladoIsla=0f;
			  //valor representa el numero de turistas que ha entrado en esa isla///
			  for (int i = 0; i < visitantesisla.size(); i++) {
				  acumuladoIsla += visitantesisla.get(i);
				  acumuladoMes[0] += visitantesisla.get(i);
				System.out.printf("%.0f\t", visitantesisla.get(i)*1000);
			}
			  System.out.print("\t total visitantes " + islas[clave] + " = " + acumuladoIsla);
			  System.out.println();
		}
		  for (Float valor : acumuladoMes) {
			  System.out.print("\t\t"+ valor);
			
		}
	
	}

	//////////////////////////////////////01/03/2018//////Actividad De Comunidades Autonomas///////////////////////////////
	
	public String[] paso1RecorreComunidades() {
		String [] comunidadesAutonomas = new String[19];
		String comunidades = null;
		try {
			// Abrir el fichero
			FileReader fr = new FileReader("ficheros/comunidades.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea;
			LocalDate fechaHoy;
			// Leer el fichero linea a linea
			while (true) {

				while ((linea = br.readLine()) != null) {
					String[] campos = linea.split("%");
					comunidades= campos[1];
					System.out.println(comunidades);
				}
				// Cerrar fichero
				fr.close();
				br.close(); 
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("EOF");
		}
		
		return comunidadesAutonomas;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//////////////////////////////////////////////////////////////////////	
	public boolean esPrimo(int numero) {

		for (int i = 2; i < numero; i++) {
			if (numero % i == 0)
				return false;
		}

		return true;
	}

	public int[] numerosPrimos(int cuantos) {
		int[] primos = new int[cuantos];
		int i = 0;
		int j = 1;
		while (i < cuantos) {
			if (esPrimo(j))
				primos[i++] = j;
			j++;
		}
		return primos;
	}

	public int[] numerosFibonacci(int cuantos) {
		int[] numeros = new int[cuantos];
		int x = 0;
		int y = 1;
		int z;
		numeros[0] = x;
		numeros[1] = y;
		for (int i = 2; i < cuantos; i++) {
			z = x + y;
			numeros[i] = z;
			x = y;
			y = z;
		}
		return numeros;
	}

	// LIGA: Obtener clasificación a partir de resultados
	public int[] obtenerClasificacion(String[][] goles) {
		int[] puntos = new int[5];
		int golesLocal;
		int golesVisitante;
		String[] resultado = null;
		// recorrer la matriz de goles
		for (int i = 0; i < goles.length; i++)
			for (int j = 0; j < goles[i].length; j++)
				if (goles[i][j].indexOf('-') != -1) {
					resultado = goles[i][j].split("-");
					golesLocal = Integer.parseInt(resultado[0]);
					golesVisitante = Integer.parseInt(resultado[1]);
					if (golesLocal > golesVisitante)
						// suma 3 al local
						puntos[i] += 3;
					else if (golesLocal < golesVisitante)
						// suma 3 al visitante
						puntos[j] += 3;
					else { // empate
						puntos[i] += 1;
						puntos[j] += 1;
					}
				}
		return puntos;
	}

	public int[] obtenerClasificacion2(String[][] goles) {
		// la diferencia con el anterior es que recorre la
		// matriz por columnas
		int[] puntos = new int[5];
		int golesLocal;
		int golesVisitante;
		String[] resultado = null;
		// recorrer la matriz de goles
		for (int j = 0; j < goles[0].length; j++)
			for (int i = 0; i < goles.length; i++)
				if (goles[i][j].indexOf('-') != -1) {
					resultado = goles[i][j].split("-");
					golesLocal = Integer.parseInt(resultado[0]);
					golesVisitante = Integer.parseInt(resultado[1]);
					if (golesLocal > golesVisitante)
						// suma 3 al local
						puntos[i] += 3;
					else if (golesLocal < golesVisitante)
						// suma 3 al visitante
						puntos[j] += 3;
					else { // empate
						puntos[i] += 1;
						puntos[j] += 1;
					}
				}
		return puntos;
	}

	public Equipo[] obtenerClasificacion3(int[][] puntosJornadas) {
		Equipo[] clasificacion = new Equipo[5];
		String[] equipos = new Datos().getEquipos();
		for (int j = 0; j < puntosJornadas[0].length; j++) {
			Equipo e = new Equipo();
			e.setNombre(equipos[j]);
			e.setPuntos(0);
			for (int i = 0; i < clasificacion.length; i++)
				e.setPuntos(e.getPuntos() + puntosJornadas[i][j]);
			clasificacion[j] = e;
		}

		return clasificacion;
	}

	public boolean validarNif(String nif) {
		char[] letrasValidas = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q',
				'V', 'H', 'L', 'C', 'K', 'E' };

		if (nif.length() != 9)
			return false;
		String numeros = nif.substring(0, 8);
		// System.out.println(numeros);
		int numerosOK;
		try {
			numerosOK = Integer.parseInt(numeros);
		} catch (NumberFormatException e) {
			return false;
		}
		int resto = numerosOK % 23;
		if (letrasValidas[resto] != nif.charAt(8))
			return false;
		return true;
	}

	// ORDENACION
	public void ordenaEnteros(int[] numeros) {
		for (int i = 0; i < numeros.length - 1; i++)
			for (int j = i + 1; j < numeros.length; j++)
				if (numeros[i] > numeros[j]) {
					int aux = numeros[i];
					numeros[i] = numeros[j];
					numeros[j] = aux;
				}
	}

	public void ordenaEnteros(ArrayList<Integer> numeros) {
		ArrayList<Integer> ordena = new ArrayList<Integer>();
		ordena.addAll(numeros);
		Collections.sort(ordena); // ordena la lista del arraylist

	}

	public void ordenaClasificacion(int[] numeros, String[] equipos) {
		for (int i = 0; i < numeros.length - 1; i++)
			for (int j = i + 1; j < numeros.length; j++)
				if (numeros[i] < numeros[j]) {
					int aux = numeros[i];
					numeros[i] = numeros[j];
					numeros[j] = aux;
					String aux2 = equipos[i];
					equipos[i] = equipos[j];
					equipos[j] = aux2;
				}
	}
	// mezcla dos arrays ordenados

	public int[] mezclaArrays(int[] l1, int[] l2) {
		int i = 0, j = 0, k = 0;
		int[] resultado = new int[l1.length + l2.length];

		while (l1[i] != Integer.MAX_VALUE || l2[j] != Integer.MAX_VALUE) {
			if (l1[i] < l2[j])
				resultado[k] = l1[i++];
			else
				resultado[k] = l2[j++];
			k++;

			if (i == l1.length)
				l1[--i] = Integer.MAX_VALUE;

			if (j == l2.length)
				l2[--j] = Integer.MAX_VALUE;
		}
		return resultado;
	}

	public void ordenaCadenas(String[] cadenas) {
		for (int i = 0; i < cadenas.length - 1; i++)
			for (int j = i + 1; j < cadenas.length; j++)
				if (cadenas[i].compareTo(cadenas[j]) > 0) {
					String aux = cadenas[i];
					cadenas[i] = cadenas[j];
					cadenas[j] = aux;
				}

	}

	public ArrayList<String> ordenaCadenas(ArrayList<String> cadenas) {
		ArrayList<String> resultado = new ArrayList<String>();
		for (int i = 0; i < cadenas.size(); i++) {
			cadenas.addAll(resultado);

		}
		return resultado;

		/*
		 * for (int i = 0; i < cadenas.length - 1; i++) for (int j = i + 1; j <
		 * cadenas.length; j++) if (cadenas[i].compareTo(cadenas[j]) > 0) { String aux =
		 * cadenas[i]; cadenas[i] = cadenas[j]; cadenas[j] = aux; }
		 */

	}

	public void ordenaEstudiantes(Estudiante[] estudiantes) {
		// ejemplo de uso de la interfaz Comparable
		// debe implementarse el método compareTo

		for (int i = 0; i < estudiantes.length - 1; i++)
			for (int j = i + 1; j < estudiantes.length; j++)
				if (estudiantes[i].compareTo(estudiantes[j]) > 0) {
					Estudiante aux = estudiantes[i];
					estudiantes[i] = estudiantes[j];
					estudiantes[j] = aux;
				}
	}

	public float calculaSaldo(float saldoInicial, float[] movimientos) {
		float saldoFinal = saldoInicial;
		for (int i = 0; i < movimientos.length; i++)
			saldoFinal += movimientos[i];
		return saldoFinal;
	}

	public float calculaSaldo(float saldoInicial, ArrayList<Float> movimientos) {
		float saldoFinal = saldoInicial;
		for (int i = 0; i < movimientos.size(); i++) {
			saldoFinal += movimientos.get(i);
		}

		return saldoFinal;

		/*
		 * float saldoFinal = saldoInicial; for (int i = 0; i < movimientos.length; i++)
		 * saldoFinal += movimientos[i]; return saldoFinal;
		 */
	}

	public float calculaSaldo(float saldoInicial, String rutaFicheroMovs) {
		float saldo = saldoInicial;
		try {
			// Abrir el fichero
			FileReader fr = new FileReader("ficheros/personas.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea;
			// Leer el fichero linea a linea

			while ((linea = br.readLine()) != null) {

			}
			// Cerrar fichero
			fr.close();
			br.close();

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("EOF");
		}

		return saldo;
	}

	public int[] convierteCadenasANumeros(String[] cadenas) {
		int[] resultado = new int[cadenas.length];
		for (int i = 0; i < resultado.length; i++) {

			try {

				resultado[i] = Integer.parseInt(cadenas[i]);
			} catch (NumberFormatException e) {

				resultado[i] = -1;
			}
		}
		return resultado;
	}

	public ArrayList<Integer> convierteCadenasANumeros(ArrayList<String> cadenas) {
		// int[] resultado = new int[cadenas.length];
		ArrayList<Integer> resultado = new ArrayList<Integer>();
		// for (int i = 0; i < resultado.length; i++) {
		for (String cadena : cadenas) {
			try {

				// resultado[i] = Integer.parseInt(cadenas[i]);
				resultado.add(Integer.parseInt(cadena));
			} catch (NumberFormatException e) {

				// resultado[i] = -1;
				resultado.add(-1);
			}
		}
		return resultado;
	}

	public void muestraNumeros() {

		int x = 0;
		while (x <= 1000) {
			System.out.println("x: " + x);
			x++;
		}
	}

	public void muestraNumeros(int min, int max) {

		if (min <= max) {
			int x = min;
			while (x <= max) {
				System.out.println("x: " + x);
				x++;
			}
		} else
			System.out.println("Error, min debe ser menor que maximo");
	}

	public void muestraNumeros2(int min, int max) {

		if (min <= max) {
			int x = min;
			do {
				System.out.println("x: " + x);
				x++;
			} while (x <= max);
		} else
			System.out.println("Error, min debe ser menor que maximo");
	}

	public void muestraNumeros3(int min, int max) {
		int x = min;
		if (min <= max) {
			// for (int x = min; x < max; x++) {
			// for (;;) {
			while (true) {
				System.out.println("x: " + x);
				x++;
			}
		} else
			System.out.println("Error, min debe ser menor que maximo");
	}

	public void generaAleatorios(int cuantos, int inferior, int superior) // max 30, min 10
	{

		for (int i = 0; i < cuantos; i++)
			System.out.println(inferior + (int) (Math.random() * (superior - inferior + 1)));

	}

	public void generaAleatorios2(int cuantos, int inferior, int superior) // max 30, min 10
	{

		Random rnd = new Random();
		for (int i = 0; i < cuantos; i++)
			System.out.println(inferior + rnd.nextInt(superior - inferior + 1));
	}

	public int[] generaAleatorios3(int cuantos, int inferior, int superior) // max 30, min 10
	{
		int[] resultado = new int[cuantos];
		Random rnd = new Random();
		for (int i = 0; i < cuantos; i++)
			// System.out.println(inferior + rnd.nextInt(superior - inferior + 1));
			resultado[i] = inferior + rnd.nextInt(superior - inferior + 1);
		return resultado;
	}

	public int[] frecuenciaAparicion(int cuantos, int inferior, int superior) {
		int[] resultado = new int[superior - inferior + 1];
		int[] lanzamientos = this.generaAleatorios3(cuantos, inferior, superior);
		for (int i = 0; i < lanzamientos.length; i++) {
			resultado[lanzamientos[i] - 1]++;
		}
		return resultado;

	}

	public void estadisticaCadena(String cadena) {
		int contadorVocales = 0;
		int contadorMayusculas = 0;
		int contadorEspeciales = 0;
		for (int i = 0; i < cadena.length(); i++) {
			if (cadena.charAt(i) == 'a' || cadena.charAt(i) == 'e' || cadena.charAt(i) == 'i' || cadena.charAt(i) == 'o'
					|| cadena.charAt(i) == 'u' || cadena.charAt(i) == 'A' || cadena.charAt(i) == 'E'
					|| cadena.charAt(i) == 'I' || cadena.charAt(i) == 'O' || cadena.charAt(i) == 'U')
				contadorVocales++;
			if (cadena.charAt(i) >= 'A' && cadena.charAt(i) <= 'Z')
				contadorMayusculas++;
			int caracterAscii = cadena.charAt(i);
			if ((caracterAscii >= 0 && caracterAscii <= 47) || (caracterAscii >= 58 && caracterAscii <= 64) ||

					(caracterAscii >= 91) && (caracterAscii <= 96))

				contadorEspeciales++;
		}
		// System.out.println("Hay " + contadorVocales + " vocales en " + cadena);
		System.out.println("Hay " + contadorEspeciales + " caracteres especiales en " + cadena);

	}

	public void listaDiasSemana() {
		Datos datos = new Datos();
		// String[] diasSemana = { "lunes", "martes", "miercoles", "jueves", "viernes",
		// "sábado", "domingo" };
		// for (int i = 0; i < datos.getDiasSemana().length; i++)
		for (String dia : datos.getDiasSemana())
			// System.out.println(datos.getDiasSemana()[i]);
			System.out.println(dia);
	}

	public void listaEstudiantes(Estudiante[] lista) {
		for (Estudiante estudiante : lista) {
			// if (estudiante != null)
			try {
				System.out.println(estudiante.getNombre());
			} catch (NullPointerException e) {

			}
		}
	}

	public void listaEstudiantes(ArrayList<Estudiante> lista) {
		for (Estudiante estudiante : lista) {
			// if (estudiante != null)
			try {
				System.out.println(estudiante.getNombre());
			} catch (NullPointerException e) {

			}
		}
	}

	public int visitantesIslaYear(int isla, int[][] v) {
		int acu = 0;
		for (int j = 0; j < v[0].length; j++)
			acu += v[isla][j];
		return acu;
	}

	public int visitantesMesYear(int mes, int[][] v) {
		int acu = 0;
		for (int i = 0; i < v.length; i++)
			acu += v[i][mes];
		return acu;
	}

	public void recorrerMatrizIrregularPorColumnas(int[][] matriz) {
		int JMAX = 0;
		// obtenemos el numero maximo de columnas
		for (int i = 0; i < matriz.length; i++) {
			if (matriz[i].length > JMAX)
				JMAX = matriz[i].length;
		}

		for (int j = 0; j < JMAX; j++) {
			for (int i = 0; i < matriz.length; i++) {
				try {
					System.out.println("[" + i + "][" + j + "]: " + matriz[i][j]);
				} catch (ArrayIndexOutOfBoundsException e) {
					continue;
				}

			}
		}
	}

	public ArrayList<Integer> recorrerMatrizIrregularPorColumnas1(ArrayList<ArrayList<Integer>> matriz) {
		ArrayList<Integer> resultado = new ArrayList<Integer>();
		int JMAX = 0;
		// obtenemos el numero maximo de columnas
		for (int i = 0; i < matriz.size(); i++) {
			if (matriz.get(i).size() > JMAX)
				JMAX = matriz.size();
		}

		for (int j = 0; j < JMAX; j++) {
			for (int i = 0; i < matriz.size(); i++) {
				try {
					System.out.println("[" + i + "][" + j + "]: " + matriz.get(i).get(j));
				} catch (ArrayIndexOutOfBoundsException e) {
					continue;
				}

			}
		}

		return resultado;
	}

	public void recorrerMatrizIrregularPorColumnas2(Integer[][] matriz) {
		int JMAX = 0;
		// obtenemos el numero maximo de columnas
		for (int i = 0; i < matriz.length; i++) {
			if (matriz[i].length > JMAX)
				JMAX = matriz[i].length;
		}

		for (int j = 0; j < JMAX; j++) {
			for (int i = 0; i < matriz.length; i++) {
				try {
					System.out.println("[" + i + "][" + j + "]: " + matriz[i][j].byteValue());
				} catch (ArrayIndexOutOfBoundsException e) {
					continue;
				} catch (NullPointerException e) {
					continue;
				}

			}
		}
	}

}
