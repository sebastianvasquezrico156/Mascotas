package controlador;

import vista.VentanaGestionarMascotas;
import vista.VentanaGestionarPersonas;
import vista.VentanaPrincipal;

public class Principal {
    private Coordinador coordinador;
    private VentanaPrincipal ventanaPrincipal;
    private VentanaGestionarPersonas ventanaPersonas;
    private VentanaGestionarMascotas ventanaMascotas;

    public Principal() {
        coordinador = new Coordinador();

        ventanaPrincipal = new VentanaPrincipal();
        ventanaPersonas = new VentanaGestionarPersonas();
        ventanaMascotas = new VentanaGestionarMascotas();

        // Inyectar Coordinador
        ventanaPrincipal.setCoordinador(coordinador);
        ventanaPersonas.setCoordinador(coordinador);
        ventanaMascotas.setCoordinador(coordinador);

        // Inyectar ventanas al Coordinador
        coordinador.setVentanaPrincipal(ventanaPrincipal);
        coordinador.setVentanaPersonas(ventanaPersonas);
        coordinador.setVentanaMascotas(ventanaMascotas);
    }

    public void iniciarAplicacion() {
        ventanaPrincipal.setVisible(true);
    }
}
