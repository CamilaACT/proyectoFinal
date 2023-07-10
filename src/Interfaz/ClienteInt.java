package Interfaz;


import ClaseOperacionales.*;
import Clases.*;
import Validaciones.Validacion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ClienteInt extends JFrame {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JTextField textField3;
    private JPanel PanelReserva;
    private JComboBox comboBoxManDia;
    private JComboBox ComboBoxHin;
    private JComboBox comboBox2;
    private JTextArea textArea1;
    private JButton confirmarButton;
    private JTextField txtMes;
    private JLabel txtInicioNombre;
    private JTextField txtCapacidad;
    private JTextField txtAnio;
    private JComboBox comboFrecuecnia;
    private JButton consultarButton;
    private JTextArea textArea2;
    private JButton cerrarSesionButton;
    private ArbolDecision AD;
    private Validacion validar;
    private Cliente cliente;
    private int mes;
    private int anio;
    private Usuario usuarioactual;

public ClienteInt(String title, Usuario usuario) {
    super(title);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(panel1);
    this.pack();
    usuarioactual=usuario;
    cliente=(Cliente)usuario;
    System.out.println("En la interfaz");
    validar=new Validacion();
    LocalDate fechaActual = LocalDate.now();
    mes = fechaActual.getMonthValue();
    String nombreMes = new DateFormatSymbols().getMonths()[mes - 1];
    anio=fechaActual.getYear();
    txtMes.setText(nombreMes);
    txtAnio.setText(""+mes);
    cargarComboBoxRuta();
    txtInicioNombre.setText(cliente.getNombre());
    button1.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("12424211421412412");
            ArbolDecision root = new ArbolDecision("¿Finde o Entre?",20,10);
            ArbolDecision FirstNode = new ArbolDecision("¿Mayor de 40 km??",20,10);
            ArbolDecision SecondNode = new ArbolDecision("¿Capacidad de personas mayor a 20?",20,15);

            root.addOption("Fin de semana", FirstNode);
            root.addOption("Entresemana", FirstNode);
            FirstNode.addOption("si",SecondNode);
            FirstNode.addOption("no",SecondNode);
            SecondNode.addOption("si",null);
            SecondNode.addOption("no",null);

            ArbolDecision currentNode = root;
            int cont=1,l=0;

            while (currentNode != null) {

                if(cont ==1) {

                    System.out.println(currentNode.getQuestion());
                    String answer = comboBox1.getSelectedItem().toString();

                    if(answer.equals("Fin de semana")){

                      l=l+currentNode.getPrecioY();
                    }else{
                       l=l+currentNode.getPrecioN();
                    }
                    currentNode = currentNode.getNextNode(answer);

                }
                if(cont==2){
                    String answer;
                    int i = Integer.parseInt(textField1.getText());
                    System.out.println(currentNode.getQuestion());
                    if(i<=40){
                        answer = "no";
                        l=l+currentNode.getPrecioN();
                    }else{
                        answer= "si";
                        l=l+currentNode.getPrecioY();
                    }
                    currentNode = currentNode.getNextNode(answer);
                }
                if (cont==3){
                    String answer;
                    int i =Integer.parseInt(textField2.getText());
                    System.out.println(currentNode.getQuestion());
                    if(i<=20){
                        answer = "no";
                        l=l+  currentNode.getPrecioN();
                    }else{
                        answer= "si";
                        l=l+currentNode.getPrecioY();
                    }
                    currentNode = currentNode.getNextNode(answer);
                }
                cont++;
            }
            textField3.setText("El precio de esta ruta es: "+l);
        }
    });
    confirmarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            textArea1.setText("");
            if(validar.validacionStringInt(txtCapacidad.getText())){
                int dia = Integer.parseInt(comboBoxManDia.getSelectedItem().toString());
                LocalDate fecha = LocalDate.of(anio, mes, dia);
                Ruta ruta=GestionRutas.getInstancia().devolverRutaporIndice(comboBox2.getSelectedIndex());
                int hora=Integer.parseInt(ComboBoxHin.getSelectedItem().toString());
                LocalTime horaF=LocalTime.of(Integer.parseInt(ComboBoxHin.getSelectedItem().toString()),00,00);
                int frecuencia=comboFrecuecnia.getSelectedIndex();
                int capacidadPersonas=Integer.parseInt(txtCapacidad.getText());
                Bus bus= GestionBuses.getInstancia().identificarBus(dia,hora,mes,capacidadPersonas,ruta.calcularHoraFin(hora));
                Chofer chofer=(Chofer) GestionUsuario.getInstancia().encontrarChoferDisponible(dia,hora,mes,ruta.calcularHoraFin(hora),frecuencia);

                if(bus!=null){
                    if(chofer!=null) {
                        GestionReservasCola.getInstancia().addReserva(new SolicitudReserva(fecha, ruta, horaF, frecuencia, bus, chofer, usuarioactual));
                        System.out.println("Tamaño de la cola de reservas ingresadas" + GestionReservasCola.getInstancia().getListadoReserva().size());
                        textArea1.setText("Su solicitud de reserva fue enviada con éxito, pronto nos pondremos en contacto, puede consultar el historia de reservas en su perfil");
                    }else{
                        JOptionPane.showMessageDialog(null, "No se encontro chofer disponible");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "No se encontro bus disponible");
                }




            }else{
                JOptionPane.showMessageDialog(null, "Ingrese un número en el campo capacidad");
            }

        }
    });
    cerrarSesionButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            usuarioactual=null;
            LogIn log=new LogIn("LogIn");
            log.setVisible(true);
        }
    });
    consultarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            textArea2.setText(GestionReservas.getInstancia().detalleReservaoUsuario(usuarioactual));
        }
    });
}
    private void cargarComboBoxRuta() {
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        comboBox2.setModel(comboBoxModel);
         List<String> nombres = GestionRutas.getInstancia().detalleRuta();//gestion
        String nombre = "";
        for (int i = 0; i < nombres.size(); i++) {
            nombre = nombres.get(i);
            comboBoxModel.addElement(nombre);
        }

    }
}
