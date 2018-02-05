/*Empezamos con la creacion de clases orientadas a objetos 
 *que utilizaremos para verificar todo lo posible de un coche
 *y si queremos importar se colocara despues del paquete*/

package poo;

public class Coche { 
	//todo es de tipo entero por que se utilizaran centimetros y kilos todo en entero
	//objeto coche.
	
	/*metodo constructor: Metodo especial que se encarga de dar un esado inicial
	 *al objeto y tiene la caracterisitca que debe llamarse igual que la clase 
	 *y es lo que diferencia el metodo constructor de un metodo normal*/

	private int ruedas; //modificador de acceso :private.Es solo accesible desde la propia clase
	
 	private int largo;
	
	private int ancho;
	
	private int motor;
	
	private int peso_plataforma;
	
	String color;
	
	int peso_total;
	
	boolean asientos_cuero, climatizador;
	
	
	public Coche() {
		//construir el estado inicial del objeto
		
		ruedas=4;
		
		largo=2000;
		
		ancho=300;
		
		motor=1600;
		
		peso_plataforma=500;
		
	}
	
	public String dime_largo() { //metodo GETTER infoma del valor del dato ya declarado anteriormente.
		return "El largo del coche es " + largo;
		
	}
	
	public void establece_color() { //metodo SETTER encargado de modificar el valor de una propiedad
		
		color="azul";
		
	}
	
	public String dime_color() {
		return "El color del coche es: " + color;
		
	}
}
