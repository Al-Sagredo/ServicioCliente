package servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.CategoriaEnum;
import modelo.Cliente;
import utilidades.Utilidad;

public class ClienteServicioImp implements ClienteServicio {

	List<Cliente> listaClientes = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	public ClienteServicioImp(List<Cliente> listaClientes) {// constructor full
		super();
		this.listaClientes = listaClientes;
	}

	public ClienteServicioImp() {// constructor vacío

	}

	public List<Cliente> listarClientes() {

		return listaClientes;

	}

	public void agregarCliente(Cliente cliente) {
		if (cliente != null) {
			listaClientes.add(cliente);
		}
	}

	public void editarCliente(Cliente cliente, String seleccion) {

		switch (seleccion) {
		case "1":
			actualizarEstado(cliente);
			break;
		case "2":
			actualizarDatos(cliente);
			break;
		default:
			Utilidad.mostrarMensajes("not");
		}
	}

	public void actualizarEstado(Cliente cliente) {
		System.out.println("-----Actualizando estado del cliente----");
		System.out.println("El estado actual es " + cliente.getNombreCategoria());
		System.out.println("1.-Si desea cambiar el estado del cliente a inactivo\n"
				+ "2.-Si desea mantener el estado del cliente Activo\n" + "");
		System.out.println("Ingrese opción: \n" + "---------------------------------------");

		String opcion = sc.next();
		if (opcion.equals("1")) {
			
			cliente.setNombreCategoria(CategoriaEnum.INACTIVO);
			Utilidad.imp("El estado del cliente ha sido cambiado a INACTIVO");
			
		} else if (opcion.equals("2")){
			System.out.println("El estado del cliente es ACTIVO");
		}
		else {
		   Utilidad.mostrarMensajes("not");
		}
	}

	public void actualizarDatos(Cliente cliente) {
		String rut = cliente.getRunCliente();
		String nombre = cliente.getNombreCliente();
		String apellido = cliente.getApellidoCliente();
		String anios = cliente.getAniosCliente();

		System.out.println("----Actualizando datos del cliente----");
		Utilidad.imp("1.-El RUN del cliente es: " + rut +"\n"
				+ "2.-El Nombre del cliente es: " + nombre +"\n"
				+ "3.-El Apellido del cliente es: " + apellido + "\n"
				+ "4.-Los años como cliente son: " + anios +"\n");
		
		Utilidad.imp("\n" + "Ingrese opcion a editar de los datos del cliente:");
		String edicion = sc.next();

		Utilidad.imp("----------------------------");
		switch (edicion) {
		case "1":
			cambiarDato(cliente, "Run");
			break;
		case "2":
			cambiarDato(cliente, "Nombre");
			break;
		case "3":
			cambiarDato(cliente, "Apellido");
			break;
		case "4":
			cambiarAnios(cliente);
			break;
		default:
			Utilidad.mostrarMensajes("not");

		}
	}

	public void cambiarDato(Cliente cliente, String nombreDato) {

		Utilidad.imp("1.-Ingrese nuevo " + nombreDato + " del Cliente:");
		String nuevoDato = sc.next() + sc.nextLine();
		if (nombreDato == "Run") {
			cliente.setRunCliente(nuevoDato);
		} else if (nombreDato == "Nombre") {
			cliente.setNombreCliente(nuevoDato);
		} else {
			cliente.setApellidoCliente(nuevoDato);
		}
		Utilidad.mostrarMensajes("datos");

	}

	public void cambiarAnios(Cliente cliente) {
		System.out.println("3.-Ingrese los años como Cliente:");
		cliente.setAniosCliente(sc.next() + sc.nextLine());
		Utilidad.mostrarMensajes("datos");
		

	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}
	public void setListaClientes(List<Cliente> lista) {
		this.listaClientes = lista;
	}

}
