package servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import modelo.Cliente;
import utilidades.Utilidad;

public class ExportadorCsv extends Exportador {

	
	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {

		Utilidad.imp("Ingresa la ruta en donde desea exportar el archivo clientes.csv:");
		String ruta = sc.nextLine();
		
		try {
			File archivoCsv = new File(ruta + "/" + fileName);
			if(archivoCsv.exists()) {
				System.out.println("Ya existe un archivo con ese nombre en el directorio ingresado");
			}
			else {
				archivoCsv.createNewFile();
				BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoCsv));

				listaClientes.stream().forEach(cliente -> {
					try {
						escritor.write(cliente.getRunCliente() + "," + cliente.getNombreCliente() + ","
								+ cliente.getApellidoCliente() + "," + cliente.getAniosCliente() + ","
								+ cliente.getNombreCategoria());
						escritor.newLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
				Utilidad.imp("Datos de clientes exportados correctamente en formato csv.");
				escritor.close();
			}
			
		} catch (IOException e) {
			System.out.println("La ruta ingresada no es válida");
		}
		
	}

}
