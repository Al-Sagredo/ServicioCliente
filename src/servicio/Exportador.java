package servicio;

import java.util.List;

import modelo.Cliente;

public abstract class Exportador {

	
	public abstract void exportar(String fileName, List<Cliente> listaClientes);
}
