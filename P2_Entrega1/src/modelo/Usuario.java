package modelo;

public abstract class Usuario {
	//< Atributos >
	protected String idUsuario;
	protected String contrasenia;
	protected String nombre;
	
	
	//< Constructor >
	public Usuario(String idUsuario, String contrasenia, String nombre) {
		this.idUsuario = idUsuario;
		this.contrasenia = contrasenia;
		this.nombre = nombre;
	}
	
	
	
//< Metodos >=====================================================================================================x>
	protected boolean login(String contrasenia) {
		if (contrasenia.equals(this.contrasenia)) {
			return true;
		}
		return false;
	}
//<x==============================================================================================================x>

	
	
//< Getters >=====================================================================================================x>
	public String getContrasenia() {
		return contrasenia;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getID(){
		return this.idUsuario;
	}
//<x==============================================================================================================x>
}
