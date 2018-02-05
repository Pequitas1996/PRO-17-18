
public class manipula_Cadenas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String nombre="Laura";
		
		System.out.println("Mi nombre es " + nombre);
		
		System.out.println("Mi nombre tiene " + nombre.length() + " letras.");
		
		System.out.println("La primera letra de "+ nombre + " es la "  + nombre.charAt(0));
		
		int ultima_letra;
		
		ultima_letra=nombre.length();
		
		System.out.println("Y la ultima letra de " + nombre + " es la " + nombre.charAt(ultima_letra-1));

	}

}
