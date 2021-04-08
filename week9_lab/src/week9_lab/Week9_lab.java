/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week9_lab;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author leoba
 */


public class Week9_lab extends Application{

    /**
     * @param args the command line arguments
     */
    
    private Circle circle1;
    
    private Circle[] points = {new Circle(300,50,10), new Circle(300,450,10),new Circle(100,250,10)};

    private Line[] lines = {new Line(300,50,300,450), new Line(300,450,100,250), new Line(100,250,300,50)};
    
    private Text[] angles = {new Text(), new Text(), new Text()};
    
    private Group root;
    
    
    @Override
    public void start(Stage stage){
        
        // Initialize the root group
        root = new Group();
        
        // Design big circle
        circle1 = new Circle(300,250,200);
        circle1.setStroke(Color.BLACK);
        circle1.setFill(Color.WHITE);
            
        for(int i=0; i<3;i++){
            points[i].setStroke(Color.BLACK);
            points[i].setFill(Color.RED);
        }
        
        root.getChildren().addAll(circle1,points[0], points[1], points[2], 
                angles[0], angles[1], angles[2],
                lines[0], lines[1], lines[2]);
        
        
        
        points[0].setOnMouseDragged(event->{
            if(points[0].contains(event.getX(), event.getY())){
                
                // Update points
                points[0].setCenterX(event.getX());
                points[0].setCenterY(event.getY());
                
                //Update lines
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
            }});
        
        points[1].setOnMouseDragged(event2->{
            if(points[1].contains(event2.getX(), event2.getY())){
                points[1].setCenterX(event2.getX());
                points[1].setCenterY(event2.getY());

                //Update lines
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
            }});
        
        points[2].setOnMouseDragged(event3->{
            if(points[2].contains(event3.getX(), event3.getY())){
                //Update points
                points[2].setCenterX(event3.getX());
                points[2].setCenterY(event3.getY());

                //Update lines
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
            }});    
        
        // Find the angles
            
        // This set the scene and displays it
        Scene scene = new Scene( root, 600, 500, Color.WHITE);
       
        
        stage.setTitle("Week9_Lab");
        stage.setScene(scene);
        stage.show();
        
    }
    
    private void setAngles(){
    }
           
    public static void main(String[] args)  {
        launch(args);
    }
}
