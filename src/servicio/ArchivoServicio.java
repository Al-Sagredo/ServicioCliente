package servicio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.CategoriaEnum;
import modelo.Cliente;
import utilidades.Utilidad;

//etiende a la clase exportador Pendiente
public class ArchivoServicio extends Exportador{

	ClienteServicio clienteServicio = new ClienteServicioImp();
	
	public List<Cliente> cargarDatos(String fileName1) {
		List<Cliente> listaClientes= new ArrayList<Cliente>();
		Utilidad.imp("Ingresa la ruta en donde se encuentra el archivo DBClientes.csv:");
		String ruta = sc.next();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(ruta + "/" + fileName1));
			String linea = reader.readLine();//lee el archivo fileName1
			
			while(linea != null){//la linea contiene informacion
				String [] datosCliente = linea.split(",");//separamos la informacion de la linea y la guardamos en un array
				String rut = datosCliente[0];
				String nombre = datosCliente[1];
				String apellido = datosCliente[2];
				String anios = datosCliente[3];
				String categoriaString = datosCliente[4];
				categoriaString = categoriaString.toUpperCase();
				CategoriaEnum categoria = CategoriaEnum.valueOf(categoriaString);
				
				Cliente cliente = new Cliente(rut, nombre, apellido, anios, categoria);//crea un cliente con los datos de la linea
				listaClientes = clienteServicio.getListaClientes();//crea una lista de tipo Cliente
				listaClientes.add(cliente);//agrega el cliente creado a la lista creada
				linea = reader.readLine();
			}
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listaClientes;
		
	}
	
	public void exportar(String fileName, List<Cliente> listaClientes) {
		
	}
}
