import java.util.*;
import javax.swing.*;

import org.omg.Messaging.SyncScopeHelper;
public class Areas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada=new Scanner(System.in);
		
		System.out.println("Elige una opcion: \n1: Cuadrado \n2: Rectagulo \n3: Triangulo \n4: Circulo");
		
		int figura=entrada.nextInt();
		
		switch(figura) {
		
		case 1:
			
			int lado=Integer.parseInt(JOptionPane.showInputDialog("Introduce el lado"));
			
			System.out.println("El area del cuadrado es " + Math.pow(lado, 2));
			
			break;
		
		case 2:
			
			int base=Integer.parseInt(JOptionPane.showInputDialog("Introduce la Base"));
			
			int altura=Integer.parseInt(JOptionPane.showInputDialog("Introduce la Altura"));
			
			System.out.println("El area del rectángulo es " + base*altura);
			
			break;
		
		case 3:
			base=Integer.parseInt(JOptionPane.showInputDialog("Introduce la Base"));
			
			altura=Integer.parseInt(JOptionPane.showInputDialog("Introduce la Altura"));
			
			System.out.println("El area del triángulo es " +(base*altura)/2);
			
			break;
			
		case 4:
			
			int radio=Integer.parseInt(JOptionPane.showInputDialog("Introduce el Radio"));
			
			System.out.print("El area del círculo es ");
			
			System.out.printf("%1.2f·", Math.PI*(Math.pow(radio, 2)));
			
			break;
			
		
		default:
			
			System.out.println("La opción no es correcta");
		
		}

	}

}
