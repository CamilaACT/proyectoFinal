package Interfaz;


import Clases.ArbolDecision;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class ClienteInt extends JFrame {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JTextField textField3;
    private ArbolDecision AD;

public ClienteInt(String title) {
    super(title);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(panel1);
    this.pack();
    System.out.println("En la interfaz");
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
}
}
