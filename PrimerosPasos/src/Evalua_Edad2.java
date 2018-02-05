import java.util.*;

public class Evalua_Edad2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner entrada=new Scanner (System.in);
		
		System.out.println("Introduce tu edad, por favor");
		
		int edad=entrada.nextInt();
		 
		if(edad<18) {
			System.out.println("Eres un adolecente");
		}
		
		else if(edad<40) {
			
			System.out.println("Eres joven");
		}
		
		else if(edad<65) {
			
			System.out.println("Eres maduro");
		}
		else  {
			
			System.out.println("Cuidate");
		}
	}
/* No hay limites para crear condicionales
 * sigue el control de flujos
 * pero como es condicional puede saltarse las condiciones 
 * E ignora las condiciones falsas y lo que queda en medio y continuando
 * la ejecucion por el final. */
}
