package assignment4;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import static javafx.scene.input.KeyCode.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class LayoutGUIController {
  
    double operand1=0;
    double operand2=0;
    double ans=0;
    String crnArthOpt;
    
    @FXML
    private TextField label;

    @FXML
    private Button num5;

    @FXML
    private Button num4;

    @FXML
    private Button num9;

    @FXML
    private Button num8;

    @FXML
    private Button num7;

    @FXML
    private Button subtraction;

    @FXML
    private Button addition;

    @FXML
    private Button multiplication;

    @FXML
    private Button divide;

    @FXML
    private Button num6;

    @FXML
    private Button num1;

    @FXML
    private Button num2;

    @FXML
    private Button num3;

    @FXML
    private Button clear;

    @FXML
    private Button num0;

    @FXML
    private Button equal;

/**
 * Reads in the id of each button on the Screen Calculator,
 * and sets a value equal to each button on MouseEvent.
 * Through the on screen buttons the user can compute
 * calculations.
 *
 * @param event 
 *  The Mouse Event
 * 
 * @author Leonel Barrientos
 * 
 * @version 1.2
 */
    @FXML
    void setText(MouseEvent event) {
         if(event.getSource() == num0){
            label.setText(label.getText() + "0");            
        }
        else if( event.getSource() == num1){
            label.setText(label.getText() + "1");
        }
        else if( event.getSource() == num2){
            label.setText(label.getText() + "2");
        }
        else if( event.getSource() == num3){
            label.setText(label.getText() + "3");
        }
        else if( event.getSource() == num4){
            label.setText(label.getText() + "4");
        }        
        else if( event.getSource() == num5){
            label.setText(label.getText() + "5");
        }
        else if( event.getSource() == num6){
            label.setText(label.getText() + "6");
        }       
        else if( event.getSource() == num7){
            label.setText(label.getText() + "7");
        }        
        else if( event.getSource() == num8){
            label.setText(label.getText() + "8");
        }        
        else if( event.getSource() == num9){
            label.setText(label.getText() + "9");
        }       
        if( event.getSource() == addition){
            operand2= Double.parseDouble(label.getText());
            crnArthOpt="add";
            label.setText("");
        }
        else if( event.getSource() == subtraction){
            operand2= Double.parseDouble(label.getText());
            crnArthOpt="subtraction";
            label.setText("");
        }
        else if( event.getSource() == divide){
            operand2= Double.parseDouble(label.getText());
            crnArthOpt="divide";
            label.setText("");
        }
        else if( event.getSource() == multiplication){
            operand2= Double.parseDouble(label.getText());
            crnArthOpt="multiplication";
            label.setText("");
        }
        else if( event.getSource() == equal){
            
         
            // Read in the new user num from the textField
            operand1 = Double.parseDouble(label.getText());
            
            // Nested if Statement to do math
            if( crnArthOpt.equals("add")){
                ans = operand2 + operand1;
                label.setText(String.valueOf(ans));
            }
            else if( crnArthOpt.equals("subtraction")){
                ans = operand2 - operand1;
                label.setText(String.valueOf(ans));                
            }
            else if( crnArthOpt.equals("multiplication")){
                ans = operand2 * operand1;
                label.setText(String.valueOf(ans));                
            }
            else if( crnArthOpt.equals("divide")){
                
                // Reports invalid if user tries tom divide by zero
                if( operand1 == 0){
                    label.setText("Invalid"); 
                }
                else{
                    ans = operand2 / operand1;   
                    label.setText(String.valueOf(ans));                
                }
            }          
        }         
        else if( event.getSource() == clear){
            label.setText("");
        } 
       
    }

/**
 * This class allows the user to use the keyboard to write simple
 * equations and press Enter to see the result on screen.
 * 
 * @param event 
 *  The Keyboard Event
 * 
 * @author Leonel Barrientos
 * 
 * @version 1.0
 */    
    @FXML
    void setText2(KeyEvent event) {
       int arithmetic_Index=0;
       String equation;
       
       // If the user press Enter
       if( event.getCode()==ENTER){
           // read in screen text
            equation = label.getText();
                       
            // Test if the user enter any text
            if ( equation.equals("")){
                label.setText("Enter values");
                
                // Move the cursor to the end of the text
                label.appendText(""); 
            }
            //Stop the user from entering letter
            else if(!equation.matches("\\d*")){
                label.setText("No letters/Symbols");
                // Move the cursor to the end of the text
                label.appendText(""); 
            }
            
            // Allows user to enter an equal sign without crashing the program
            if(equation.endsWith("=")){
                String str = equation.substring(0, equation.length()-1);
                equation = str;
            }
            
            
            // Copy equation into the array
            char[] char_equation = new char[equation.length()];
            
            // Read equation into the array
            for(int i=0; i< equation.length();i++){
                char_equation[i] = equation.charAt(i);
            }
            
            //arithmetic variable
            for(int i=0; i< equation.length();i++){
                if(char_equation[i] == '+'){
                    arithmetic_Index = i;
                    
                    // Seperate the two numbers
                    operand2 = Double.parseDouble(equation.substring(0, arithmetic_Index));
                    operand1 = Double.parseDouble(equation.substring(arithmetic_Index+1, equation.length()));
                    label.setText(String.valueOf(operand2+operand1));                    

                }
                else if(char_equation[i] == '-'){
                    arithmetic_Index = i;
                    
                    // Seperate the two numbers
                    operand2 = Double.parseDouble(equation.substring(0, arithmetic_Index));
                    operand1 = Double.parseDouble(equation.substring(arithmetic_Index+1, equation.length()));
                    
                    //Print to screen
                    label.setText(String.valueOf(operand2-operand1));  
                }
                else if(char_equation[i] == '*' || char_equation[i] == 'x' || char_equation[i] == 'X'){
                    arithmetic_Index = i;
                    
                    // Seperate the two numbers
                    operand2 = Double.parseDouble(equation.substring(0, arithmetic_Index));
                    operand1 = Double.parseDouble(equation.substring(arithmetic_Index+1, equation.length()));
                    label.setText(String.valueOf(operand2*operand1));  
                }
                else if(char_equation[i] == '/'){
                    arithmetic_Index = i;
                    
                    // Seperate the two numbers
                    operand2 = Double.parseDouble(equation.substring(0, arithmetic_Index));
                    operand1 = Double.parseDouble(equation.substring(arithmetic_Index+1, equation.length()));
                    label.setText(String.valueOf(operand2/operand1));  
                }
            }   
       }
       // Found the appendText() function online which sets the cursor to the end of the output
       label.appendText("");  
    }
    
}
