package vista;
import java.util.List;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ArchivoServicio;
import servicio.ClienteServicioImp;
import servicio.Exportador;
import servicio.ExportadorCsv;
import servicio.ExportadorTxt;
import utilidades.Utilidad;

public class Menu extends MenuTemplate {

	private ClienteServicioImp clienteServicio = new ClienteServicioImp();
	private ArchivoServicio archivoServicio = new ArchivoServicio();
	private Exportador exportadorCsv = new ExportadorCsv();
	private Exportador exportadorTxt = new ExportadorTxt();
	private String fileName = "Clientes";
	private String fileName1 = "DBClientes.csv";

	
	
	public void listarClientes() {

		clienteServicio.listarClientes().stream().forEach(c -> {
			Utilidad.imp("----------------Datos del Cliente----------------");
			Utilidad.imp(c.toString());
			Utilidad.imp("\n-------------------------------------------------");
		});
	}

	
	public void agregarCliente() {
		// solicita ingreso de datos y llena objeto de tipo Cliente.
		System.out.println("--------------Crear Cliente--------------");
		System.out.println("");
		System.out.println("Ingresa RUN  del Cliente:");
		String rut = sc.next();
		System.out.println("Ingresa Nombre  del Cliente:");
		String nombre = sc.next() + sc.nextLine();
		System.out.println("Ingresa Apellido  del Cliente:");
		String apellido = sc.next() + sc.nextLine();
		System.out.println("Ingresa años como Cliente:");
		String anios = sc.next() + sc.nextLine();

		System.out.println("-----------------------------------------");

		Cliente cliente = new Cliente(rut, nombre, apellido, anios, CategoriaEnum.ACTIVO);//crea un cliente con los atributos ingresados
		clienteServicio.agregarCliente(cliente);//pasa el cliente creado como parametro al metodo de ClienteServicio
	}

	
	public void editarCliente() {
		List<Cliente> listaClientes = clienteServicio.getListaClientes();// obtengo la lista de clientes
		Cliente cliente = new Cliente();
		Utilidad.imp("-----------------Editar Cliente-----------------\n" + "Seleccione qué desea hacer:\n"
				+ "1.-Cambiar el estado del cliente\n" + "2. Editar los datos ingresados del cliente\n" + ""
				+ "Ingrese opción:");
		String seleccion = sc.next();

		if (seleccion.equals("1") || seleccion.equals("2")) {
			System.out.println("------------------------------------------------");
			System.out.println("Ingrese RUN del cliente a editar:");
			String rut = sc.next();
			
			
			cliente = listaClientes.stream().filter(c -> c.getRunCliente().equals(rut)).findAny().orElse(null);//verifico que exista el rut
			if (cliente != null) {
																										
				clienteServicio.editarCliente(cliente, seleccion);
			}
			else {
				Utilidad.imp("El RUN ingresado no existe");
			}
		} else {
			Utilidad.mostrarMensajes("not");
		}
		
	}
	

	public void cargarDatos() {
		//llama al metodo de archivoServicio para transformar el archivo en una List
		List<Cliente> listaImportada = archivoServicio.cargarDatos(fileName1);
		clienteServicio.setListaClientes(listaImportada);// seteamos la lista de clientes con la lista creada
		Utilidad.imp("Datos cargados correctamente en la lista");
	}
	

	public void exportarDatos() {

		List<Cliente> listaClientes = clienteServicio.listarClientes();
		Utilidad.imp("---------Exportar Datos-----------\n" + "Seleccione el formato a exportar:\n" + "1.-Formato csv\n"
				+ "2.-Formato txt\n" + "Ingrese una opción para exportar:\n" + "----------------------------------\n");
		String formato = sc.next();
		switch (formato) {
		case "1":
			fileName = fileName + ".csv";
			exportadorCsv.exportar(fileName, listaClientes);
			fileName = "Clientes";
			break;
		case "2":
			fileName = fileName + ".txt";
			exportadorTxt.exportar(fileName, listaClientes);
			fileName = "Clientes";
			break;
		default:
			Utilidad.mostrarMensajes("not");
		}
	}

	
	public void terminarPrograma() {
		Utilidad.limpiarPantalla();
		System.out.println("Ha salido del programa");
		System.exit(0);
	}

}
