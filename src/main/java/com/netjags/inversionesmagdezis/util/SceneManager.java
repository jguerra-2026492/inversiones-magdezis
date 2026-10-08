/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.netjags.inversionesmagdezis.util;

import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.com.netjags.inversionesmagdezis.controller.LoginController;
import main.java.com.netjags.inversionesmagdezis.repository.AuthRepository;
import main.java.com.netjags.inversionesmagdezis.repository.UsuarioRepository;
import main.java.com.netjags.inversionesmagdezis.service.AuthService;

/**
 *
 * @author informatica
 */
public class SceneManager {
    
        private static Stage stage;
        private final String FXML_PATH = ".../main/resources/view/login-view.fxml";

    
     public void showLoginView()throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource(FXML_PATH + "login-view.fxml"));
        loader.setControllerFactory(
        clazz->{
            if(clazz == LoginController.class){
                UsuarioRepository usuarioRepository = new UsuarioRepository();
                AuthService authService = new AuthService(usuarioRepository);
                return new LoginController(authService, this);
            }
            try{
                return clazz.getDeclaredConstructor().newInstance();
            }catch(Exception e){
                throw new RuntimeException("Error al crear el constructor" + e.getMessage());
        }
        });
        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 400);
        Stage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

}
