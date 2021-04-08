package basicpaint;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author leoba
 */
public class FXMLController implements Initializable {

    
    private String selectedShape="LINE";
    private Color selectedColor = Color.BLUE;
    double srtX=0, srtY=0;
    double endX=0, endY=0;
    
    private Label label;
    
    private Group C;
    
    @FXML
    private Canvas mCanvas;
    @FXML
    private ColorPicker mColorPicker;
    @FXML
    private Slider mSlider;
    
    @FXML
    private void openFile(ActionEvent event){
        
    }
    
    @FXML
    private void saveFile(ActionEvent event){
        
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    

    @FXML
    private void startDraw(MouseEvent event) {
        
        endX=event.getX();
        endY=event.getY();
        GraphicsContext gc= mCanvas.getGraphicsContext2D();
        gc.setStroke(selectedColor);
        System.out.println(""+selectedColor);
        gc.setLineWidth(mSlider.getValue());
        switch(selectedShape){
          case "LINE":   gc.strokeLine(srtX,srtY,endX,endY);break;
          case "RECT":  gc.strokeRect(srtX,srtY,endX,endY); break;
          case "CIRCLE":  gc.strokeOval(srtX,srtY,Math.abs(endX-srtX),Math.abs(endY-srtY)); break;     
        }
    }

    @FXML
    private void startShape(MouseEvent event) {
        srtX=event.getX();
        srtY=event.getY();
    }

    @FXML
    private void setShape(ActionEvent event) {
        Button btn = (Button)event.getSource();
        
        switch(btn.getText()){
            case "Line": selectedShape="LINE";  break;
            case "Rect": selectedShape="RECT";  break;
            case "Circle": selectedShape="CIRCLE";  break;
        }
    }

    @FXML
    private void selectColor(ActionEvent event) {
        selectedColor = mColorPicker.getValue();
    }
    
}
