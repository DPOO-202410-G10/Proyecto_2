package usuarios;

import modelo.Usuario;

public class Cliente extends Usuario{
	//< Atributos >
	private boolean esPropietario;
	private String telefono;
	private String direccion;
	public int numCompras;
	public boolean verificacion;
	

	//< Constructor >
	public Cliente(String idUsuario, String contrasenia, String nombre, boolean esPropietario, String telefono, String direccion, int numCompras) {
		super(idUsuario, contrasenia, nombre);
		this.esPropietario = esPropietario;
		this.telefono = telefono;
		this.direccion = direccion;
		this.numCompras = numCompras;
	}

	
	
//< Metodos >=====================================================================================================x>
	
	
//<x==============================================================================================================x>
	
	
	
//< Getters >=====================================================================================================x>
	public int getNumCompras() {
		return numCompras;
	}
//<x==============================================================================================================x>

	
	
//< Setters >=====================================================================================================x>
	public void setNumCompras(int numCompras) {
		this.numCompras = numCompras;
	}
//<x==============================================================================================================x>	
}
