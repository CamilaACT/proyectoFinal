package Clases;

import ClaseOperacionales.GestionHorarios;
import ClaseOperacionales.GestionUsuario;

import java.sql.SQLOutput;
import java.util.Calendar;

public class Chofer extends Usuario{
    private Horario horario;
    private CapacidadHorario capacidadHorario;


    public Chofer(String cedula, String nombre, String apellido, int indice) {
        super(cedula, nombre, apellido);
        this.horario = GestionHorarios.getInstancia().encontrarHorario(indice);
        Calendar calendar = Calendar.getInstance();
        int mes = calendar.get(Calendar.MONTH) + 1;
        capacidadHorario=new CapacidadHorario(mes);
    }
    public boolean HoararioChoferDisponible(int dia,int hora,int mes,int horaFin,int frecuencia){
        System.out.println("HORA QUE ME MANDAN"+hora);
        System.out.println("HORA QUE TIENE EL OBJETO"+ horario.getHoraInicio().getHour());
        System.out.println("HORA FINAL QUE ME MANDAN"+horaFin);
        System.out.println("HORA FINAL QUE TIENE EL OBJETO"+horario.getHoraFin().getHour());
        System.out.println("FRECUENCIA QUE ME MANDAN"+frecuencia);
        System.out.println("FRECUENCIA QUE TENGO"+horario.getFrecuencia());
       if((horario.getHoraInicio().getHour())<=hora){
           if((horario.getHoraFin().getHour())>=horaFin){
               if(horario.getFrecuencia()==frecuencia){
                   for(int i=hora;i<=horaFin;i++){
                       if(capacidadHorario.reservarHora(dia,i)){
                       }else{
                           return false;
                       }
                   }
                   return true;
               }

           }
       }
       return false;
    }
    public Horario getHorario() {
        return horario;

    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return   super.toString()+
                "\nEspecificación de Usuario: Chofer" +
                "\nHorario=" + horario;

    }

}
