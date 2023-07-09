package ClaseOperacionales;

import Clases.Bus;
import Clases.Ruta;
import Clases.Usuario;

import java.util.ArrayList;
import java.util.List;

public class GestionRutas {
    private static GestionRutas instancia;
    private List<Ruta> listadoRutas;

    //Patron singelton
    private GestionRutas(){
        listadoRutas=new ArrayList<Ruta>();
        //QuemarDatos();
        System.out.printf("Tamanio de la lista quemando datos buses: "+listadoRutas.size());
    }
    public static GestionRutas getInstancia() {
        if (instancia == null) {
            instancia  = new GestionRutas();
        }
        return instancia;
    }

    public boolean addRuta(Ruta ruta){
        if(busquedaRuta(ruta.getNombre())==null){
            listadoRutas.add(ruta);
            System.out.println("Tamaño de la lista de usuarios: "+listadoRutas.size());
            return true;
        }else{
            return false;
        }
    }
    public Ruta busquedaRuta(String nombre){
        for (Ruta ruta1 : listadoRutas) {
            if(ruta1.getNombre().equals(nombre)){
                return ruta1;
            }
        }
        return null;
    }

    public boolean eliminarRuta(String nombre){
        Ruta ruta;
        ruta=busquedaRuta(nombre);
        if(ruta!=null){
            listadoRutas.remove(ruta);
            return true;
        }
        return false;
    }

    private void QuemarDatos(){
        listadoRutas.add(new Ruta("Quito-Zoologico",180,"Quito","Zoologico"));
        listadoRutas.add(new Ruta("Quito-Cuenca",180,"Quito","Cuenca"));
    }


}
