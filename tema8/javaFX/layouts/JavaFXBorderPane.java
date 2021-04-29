package tema8.javaFX.layouts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Disposición de controles botón usando el layout BorderPane
 * @author Profesor
 */
public class JavaFXBorderPane extends Application {
    
    private BorderPane raiz;
   
    @Override
    public void start(Stage stage)  {
        raiz = new BorderPane();
       
        //raiz.setTop(new Button("ARRIBA -> TOP"));
        raiz.setBottom(new Button("ABAJO -> BOTTOM"));
        raiz.setLeft(new Button("IZQUIERDA -> LEFT"));
        raiz.setRight(new Button("DERECHA -> RIGHT"));
        raiz.setCenter(new Button("CENTER"));
       
        Scene scene = new Scene(raiz, 300,190);
       
        stage.setTitle("Probando BorderPane");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);    
    }    
}

