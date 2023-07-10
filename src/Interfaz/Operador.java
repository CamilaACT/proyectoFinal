package Interfaz;

import ClaseOperacionales.GestionRutas;
import Clases.Ruta;
import Clases.Usuario;
import Grafo.Vertice;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Dictionary;
import java.util.Enumeration;

public class Operador extends JFrame {
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
    private JButton insertarButton2;
    private JButton mostrarRutaButton;
    private JTextArea textArea1;
    private JButton DIJASKSTRAButton;
    private JTextField txtVerticeInicial;
    private JTextField textVerticeFinal;
    private JButton finalizarRutaButton;
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
public Operador(String title, Usuario usuarioactual) {
    super(title);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(panel1);
    this.pack();
    ruta=null;
    PanelGrafo.setVisible(false);
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
                    JOptionPane.showMessageDialog(null, "Se creo Correctamente la Ruta,complete los campos");
                    PanelGrafo.setVisible(true);
                    cargarComboBox();
                    btnIngresarRuta.setEnabled(false);
                    txtOrigen.setEnabled(false);
                    txtDestino.setEnabled(false);
                    txtVerticeInicial.setText(txtOrigen.getText());
                    textVerticeFinal.setText(txtDestino.getText());
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
    insertarButton2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!VerticeIniciocomboBox1.getSelectedItem().toString().equals(VerticeFinalcomboBox1.getSelectedItem().toString())){
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
            }else{
                JOptionPane.showMessageDialog(null, "No se puede poner la misma paradad incial y final");
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
    DIJASKSTRAButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Dictionary[] result = ruta.getGrafoRuta().Dijsktra(ruta.getGrafoRuta().getVertexByValue(txtOrigen.getText()));
            Dictionary<String, Integer> distances = result[0];
            Dictionary<String, Vertice> previous = result[1];

            StringBuilder resultText = new StringBuilder();
            Enumeration<String> keys = distances.keys();
            while (keys.hasMoreElements()) {
                String vertexData = keys.nextElement();
                int distance = distances.get(vertexData);
                Vertice previousVertex = previous.get(vertexData);

                if (vertexData.equals(txtDestino.getText()) && distance > 0 && distance != 2147483647) {
                    resultText.append("Vertice: ").append(vertexData).append("\n");
                    resultText.append("Distancia: ").append(distance).append("\n");
                    resultText.append("Vértice previo: ").append(previousVertex.getDato()).append("\n");
                    resultText.append("-------------------\n");
                }
            }
            textArea1.setText(resultText.toString());
        }
    });
    finalizarRutaButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            btnIngresarRuta.setEnabled(true);
            PanelGrafo.setVisible(false);
            txtOrigen.setEnabled(true);
            txtDestino.setEnabled(true);
        }
    });
    cerrarSesiónButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            LogIn log=new LogIn("Login");
            log.setVisible(true);
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
