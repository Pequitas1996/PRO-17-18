package modelo;

public class Venta {

	private String fecha;
	private String idVendedor;
	private float importe;
	
		
	public Venta() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getIdVendedor() {
		return idVendedor;
	}
	public void setIdVendedor(String idVendedor) {
		this.idVendedor = idVendedor;
	}
	public float getImporte() {
		return importe;
	}
	public void setImporte(float importe) {
		this.importe = importe;
	}
	
}
