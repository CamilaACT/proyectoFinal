package ClaseOperacionales;

import Clases.Bus;
import Clases.Horario;
import Ordenamiento.OrdenBuses;
import Ordenamiento.OrdenHorarios;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class GestionBuses {
    private static GestionBuses instancia;
    private List<Bus> listadoBuses;

    //Patron singelton
    private GestionBuses(){
        listadoBuses=new ArrayList<Bus>();
        QuemarDatos();
        System.out.printf("Tamanio de la lista quemando datos buses: "+listadoBuses.size());
    }
    public static GestionBuses getInstancia() {
        if (instancia == null) {
            instancia  = new GestionBuses();
        }
        return instancia;
    }


    /**
     * Añade un bus a la lista comprobando si ya esta registrado por placa
     * @param bus
     * @return true si se añade a la lista, false si no
     */
    public boolean addBus(Bus bus){
        if(busquedaBus(bus.getPlaca())==null){
            listadoBuses.add(bus);
            System.out.printf("Tamanio de la lista datos buses: "+listadoBuses.size());
            return true;
        }else{
            return false;
        }
    }

    /**
     * Busca en la lista de usuarios por placa
     * @param placa
     * @return un objeto usuario si encuentra en la lista, null si no encuentra
     */
    public Bus busquedaBus(String placa){
        for (Bus bus1 : listadoBuses) {
            if(bus1.getPlaca().equals(placa)){
                return bus1;
            }
        }
        return null;
    }
    public Bus buscarBusesBinario(String dato, int selectedIndex){
        Bus retornarBus = null;
        MostrarBuses(selectedIndex);

        switch (selectedIndex){
            case 0:
                //Ordenar por placa
                String placa = dato;
                retornarBus = OrdenBuses.binarySearch(listadoBuses, Comparator.comparing(Bus::getPlaca), new Bus(dato,"",0, null, 0,0));
                break;
            case 1:
                //Ordenar por matricula
                String matricula = dato;
                retornarBus = OrdenBuses.binarySearch(listadoBuses, Comparator.comparing(Bus::getMatricula), new Bus("", matricula, 0,null,0,0));
                break;
            case 2:
                //Ordenar por Kilometraje
                int kilometraje = Integer.parseInt(dato);
                retornarBus = OrdenBuses.binarySearch(listadoBuses, Comparator.comparing(Bus::getKilometraje), new Bus("", "", kilometraje,null,0,0));
                break;
            case 3:
                //Ordenar por fecha de mantenimiento
                Date fechaMantenimiento= new Date();
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
                dato=formatoFecha.format(fechaMantenimiento);
                retornarBus = OrdenBuses.binarySearch(listadoBuses, Comparator.comparing(Bus::getFechamantenieminto), new Bus("", "",0,fechaMantenimiento,0,0));
                break;
            case 4:
                //Ordenar por número de defectos
                int defectos = Integer.parseInt(dato);
                retornarBus = OrdenBuses.binarySearch(listadoBuses, Comparator.comparing(Bus::getNumeroDefectos), new Bus("","", 0,null,defectos,0));
                break;
            case 5:
                //Ordenar por capacidad de personas
                int capaPersonas = Integer.parseInt(dato);
                retornarBus = OrdenBuses.binarySearch(listadoBuses, Comparator.comparing(Bus::getCapacidadPersonas), new Bus("","",0,null,0,capaPersonas));
                break;
        }

        return retornarBus;
    }

    /**
     * Mostrar Buses
     */
    public String MostrarBuses(int selectedIndex) {
        switch (selectedIndex){
            case 0:
                //Ordenar por placa
                OrdenBuses.Burbuja(listadoBuses, Comparator.comparing(Bus::getPlaca));
                break;
            case 1:
                //Ordenar por matricula
                OrdenBuses.Burbuja(listadoBuses, Comparator.comparing(Bus::getMatricula));
                break;
            case 2:
                //Ordenar por kilometraje
                OrdenBuses.Insercion(listadoBuses, Comparator.comparing(Bus::getKilometraje));
                break;
            case 3:
                //Ordenar por fecha de mantenimiento
                OrdenBuses.Insercion(listadoBuses, Comparator.comparing(Bus::getFechamantenieminto));
                break;
            case 4:
                //Ordenar por número de defectos
                OrdenBuses.Insercion(listadoBuses, Comparator.comparing(Bus::getNumeroDefectos));
                break;
            case 5:
                //Ordenar por capacidad de personas
                OrdenBuses.Insercion(listadoBuses, Comparator.comparing(Bus::getCapacidadPersonas));
                break;
        }
        String horarios = "";

        for (int i = 0; i < listadoBuses.size(); i++) {
            horarios += listadoBuses.get(i).toString() + "\n";
        }

        return horarios;
    }

    private void QuemarDatos(){

        addBus(new Bus("PCA-6131","A0001J5",279,new Date(123,5,11),5,20));
        addBus(new Bus("PTJ-560","A00012F5",1000,new Date(123,6,11),5,20));

    }

    @Override
    public String toString() {
        return "GestionBuses{" +
                "listadoBuses=" + listadoBuses +
                '}';
    }
}
