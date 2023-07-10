package Interfaz;

import ClaseOperacionales.GestionRutas;
import Clases.Ruta;
import Grafo.Vertice;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Operador {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JTextField txtOrigen;
    private JTextField txtDestino;
    private JComboBox cmbHoras;
    private JPanel PanelGrafo;
    private JTextField VerticetextField1;
    private JButton insertarButton;
    private JComboBox VerticeIniciocomboBox1;
    private JComboBox VerticeFinalcomboBox1;
    private JTextField PesotextField1;
    private JButton insertarButton1;
    private JButton mostrarRutaButton;
    private JTextArea textArea1;
    private JButton DIJASKSTRAButton;
    private JTextField txtVerticeInicial;
    private JTextField textField2;
    private JButton btnIngresarRuta;
    private JLabel txtPendientes;
    private JButton desencolarButton;
    private JTextArea textArea2;
    private JButton aprobarButton;
    private JTextField textField1;
    private JButton rechazarButton;
    private JLabel txtInicioNombre;
    private JButton cerrarSesiónButton;
    private Ruta ruta;
public Operador() {
    btnIngresarRuta.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!txtOrigen.getText().isBlank()&&!txtDestino.getText().isBlank()){
                int horasMinutos;
                horasMinutos=Integer.parseInt(cmbHoras.getSelectedItem().toString())*60;

                //int tiempo;
                //tiempo=horasMinutos+Integer.parseInt(cmbMinutos.getSelectedItem().toString());
                ruta=new Ruta(txtOrigen.getText()+"-"+txtDestino.getText(),horasMinutos,txtOrigen.getText(),txtDestino.getText());

                if(GestionRutas.getInstancia().addRuta(ruta)){
                    JOptionPane.showMessageDialog(null, "Se creo Correctamente la Ruta");
                    PanelGrafo.setVisible(true);
                    cargarComboBox();
                }else{
                    JOptionPane.showMessageDialog(null, "No fue posible crear la Ruta, ya existe una con el mismo destino y origen");
                }

            }
        }
    });
    insertarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!VerticetextField1.getText().isBlank()){
                if(ruta.getGrafoRuta().getVertexByValue(VerticetextField1.getText())==null){
                    ruta.getGrafoRuta().addVertice(VerticetextField1.getText());
                    cargarComboBox();
                    JOptionPane.showMessageDialog(null, "Vertice añadido con éxito");
                    System.out.printf("Tamaño al imprimir: "+ruta.getGrafoRuta().getVertices().size());
                }else{
                    JOptionPane.showMessageDialog(null, "Ya hay un vertice con ese nombre,pruebe con otro");
                }

            }else{
                JOptionPane.showMessageDialog(null, "Llene correctamente el campo de vertice");
                textArea1.setText("No se añadio el vertice, reintente...");
            }
        }
    });
    insertarButton1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!PesotextField1.getText().isBlank()){
                if(ruta.getGrafoRuta().getVertexByValue(VerticeIniciocomboBox1.getSelectedItem().toString()).aristaUnica(VerticeFinalcomboBox1.getSelectedItem().toString())){
                    ruta.getGrafoRuta().addArista(VerticeIniciocomboBox1.getSelectedItem().toString(),VerticeFinalcomboBox1.getSelectedItem().toString(),Integer.parseInt(PesotextField1.getText()));
                    JOptionPane.showMessageDialog(null, "Parada agregada con éxito");
                }else{
                    JOptionPane.showMessageDialog(null, "Esta Parada ya existe");
                }
            }else{
                LogIn login=new LogIn("RegresoLogin");
            }
        }
    });
    mostrarRutaButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
                for (int i = 0; i < ruta.getGrafoRuta().getVertices().size(); i++) {
                    textArea1.append(ruta.getGrafoRuta().getVertices().get(i).imprimir(ruta.getGrafoRuta().isConPesos())+"\n");
                }
        }
    });
}
    private void cargarComboBox(){
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<String> comboBoxModel2 = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<String> comboBoxModel3 = new DefaultComboBoxModel<>();
        VerticeIniciocomboBox1.setModel(comboBoxModel);
        VerticeFinalcomboBox1.setModel(comboBoxModel2);
        //BusVerticeInicialcomboBox1.setModel(comboBoxModel3);
        for (Vertice vertice : ruta.getGrafoRuta().getVertices() ) {
            String data = vertice.getDato();
            comboBoxModel.addElement(data);
            comboBoxModel2.addElement(data);
            comboBoxModel3.addElement(data);
        }
    }
}
