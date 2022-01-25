package vista;

import java.util.Scanner;

public abstract class MenuTemplate {

	public abstract void listarClientes();
	public abstract void agregarCliente();
	public abstract void editarCliente();
	public abstract void importarDatos();
	public abstract void exportarDatos();
	public abstract void terminarPrograma();
	
	
	protected Scanner sc = new Scanner(System.in);
	
	public final void iniciarMenu() {
		System.out.println("1. Listar Clientes\n"
				+ "2. Agregar Cliente\n"
				+ "3. Editar Cliente"
				+ "4. Cargar Datos"
				+ "5. Exportar Datos"
				+ "6. Salir");
		System.out.println("Ingrese una opción:");
		String seleccion = sc.nextLine();
		
		switch(seleccion) {
		case "1":
			listarClientes();
			break;
		case "2":
			agregarCliente();
			break;
		case"3":
			editarCliente();
			break;
		case "4":
			importarDatos();
			break;
		case "5":
			exportarDatos();
			break;
		case "6":
			terminarPrograma();
		}
		
	}
}
