package Clases;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Horario {

    private int frecuencia;//Si es 0 es de fin de semana, si es 1 es lunes viernes y si es 2 es alternado.
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String codigo;
    private static int contador=0;

    public Horario(int frecuencia, LocalTime horaInicio, LocalTime horaFin) {
        this.frecuencia = frecuencia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        codigo= "HO-"+contador;
        contador++;
    }
    public int getFrecuencia(){
        return frecuencia;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horario horario = (Horario) o;
        return frecuencia == horario.frecuencia && Objects.equals(horaInicio, horario.horaInicio) && Objects.equals(horaFin, horario.horaFin) && Objects.equals(codigo, horario.codigo);
    }

    @Override
    public String toString() {
        return "Horario{" +
                "Frecuencia:" + frecuencia +
                " Hora Inicio:" + horaInicio +
                " Hora Fin:" + horaFin +
                " Código: " + codigo;
    }
}
