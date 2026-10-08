/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.netjags.inversionesmagdezis.repository;

import main.java.com.netjags.inversionesmagdezis.model.Usuario;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import main.java.com.netjags.inversionesmagdezis.config.DBConnection;
import main.java.com.netjags.inversionesmagdezis.service.AuthService;

 /*
 * @author informatica
 */
public class UsuarioRepository {

        public UsuarioRepository(){
    
    }
    
    public boolean registerUser(Usuario usuario, String rol) {
        String sql = "INSERT INTO usuarios (?,?,?,?,?,?)";
        
        try (Connection conn = DBConnection.getDBConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)) {
            
            pstm.setString(1, usuario.getNombre());
            pstm.setString(2, usuario.getApellido()); 
            pstm.setString(3, usuario.getIdUsuario());
            pstm.setInt(4, usuario.getIdRol());
            pstm.setString(5, usuario.getCorreo());
            pstm.setString(6, usuario.getContrasenaHash());
            
            int filasAfectadas = pstm.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Usuario findByEmail(String email) {
        String sql = "SELECT * FROM usuarios WHERE correo = ?";
        
        try (Connection conn = DBConnection.getDBConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)) {
            
            pstm.setString(1, email);
            ResultSet rs = pstm.executeQuery();
            
            if (rs.next()) {
                return new Usuario(
                    String.valueOf(rs.getInt("id_usuario")),
                    rs.getString("nombre"),
                    rs.getString("correo"),
                    rs.getString("contrasena")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String obtenerRolPorEmail(String email) {
        String sql = "SELECT r.nombre FROM roles r JOIN usuarios u ON u.rol_id = r.id WHERE u.correo = ?";
        
        try (Connection conn = DBConnection.getDBConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)) {
            
            pstm.setString(1, email);
            ResultSet rs = pstm.executeQuery();
            
            if (rs.next()) {
                return rs.getString("nombre"); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "USER"; 
    }
}