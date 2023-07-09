package ClaseOperacionales;

import Clases.Ruta;
import Clases.SolicitudReserva;

import java.time.LocalTime;
import java.util.*;

public class GestionReservasLista {

    private static GestionReservasLista instancia;
    private Queue<SolicitudReserva> listadoReserva;

    private GestionReservasLista(){
        listadoReserva=new Queue<SolicitudReserva>() {
            @Override
            public boolean add(SolicitudReserva solicitudReserva) {
                return false;
            }

            @Override
            public boolean offer(SolicitudReserva solicitudReserva) {
                return false;
            }

            @Override
            public SolicitudReserva remove() {
                return null;
            }

            @Override
            public SolicitudReserva poll() {
                return null;
            }

            @Override
            public SolicitudReserva element() {
                return null;
            }

            @Override
            public SolicitudReserva peek() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<SolicitudReserva> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends SolicitudReserva> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };
        QuemarDatos();
        System.out.printf("Tamanio de la lista"+listadoReserva.size());
    }

    public static GestionReservasLista getInstancia() {
        if (instancia == null) {
            instancia  =new GestionReservasLista();
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
        return listadoReserva.peek();
    }

    private void QuemarDatos(){
        listadoReserva.add(new SolicitudReserva(Date.from(null),new Ruta("Ruta 1",1,"UdlaPark","Quito"), LocalTime.of(12, 30, 0),1));
    }


}
