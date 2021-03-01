
package javafx_demo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JavaFx_Demo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
             
        Text hello = new Text(50, 50, "Hello, JavaFX!");
        Text question = new Text(120, 80, "How's it going?");
        Group root = new Group(hello, question);
        Scene scene = new Scene( root, 300, 120, Color.LIGHTGREEN);
        stage.setScene(scene);
        stage.show();

    }
    
}
