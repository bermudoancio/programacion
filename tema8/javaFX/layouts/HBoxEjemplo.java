package tema8.javaFX.layouts;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Ejemplo de uso del layout HBox 
 * @author JJBH
 */
public class HBoxEjemplo extends Application {
    // Declarar el layout
    private HBox caja ;

    @Override
    public void start(Stage stage) {
        // Asignar 10 píxeles de separación entre los nodos
        caja = new HBox(10); 
        // Agregar un relleno de 15 píxeles para separarlo del borde de la ventana
        caja.setPadding(new Insets(15)); 
        // Llamando al metodo addAll podemos agregar nodos en una sola línea
        caja.getChildren().addAll(new Button("Botón 1"), new Button("Botón 2"), 
                new Button("Botón 3"));
        
               
        Scene s = new Scene(caja);
        stage.setScene(s);
        stage.setTitle("Horizontal");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}