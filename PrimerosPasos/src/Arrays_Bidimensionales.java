
public class Arrays_Bidimensionales {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] matrix= {
				{15,21,18,9,15},
				{10,52,17,19,7},
				{19,2,19,17,7},
				{92,13,13,32,41}
				
		};

		 /*for (int i = 0; i < 4; i++) { //metodo de recorrer un array solo con for.
			 System.out.println();//forma de verlo en forma de tabla
			 for (int j = 0; j < 5; j++) {
				 
				 System.out.print(matrix[i][j] + " ");
				
			} 
			
		}*/
		
		for(int[]fila:matrix) { //bucle foreach que es un metodo mas sencillo para recorrer una array
			
			System.out.println();
		
			for (int z : fila) {
				 
				System.out.print(z + " ") ; 
				
			}
		}
	}

}
