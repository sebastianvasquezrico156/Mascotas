package controlador;

import modelo.dto.PersonaDTO;
import modelo.dto.MascotaDTO;
import modelo.procesos.Procesos;
import vista.VentanaGestionarPersonas;
import vista.VentanaGestionarMascotas;
import vista.VentanaPrincipal;

public class Coordinador {

    private Procesos procesos;
    private VentanaPrincipal ventanaPrincipal;
    private VentanaGestionarPersonas ventanaPersonas;
    private VentanaGestionarMascotas ventanaMascotas;

    public Coordinador() {
        procesos = new Procesos();
    }

    // Métodos de control para vistas
    public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }

    public void setVentanaPersonas(VentanaGestionarPersonas ventanaPersonas) {
        this.ventanaPersonas = ventanaPersonas;
    }

    public void setVentanaMascotas(VentanaGestionarMascotas ventanaMascotas) {
        this.ventanaMascotas = ventanaMascotas;
    }

    public void mostrarVentanaPersonas() {
        ventanaPersonas.setVisible(true);
    }

    public void mostrarVentanaMascotas() {
        ventanaMascotas.setVisible(true);
    }

    // Delegación a Procesos (personas)
    public String registrarPersona(PersonaDTO p) {
        return procesos.registrarPersona(p);
    }

    public String consultarPersona(String documento) {
        return procesos.consultarPersona(documento);
    }

    public String actualizarPersona(PersonaDTO p) {
        return procesos.actualizarPersona(p);
    }

    public String eliminarPersona(String documento) {
        return procesos.eliminarPersona(documento);
    }

    public String listarPersonas() {
        return procesos.listarPersonas();
    }

    // Delegación a Procesos (mascotas)
    public String registrarMascota(MascotaDTO m) {
        return procesos.registrarMascota(m);
    }

    public String consultarMascota(String codigo) {
        return procesos.consultarMascota(codigo);
    }

    public String actualizarMascota(MascotaDTO m) {
        return procesos.actualizarMascota(m);
    }

    public String eliminarMascota(String codigo) {
        return procesos.eliminarMascota(codigo);
    }

    public String listarMascotas() {
        return procesos.listarMascotas();
    }
}
