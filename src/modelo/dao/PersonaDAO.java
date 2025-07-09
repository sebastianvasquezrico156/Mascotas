package modelo.dao;

import modelo.conexion.ConexionBD;
import modelo.dto.PersonaDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {

    public boolean registrarPersona(PersonaDTO persona) {
        String sql = "INSERT INTO persona (documento, nombre, apellido, telefono, direccion) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, persona.getDocumento());
            ps.setString(2, persona.getNombre());
            ps.setString(3, persona.getApellido());
            ps.setString(4, persona.getTelefono());
            ps.setString(5, persona.getDireccion());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al registrar persona: " + e.getMessage());
            return false;
        }
    }

    public PersonaDTO consultarPersona(String documento) {
        String sql = "SELECT * FROM persona WHERE documento = ?";
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, documento);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new PersonaDTO(
                        rs.getString("documento"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("telefono"),
                        rs.getString("direccion")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar persona: " + e.getMessage());
        }
        return null;
    }

    public boolean actualizarPersona(PersonaDTO persona) {
        String sql = "UPDATE persona SET nombre=?, apellido=?, telefono=?, direccion=? WHERE documento=?";
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setString(3, persona.getTelefono());
            ps.setString(4, persona.getDireccion());
            ps.setString(5, persona.getDocumento());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar persona: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarPersona(String documento) {
        String sql = "DELETE FROM persona WHERE documento=?";
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, documento);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar persona: " + e.getMessage());
            return false;
        }
    }

    public List<PersonaDTO> listarPersonas() {
        List<PersonaDTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM persona";
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new PersonaDTO(
                        rs.getString("documento"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("telefono"),
                        rs.getString("direccion")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar personas: " + e.getMessage());
        }
        return lista;
    }
}
