package frontal;

import java.io.IOException;

public class ConsolaAdministrador extends Consola{
	public ConsolaAdministrador() throws IOException {
		super();
	}
	public static void main(String[] args) throws IOException {
		ConsolaAdministrador consola = new ConsolaAdministrador();
		consola.mostrarMenu();
	}

	
	
	@Override
	public void mostrarMenu() {
		System.out.println("< Bienvenido >");
	}

	@Override
	public void ejecutarOpcion() {
		// TODO Auto-generated method stub
		
	}

}
