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
	protected void login() {
		if (idUsuario == getID() && contrasenia == getContrasenia() && nombre == getNombre()) {
			System.out.println("Login aceptado.");
		}else {
			System.out.println("Login rechazado.");
		}
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
