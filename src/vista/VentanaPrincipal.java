package vista;

import controlador.Coordinador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {
    private Coordinador coordinador;
    private JButton btnPersonas, btnMascotas;

    public VentanaPrincipal() {
        setTitle("Clínica Veterinaria ABC - Menú Principal");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelTitulo = new JPanel();
        JLabel titulo = new JLabel("Sistema de Gestión Clínica Veterinaria", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        panelTitulo.add(titulo);
        add(panelTitulo, BorderLayout.NORTH);

        JPanel panelFondo = new PanelConFondo();
        panelFondo.setLayout(new BorderLayout());

        JPanel panelCentral = new JPanel();
        panelCentral.setOpaque(false);
        panelCentral.setLayout(new BorderLayout());

        panelCentral.add(Box.createVerticalStrut(50), BorderLayout.NORTH);

        JPanel panelBotones = new JPanel(new GridLayout(1, 2, 10, 0));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
        panelBotones.setOpaque(false);

        btnPersonas = new JButton("Gestionar Personas");
        btnMascotas = new JButton("Gestionar Mascotas");

        btnPersonas.setPreferredSize(new Dimension(180, 40));
        btnMascotas.setPreferredSize(new Dimension(180, 40));

        panelBotones.add(btnPersonas);
        panelBotones.add(btnMascotas);

        panelCentral.add(panelBotones, BorderLayout.SOUTH);
        panelFondo.add(panelCentral, BorderLayout.CENTER);

        add(panelFondo, BorderLayout.CENTER);

        btnPersonas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                coordinador.mostrarVentanaPersonas();
            }
        });

        btnMascotas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                coordinador.mostrarVentanaMascotas();
            }
        });
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    private class PanelConFondo extends JPanel {
        private Image imagenFondo;

        public PanelConFondo() {
            try {
                ImageIcon icono = new ImageIcon(getClass().getResource("/imagen/imagen.jpg"));
                imagenFondo = icono.getImage();
            } catch (Exception e) {
                try {
                    ImageIcon icono = new ImageIcon("src/imagen/imagen.jpg");
                    imagenFondo = icono.getImage();
                } catch (Exception ex) {
                    imagenFondo = null;
                }
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (imagenFondo != null) {
                g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
            } else {
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(
                        0, 0, new Color(135, 206, 235),
                        0, getHeight(), new Color(255, 182, 193)
                );
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        }
    }
}