package ClaseOperacionales;

import Clases.AsistenteAdministrativo;
import Clases.Chofer;
import Clases.Horario;
import Clases.Usuario;

import java.util.ArrayList;
import java.util.List;

public class GestionUsuario {
    private List<Usuario> listadoUsuarios;
    private static GestionUsuario instancia;


    private GestionUsuario(){
        listadoUsuarios=new ArrayList<Usuario>();
        QuemarDatos();
        System.out.printf("Tamanio de la lista"+listadoUsuarios.size());
    }
    public static GestionUsuario getInstancia() {
        if (instancia == null) {
            instancia =new GestionUsuario();
        }
        return instancia;
    }


    /**
     * Valida credenciales de acceso al sistema
     * @param Usuario
     * @param Contrasenia
     * @return retorna objeto usuario con ese usuario y contraseña o null si no encontro
     */

    public Usuario validarCredenciales(String Usuario,String Contrasenia){
        for (Usuario usuario1 : listadoUsuarios) {
            if(usuario1.getUsuario().equals(Usuario)){
                if(usuario1.getContrasenia().equals(Contrasenia)){
                    return usuario1;
                }
            }
        }
        return null;
    }

    /**
     * Añade un usuario a la lista comprobando si ya esta registrado
     * @param usuario
     * @return true si se añade a la lista, false si no
     */
    public boolean addUsuario(Usuario usuario){
        if(busquedaUsuario(usuario.getCedula())==null){
            listadoUsuarios.add(usuario);
            System.out.println("Tamaño de la lista de usuarios: "+listadoUsuarios.size());
            return true;
        }else{
            return false;
        }
    }

    /**
     * Busca en la lista de usuarios por cedula
     * @param cedula
     * @return un objeto usuario si encuentra en la lista, null si no encuentra
     */
    public Usuario busquedaUsuario(String cedula){
        for (Usuario usuario1 : listadoUsuarios) {
            if(usuario1.getCedula().equals(cedula)){
                return usuario1;
            }
        }
        return null;
    }


    public boolean modificarUsuario(String cedula, String nombre, String apellido){
        Usuario usuario1=busquedaUsuario(cedula);
        if(usuario1!=null){
            usuario1.setNombre(nombre);
            usuario1.setApellido(apellido);
            return true;
        } else {
            return false;
        }
    }

    public boolean modificarAsistente(String cedula, String nombre, String apellido,String sucursal){
        Usuario usuario1=busquedaUsuario(cedula);
        AsistenteAdministrativo asistente1 = (AsistenteAdministrativo)usuario1;
        if(asistente1!=null){
            asistente1.setNombre(nombre);
            asistente1.setApellido(apellido);
            asistente1.setSucursal(sucursal);
            return true;
        } else {
            return false;
        }
    }

    public boolean modificarChofer(String cedula, String nombre, String apellido, int indice){
        Usuario usuario1=busquedaUsuario(cedula);
        Chofer chofer1= (Chofer) usuario1;
        if(chofer1!=null){
            chofer1.setNombre(nombre);
            chofer1.setApellido(apellido);
            chofer1.setHorario(GestionHorarios.getInstancia().encontrarHorario(indice));
            return true;
        } else {
            return false;
        }
    }




    private void QuemarDatos(){
        addUsuario(new Usuario("1715126613","Camila","Cabrera"));
        addUsuario(new Chofer("1750473942","Chofer","Ingreso",0));
    }



}
