/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Assignment4 extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        Parent gp = FXMLLoader.load(getClass().getResource("LayoutGUI.fxml"));
        stage.setScene(new Scene(gp, 600,400));
        stage.setTitle("My Calculator");
        stage.show();
    }
    
    
}
