package tema8.javaFX.layouts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Ejemplo de uso del layout VBox 
 * @author JJBH
 */
public class VBoxEjemplo extends Application {
    // Declarar el layout
    private VBox caja ;

    @Override
    public void start(Stage stage) {
        // Asignar 10 p�xeles de separaci�n entre los nodos
        caja = new VBox(10); 
        // Agregar un relleno de 15 p�xeles para separarlo del borde de la ventana
        caja.setPadding(new Insets(15)); 
        // Llamando al metodo addAll podemos agregar nodos en una sola l�nea
        caja.getChildren().addAll(new Button("Bot�n 1"), new Button("Bot�n 2"), 
                new Button("Bot�n 3"));
        
               
        Scene s = new Scene(caja);
        stage.setScene(s);
        stage.setTitle("Vertical");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
