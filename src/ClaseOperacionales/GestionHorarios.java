package ClaseOperacionales;

import Clases.Horario;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class GestionHorarios {

    private static GestionHorarios instancia;
    private List<Horario> listadoHorarios;

    //SINGELTON
    private GestionHorarios(){
        listadoHorarios=new ArrayList<Horario>();
        QuemarDatos();
        System.out.printf("Tamanio de la lista"+listadoHorarios.size());
    }
    public static GestionHorarios getInstancia() {
        if (instancia == null) {
            instancia  =new GestionHorarios();
        }
        return instancia;
    }

    /**
     * Busca en la lista de horarios un horario igual
     * @param horario
     * @return un objeto usuario si encuentra en la lista, null si no encuentra
     */
    public boolean addHorario(Horario horario){
        for (Horario horario1 : listadoHorarios) {
            System.out.println("QUE ES LA CONDICION"+horario1.equals(horario));
            if(horario1.equals(horario)){
                return false;
            }
        }
        listadoHorarios.add(horario);
        System.out.println("Tamaño arreglo horarios: "+listadoHorarios.size());
        return true;
    }
    public List<String> detalleHorario(){
        List<String> nombres=new ArrayList<String>();
        for (Horario horario1 : listadoHorarios) {
            nombres.add(horario1.getCodigo()+"("+horario1.getHoraInicio()+"-"+horario1.getHoraFin()+")");
        }
        return nombres;
    }

    public Horario encontrarHorario(int indice){
        return listadoHorarios.get(indice);
    }

    private void QuemarDatos(){
        listadoHorarios.add(new Horario(1,LocalTime.of(12, 30, 0),LocalTime.of(13, 30, 0)));
    }


}
