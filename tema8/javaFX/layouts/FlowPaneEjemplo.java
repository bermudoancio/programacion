package tema8.javaFX.layouts;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Ejemplo de uso del panel FlowPane
 * @author JJBH
 */
public class FlowPaneEjemplo extends Application {

    @Override
    public void start(Stage stage) {
                
        // Crear panel. Prueba a cambiar la orientación a vertical
        FlowPane flow = new FlowPane(Orientation.HORIZONTAL);
        // Espacio entre filas y columnas
        flow.setVgap(8);
        flow.setHgap(4);
        // Ancho preferido
        flow.setPrefWrapLength(300); 
        // Añadir 10 botones
        for (int i = 0; i < 10; i++) {
            flow.getChildren().add(new Button("botón"));
        }
        
        // EStabelcemos propiedades del escenario
        stage.setTitle("Ejemplo FlowPane");
        stage.setWidth(500);
        stage.setHeight(500);
        
        // Creamos escena
        Scene scene = new Scene(flow);
        // Añair escena al escenario         
        stage.setScene(scene);
        // Mostrar escenario
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}