package ClaseOperacionales;

import Clases.Horario;
import Clases.Usuario;
import Ordenamiento.OrdenHorarios;
import Ordenamiento.OrdenUsuario;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
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
            //System.out.println("QUE ES LA CONDICION"+horario1.equals(horario));
            if (horario1.equals(horario)) {
                return false;
            }
        }
            listadoHorarios.add(horario);
            System.out.println("Tamaño arreglo horarios: " + listadoHorarios.size());
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
    public Horario buscarUsuarioBinario(String dato, int selectedIndex){
        Horario retornarHorario = null;
        MostrarHorarios(selectedIndex);

        switch (selectedIndex){
            case 0:
                //Ordenar por cedula
                int frecuencia = Integer.parseInt(dato);
                retornarHorario = OrdenHorarios.binarySearch(listadoHorarios, Comparator.comparing(Horario::getFrecuencia), new Horario(frecuencia,null,null));
                break;
            case 1:
                //Ordenar por nombre
                LocalTime horaInicio = LocalTime.parse(dato);
                retornarHorario = OrdenHorarios.binarySearch(listadoHorarios, Comparator.comparing(Horario::getHoraInicio), new Horario(0, horaInicio, null));
                break;
            case 2:
                //Ordenar por apellido
                LocalTime horaFinal = LocalTime.parse(dato);
                retornarHorario = OrdenHorarios.binarySearch(listadoHorarios, Comparator.comparing(Horario::getHoraFin), new Horario(0, null, horaFinal));
                break;
        }

        return retornarHorario;
    }

    /**
     * Mostrar Horarios
     */
    public String MostrarHorarios(int selectedIndex) {
        switch (selectedIndex){
            case 0:
                //Ordenar por frecuencia
                OrdenHorarios.Burbuja(listadoHorarios, Comparator.comparing(Horario::getFrecuencia));
                break;
            case 1:
                //Ordenar por hora inicial
                OrdenHorarios.Burbuja(listadoHorarios, Comparator.comparing(Horario::getHoraInicio));
                break;
            case 2:
                //Ordenar por hora final
                OrdenHorarios.Insercion(listadoHorarios, Comparator.comparing(Horario::getHoraFin));
                break;
            case 3:
                //Ordenar por codigo
                OrdenHorarios.Insercion(listadoHorarios, Comparator.comparing(Horario::getCodigo));
                break;
        }
        String horarios = "";

        for (int i = 0; i < listadoHorarios.size(); i++) {
            horarios += listadoHorarios.get(i).toString() + "\n";
        }

        return horarios;
    }


}
