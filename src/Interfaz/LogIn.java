package Interfaz;

import Clases.Chofer;
import Clases.Usuario;
import ClaseOperacionales.GestionUsuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogIn extends JFrame {
    private JTextField txtLogUsua;
    private JButton btnLogIngre;
    private JLabel txtBtnRegistrarse;
    private JPanel panelPresentacion;
    private JPasswordField txtLogCont;
    private GestionUsuario gestionarUsuario;
    private static Usuario usuarioactual;

    public LogIn(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelPresentacion);
        this.pack();
        gestionarUsuario=new GestionUsuario();


        btnLogIngre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String contrasenia;
                contrasenia=String.valueOf(txtLogCont.getPassword());
                System.out.printf("Contraseña: "+contrasenia);

                usuarioactual=gestionarUsuario.validarCredenciales(txtLogUsua.getText(),contrasenia);
                if(usuarioactual==null){
                    JOptionPane.showMessageDialog(null, "Verifique los datos ingresados, clave o contraseña incorrectos");
                }else{
                    if(usuarioactual instanceof Chofer){
                        System.out.println("El usuario ingresado fue un chofer");
                        ChoferInt interfazchofer=new ChoferInt("GESTION PERFIL CHOFER",usuarioactual);
                        interfazchofer.setVisible(true);
                        dispose();
                    }else if(usuarioactual instanceof Usuario){
                        System.out.println("El usuario ingresado fue un Usuario");
                        AdministradorCRUD interfazadministrador=new AdministradorCRUD("GESTION PERFIL ADMINISTRADOR",usuarioactual,gestionarUsuario);
                        interfazadministrador.setVisible(true);
                        dispose();//Cierra la ventana actual

                    }
                }

            }
        });
    }

}
