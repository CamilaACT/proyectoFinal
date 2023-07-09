package Clases;

public class Cliente extends Usuario{
//Agregar una lista de objetos tipo reserva
    private String correoElectronico;

    public Cliente(String cedula, String nombre, String apellido, String usuario, String contrasenia, String correoElectronico) {
        super(cedula, nombre, apellido, usuario, contrasenia);
        this.correoElectronico = correoElectronico;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
}
