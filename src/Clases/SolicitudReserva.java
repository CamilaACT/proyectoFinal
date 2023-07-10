package Clases;

import ClaseOperacionales.GestionBuses;

import java.time.LocalTime;
import java.time.LocalDate;

public class SolicitudReserva {
    private LocalDate  fecha;
    private Ruta ruta;
    private Bus bus;
    private Chofer chofer;
    private Usuario usuario;
    private int status;//0=no aprobada 1=aprobada
    private LocalTime hora;
    private int frecuencia;
    private double precio;


    public SolicitudReserva(LocalDate fecha, Ruta ruta, LocalTime hora, int frecuencia,Bus bus,Chofer chofer, Usuario usuario) {
        this.fecha = fecha;
        this.ruta = ruta;
        this.hora = hora;
        this.frecuencia = frecuencia;
        this.bus=bus;
        this.chofer=chofer;
        this.usuario=usuario;
        status=0;
        this.precio=0;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Bus getBuses() {
        return bus;
    }

    public void setBuses(Bus buses) {
        this.bus= buses;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public boolean esMismoUsuario(Usuario usuarioComparar) {
        return this.usuario.equals(usuarioComparar);
    }

    public int getStatus() {
        return status;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "\n--SOLICITUD DE RESERVA--" +"\n"+
                "Fecha=" + fecha +"\n"+
                "Ruta=" + ruta +"\n"+
                "Bus=" + bus +"\n"+
                "Chofer=" + chofer +"\n"+
                "Usuario=" + usuario +"\n"+
                "Status=" + status +"\n"+
                "Hora=" + hora +"\n"+
                "Frecuencia=" + frecuencia ;
    }
}
