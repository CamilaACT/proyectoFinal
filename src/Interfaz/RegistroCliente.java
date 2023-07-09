package Interfaz;

import ClaseOperacionales.GestionUsuario;
import Clases.Cliente;
import Clases.Usuario;
import Validaciones.Validacion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroCliente extends JFrame {
    private JTextField txtIngresoNombreUsuario;
    private JTextField txtIngresoApellidoUsuario;
    private JTextField txtIngresoCedulaUsuario;
    private JTextField txtIngresoCorreoUsuario;
    private JTextField txtIngresoUsuario;
    private JTextField txtIngresaContraseniaUsuario;
    private JTextField txtIngresaConfirmarContraseniaUsuario;
    private JButton btnRegistroUsuario;
    private JPanel panelRegistro;
    //private GestionUsuario gestionarUsuario;
    private Validacion validar;
    private static Usuario usuarioactual;
public RegistroCliente(String title) {
    super(title);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(panelRegistro);
    this.pack();
    validar=new Validacion();

    btnRegistroUsuario.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (validar.validarCedula(txtIngresoCedulaUsuario.getText())) {
                    if (txtIngresoNombreUsuario.getText().isBlank()==false&&txtIngresoApellidoUsuario.getText().isBlank()==false&&txtIngresoCedulaUsuario.getText().isBlank()==false&&
                            txtIngresoCorreoUsuario.getText().isBlank()==false&&txtIngresoUsuario.getText().isBlank()==false&&txtIngresaContraseniaUsuario.getText().isBlank()==false&&
                            txtIngresaConfirmarContraseniaUsuario.getText().isBlank()==false){
                        if (txtIngresaConfirmarContraseniaUsuario.getText().equals(txtIngresaContraseniaUsuario.getText())){
                            //JOptionPane.showMessageDialog(null,"Las contraseñas no coinciden");
                            if (GestionUsuario.getInstancia().addUsuario(new Cliente(txtIngresoCedulaUsuario.getText(),txtIngresoNombreUsuario.getText(),
                                    txtIngresoApellidoUsuario.getText(),txtIngresoUsuario.getText(), txtIngresaContraseniaUsuario.getText(),
                                    txtIngresaConfirmarContraseniaUsuario.getText()))) {
                                JOptionPane.showMessageDialog(null, "Has sido registrado correctamente");
                                LogIn volverLogin = new LogIn("Login");
                                volverLogin.setVisible(true);
                                dispose();
                            }else{
                                JOptionPane.showMessageDialog(null, "No se ha podido registrar. Usuario existente");
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "No coincide la verificacion de la contraseña");
                        }


                    }else {
                        JOptionPane.showMessageDialog(null, "Campos incompletos. Llene todos los campos");
                    }
                }else {
                JOptionPane.showMessageDialog(null, "Cédula no válida. Ingrese una cédula Ecuatoriana válida");
            }



        }
    });
}
}
