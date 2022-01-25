package vista;

import servicio.ArchivoServicio;
import servicio.ClienteServicio;
import servicio.Exportador;
import servicio.ExportadorCsv;
import servicio.ExportadorTxt;

public class Menu extends MenuTemplate{

	private ClienteServicio clienteServicio;
	private ArchivoServicio archivoServicio;
	private ExportadorCsv exportadorCsv;
	private ExportadorTxt exportarTxt;
	private String fileName= "Clientes";//para exportar el archivo
	private String fileName1= "DBClientes.csv";//para importar el archivo
	
	public void listarClientes() {
		
	}
	public  void agregarCliente() {
		
	}
	public  void editarCliente() {
		
	}
	public  void importarDatos() {
		
	}
	public  void exportarDatos() {
		
	}
	public  void terminarPrograma() {
		
	}
	
}
