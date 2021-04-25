package tema8.javaFX.layouts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class AbsoluteLayoutEjemplo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        
        // Crear rectángulo y rellenarlo de color.
        Rectangle rect = new Rectangle(25, 25, 50, 50);
        rect.setFill(Color.AQUAMARINE);
        
        // Crear línea de color roja.
        Line line = new Line(90, 40, 230, 40);
        line.setStroke(Color.RED);
        
        // Crear círculo y rellenarlo de color.
        Circle circle = new Circle(130, 130, 30);
        circle.setFill(Color.CORNFLOWERBLUE);
        
        // Añadir las figuras como hijos del panel.
        root.getChildren().addAll(rect, line, circle);

        // Color de fondo de la escena
        Scene scene = new Scene(root, 310, 220, Color.WHEAT);

        // Establecer el título, la escena y mostrar.
        primaryStage.setTitle("Absolute layout");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}

