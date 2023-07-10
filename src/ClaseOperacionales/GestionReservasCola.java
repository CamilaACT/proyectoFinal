package ClaseOperacionales;

import Clases.Ruta;
import Clases.SolicitudReserva;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class GestionReservasCola {

    private static GestionReservasCola instancia;
    private Queue<SolicitudReserva> listadoReserva;

    private GestionReservasCola(){
        listadoReserva=new LinkedList<SolicitudReserva>();
        QuemarDatos();
        System.out.printf("Tamanio de la lista"+listadoReserva.size());
    }

    public static GestionReservasCola getInstancia() {
        if (instancia == null) {
            instancia  =new GestionReservasCola();
        }
        return instancia;
    }

    public boolean addReserva(SolicitudReserva SR){
        listadoReserva.offer(SR);
        return true;
    }

    public List<String> detalleReservao(){
        List<String> nombres=new ArrayList<String>();
        for (SolicitudReserva SR1 : listadoReserva) {
            nombres.add(SR1.getRuta()+"("+SR1.getFecha()+"-"+ SR1.getHora()+")");
        }
        return nombres;
    }

    public SolicitudReserva encontrarReserva(int indice){
        return listadoReserva.peek();
    }

    private void QuemarDatos(){
        //listadoReserva.add(new SolicitudReserva(LocalDate.from(null),new Ruta("Ruta 1",1,"UdlaPark","Quito"), LocalTime.of(12, 30, 0),1));
    }

    public Queue<SolicitudReserva> getListadoReserva() {
        return listadoReserva;
    }
}
