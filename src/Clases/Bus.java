package Clases;

import java.util.Calendar;
import java.util.Date;

public class Bus {
    private String placa;
    private String matricula;
    private int Kilometraje;
    private Date fechamantenieminto;

    private int numeroDefectos;
    private int capacidadPersonas;
    private CapacidadHorario capacidadHorario;

    public Bus(String placa, String matricula, int kilometraje, Date fechamantenieminto, int numeroDefectos, int capacidadPersonas) {
        this.placa = placa;
        this.matricula = matricula;
        Kilometraje = kilometraje;
        this.fechamantenieminto = fechamantenieminto;
        this.numeroDefectos = numeroDefectos;
        this.capacidadPersonas = capacidadPersonas;
        Calendar calendar = Calendar.getInstance();
        int mes = calendar.get(Calendar.MONTH) + 1;
        capacidadHorario=new CapacidadHorario(mes);
    }

    public String getPlaca() {
        return placa;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getKilometraje() {
        return Kilometraje;
    }

    public Date getFechamantenieminto() {
        return fechamantenieminto;
    }



    public int getNumeroDefectos() {
        return numeroDefectos;
    }

    public int getCapacidadPersonas() {
        return capacidadPersonas;
    }

    public boolean HoararioBusDisponible(int dia,int hora,int mes,int capacidadPersonas,int horaFin){
        //EL DOMINGO ES CERO,lunes es 1
        int diaMan= fechamantenieminto.getDay();
        int diaMes=fechamantenieminto.getMonth();//Puede haber error

        if(diaMan!=dia&&diaMes!=mes){
                if(this.capacidadPersonas>=capacidadPersonas){
                    for(int i=hora;i<=horaFin;i++){
                        if(capacidadHorario.reservarHora(dia,i)){
                        }else{
                            return false;
                        }
                    }
                    return true;
                }
        }
        return false;
    }
    @Override
    public String toString() {
        return "--BUS--" +
                "Placa='" + placa + "\n" +
                "Matricula='" + matricula + "\n" +
                "Kilometraje=" + Kilometraje +"\n"+
                "Fechamantenieminto=" + fechamantenieminto +"\n"+
                "NumeroDefectos=" + numeroDefectos +"\n"+
                "CapacidadPersonas=" + capacidadPersonas +"\n";
    }
}
