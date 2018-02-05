import javax.swing.JOptionPane; //Eclipse importo el metodo con el que vamos a trabajar

/*Vamos a trabajar con la comprobacion de un correo electronico
  * sabiendo que si lleva un @ sera correcto y si no es falso e utilizaremos 
  * varios metodos y el primero es charArt de la clase String y el lengt 
  * tambien de la clase String*/
public class Comprueba_mail {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arroba = 0; //forma para que solo acepte una arroba
		boolean punto=false;
		
		String mail=JOptionPane.showInputDialog("Introduce mail");

		for (int i = 0; i < mail.length(); i++) {
			
			if(mail.charAt(i)=='@') {
				
				arroba++;
			}
			if(mail.charAt(i)=='.') {//forma de comprobar que el mail es correcto
				
				punto=true;
			}
			
		}
		
		if(arroba==1 && punto==true) {
			
			System.out.println("El mail es correcto");
		}
		else {
			
			System.out.println("El mail no es correcto");
		}
		
	}

}
