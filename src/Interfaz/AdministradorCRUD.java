package Interfaz;
import ClaseOperacionales.GestionBuses;
import ClaseOperacionales.GestionHorarios;
import ClaseOperacionales.GestionRutas;
import ClaseOperacionales.GestionUsuario;
import Clases.*;
import Clases.Ruta;
import Grafo.Vertice;
import Validaciones.Validacion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.Date;
import java.util.Dictionary;
import java.util.Enumeration;
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
    private JTextField txtBuscarUsuario;
    //private JButton btnBuscarUsuario;
    private JTextArea txtResultadoBusqueda;
    private JTextArea txtResultadoBuaquedaBuses;
    private JTextField txtBusPlaca;
    //private JButton btnBuscarBus;
    private JTabbedPane tabbedPane4;
    private JButton buscarButton;
    private JLabel txtTipoUsuario;
    private JTextField txtSucursal;
    private JButton modificarButton;
    private JButton cancelarButton;
    private JTextField txtBuscarCedula;

    private JTextField txtNomb;
    private JTextField txtApell;
    private JComboBox JcomboBoxHorario;
    private JPanel JPanelSucursal;
    private JPanel JPanelHorario;

    private JTabbedPane tabbedPane3;
    private JComboBox comboBoxUsuarios;
    private JButton buscarUsuarios;
    private JButton mostrarUsuarios;
    private JTextArea txtMostrarUsuariosOrdenados;
    private JComboBox comboBoxBuses;
    private JButton mostrarBuses;
    private JTextField txtBuscarBus;
    private JButton buscarBuses;
    private JTextArea txtMostrarBusesOrdenados;
    private JComboBox comboBoxHorarios;
    private JButton mostrarHorarios;
    private JTextField txtBuscarHorario;
    private JButton buscarHorarios;
    private JTextArea txtMostrarHorariosOrdenados;
    private JTextField txtOrigen;
    private JTextField txtDestino;
    private JComboBox cmbHoras;

    private JComboBox cmbMinutos;
    private JButton btnIngresarRuta;
    private JTextField VerticetextField1;
    private JButton insertarButton;
    private JComboBox VerticeIniciocomboBox1;
    private JComboBox VerticeFinalcomboBox1;
    private JTextField PesotextField1;
    private JButton insertarButton1;
    private JButton mostrarRutaButton;
    private JComboBox BusVerticeInicialcomboBox1;
    private JButton DIJASKSTRAButton;
    private JTextArea textArea1;
    private JPanel PanelGrafo;

    private JButton aceptarButton;


    private Validacion validar;
    private GestionUsuario gestionUsuario;
    private GestionBuses gestionBuses;
    private GestionHorarios gestionHorarios;
    private Ruta ruta;


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
        ruta=null;
        JPanelSucursal.setVisible(false);
        JPanelHorario.setVisible(false);
        PanelGrafo.setVisible(false);

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

        /*btnBuscarUsuario.addActionListener(new ActionListener() {

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
        });*/
        /*btnBuscarBus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Bus bus1 = gestionBuses.busquedaBus(txtBusPlaca.getText());

                if (bus1 != null) {
                    txtResultadoBuaquedaBuses.setText(bus1.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontraron coincidencias");
                }


            }
        });*/
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usuario usuario1 = gestionUsuario.busquedaUsuario(txtBuscarCedula.getText());

                if (usuario1 == null) {
                    JOptionPane.showMessageDialog(null, "No se encontraron coincidencias de busqueda");
                } else {
                    if (usuario1 instanceof AsistenteAdministrativo) {
                        AsistenteAdministrativo as = (AsistenteAdministrativo) usuario1;
                        txtTipoUsuario.setText("Asistente Administrativo");
                        JPanelSucursal.setVisible(true);
                        txtNomb.setText(usuario1.getNombre());
                        txtApell.setText(usuario1.getApellido());
                        txtSucursal.setText(as.getSucursal());


                    } else if (usuario1 instanceof Chofer) {
                        JPanelHorario.setVisible(true);
                        txtTipoUsuario.setText("Chofer");
                        txtNomb.setText(usuario1.getNombre());
                        txtApell.setText(usuario1.getApellido());
                        Chofer chofer1 = (Chofer) usuario1;
                        cargarComboBoxHorario();
                    } else
                        txtNomb.setText(usuario1.getNombre());
                    txtApell.setText(usuario1.getApellido());

                }
            }
        });


        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usuario usuario1 = gestionUsuario.busquedaUsuario(txtBuscarCedula.getText());
                if (usuario1 instanceof AsistenteAdministrativo) {
                    AsistenteAdministrativo as = (AsistenteAdministrativo) usuario1;
                    gestionUsuario.modificarAsistente(txtBuscarCedula.getText(), txtNomb.getText(), txtApell.getText(), txtSucursal.getText());
                    txtBuscarCedula.setText("");
                    txtNomb.setText("");
                    txtApell.setText("");
                    JPanelSucursal.setVisible(false);
                    JPanelHorario.setVisible(false);
                    txtTipoUsuario.setText("Usuario");
                } else if (usuario1 instanceof Chofer) {
                    Chofer chofer1 = (Chofer) usuario1;
                    gestionUsuario.modificarChofer(txtBuscarCedula.getText(), txtNomb.getText(), txtApell.getText(), JcomboBoxHorario.getSelectedIndex());
                    txtBuscarCedula.setText("");
                    txtNomb.setText("");
                    txtApell.setText("");
                    JPanelSucursal.setVisible(false);
                    JPanelHorario.setVisible(false);
                    txtTipoUsuario.setText("Usuario");
                } else
                    gestionUsuario.modificarUsuario(txtBuscarCedula.getText(), txtNomb.getText(), txtApell.getText());
                txtBuscarCedula.setText("");
                txtNomb.setText("");
                txtApell.setText("");
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtBuscarCedula.setText("");
                txtNomb.setText("");
                txtApell.setText("");
                JPanelSucursal.setVisible(false);
                JPanelHorario.setVisible(false);
                txtTipoUsuario.setText("Usuario");
            }
        });

        mostrarUsuarios.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        txtMostrarUsuariosOrdenados.setText(gestionUsuario.MostrarUsuarios(comboBoxUsuarios.getSelectedIndex()));
                    }
                });
        buscarUsuarios.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (txtBuscarUsuario.getText().equals("")) {
                            txtMostrarUsuariosOrdenados.setText("Ingrese un dato a buscar");
                            return;
                        }

                        Usuario usuario = gestionUsuario.buscarUsuarioBinario(txtBuscarUsuario.getText(), comboBoxUsuarios.getSelectedIndex());

                        if (usuario == null) {
                            txtMostrarUsuariosOrdenados.setText("No se encontro el usuario");
                        } else {
                            txtMostrarUsuariosOrdenados.setText(usuario.toString());
                        }
                    }
                });
        mostrarBuses.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        txtMostrarBusesOrdenados.setText(gestionBuses.MostrarBuses(comboBoxBuses.getSelectedIndex()));
                    }
                });
        buscarBuses.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (txtBuscarBus.getText().equals("")) {
                            txtMostrarBusesOrdenados.setText("Ingrese un dato a buscar");
                            return;
                        }

                        Bus bus1 = gestionBuses.buscarBusesBinario(txtBuscarBus.getText(), comboBoxBuses.getSelectedIndex());

                        if (bus1 == null) {
                            txtMostrarBusesOrdenados.setText("No se encontro el bus");
                        } else {
                            txtMostrarBusesOrdenados.setText(bus1.toString());
                        }
                    }

                });
        mostrarHorarios.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        txtMostrarHorariosOrdenados.setText(gestionHorarios.MostrarHorarios(comboBoxHorarios.getSelectedIndex()));
                    }
                });
        buscarHorarios.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (txtBuscarHorario.getText().equals("")) {
                            txtMostrarHorariosOrdenados.setText("Ingrese un dato a buscar");
                            return;
                        }

                        Horario horario1 = gestionHorarios.buscarUsuarioBinario(txtBuscarBus.getText(), comboBoxHorarios.getSelectedIndex());

                        if (horario1 == null) {
                            txtMostrarHorariosOrdenados.setText("No se encontro el horario");
                        } else {
                            txtMostrarHorariosOrdenados.setText(horario1.toString());
                        }

                    }
                });
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
                    JOptionPane.showMessageDialog(null, "No se puede agregar la parada, complete el campo de pesa");
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
                Dictionary[] result = ruta.getGrafoRuta().Dijsktra(ruta.getGrafoRuta().getVertexByValue(BusVerticeInicialcomboBox1.getSelectedItem().toString()));
                Dictionary<String, Integer> distances = result[0];
                Dictionary<String, Vertice> previous = result[1];

                StringBuilder resultText = new StringBuilder();
                Enumeration<String> keys = distances.keys(); // Obtener las claves usando keys()
                while (keys.hasMoreElements()) {
                    String vertexData = keys.nextElement();
                    int distance = distances.get(vertexData);
                    Vertice previousVertex = previous.get(vertexData);

                    resultText.append("Vertice: ").append(vertexData).append("\n");
                    resultText.append("Distancia: ").append(distance).append("\n");
                    resultText.append("Vértice previo: ").append(previousVertex.getDato()).append("\n");
                    resultText.append("-------------------\n");
                }
                textArea1.setText(resultText.toString());
            }
        });
    }

            private void cargarComboBoxHorario() {
                DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
                comboBoxHorarioChofer.setModel(comboBoxModel);
                JcomboBoxHorario.setModel(comboBoxModel);
                List<String> nombres = GestionHorarios.getInstancia().detalleHorario();//gestion
                String nombre = "";
                for (int i = 0; i < nombres.size(); i++) {
                    nombre = nombres.get(i);
                    comboBoxModel.addElement(nombre);
                }

            }
            private void cargarComboBox(){
                DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
                DefaultComboBoxModel<String> comboBoxModel2 = new DefaultComboBoxModel<>();
                DefaultComboBoxModel<String> comboBoxModel3 = new DefaultComboBoxModel<>();
                VerticeIniciocomboBox1.setModel(comboBoxModel);
                VerticeFinalcomboBox1.setModel(comboBoxModel2);
                BusVerticeInicialcomboBox1.setModel(comboBoxModel3);
                for (Vertice vertice : ruta.getGrafoRuta().getVertices() ) {
                    String data = vertice.getDato();
                    comboBoxModel.addElement(data);
                    comboBoxModel2.addElement(data);
                    comboBoxModel3.addElement(data);
                }
    }

        }





