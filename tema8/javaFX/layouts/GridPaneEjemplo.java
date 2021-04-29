package tema8.javaFX.layouts;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

/**
 * Ejemplo de GridPane
 * @author Basado en el ejemplo de Jan Bodnar
 */
public class GridPaneEjemplo extends Application {
    
    @Override
    public void start(Stage stage) {
   
        // Crear el panel
        GridPane root = new GridPane();
        
        // Establecer espacios entre los nodos
        root.setHgap(8);
        root.setVgap(8);
        root.setPadding(new Insets(5));
        
        // Tenemos que hacer que la segunda columna pueda crecer. 
        // De forma predeterminada, el panel muestra sus elementos secundarios
        // en sus tamaños preferidos y no los agranda cuando se amplía la
        // ventana. Creamos restricciones de columna, donde establecemos la
        // prioridad de crecimiento horizontal en Priority.ALWAYS para la
        // segunda columna. Esto hace que el campo de texto y los controles de
        // la vista de lista crezcan en dirección horizontal a medida que se
        // agranda la ventana.
        ColumnConstraints cons1 = new ColumnConstraints();
        cons1.setHgrow(Priority.NEVER);
        root.getColumnConstraints().add(cons1);

        // De manera similar, hacemos crecer la segunda fila. Al hacer crecer 
        // la segunda columna y la fila, la vista de lista crece en ambas 
        // direcciones, ocupando la mayor parte del área del cliente.
        ColumnConstraints cons2 = new ColumnConstraints();
        cons2.setHgrow(Priority.ALWAYS);
        
        root.getColumnConstraints().addAll(cons1, cons2);
        
        RowConstraints rcons1 = new RowConstraints();
        rcons1.setVgrow(Priority.NEVER);
        
        RowConstraints rcons2 = new RowConstraints();
        rcons2.setVgrow(Priority.ALWAYS);  
        
        root.getRowConstraints().addAll(rcons1, rcons2);
        
        Label lbl = new Label("Nombre:");
        TextField field = new TextField();
        ListView view = new ListView();
        Button okBtn = new Button("Aceptar");
        Button closeBtn = new Button("Cerrar");

        // Botón de aceptar alineado a la derecha
        GridPane.setHalignment(okBtn, HPos.RIGHT);
                
        //root.setGridLinesVisible(true) ;
        
        // Se añaden los controles al panel. Los dos primeros parámetros
        // del método add() son los índices de columna y fila. Los índices
        // empiezan por 0.
        root.add(lbl, 0, 0);
        root.add(field, 1, 0, 3, 1);
        root.add(view, 0, 1, 4, 2);
        root.add(okBtn, 2, 3);
        root.add(closeBtn, 3, 3);
        
        Scene scene = new Scene(root, 280, 300);

        stage.setTitle("Prueba GridPane");
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}