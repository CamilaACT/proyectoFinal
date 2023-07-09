package Clases;

import java.time.LocalTime;
import java.util.Date;

public class SolicitudReserva {
    private Date fecha;
    private Ruta ruta;
    private Bus buses;
    private Chofer chofer;
    private Cliente cliente;
    private String descripcion;
    private int status;
    private LocalTime hora;
    private int kilometraje;
    private int costoEstimado;
    private int frecuencia;

    public SolicitudReserva(Date fecha, Ruta ruta, LocalTime hora, int frecuencia) {
        this.fecha = fecha;
        this.ruta = ruta;
        this.hora = hora;
        this.frecuencia = frecuencia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public Bus getBuses() {
        return buses;
    }

    public void setBuses(Bus buses) {
        this.buses = buses;
    }

    public LocalTime getHora() {
        return hora;
    }
}
