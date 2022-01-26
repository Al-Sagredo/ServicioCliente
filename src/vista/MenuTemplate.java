package vista;

import java.util.Scanner;

import utilidades.Utilidad;

public abstract class MenuTemplate {

	public abstract void listarClientes();
	public abstract void agregarCliente();
	public abstract void editarCliente();
	public abstract void cargarDatos();
	public abstract void exportarDatos();
	public abstract void terminarPrograma();
	
	
	protected Scanner sc = new Scanner(System.in);
	
	public final void iniciarMenu() {
		System.out.println("1. Listar Clientes\n"
				+ "2. Agregar Cliente\n"
				+ "3. Editar Cliente\n"
				+ "4. Cargar Datos\n"
				+ "5. Exportar Datos\n"
				+ "6. Salir");
		System.out.println("Ingrese una opción:");
		String seleccion = sc.next();
		
		switch(seleccion) {
		case "1":
			listarClientes();
			Utilidad.esperar(2);
			break;
		case "2":
			agregarCliente();
			Utilidad.esperar(1);
			Utilidad.limpiarPantalla();
			break;
		case"3":
			editarCliente();
			Utilidad.esperar(1);
			Utilidad.limpiarPantalla();
			break;
		case "4":
			cargarDatos();
			Utilidad.esperar(1);
			Utilidad.limpiarPantalla();
			break;
		case "5":
			exportarDatos();
			Utilidad.esperar(1);
			Utilidad.limpiarPantalla();
			break;
		case "6":
			terminarPrograma();
			
		default: 
			Utilidad.mostrarMensajes("not");
			Utilidad.limpiarPantalla();
			
		}
		
		iniciarMenu();
		
	}
}
