package modelo.dao;

import modelo.conexion.ConexionBD;
import modelo.dto.MascotaDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MascotaDAO {

    public boolean registrarMascota(MascotaDTO mascota) {
        String sql = "INSERT INTO mascota (codigo, nombre, especie, raza, edad, documento_propietario) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, mascota.getCodigo());
            ps.setString(2, mascota.getNombre());
            ps.setString(3, mascota.getEspecie());
            ps.setString(4, mascota.getRaza());
            ps.setInt(5, mascota.getEdad());
            ps.setString(6, mascota.getDocumentoPropietario());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al registrar mascota: " + e.getMessage());
            return false;
        }
    }

    public MascotaDTO consultarMascota(String codigo) {
        String sql = "SELECT * FROM mascota WHERE codigo = ?";
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new MascotaDTO(
                        rs.getString("codigo"),
                        rs.getString("nombre"),
                        rs.getString("especie"),
                        rs.getString("raza"),
                        rs.getInt("edad"),
                        rs.getString("documento_propietario")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar mascota: " + e.getMessage());
        }
        return null;
    }

    public boolean actualizarMascota(MascotaDTO mascota) {
        String sql = "UPDATE mascota SET nombre=?, especie=?, raza=?, edad=?, documento_propietario=? WHERE codigo=?";
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, mascota.getNombre());
            ps.setString(2, mascota.getEspecie());
            ps.setString(3, mascota.getRaza());
            ps.setInt(4, mascota.getEdad());
            ps.setString(5, mascota.getDocumentoPropietario());
            ps.setString(6, mascota.getCodigo());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar mascota: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarMascota(String codigo) {
        String sql = "DELETE FROM mascota WHERE codigo=?";
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, codigo);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar mascota: " + e.getMessage());
            return false;
        }
    }

    public List<MascotaDTO> listarMascotas() {
        List<MascotaDTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM mascota";
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new MascotaDTO(
                        rs.getString("codigo"),
                        rs.getString("nombre"),
                        rs.getString("especie"),
                        rs.getString("raza"),
                        rs.getInt("edad"),
                        rs.getString("documento_propietario")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar mascotas: " + e.getMessage());
        }
        return lista;
    }
}
