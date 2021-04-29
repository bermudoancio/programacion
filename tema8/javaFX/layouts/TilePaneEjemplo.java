package tema8.javaFX.layouts;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class TilePaneEjemplo extends Application  {

    @Override
    public void start(Stage stage) throws Exception {
        
        // A�adir unos botones
        Button button1 = new Button("Bot�n 1");
        Button button2 = new Button("Bot�n 2");
        Button button3 = new Button("Bot�n 3");
        Button button4 = new Button("Bot�n Nu�mero 4");
        Button button5 = new Button("Bot�n 5");
        Button button6 = new Button("Bot�n 6");

        // Crear panel
        TilePane tilePane = new TilePane();

        tilePane.getChildren().add(button1);
        tilePane.getChildren().add(button2);
        tilePane.getChildren().add(button3);
        tilePane.getChildren().add(button4);
        tilePane.getChildren().add(button5);
        tilePane.getChildren().add(button6);

        // Espacio entre filas y columnas
        tilePane.setHgap(10);
        tilePane.setVgap(10);

        
        tilePane.setTileAlignment(Pos.CENTER);

        // Creamos escena
        Scene scene = new Scene(tilePane, 300, 200);
        // A�air escena al escenario         
        stage.setScene(scene);
        stage.setTitle("TilePane Ejemplo");
        // Mostrar escenario
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}

