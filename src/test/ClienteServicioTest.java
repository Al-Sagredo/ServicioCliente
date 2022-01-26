package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import modelo.Cliente;
import servicio.ClienteServicio;
import servicio.ClienteServicioImp;

public class ClienteServicioTest {

	
	private ClienteServicio servicio;
	private Cliente cliente;
	
	@BeforeEach
	void setup() {
		servicio = new ClienteServicioImp();
		cliente= new Cliente("123", "Juan", "Ayala", "12", null);
	}
	@Test
	public void agregarClienteTest() {
		//given
		//when
		servicio.agregarCliente(cliente);
		//then
		Assertions.assertNotNull(servicio.listarClientes().get(0));
	}
	
	@Test
	public void agregarClienteNullTest() {
		//agregar cliente nulo
		//given
		Cliente cliente = null;
		//when
		servicio.agregarCliente(cliente);
		//then
		Assertions.assertEquals(servicio.listarClientes().size(), 0);
	}
}
