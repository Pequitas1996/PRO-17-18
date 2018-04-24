package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class AccesoDatos {
	private String usuario;
	private String clave;
	private String host;
	private String bd;

	public AccesoDatos() {
		super();
		this.usuario = usuario;
		this.clave = clave;
		this.host = host;
		this.bd = bd;
	}

	public Connection conexion(String dominio, String bd, String usr, String clave) {
		// forma de conectar con mysql desde xamp y con la base de datos creada
		// anteriormente.
		try {
			String url = "jdbc:mysql://" + dominio + "/" + bd;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection(url, usr, clave);
			// ruta necesaria para poder conectar con cualquier base de datos exterior con
			// la configuracion del driver manager.
			System.out.println("¡¡Has conectado con la  base de datos!!");
			
			return con;
		} catch (InstantiationException e) {
			System.out.println(e.getMessage());
		} catch (IllegalAccessException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			// System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("¡¡NO has conectado con la base de datos!!");

		return null;
	}

	public ArrayList<HashMap<String, Object>> getAllRecords(String dominio, String bd, String usr, String clave,
			String tabla) {
		try {
			ArrayList<HashMap<String, Object>> registros = new ArrayList<HashMap<String, Object>>();
			Connection conexion = this.conexion(dominio, bd, usr, clave);
			String sql = "SELECT * FROM " + tabla;
			Statement stm = conexion.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			ResultSetMetaData metaData = rs.getMetaData();

			// mostrar los nombres de las columnas...
		/*	for (int i = 1; i < metaData.getColumnCount(); i++) {
				System.out.println(metaData.getColumnName(i));

			}*/
			while (rs.next()) {
				HashMap<String, Object> registro = new HashMap<String, Object>();
				registros.add(registro);
				//System.out.println(rs.getString("precio"));
				for (int i = 1; i <= metaData.getColumnCount(); i++) {//forma de visualizar datos de una tabla externa 
					//en donde se inicializa el for desde 1 no desde 0; puesto que en las conexiones de base de datos no hay 0.
					registro.put(metaData.getColumnName(i), rs.getString(i));//metodo para meter los registros de la bas
						System.out.println(metaData.getColumnName(i) + "=>" + rs.getString(i)+ "\t");	
				}
				System.out.println();
			}
			stm.close();
			rs.close();
			return registros;

		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;

	}
	
	public ArrayList<ArrayList<Object>>getAllRecords2(String dominio, String bd, String usr, String clave, String tabla){
		try {
			ArrayList<ArrayList<Object>> registros = new ArrayList<ArrayList<Object>>();
			Connection conexion = this.conexion(dominio, bd, usr, clave);
			String sql = "SELECT * FROM " + tabla;
			Statement stm = conexion.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			ResultSetMetaData metaData = rs.getMetaData();
			//primera fila:
			ArrayList<Object>regis = new ArrayList<Object>();
			registros.add(regis);
			for (int i = 1; i <=metaData.getColumnCount(); i++) {
				regis.add(metaData.getColumnName(i));//forma de meter la primera fila dentro de un obj.
				//resto de filas
				while (rs.next()) {
					regis= new ArrayList<Object>();
					registros.add(regis);
					for (int j = 1; j <=metaData.getColumnCount(); j++) {
						regis.add(rs.getString(j));
						System.out.println(metaData.getColumnName(i) + "=>" + rs.getString(j) + "\t");
					}
					System.out.println();					
				}
				stm.close();
				rs.close();
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;	
	}
	
	public void consultaPadronCAProvincias(){
		//conectar base de datos.//
		try {
			Connection conexion = this.conexion("localhost", "paro", "root", "");
			String sql = "select CA as Comunidad, provincia, sum(padron) as padron from padron pa inner join provincias p1, comunidadesautonomas c1, municipios m1 "
					+ " where pa.CodMunicipio = m1.CodMunicipio and m1.CodProvincia = p1.CodProvincia and p1.CodCA = c1.CodCA group by p1.CodProvincia order by c1.CA, p1.Provincia";
			Statement stm = conexion.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			int subtotal= 0, total= 0;
			String ca_ant= "";
			
			while(rs.next()) {
				//System.out.println();
				//System.out.println(rs.getString(1)+ "," + rs.getString(2) + " = " + rs.getInt(3));
				if (rs.getString(1).equals(ca_ant) && !ca_ant.equals("")) {
					System.out.println("COMUNIDAD AUTONOMA : " +  rs.getString(1));
					total +=subtotal;
					System.out.println("COMUNIDAD AUTONOMA : " + ca_ant + " ," + subtotal);
					subtotal = 0;
				
					ca_ant= rs.getString(1);	
				}
				System.out.println("\t\t" + rs.getString(2) + " = " + rs.getInt(3));
				subtotal +=rs.getInt(3);
			}
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		//hacer consulta,
		//listar desde resulset.

	}

}
