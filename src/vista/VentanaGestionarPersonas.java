package vista;

import controlador.Coordinador;
import modelo.dto.PersonaDTO;

import javax.swing.*;
import java.awt.*;

public class VentanaGestionarPersonas extends JFrame {
    private Coordinador coordinador;

    private JTextField txtDocumento, txtNombre, txtApellido, txtTelefono, txtDireccion;
    private JTextArea areaResultado;
    private JButton btnRegistrar, btnConsultar, btnActualizar, btnEliminar, btnListar;

    public VentanaGestionarPersonas() {
        setTitle("Gestión de Personas");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel panelCampos = new JPanel(new GridLayout(5, 2, 10, 10));
        panelCampos.setBorder(BorderFactory.createTitledBorder("Datos de la Persona"));

        panelCampos.add(new JLabel("Documento:"));
        txtDocumento = new JTextField();
        panelCampos.add(txtDocumento);

        panelCampos.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelCampos.add(txtNombre);

        panelCampos.add(new JLabel("Apellido:"));
        txtApellido = new JTextField();
        panelCampos.add(txtApellido);

        panelCampos.add(new JLabel("Teléfono:"));
        txtTelefono = new JTextField();
        panelCampos.add(txtTelefono);

        panelCampos.add(new JLabel("Dirección:"));
        txtDireccion = new JTextField();
        panelCampos.add(txtDireccion);

        add(panelCampos, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        btnRegistrar = new JButton("Registrar");
        btnConsultar = new JButton("Consultar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        btnListar = new JButton("Listar");

        panelBotones.add(btnRegistrar);
        panelBotones.add(btnConsultar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnListar);

        add(panelBotones, BorderLayout.CENTER);

        areaResultado = new JTextArea(8, 50);
        areaResultado.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaResultado);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Resultado"));
        add(scrollPane, BorderLayout.SOUTH);

        // Listeners
        btnRegistrar.addActionListener(e -> registrar());
        btnConsultar.addActionListener(e -> consultar());
        btnActualizar.addActionListener(e -> actualizar());
        btnEliminar.addActionListener(e -> eliminar());
        btnListar.addActionListener(e -> listar());
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    private PersonaDTO obtenerDatos() {
        return new PersonaDTO(
                txtDocumento.getText(),
                txtNombre.getText(),
                txtApellido.getText(),
                txtTelefono.getText(),
                txtDireccion.getText()
        );
    }

    private void registrar() {
        PersonaDTO persona = obtenerDatos();
        areaResultado.setText(coordinador.registrarPersona(persona));
    }

    private void consultar() {
        areaResultado.setText(coordinador.consultarPersona(txtDocumento.getText()));
    }

    private void actualizar() {
        PersonaDTO persona = obtenerDatos();
        areaResultado.setText(coordinador.actualizarPersona(persona));
    }

    private void eliminar() {
        areaResultado.setText(coordinador.eliminarPersona(txtDocumento.getText()));
    }

    private void listar() {
        areaResultado.setText(coordinador.listarPersonas());
    }
}
