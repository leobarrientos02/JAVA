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
    public static void main(String[] args)  {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        
        // Create a root group
        Group root = new Group();
        
        
        //Circle
        Circle circle1 = new Circle(300,250,200);
        circle1.setStroke(Color.BLACK);
        circle1.setFill(Color.WHITE);
        root.getChildren().add(circle1);
        
        //Line1 from point1 to point3
        Line line1 = new Line(300,50,100,250);
        root.getChildren().add(line1);
        
        //Line2 from point1 to point2
        Line line2 = new Line(300,50,300,450);
        root.getChildren().add(line2);
        
        //Line3 from point2 to point3
        Line line3 = new Line(300,450,100,250);
        root.getChildren().add(line3);
        
        //Point1 ( y value gets - 200)
        Circle point1 = new Circle(300,50,10);
        point1.setStroke(Color.BLACK);
        point1.setFill(Color.RED);
        root.getChildren().add(point1);
        
        //Point2 ( y value gets + 200)
        Circle point2 = new Circle(300,450,10);
        point2.setStroke(Color.BLACK);
        point2.setFill(Color.RED);
        root.getChildren().add(point2);
        
        //Point3 (x value gets - 200)
        Circle point3 = new Circle(100,250,10);
        point3.setStroke(Color.BLACK);
        point3.setFill(Color.RED);
        root.getChildren().add(point3);
        
        // This set the scene and displays it
        Scene scene = new Scene( root, 600, 500, Color.WHITE);
        stage.setTitle("Week9_Lab");
        stage.setScene(scene);
        stage.show();
        
        //Move Points
        point1.setOnMouseDragged(event->{
            if(point1.contains(event.getX(), event.getY())){
                point1.setCenterX(event.getX());
                point1.setCenterY(event.getY());
                moveLines(line1, point1,line2, point2,line3,point3);
            }
        });
        
        point2.setOnMouseDragged(event->{
            if(point2.contains(event.getX(), event.getY())){
                point2.setCenterX(event.getX());
                point2.setCenterY(event.getY());
                moveLines(line1, point1,line2, point2,line3,point3);                              
            }
        });
        
        point3.setOnMouseDragged(event->{
            if(point3.contains(event.getX(), event.getY())){
                point3.setCenterX(event.getX());
                point3.setCenterY(event.getY());
                moveLines(line1, point1,line2, point2,line3,point3);                
            }
        });
        
    }
    
    public void moveLines(Line line1, Circle point1,
    Line line2, Circle point2,
            Line line3, Circle point3){

        //Move Line1 according with point1
        line1.setStartX(point1.getCenterX());
        line1.setStartY(point1.getCenterY());
        line1.setEndX(point1.getCenterX());
        line1.setEndY(point1.getCenterY());        

        //Move Line2 according with point2
        line2.setStartX(point2.getCenterX());
        line2.setStartY(point2.getCenterY());
        line2.setEndX(point2.getCenterX());
        line2.setEndY(point2.getCenterY()); 
        
        //Move Line3 according with point3
        line3.setStartX(point3.getCenterX());
        line3.setStartY(point3.getCenterY());
        line3.setEndX(point3.getCenterX());
        line3.setEndY(point3.getCenterY());
                             
    }
    
}
