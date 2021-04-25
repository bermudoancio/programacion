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
        
        // Crear bot�n
        Button btn = new Button();
        // Texto del bot�n
        btn.setText("Saluda al mundo");
        
        // Crear manejador de evento para la acci�n que se debe hacer al clicar
        // sobre el bot�n.
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                // Escribir por consola
                System.out.println("�Hola mundo!");
            }
        });
        
        // Crear un panel
        StackPane root = new StackPane();
        // A�adir el bot�n al panel.
        root.getChildren().add(btn);
        // Crear la escena
        Scene scene = new Scene(root, 300, 250);
        // Dar t�tulo al escenario
        primaryStage.setTitle("Hola mundo.");
        // A�adir la escena al escenario
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