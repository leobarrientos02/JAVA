package assignment2;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Assignment2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    // Step method to create the step
    public void step(Group house,int x,int y, int width){
        
        // Create the step
        Rectangle step = new Rectangle(x,y,width, 10);
        step.setStroke(Color.BLACK);
        step.setFill(Color.LIGHTGREY);

        house.getChildren().add(step);
    }
    
    // Pillar method to create the pillar
    public void housePillar(Group house, int x,int y){
        
        //Create House Pillars
        Rectangle pillar = new Rectangle(x,y,35,190);
        pillar.setStroke(Color.BLACK);
        pillar.setFill(Color.WHITE);
        house.getChildren().add(pillar);
        
        Circle pillarTop1 = new Circle(x,y+12,12);
        pillarTop1.setStroke(Color.BLACK);
        pillarTop1.setFill(Color.WHITE);
        house.getChildren().add(pillarTop1);
        
        Circle pillarTop2 = new Circle(x+35,y+12,12);
        pillarTop2.setStroke(Color.BLACK);
        pillarTop2.setFill(Color.WHITE);
         house.getChildren().add(pillarTop2);
        
        Rectangle pillarBottom = new Rectangle(x-8,y+190,50,15);
        pillarBottom.setStroke(Color.BLACK);
        pillarBottom.setFill(Color.WHITE);  
        house.getChildren().add(pillarBottom);
    }
	
	// Method to create doorWindows
    public void doorWindows(Group house, int x, int y){
        
        int count= 0;
        
        Rectangle smallWindow1 = new Rectangle(x,y,12,12);
        house.getChildren().add(smallWindow1);
        Rectangle smallWindow2 = new Rectangle(x+23,y,12,12);
        house.getChildren().add(smallWindow2);       
        
        //Large windows
        while(count != 4){
            Rectangle largeWindowLeft = new Rectangle(x,y+20,12,16);
            Rectangle largeWindowRight = new Rectangle(x+23,y+20,12,16);
            y = y+20;
            house.getChildren().add(largeWindowLeft);
            house.getChildren().add(largeWindowRight);
            
            count = count +1;
        }
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        
        
        // Create a root group
        Group root = new Group();
        
        //Create the grass portion
        Rectangle grass = new Rectangle(0,200,600,400);
        grass.setFill(Color.FORESTGREEN);
       
        // Create a group for the house components
        Group house = new Group();
        
        //House Base
        Rectangle houseBase = new Rectangle(80,120,425,300);
        houseBase.setStroke(Color.BLACK);
        houseBase.setFill(Color.FIREBRICK);
        house.getChildren().add(houseBase);
       
        //Creating the roof
        Rectangle roofBase = new Rectangle(80,110,425,20);
        roofBase.setStroke(Color.BLACK);
        roofBase.setFill(Color.WHITE);
        house.getChildren().add(roofBase);
        
        // Triangle portion of the roof
        Polygon roof = new Polygon();
            roof.getPoints().addAll(new Double[]{  
            295.0, 0.0,  
            50.0, 110.0,  
            540.0, 110.0 });   
        roof.setStroke(Color.BLACK);
        roof.setFill(Color.WHITE);
        
        root.getChildren().add(roof);
        
        //House pillars from left to right, using housePillar Method
        housePillar(house,92,130);
        housePillar(house,205,130);
        housePillar(house,340,130);
        housePillar(house,458,130);
        
        // House Steps
        int stepCount=0;
        int x = 135;
        int y =335;
        int width=315;
        while( stepCount != 11){
            // Using step method to create 11 steps
            step(house,x,y,width);
            
            stepCount++;
            y = y + 10;
            x = x - 10;
            width = width + 20;
        }
        
        //Steps under the two last pillars
        Rectangle miniStep1 = new Rectangle(80,335,55,7);
        miniStep1.setStroke(Color.BLACK);
        miniStep1.setFill(Color.LIGHTGRAY);
        house.getChildren().add(miniStep1);
        
        Rectangle miniStep2 = new Rectangle(450,335,55,7);
        miniStep2.setStroke(Color.BLACK);
        miniStep2.setFill(Color.LIGHTGRAY);
        house.getChildren().add(miniStep2);
        
        //Window in the center
        Rectangle window = new Rectangle(258,148,65,30);
        window.setStroke(Color.BLACK);
        window.setFill(Color.LIGHTGRAY);
        house.getChildren().add(window);
        
        //Middle Door
        Rectangle midDoor = new Rectangle(260,200,60,135);
        midDoor.setStroke(Color.BLACK);
        midDoor.setFill(Color.WHITE);
        house.getChildren().add(midDoor);
        
        //Door Windows for midDoor, using doorWindows method
        doorWindows(house,272,233);
        
        // Left Door
        Rectangle leftDoor = new Rectangle(138,225,55,110);
        leftDoor.setStroke(Color.BLACK);
        leftDoor.setFill(Color.WHITE);
        house.getChildren().add(leftDoor);
        
        // Door Windows for left door using doorWindows method
        doorWindows(house,148,233);
        
        //Right Door
        Rectangle rightDoor = new Rectangle(390,225,55,110);
        rightDoor.setStroke(Color.BLACK);
        rightDoor.setFill(Color.WHITE);
        house.getChildren().add(rightDoor);        
        doorWindows(house,400,233);
        
        // Using the root group to pass the grass object and house Group
        root.getChildren().add(grass);
        root.getChildren().add(house);
        
        // This set the scene and displays it
        // Made the background the color of the sky area
        Scene scene = new Scene( root, 600, 500, Color.SKYBLUE);
        stage.setTitle("A House");
        stage.setScene(scene);
        stage.show();
    }
    
    
}
