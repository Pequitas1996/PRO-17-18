/*Vamos a declarar una matriz de dos dimenciones que va a tener
 * la capacidad de almacenar 20 elementos y se va a rrellenar de
 * forma manual en una matriz de dos dimenciones se escriben 
 * [[
 * 
 * En esta matriz utilizaremos dos bucles for que seran i y j*/
public class Arrays_Bidimencionales {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] matrix=new int[4][5]; //forma de declarar cuantos elementos van en cada dimencion o posicion
		
		 matrix[0][0]=15;
		 matrix[0][1]=21;
		 matrix[0][2]=18;
		 matrix[0][3]=9;
		 matrix[0][4]=15;
		 
		 matrix[1][0]=10;
		 matrix[1][1]=52;
		 matrix[1][2]=17;
		 matrix[1][3]=19;
		 matrix[1][4]=7;
		 
		 matrix[2][0]=19;
		 matrix[2][1]=2;
		 matrix[2][2]=19;
		 matrix[2][3]=17;
		 matrix[2][4]=7;
		 
		 matrix[3][0]=92;
		 matrix[3][1]=13;
		 matrix[3][2]=13;
		 matrix[3][3]=32;
		 matrix[3][4]=41;
		 
		 //System.out.println("valor alacenado en la posicion 2, 3 es: " + matrix[2][3]);

		 
		 for (int i = 0; i < 4; i++) {
			 System.out.println();//forma de verlo en forma de tabla
			 for (int j = 0; j < 5; j++) {
				 
				 System.out.print(matrix[i][j] + " ");
				
			}
			
		}
	}
	

}
