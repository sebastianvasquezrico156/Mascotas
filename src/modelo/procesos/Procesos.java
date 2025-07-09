package modelo.procesos;

import modelo.dao.PersonaDAO;
import modelo.dao.MascotaDAO;
import modelo.dto.PersonaDTO;
import modelo.dto.MascotaDTO;

import java.util.List;

public class Procesos {
    private PersonaDAO personaDAO = new PersonaDAO();
    private MascotaDAO mascotaDAO = new MascotaDAO();

    // Procesos Personas
    public String registrarPersona(PersonaDTO persona) {
        boolean exito = personaDAO.registrarPersona(persona);
        return exito ? "Persona registrada con éxito.\n" + persona
                : "Error al registrar la persona.";
    }

    public String consultarPersona(String documento) {
        PersonaDTO persona = personaDAO.consultarPersona(documento);
        return persona != null ? persona.toString() : "La persona no se encuentra registrada.";
    }

    public String actualizarPersona(PersonaDTO persona) {
        boolean exito = personaDAO.actualizarPersona(persona);
        return exito ? "Persona actualizada correctamente.\n" + persona
                : "No se pudo actualizar la persona.";
    }

    public String eliminarPersona(String documento) {
        boolean exito = personaDAO.eliminarPersona(documento);
        return exito ? "Persona eliminada exitosamente." : "No se pudo eliminar la persona.";
    }

    public String listarPersonas() {
        List<PersonaDTO> lista = personaDAO.listarPersonas();
        if (lista.isEmpty()) return "No existen personas registradas.";
        StringBuilder sb = new StringBuilder("Lista de personas:\n");
        for (PersonaDTO p : lista) sb.append(p).append("\n");
        return sb.toString();
    }

    // Procesos Mascotas
    public String registrarMascota(MascotaDTO mascota) {
        PersonaDTO propietario = personaDAO.consultarPersona(mascota.getDocumentoPropietario());
        if (propietario == null) {
            return "No se puede registrar la mascota. El dueño no está registrado.";
        }
        boolean exito = mascotaDAO.registrarMascota(mascota);
        return exito ? "Mascota registrada con éxito.\nDueño: " + propietario.getNombre() + "\n" + mascota
                : "Error al registrar la mascota.";
    }

    public String consultarMascota(String codigo) {
        MascotaDTO mascota = mascotaDAO.consultarMascota(codigo);
        if (mascota != null) {
            PersonaDTO propietario = personaDAO.consultarPersona(mascota.getDocumentoPropietario());
            String nombreDueno = propietario != null ? propietario.getNombre() + " " + propietario.getApellido()
                    : "Dueño no encontrado";
            return mascota.toString() + "Dueño: " + nombreDueno;
        } else {
            return "La mascota no está registrada.";
        }
    }

    public String actualizarMascota(MascotaDTO mascota) {
        boolean exito = mascotaDAO.actualizarMascota(mascota);
        return exito ? "Mascota actualizada correctamente.\n" + mascota
                : "No se pudo actualizar la mascota.";
    }

    public String eliminarMascota(String codigo) {
        boolean exito = mascotaDAO.eliminarMascota(codigo);
        return exito ? "Mascota eliminada exitosamente." : "No se pudo eliminar la mascota.";
    }

    public String listarMascotas() {
        List<MascotaDTO> lista = mascotaDAO.listarMascotas();
        if (lista.isEmpty()) return "No existen mascotas registradas.";
        StringBuilder sb = new StringBuilder("Lista de mascotas:\n");
        for (MascotaDTO m : lista) sb.append(m).append("\n");
        return sb.toString();
    }
}
