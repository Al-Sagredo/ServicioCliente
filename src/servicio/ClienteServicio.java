package servicio;

import java.util.List;

import modelo.Cliente;

public interface ClienteServicio {

	List<Cliente> listarClientes();
	void agregarCliente(Cliente cliente);
	void editarCliente(Cliente cliente, String seleccion);
	void actualizarEstado(Cliente cliente);
	void actualizarDatos(Cliente cliente);
	void cambiarDato(Cliente cliente, String nombreDato);
	void cambiarAnios(Cliente cliente);
	List<Cliente> getListaClientes();
}
