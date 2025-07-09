package vista;

import controlador.Coordinador;
import modelo.dto.MascotaDTO;

import javax.swing.*;
import java.awt.*;

public class VentanaGestionarMascotas extends JFrame {
    private Coordinador coordinador;

    private JTextField txtCodigo, txtNombre, txtEspecie, txtRaza, txtEdad, txtDocumentoDueno;
    private JTextArea areaResultado;
    private JButton btnRegistrar, btnConsultar, btnActualizar, btnEliminar, btnListar;

    public VentanaGestionarMascotas() {
        setTitle("Gestión de Mascotas");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel panelCampos = new JPanel(new GridLayout(6, 2, 10, 10));
        panelCampos.setBorder(BorderFactory.createTitledBorder("Datos de la Mascota"));

        panelCampos.add(new JLabel("Código:"));
        txtCodigo = new JTextField();
        panelCampos.add(txtCodigo);

        panelCampos.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelCampos.add(txtNombre);

        panelCampos.add(new JLabel("Especie:"));
        txtEspecie = new JTextField();
        panelCampos.add(txtEspecie);

        panelCampos.add(new JLabel("Raza:"));
        txtRaza = new JTextField();
        panelCampos.add(txtRaza);

        panelCampos.add(new JLabel("Edad:"));
        txtEdad = new JTextField();
        panelCampos.add(txtEdad);

        panelCampos.add(new JLabel("Documento del Dueño:"));
        txtDocumentoDueno = new JTextField();
        panelCampos.add(txtDocumentoDueno);

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

    private MascotaDTO obtenerDatos() {
        int edad;
        try {
            edad = Integer.parseInt(txtEdad.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La edad debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        return new MascotaDTO(
                txtCodigo.getText(),
                txtNombre.getText(),
                txtEspecie.getText(),
                txtRaza.getText(),
                edad,
                txtDocumentoDueno.getText()
        );
    }

    private void registrar() {
        MascotaDTO mascota = obtenerDatos();
        if (mascota != null) {
            areaResultado.setText(coordinador.registrarMascota(mascota));
        }
    }

    private void consultar() {
        areaResultado.setText(coordinador.consultarMascota(txtCodigo.getText()));
    }

    private void actualizar() {
        MascotaDTO mascota = obtenerDatos();
        if (mascota != null) {
            areaResultado.setText(coordinador.actualizarMascota(mascota));
        }
    }

    private void eliminar() {
        areaResultado.setText(coordinador.eliminarMascota(txtCodigo.getText()));
    }

    private void listar() {
        areaResultado.setText(coordinador.listarMascotas());
    }
}
