import java.util.*;
/*vamos a generar  numeros aleatorios entre 0 y 100.
 * por lo que tenemos que importar la clase java.util.
 * y para conseguir la actividad utilizaremos el metodo random(), que sirve
 * para generar numeros aleatorios, pero tambien trabajaremos con la api 
 * de java.*/
 
public class Adivina_Numero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int aleatorio=(int)(Math.random()*100);
		
		Scanner entrada = new Scanner(System.in);
		
		int numero = 0;
		int intentos = 0;
		
		while(numero !=aleatorio){
			intentos++;
			
			System.out.println("Introduce un numero porfavor");
			
			numero = entrada.nextInt(); 
			
			if(aleatorio < numero) {
				
				System.out.println("Mas bajo");
			}
			
			else if(aleatorio > numero) {
				
				System.out.println("Mas alto");
			}
			
		}
		
		System.out.println("Correcto. Lo has conseguido en " + intentos + " intentos");
		
		//System.out.println(Math.random()*100 ); //genera numeros aleatorios entre 0 y 1 y multiplicado por 100 genera y numero mayor de 1 y 0.
		//System.out.println(aleatorio);
	}

}
