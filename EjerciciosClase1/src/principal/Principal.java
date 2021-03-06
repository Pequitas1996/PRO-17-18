package principal;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

import auxiliar.Practicas;
import modelo.Datos;
import modelo.Equipo;
import modelo.Estudiante;
import modelo.Persona;
import modelo.Profesor;
import modelo.Vehiculo;
import modelo.dao.AccesoDatos;

public class Principal {
	// metodo por el que debe empezar la ejecución ..
	public static void main(String[] args) {
		/*
		 * Persona persona; persona = new Persona();
		 * 
		 * persona.setNombre("Manolo"); System.out.println("nif : " + persona.getNif());
		 * System.out.println("nombre : " + persona.getNombre());
		 * System.out.println("altura : " + persona.getAltura());
		 * System.out.println("persona1 creada");
		 */
		/*
		 * Persona padre = new Persona(); padre.setNombre("JorgePadre");
		 * padre.setSexo('M'); Persona madre = new Persona();
		 * madre.setNombre("MariaMadre"); madre.setNif("44567981H"); madre.setSexo('F');
		 */

		/*
		 * Persona persona2 = new Persona("43897124R", "PEPE", 'F', LocalDate.of(1999,
		 * 9, 21), 170, padre, madre); System.out.println("persona2 creada");
		 * System.out.println("Nombre madre : " + persona2.getMadre().getNombre());
		 */
		// crear un Estudiante

		Estudiante estAnonimo = new Estudiante(123);

		Estudiante estudiante = new Estudiante(111, "44556677G", "Rafael", 'M', LocalDate.now(), 187, estAnonimo, null);
		Estudiante estudiante2 = new Estudiante(111, "44556674T", "Javier", 'M', LocalDate.now(), 187, estAnonimo,
				null);
		Estudiante estudiante3 = new Estudiante(111, "44556672X", "Marcos", 'M', LocalDate.now(), 187, estAnonimo,
				null);

		Estudiante[] listaEstudiantes = { estAnonimo, estudiante, estudiante2, estudiante3 };

		Practicas practicas = new Practicas();
		practicas.ordenaEstudiantes(listaEstudiantes);

		// new Practicas().muestraNumerosDe1A1000();
		// practicas.muestraNumerosDe1A1000();
		// practicas.muestraNumeros3(20, 25);
		// practicas.generaAleatorios2(3,10,11);
		// practicas.estadisticaCadena("Las&%=\" PalmAs\\ de Gran CanarIa");
		// int [] numeros=practicas.generaAleatorios3(100, 1, 6);
		// int[] frecuencia = practicas.frecuenciaAparicion(100, 1, 8);
		// practicas.listaDiasSemana();
		// Estudiante[] lista = new Datos().getEstudiantes();
		// practicas.listaEstudiantes(new Datos().getEstudiantes());
		int[][] visitantesYear = { { 2, 4, 5, 1, 3, 2, 1, 1, 1, 3, 5, 1 },
				{ 23, 1, 56, 12, 32, 23, 17, 12, 11, 34, 45, 13 }, { 23, 3, 56, 12, 32, 23, 17, 12, 11, 34, 45, 12 },
				{ 23, 1, 56, 12, 32, 23, 17, 12, 11, 34, 45, 13 }, { 23, 4, 56, 12, 32, 23, 17, 12, 11, 34, 45, 10 },
				{ 23, 3, 56, 12, 32, 23, 17, 12, 11, 34, 45, 45 }, { 23, 1, 56, 12, 32, 23, 17, 12, 11, 34, 45, 37 }

		};
		ArrayList<ArrayList<Integer>> listaMatriz = practicas.convierteMatrizArrayLista(visitantesYear);

		String[] islas = { "GC", "LTE", "FTV", "TFE", "LPA", "GOM", "HIE" };
		String[] meses = { "ENE", "FEB", "MAR", "ABR", "MAY", "JUN", "JUL", "AGO", "SEP", "OCT", "NOV", "DIC" };

		/*
		 * int isla=2; int mes =7; System.out.println("Visitantes en "+ islas[isla]
		 * +" : " + practicas.visitantesIslaYear(isla, visitantesYear));
		 * System.out.println("Visitantes  en Canarias en el mes " + meses[mes]+ " : " +
		 * practicas.visitantesMesYear(mes, visitantesYear));
		 */

		/*
		 * String[] misDatos = { "123","abc", "345", "1x2", "990" }; //int[] res =
		 * practicas.convierteCadenasANumeros(misDatos); float saldo= 1000.0f; float[]
		 * movimientos= {10.0f, -5.0f,20.5f};
		 * 
		 * float saldoFinal = practicas.calculaSaldo(saldo, movimientos);
		 */
		//int[] datos = practicas.generaAleatorios3(500, 1, 500);
		// practicas.ordenaEnteros(datos);
		// Arrays.sort(datos);
		String[] cadenas = { "perro", "gato", "alce" };
		practicas.ordenaCadenas(cadenas);
		int[] array2 = { 3, 6, 9, 9, 9, 15, 29 };
		int[] array1 = { 1, 2, 9, 9, 25, 39, 56, 67, 99 };
		int[] arrayMezclado = practicas.mezclaArrays(array1, array2);
		// liga
		String[][] goles = new Datos().getResultados();

		int[] clasificacion = practicas.obtenerClasificacion2(goles);
		String[] equipos = new Datos().getEquipos();
		//practicas.ordenaClasificacion(clasificacion, equipos);
		for (int i = 0; i < equipos.length; i++) {
			// System.out.println(equipos[i] + " \t" + clasificacion[i]);

		}
		int[][] puntosJornadas = new Datos().getPuntosJornada();
		//Equipo[] clasi = practicas.obtenerClasificacion3(puntosJornadas);
		String nif = "345239";
		// System.out.println(practicas.validarNif(nif)?"OK":"KO");
		int x = 67;
		// System.out.println("El numero "+ x + (practicas.esPrimo(x)?" ES ":" NO ES ")+
		// " PRIMO" );
		// int[][] matriz = { { 3, 4, 8 }, { 6 }, { 5, 9 } };

		Integer[][] matriz2 = { { 3, 4, null, 8, null, 12, 37, null }, { 6, 7, 12, null, 34, 21, null, 11 },
				{ 5, null, 9 } };
		// practicas.recorrerMatrizIrregularPorColumnas(matriz);
		// practicas.recorrerMatrizIrregularPorColumnas2(matriz2);
		// int[] primos = practicas.numerosPrimos(100);
		// int [] fibonacci = practicas.numerosFibonacci(20);
		// ArrayList<Estudiante> lista = practicas.introListas();
		// practicas.listaEstudiantes(practicas.introListas());

		ArrayList<String> lista = new ArrayList<String>();
		lista.add("12");
		lista.add("19");
		lista.add("-12");
		lista.add("1x2");
		//ArrayList<Integer> numeros = practicas.convierteCadenasANumeros(lista);
		//HashMap<String, Estudiante> mapa = practicas.introMapas();
		//Estudiante noexisto = mapa.get("noexisto");

		// practicas.leerFicheroTexto();

		//ArrayList<String> fichero = practicas.LeerFicherpoArrayList("ficheros/personas.txt");

		//HashMap<String, String> numero = practicas.LeerFicherpoHashMap("ficheros/personas.txt");

		//HashMap<String, ArrayList<Float>> mapa1 = practicas.resumenventasVendedor("ficheros/ventaDep.txt");
		//HashMap<String, Float> resumenVentasVendedor = practicas.resumenVentasPorVendedor(mapa1);

		ArrayList<Float> movs = new ArrayList<Float>();
		movs.add(51.4f);
		movs.add(40.0f);
		movs.add(85.3f);

		ArrayList<Integer> minimatriz = new ArrayList<Integer>();
		minimatriz.add(7);
		minimatriz.add(12);
		minimatriz.add(8);
		minimatriz.add(50);

		ArrayList<ArrayList<Integer>> matriz1 = new ArrayList<ArrayList<Integer>>();
		//matriz1.add(minimatriz);

		//practicas.recorrerMatrizIrregularPorColumnas1(matriz1);

		//Practicas.grabarObjetosEnFichero("ficheros/estudiantesLista.obj");
		//practicas.leeObjetosDesdeFichero("ficheros/estudiantesLista.obj");
		// float saldo7 = practicas.calculaSaldo(0, movs);
		ArrayList<Integer> lista8 = new ArrayList<Integer>();
		lista8.add(78);
		lista8.add(7);
		//lista8.add(85);
		practicas.ordenaEnteros(lista8);
		int cuantos = 0;
	
		//practicas.generaDadosAleatorios(cuantos, "ficheros/dados.txt");

		//ArrayList<Vehiculo> lista3 = practicas.leerFicheroconArrayList("ficheros/Vehiculos.txt");
		//Practicas.grabarObjetosEnFicheroDeVehiculos("ficheros/VehiculosLista.obj");
		//practicas.leeObjetosDesdeFichero("ficheros/VehiculosLista.obj");


		/////////////////////////////////20/02/2018///////////////////////////////////////
		//HashMap<Integer, ArrayList<Float>> xyz = practicas.visitantesIslaMes("ficheros/visitantesIslaMes.txt");
		
		
		
		/////////22/02/2018/////////
		//9practicas.listadoIslasMeses("ficheros/visitantesIslaMes.txt");
		
		///01/03/218/////
		
		//practicas.paso1RecorreComunidades();
		
		///////////////////////////////Tercer Trimestre////////////////////////////////////////
		
		AccesoDatos ad = new AccesoDatos();
		//ad.conexion("localhost", "tienda", "root", "");
		//ArrayList<HashMap<String, Object>> registroTablas = ad.getAllRecords("localhost", "tienda", "root", "", "books");
		
		//ArrayList<ArrayList<Object>> registrosTabla = ad.getAllRecords2("localhost", "tienda", "root", "", "books");
		
		ad.consultaPadronCAProvincias();
		System.out.println("FIN");
		
	}

}
