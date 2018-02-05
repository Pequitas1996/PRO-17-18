
public class manipula_Cadenas2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String frase="Hoy es un buen dia para decirte que me enamore de ti";
		
		String frase_resumen=frase.substring(24, 52); 
		
		/*el 24 es el caracter con el que vamos a empezar a extraer y el 52
		 * es el caracter que no queremos utilizar; siempre hay que empezar a contar
		 * desde el primer caracter en las dos ocaciones.*/
		 
		/* tambien se pueden concatenar con otro string para crear
		 * otras frases con la cadena de caracteres extraida */
		
		System.out.println(frase_resumen); 
	}

}
 