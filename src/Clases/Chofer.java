package Clases;

import ClaseOperacionales.GestionHorarios;
import ClaseOperacionales.GestionUsuario;

public class Chofer extends Usuario{
    private Horario horario;

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Chofer(String cedula, String nombre, String apellido, int indice) {
        super(cedula, nombre, apellido);
        this.horario = GestionHorarios.getInstancia().encontrarHorario(indice);
    }

    @Override
    public String toString() {
        return "Especificación de Usuario: Chofer" +
                "\nHorario=" + horario+
                super.toString();
    }
}
