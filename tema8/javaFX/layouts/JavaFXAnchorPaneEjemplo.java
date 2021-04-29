package tema8.javaFX.layouts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Ejemplo de uso del layout AnchorPane
 * @author Profesor
 */
public class JavaFXAnchorPaneEjemplo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        AnchorPane anchorPane = new AnchorPane();
        
        Button btn = new Button("Abrir");
        
        AnchorPane.setTopAnchor(btn, 10.0);
        AnchorPane.setLeftAnchor(btn, 10.0);
        AnchorPane.setRightAnchor(btn, 65.0);
        
        // Botón en el borde derecho
        Button button = new Button("Añadir");
        AnchorPane.setTopAnchor(button, 10.0);
        AnchorPane.setRightAnchor(button, 10.0);
        anchorPane.getChildren().addAll(btn, button);
        
        // Añadir el panel a la escena        
        Scene scene = new Scene(anchorPane, 220, 190);
        // Título del escenario
        primaryStage.setTitle("Ancla.");
        // Añadir la escena al escenario
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}