/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package main.java.com.netjags.inversionesmagdezis.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.java.com.netjags.inversionesmagdezis.service.AuthService;

/**
 * FXML Controller class
 *
 * @author informatica
 */
public class LoginController {

    @FXML
    private TextField txtEmail;
    @FXML
    private PasswordField txtContrasena;
    
    private final AuthService authService = new AuthService();

    @FXML
    public void handleLogin() {
        String email = txtEmail.getText().trim();
        String contrasena = txtContrasena.getText().trim();

        if (email.isEmpty() || contrasena.isEmpty()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Los campos no pueden estar vacios", "Complete los campos e intente otra vez.");
            return;
        }

        AuthService.AuthRS resultado = authService.autenticar(email, contrasena);

        
        if (resultado.esVerdadero()) {
            mostrarAlerta(
                Alert.AlertType.INFORMATION, 
                "Inicio de Sesión Exitoso - Inversiones Magdezis",
                
                "¡Bienvenido seas, " + resultado.getUsuario().getNombre() +
                        
                "Usted tiene el rol de: " + resultado.getRol()
            );

        } else {
            mostrarAlerta(Alert.AlertType.ERROR, "error al intentar acceso", "El correo o contraseña posiblemente sean incorrectos.");
        }
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    
    
}

