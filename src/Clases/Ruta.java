package Clases;

import Grafo.Grafo;

public class Ruta {
    private String nombre;
    private int tiempo;//minutos
    private Grafo grafoRuta;

    public Ruta(String nombre, int tiempo,String origen,String destino) {
        this.nombre = nombre;
        this.tiempo = tiempo;
        grafoRuta=new Grafo(true,true);
        grafoRuta.addVertice(origen);
        grafoRuta.addVertice(destino);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public Grafo getGrafoRuta() {
        return grafoRuta;
    }
}
