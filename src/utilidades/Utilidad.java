package utilidades;
import java.util.concurrent.TimeUnit;

public class Utilidad {

	
	public static void limpiarPantalla() {
		for(int i=0; i<20; i++) {
			System.out.println("");
		}
	}
	
	public static void mostrarMensajes(String mensaje) {
		if(mensaje.equals("datos")) {
			imp("----------------------------\n" + "Datos cambiados con éxito");
		}
		else if(mensaje.equals("not")) {
			imp("opción inválida");
		}
		
		
	}

	public static void imp(String mensaje) {
		System.out.println(mensaje);
		
	}
	public static void esperar(int segundos) {
		try {
			TimeUnit.SECONDS.sleep(segundos);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
