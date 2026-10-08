/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.netjags.inversionesmagdezis.model;

/**
 *
 * @author informatica
 */
public class Usuario {

    String nombre;
    String apellido;
    String idUsuario;    
    int idRol;
    String correo;
    String contrasenaHash;

    public Usuario(String nombre, String apellido, String idUsuario, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.idUsuario = idUsuario;
        this.idRol = idRol;
        this.correo = correo;
        this.contrasenaHash = contrasenaHash;
    }   
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenaHash() {
        return contrasenaHash;
    }

    public void setContrasenaHash(String contrasenaHash) {
        this.contrasenaHash = contrasenaHash;
    }

    
    
    
}
