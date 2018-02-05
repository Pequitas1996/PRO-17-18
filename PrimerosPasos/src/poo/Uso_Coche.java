package poo;
/*sirve como clase principal para no colocar todo dentro de una sola clase.Y es lo que se llama modularizacion
 * ques dividir un codigo en pseudocodigos o en distintos ficheros y que se vean en un sola clase 
 * que sera la prncipal, que llevara el metodo main*/

public class Uso_Coche {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Crear los dos objetos
		
		Coche micoche=new Coche(); //instanciar una clase. Ejemplar de clase.
		
		//System.out.println(Renault.dime_largo());
		
		//System.out.println("Este coche tiene " + Renault.getRuedas() + " ruedas.");

		micoche.establece_color();
		
		System.out.println(micoche.dime_color());
		
	}
	
	
	

}
