import javax.swing.*;
/*Vamos a crear un programa que saque un numero factorial 
 * que significa que colocando un nº! sera multiplicado
 * por los numeros que le preceden;en otras palabras 
 * por los numeros anteriores*/

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long resultado=1L;//para que pueda dar el resultado de numeros mas grandes.
		
		int numero=Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero"));
		
		for (int i = numero; i >0 ; i--) {
			
			resultado=resultado*i;
			
		}
		
		System.out.println("El factorial de "+ numero + " es " + resultado);

	}

}
