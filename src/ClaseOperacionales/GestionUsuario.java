package ClaseOperacionales;

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

    private void QuemarDatos(){
        addUsuario(new Usuario("1711512663","Camila","Cabrera"));
        addUsuario(new Chofer("1750473942","Chofer","Ingreso",0));
    }



}
