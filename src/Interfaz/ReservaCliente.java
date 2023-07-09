package Interfaz;

import ClaseOperacionales.GestionUsuario;
import Clases.Cliente;
import Clases.Usuario;
import Validaciones.Validacion;

import javax.swing.*;

public class ReservaCliente extends JFrame {
    private JComboBox comboBoxManDia;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JComboBox ComboBoxHin;
    private JComboBox comboBox2;
    private JTextField textField2;
    private JTextArea textArea1;
    private JButton confirmarButton;
    private JPanel PanelReserva;

    public ReservaCliente(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(PanelReserva);
        this.pack();
    }
}
