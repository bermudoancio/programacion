package tema8.javaFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Ejemplo02 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        // Crear botón
        Button btn = new Button();
        // Texto del botón
        btn.setText("Saluda al mundo");
        
        // Crear manejador de evento para la acción que se debe hacer al clicar
        // sobre el botón.
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                // Escribir por consola
                System.out.println("¡Hola mundo!");
            }
        });
        
        // Crear un panel
        StackPane root = new StackPane();
        // Añadir el botón al panel.
        root.getChildren().add(btn);
        // Crear la escena
        Scene scene = new Scene(root, 300, 250);
        // Dar título al escenario
        primaryStage.setTitle("Hola mundo.");
        // Añadir la escena al escenario
        primaryStage.setScene(scene);
        // Mostrar el escenario
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}