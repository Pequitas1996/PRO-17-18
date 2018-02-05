import javax.swing.*;

/* Vamos a generar un programa para averiguar cual seria el peso ideal
 * para una persona dependiendo de su sexo, por lo que utilizaremos 
 * otra ventana emergente a la consola y por eso importamos de la api
 * la clase javax.swing
 * 
 * el metodo equalsIgnoreCase distingue entre letras mayusculas y letras minusculas*/
public class Peso_Ideal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String genero="";
		
		do {
			genero=JOptionPane.showInputDialog("Introduce tu genero (H/M)");
			
		}while(genero.equalsIgnoreCase("H") == false && genero.equalsIgnoreCase("M") ==false);

		int altura= Integer.parseInt(JOptionPane.showInputDialog("Introduce altura el cm"));
		
		int pesoideal=0;
		
		if(genero.equalsIgnoreCase("H")) {
			
			pesoideal=altura-110;
			
		}
		
		else if(genero.equalsIgnoreCase("M")) {
			
			pesoideal=altura-120;
		}
		
		System.out.println("Tu peso ideal es " + pesoideal + " kg");
	}

}
