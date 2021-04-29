package tema8.javaFX.componentes;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Botón con inoco asociado.
 * 
 * @author JJBH
 */
public class BotonImagenFX extends Application {
    private int contador = 0 ;
    
    
    @Override
    public void start(Stage primaryStage) {
        
        Button btn = new Button();
        Label etiqueta = new Label() ;
        etiqueta.setText("Prueba de botón");
        
        try {
            Image imageDecline = new Image(getClass().getResourceAsStream("ok.png"));
            btn.setGraphic(new ImageView(imageDecline));
        } catch (NullPointerException e) {
            System.err.println("No existe la imagen");
        }
        
       
        btn.setText("Púlsame");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                contador++ ;
                etiqueta.setText(contador + "");
            }
        });
        
        HBox root = new HBox();
        root.getChildren().add(btn);
        root.getChildren().add(etiqueta);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Botón con imagen");
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
