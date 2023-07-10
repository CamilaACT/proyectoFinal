package Clases;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario{
//Agregar una lista de objetos tipo reserva
    private String correoElectronico;
    private List<SolicitudReserva> listadosolicitudes;

    public Cliente(String cedula, String nombre, String apellido, String usuario, String contrasenia, String correoElectronico) {
        super(cedula, nombre, apellido, usuario, contrasenia);
        this.correoElectronico = correoElectronico;
        this.listadosolicitudes=new ArrayList<SolicitudReserva>();
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    public boolean addSolicitud(SolicitudReserva solicitud){
        listadosolicitudes.add(solicitud);
        return true;
    }
}
