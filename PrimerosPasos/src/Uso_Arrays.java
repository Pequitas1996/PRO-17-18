
public class Uso_Arrays {
/*Vamos a crear nuestra primera array que almacene 5 elementos
 * dentro de ese array
 * int[] mi_matriz2=new int[5];forma de llamar a otra matriz;*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*int[]mi_matriz=new int[5];
				
		mi_matriz[0]=5;
		mi_matriz[1]=38;
		mi_matriz[2]=-15;
		mi_matriz[3]=92;
		mi_matriz[4]=71;
		forma mas larga de declarar una array
		*/
		
		int[] mi_matriz= {5,38,-15,92,71,95,85,6,25,14,78};//forma mas facil de declarar el array
		
		for (int i = 0; i < mi_matriz.length; i++) {//lengt sirve para recorrer totalmente la matriz si tiene muchos caracteres
			
			System.out.println("Valor del índice " + i + " = " + mi_matriz[i]);
			
		}
		

	}

}
