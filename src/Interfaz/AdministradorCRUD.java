package Interfaz;


import ClaseOperacionales.GestionBuses;
import ClaseOperacionales.GestionHorarios;
import ClaseOperacionales.GestionUsuario;
import Clases.*;
import Validaciones.Validacion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class AdministradorCRUD extends JFrame {

    private Usuario usuario;
    private JPanel panelUsuario;
    private JTabbedPane tabbedPane1;
    private JTabbedPane tabbedPane2;
    private JTextField txtAdminCedula;
    private JTextField txtAdminNombre;
    private JTextField txtAdminApellido;
    private JButton btnRegistrarAdmin;
    private JComboBox comboBoxHorarioChofer;
    private JComboBox comboBoxManDia;
    private JComboBox comboBoxManMes;
    private JComboBox comboBoxMananio;
    private JTextField txtNumDefectos;
    private JTextField txtCapacidadPersonas;
    private JComboBox comboBoxfrecuencia;
    private JComboBox ComboBoxHin;
    private JComboBox ComboBoxMin;
    private JComboBox ComboBoxHfin;
    private JComboBox ComoboBoxMfin;
    private JTextField txtPlaca;
    private JTextField txtMatricula;
    private JTextField txtKilometraje;
    private JButton btnRegistrarBus;
    private JTextField txtAsisCedula;
    private JTextField txtAsisNombre;
    private JTextField txtAsisApellido;
    private JPanel txtAsisSucursal;
    private JLabel txtInicioNombre;
    private JTextField txtAsiSucursal;
    private JButton btnRegistrarAsistente;
    private JButton btnRegistrarChofer;
    private JTextField txtChoferCedula;
    private JTextField txtChoferNombre;
    private JTextField txtChoferApellido;
    private JButton btnRegistrarHorario;
    private JTabbedPane tabbedPane3;
    private JTextField txtBuscarUsuario;
    private JButton btnBuscarUsuario;
    private JTextArea txtResultadoBusqueda;
    private JTextArea txtResultadoBuaquedaBuses;
    private JTextField txtBusPlaca;
    private JButton btnBuscarBus;
    private JTabbedPane tabbedPane4;
    private JButton buscarButton;
    private JLabel txtTipoUsuario;
    private JTextField textField1;
    private JButton modificarButton;
    private JButton cancelarButton;
    private JTextField txtBuscarCedula;
    private Validacion validar;
    private GestionUsuario gestionUsuario;
    private GestionBuses gestionBuses;
    private GestionHorarios gestionHorarios;


    public AdministradorCRUD(String title, Usuario usuarioactual) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelUsuario);
        this.pack();
        usuario = usuarioactual;
        this.gestionUsuario = GestionUsuario.getInstancia();
        this.gestionBuses = GestionBuses.getInstancia();
        this.gestionHorarios = GestionHorarios.getInstancia();
        validar = new Validacion();

        txtInicioNombre.setText(usuarioactual.getNombre());
        cargarComboBoxHorario();

        btnRegistrarAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (validar.validarCedula(txtAdminCedula.getText())) {
                    if (txtAdminNombre.getText().isBlank() == false && txtAdminApellido.getText().isBlank() == false) {
                        if (gestionUsuario.addUsuario(new Usuario(txtAdminCedula.getText(), txtAdminNombre.getText(), txtAdminApellido.getText()))) {
                            JOptionPane.showMessageDialog(null, "Usuario creado correctamente");
                        } else {
                            JOptionPane.showMessageDialog(null, "No se pudo crear el usuario, ya existe en la lista");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe llenar los campos Nombre y Apellido");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese una cédula Ecuatoriana valida");
                }

            }
        });
        btnRegistrarAsistente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validar.validarCedula(txtAsisCedula.getText())) {
                    if (txtAsisNombre.getText().isBlank() == false && txtAsisApellido.getText().isBlank() == false && txtAsiSucursal.getText().isBlank() == false) {
                        if (gestionUsuario.addUsuario(new AsistenteAdministrativo(txtAsisCedula.getText(), txtAsisNombre.getText(), txtAsisApellido.getText(), txtAsiSucursal.getText()))) {
                            JOptionPane.showMessageDialog(null, "Usuario creado correctamente");
                        } else {
                            JOptionPane.showMessageDialog(null, "No se pudo crear el usuario, ya existe en la lista");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe llenar los campos Nombre y Apellido");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese una cédula Ecuatoriana valida");
                }
            }
        });

        btnRegistrarChofer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validar.validarCedula(txtChoferCedula.getText())) {
                    if (txtChoferNombre.getText().isBlank() == false && txtChoferApellido.getText().isBlank() == false) {
                        if (gestionUsuario.addUsuario(new Chofer(txtChoferCedula.getText(), txtChoferNombre.getText(), txtChoferApellido.getText(), comboBoxHorarioChofer.getSelectedIndex()))) {
                            System.out.println("El indice del combo box es: " + comboBoxHorarioChofer.getSelectedIndex());
                            JOptionPane.showMessageDialog(null, "Usuario creado correctamente");
                        } else {
                            JOptionPane.showMessageDialog(null, "No se pudo crear el usuario, ya existe en la lista");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe llenar los campos Nombre y Apellido");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese una cédula Ecuatoriana valida");
                }

            }
        });
        btnRegistrarBus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean[] validarTxt = new boolean[7];
                validarTxt[0] = txtPlaca.getText().isBlank();//si es false esta lleno, si es true esta vacio
                validarTxt[1] = txtMatricula.getText().isBlank();
                validarTxt[2] = validar.validacionStringInt(txtKilometraje.getText());
                validarTxt[3] = validar.validacionStringInt(txtNumDefectos.getText());
                validarTxt[4] = validar.validacionStringInt(txtCapacidadPersonas.getText());

                int dia = Integer.parseInt(comboBoxManDia.getSelectedItem().toString());
                System.out.printf("Que día seleciones: " + dia);
                int mes = comboBoxManMes.getSelectedIndex();
                int indice = comboBoxMananio.getSelectedIndex();
                int anio = 122;
                if (indice == 0) {
                    anio = 121;
                } else if (indice == 1) {
                    anio = 122;
                } else {
                    anio = 123;
                }

                if (validarTxt[0] == false && validarTxt[1] == false && validarTxt[2] && validarTxt[3] && validarTxt[4]) {
                    if (gestionBuses.addBus(new Bus(txtPlaca.getText(), txtMatricula.getText(), Integer.parseInt(txtKilometraje.getText()), new Date(anio, mes, dia), Integer.parseInt(txtNumDefectos.getText()), Integer.parseInt(txtCapacidadPersonas.getText())))) {
                        JOptionPane.showMessageDialog(null, "Bus ingresado correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "Bus no ingresado, ya existe en la lista");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Verifique que est llenando todos los campos y colocando correctamente los valores numericos");
                }

            }
        });
        btnRegistrarHorario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int horainicio = Integer.parseInt(ComboBoxHin.getSelectedItem().toString());
                int minutoinicio = Integer.parseInt(ComboBoxMin.getSelectedItem().toString());
                int horafin = Integer.parseInt(ComboBoxHfin.getSelectedItem().toString());
                int minutofin = Integer.parseInt(ComoboBoxMfin.getSelectedItem().toString());

                if (gestionHorarios.addHorario(new Horario(ComoboBoxMfin.getSelectedIndex(), LocalTime.of(horainicio, minutoinicio, 00), LocalTime.of(horafin, minutofin, 00)))) {
                    JOptionPane.showMessageDialog(null, "Registro de horario correcto");
                    cargarComboBoxHorario();
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo registrar el horario, ya existe un horario con esos parametros");
                }


            }
        });
        btnBuscarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usuario usuario1 = gestionUsuario.busquedaUsuario(txtBuscarUsuario.getText());
                if (validar.validarCedula(txtBuscarUsuario.getText())) {
                    if (usuario1 != null) {
                        txtResultadoBusqueda.setText(usuario1.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontraron coincidencias");
                    }

                }

            }
        });
        btnBuscarBus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Bus bus1 = gestionBuses.busquedaBus(txtBusPlaca.getText());

                if (bus1 != null) {
                    txtResultadoBuaquedaBuses.setText(bus1.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontraron coincidencias");
                }


            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usuario usuario1 = gestionUsuario.busquedaUsuario(txtBuscarCedula.getText());
                if (usuario1 == null) {
                    JOptionPane.showMessageDialog(null, "No se encontraron coincidencias de busqueda");
                } else {
                    if (usuario1 instanceof Usuario) {

                    } else if (usuarioactual instanceof Usuario) {

                    }
                }
            }
        });

    }

    private void cargarComboBoxHorario(){
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        comboBoxHorarioChofer.setModel(comboBoxModel);
        List<String> nombres= GestionHorarios.getInstancia().detalleHorario();//gestion
        String nombre="";
        for (int i=0;i<nombres.size();i++) {
            nombre=nombres.get(i);
            comboBoxModel.addElement(nombre);
        }

         }
    }





