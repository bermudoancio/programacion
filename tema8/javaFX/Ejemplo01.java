package tema8.javaFX;

import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Ejemplo01 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
    	// Creamos el contenido de la ventana
    	Text texto = new Text("¡Hola mundo gráfico!");
    	// Creamos un panel con el texto y se lo añadimos a la escena
    	Scene escena = new Scene(new StackPane(texto), 640, 480);
    	// Añadimos la escena al escenario
        stage.setScene(escena);
        // Mostramos el escenario
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

