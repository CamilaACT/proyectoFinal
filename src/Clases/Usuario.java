package Clases;

public class Usuario {
    private String nombre, apellido, usuario, contrasenia, cedula;
    private static int contador=100;
    private int estado;//El estado será 1 cuando el usuario este activo, será 0 cuando este inactivo
    private int codigo;//El código sera unico por empleado

    public Usuario(String cedula, String nombre, String apellido) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = cedula;
        this.estado=1;
        this.codigo=contador;
        this.contrasenia ="password"+contador;
        contador++;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getCedula() {
        return cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "\n --Usuario--\n" +
                "Nombre= " + nombre+
                "\nApellido= " + apellido +
                "\nUsuario='" + usuario +
                "\nEstado=" + estado +
                "\nCódigo=" + codigo;
    }
}

