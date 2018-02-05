import javax.swing.*;

public class Entrada_Numeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String num1=JOptionPane.showInputDialog("Introduce un numero");
		//lo que sigue es transformar el string en double//
		
		double num2=Double.parseDouble(num1);
		//Forma de pasar un string a double con el metodo parseDouble//
		
		System.out.print("La raiz de " + num2 + " es ");
		
		System.out.printf("%1.2f", Math.sqrt(num2));
		
		
		/*double x=10000.0; 
		
		System.out.printf("%1.2f",x/3); 
		Este formato solo nos mostrara en consola
		 * dos decimales a la hora de realizar la division
		 * El ,2 hace referencia a cuantos decimales quieres 
		 * ver por pantalla*/

	}

}
