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
    }
    
    @FXML
    void movePoints(ActionEvent event1){
      
        
    }
    
    @FXML
    void movePoints(MouseEvent event1){
        double clickX = event1.getX();
        double clickY= event1.getY();
        
        
    }
    
}
