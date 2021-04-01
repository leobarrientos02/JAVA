/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week9_lab;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

/**
 *
 * @author leoba
 */


public class Week9_lab extends Application{

    /**
     * @param args the command line arguments
     */
    
    public Circle circle1 = new Circle(300,250,200);
    
    public Circle[] points = {new Circle(300,50,10), new Circle(300,450,10), new Circle(100,250,10)};

    public Line[] lines = {new Line(),new Line(), new Line()};
    
    public String[] angles = {new String(), new String(), new String()}; 
    
    public void Lines(){

            lines[0].setStartX(points[0].getCenterX());
            lines[0].setStartY(points[0].getCenterY());
            lines[0].setEndX(points[1].getCenterX());
            lines[0].setEndY(points[1].getCenterY());    
            
            lines[1].setStartX(points[0].getCenterX());
            lines[1].setStartY(points[0].getCenterY());
            lines[1].setEndX(points[2].getCenterX());
            lines[1].setEndY(points[2].getCenterY());  
           
            lines[2].setStartX(points[1].getCenterX());
            lines[2].setStartY(points[1].getCenterY());
            lines[2].setEndX(points[2].getCenterX());
            lines[2].setEndY(points[2].getCenterY());  
    }
    @Override
    public void start(Stage stage) throws Exception {
        
        // Create a root group
        Group root = new Group();
        
        // Design big circle
        circle1.setStroke(Color.BLACK);
        circle1.setFill(Color.WHITE);
        root.getChildren().add(circle1);
        
        // Set the lines
        Lines();
        root.getChildren().add(lines[0]);
        root.getChildren().add(lines[1]);
        root.getChildren().add(lines[2]);
        
        // Design the points
        for(int i=0; i<3;i++){
            points[i].setStroke(Color.BLACK);
            points[i].setFill(Color.RED);
            root.getChildren().add(points[i]);
        }
        
        // This set the scene and displays it
        Scene scene = new Scene( root, 600, 500, Color.WHITE);
        stage.setTitle("Week9_Lab");
        stage.setScene(scene);
        stage.show();
        
    }
    
    
    public static void main(String[] args)  {
        launch(args);
    }
}
