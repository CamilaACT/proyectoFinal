package ClaseOperacionales;

import Clases.Horario;
import Clases.Ruta;
import Clases.SolicitudReserva;
import Clases.Usuario;
import Ordenamiento.OrdenHorarios;

import java.time.LocalDate;
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

    public String detalleReservaoUsuario(Usuario usuario){
        String respuesta="";
        for (SolicitudReserva SR1 : listadoReserva) {
            if(SR1.esMismoUsuario(usuario)){
                if(SR1.getStatus()==1){
                    respuesta=respuesta+"\n--SOLICITUD APROBADA--\n"+"Fecha: "+SR1.getFecha().toString()+"\nRuta: "+SR1.getRuta().toString()+"\nPrecio: "+SR1.getPrecio()+"\nPara finalizar el proceso de pago contactese con: 0987409415";
                }else{
                    respuesta=respuesta+"\n--SOLICITUD RECHAZADA--\n"+"Fecha: "+SR1.getFecha().toString()+"\nRuta: "+SR1.getRuta().toString()+"\nPara recibir información sobre el rechazo comunicarse con:0987409415";
                }

            }

        }
        return respuesta;
    }
    public String listaAprDes(int indice){
        String respuesta="";
        for (SolicitudReserva SR1 : listadoReserva) {
            if(SR1.getStatus()==indice){
                respuesta=respuesta+"\n--SOLICITUD APROBADA--\n"+"Fecha: "+SR1.getFecha().toString()+"\nRuta: "+SR1.getRuta().toString()+"\nPrecio: "+SR1.getPrecio();

            }else {
                respuesta=respuesta+"\n--SOLICITUD RECHAZADA--\n"+"Fecha: "+SR1.getFecha().toString()+"\nRuta: "+SR1.getRuta().toString();
            }

        }
        return respuesta;

    }

    public SolicitudReserva encontrarReserva(int indice){
        return listadoReserva.get(indice);
    }



    private void QuemarDatos(){
        //listadoReserva.add(new SolicitudReserva(LocalDate.from(null),new Ruta("Ruta 1",1,"UdlaPark","Quito"), LocalTime.of(12, 30, 0),1));
    }



}
