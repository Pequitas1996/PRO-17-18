import javax.swing.*; //para importar JOptionpanen
public class Uso_Arrays2 {

/*Vamos a recorrer una matriz de tipo String,la recorreremos
 * con un bucle for normal y despues con un bucle de tipo for each
 * y saber la diferencia entre uno y otro y dar lo valores por una ventana de joptionpanen
 * que en vez de numeros almacene paises*/

	public static void main(String[] args) { 
		// TODO Auto-generated method stub
		
		String[]paises=new String[8]; //para colocar los paises por ventana
		//relleno de forma manual;
		
		/*paises[0]="España";
		paises[1]="Colombia";
		paises[2]="Italia";
		paises[3]="Mexico";
		paises[4]="Peru";
		paises[5]="Chile";
		paises[6]="Argentina";
		paises[7]="Alemania";*/
		
		//String[]paises = {"España","Colombia","Italia","Mexico","Peru","Chile","Argentina","Alemania"};
		
		/*for (int i = 0; i < paises.length; i++) {
			
			System.out.println("Pais " + (i+1) + " " + paises[i]);
		}*/
		
		for (int i = 0; i < paises.length; i++) {
			
			paises[i]=JOptionPane.showInputDialog("Introduce país " + (i+1));
			
		}
		
		for(String elemento:paises) {//sintaxix del bucle for each
			
			System.out.println("Pais: " + elemento);
		}
	}

}
