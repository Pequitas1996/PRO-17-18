/*Tercera forma de declarar una matriz mas grande,solo que cree 
 * otra clase solo para no perder la otra forma de hacerlo anteriormete.
 * se almacenaran numeros enteros*/
public class Uso_Arrays_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[]matriz_aleatorios=new int[150];
		
		for (int i = 0; i < matriz_aleatorios.length; i++) {
			//utilizaremos una refundicion, para generar aleatorios entre 0 a 100
			matriz_aleatorios[i]=(int)Math.round(Math.random()*100);
			
		}
		
		for (int numeros : matriz_aleatorios) {
			
			System.out.print(numeros + " ");//para ver los numeros uno al lado de otro y no hace abajo
			
		}
 
	}

}
