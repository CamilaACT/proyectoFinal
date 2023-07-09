package ClaseOperacionales;

import Clases.Horario;
import Clases.Ruta;
import Clases.SolicitudReserva;
import Ordenamiento.OrdenHorarios;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class GestionReservas {
    private static GestionReservas instancia;
    private List<SolicitudReserva> listadoReserva;

    private GestionReservas(){
        listadoReserva=new ArrayList<SolicitudReserva>();
        QuemarDatos();
        System.out.printf("Tamanio de la lista"+listadoReserva.size());
    }

    public static GestionReservas getInstancia() {
        if (instancia == null) {
            instancia  =new GestionReservas();
        }
        return instancia;
    }

    public boolean addReserva(SolicitudReserva SR){
        for (SolicitudReserva SR1 : listadoReserva) {
            //System.out.println("QUE ES LA CONDICION"+horario1.equals(horario));
            if (SR1.equals(SR)) {
                return false;
            }
        }
        listadoReserva.add(SR);
        System.out.println("Tamaño arreglo horarios: " + listadoReserva.size());
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
        return listadoReserva.get(indice);
    }

    private void QuemarDatos(){
        listadoReserva.add(new SolicitudReserva(Date.from(null),new Ruta("Ruta 1",1,"UdlaPark","Quito"), LocalTime.of(12, 30, 0),1));
    }



}
