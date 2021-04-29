package tema8.javaFX.componentes;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Ejemplo de uso de etiquetas y campos de texto en JavaFX
 * Se muestra también cómo se puede asociar una imagen a una etiqueta
 * 
 * @author JJBH
 */
public class EtiquetasyTexto extends Application {
    
	/*
	 * Una instancia de la clase Label representa un control de etiqueta. 
	 * Este control consiste simplemente en una etiqueta que se utiliza para describir otro componente. 
	 * Puede mostrar un texto, un icono o imagen o ambas cosas. Por lo general, una etiqueta se coloca 
	 * al lado de (a la derecha o izquierda) o en la parte superior del nodo que describe. 
	 * Una etiqueta no puede tener el foco, es decir, no se puede acceder a ella mediante la tecla Tab 
	 * o el click del ratón.
	 * Un TextField es un control de entrada de texto. Hereda de la clase TextInputControl. 
	 * Permite al usuario introducir una sola línea de texto plano. Si necesitamos un control para 
	 * introducir más de una línea, entonces hay que recurrir al control TextArea.
	 * En un TextField, al definir tanto texto como contenido gráfico para un botón, se puede usar el 
	 * método setGraphicTextGap para establecer el espacio entre ellos.
	 * Además, se puede variar la posición del contenido de la etiqueta dentro de su área de diseño 
	 * mediante el método setTextAlignment. También puede definir la posición del gráfico en relación con
	 * el texto aplicando el método setContentDisplay y especificando una de las siguientes constantes de 
	 * ContentDisplay: LEFT, RIGHT, CENTER, TOP, BOTTOM.
	 * Se puede utilizar el método setPrefWidth para indicar el tamaño del control. Así, dado un campo de 
	 * texto llamado por ejemplo ctex, con ctex.setPrefWidth(50) le estaríamos dando una anchura de 50.
	 * En el siguiente ejemplo se puede ver el uso de etiquetas y campos de texto.
	 * Al principio se declaran un par de etiquetas donde se muestran mensajes al usuario. Se muestra también 
	 * cómo emplear una imagen, una lupa que se muestra en la ventana.
	 * Cuando se introduce algo en el campo de texto y se pulsa la tecla Intro, se escribe mediante una etiqueta, 
	 * llamada etiqueta, que el campo ha cambiado. Fíjate que eso se especifica mediante el método setOnAction.
	 * Debes observar también que para la etiqueta labelNombre establecemos manejadores, esta vez sin la 
	 * notación lambda, para que se haga un zoom cuando con el puntero del ratón se acerque a ella, y se 
	 * quite el zoom al alejarnos, al salir de ella.
	 */
	
	
    // Crear etiqueta
    Label etiqueta = new Label("Escribe tu nombre en los campos de texto.");
    // Crear etiqueta para el nombre
    Label labelNombre = new Label("Nombre:") ;
    
    @Override
    public void start(Stage primaryStage) {
        
        // Dar color a la etiqueta
        etiqueta.setTextFill(Color.web("#0076a3"));
        
        // Obtener image y asoociarla a la etiqueta.
        // (Estamos suponiendo que existe esa imagen, por lo que deberÃ­amos
        // capturar las excepciones que puedan surgir en este punto, por si no
        // existiera, pero lo omitimos por claraida de este cÃ³digo.
        Image image = new Image(getClass().getResourceAsStream("lupa.png"));
        etiqueta.setGraphic(new ImageView(image));
               

        // Crear campos de texto
        TextField campoNombre = new TextField();
        TextField campoApellidos = new TextField();
        // Ancho para mostraar 15 caracteres
        campoNombre.setPrefColumnCount(15);
        campoApellidos.setPrefColumnCount(15);
        
        // Establecer los manejadores ActionEvent para ambos campos de texto
        campoNombre.setOnAction((ActionEvent e) -> {
            etiqueta.setText("Has cambiado el nombre");
        });
        campoApellidos.setOnAction((ActionEvent e) -> {
            etiqueta.setText("Has cambiado los apellidos");
        });
        
        
        // Para la etiqueta del nombre establecemos manejadores para que se
        // haga un zoom, cuando con el ratón nos acerquemos a ella, y se quite
        // el zoom al alejarnos, al salir de ella.
        labelNombre.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                labelNombre.setScaleX(1.5);
                labelNombre.setScaleY(1.5);
            }
        });
        labelNombre.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                labelNombre.setScaleX(1);
                labelNombre.setScaleY(1);
            }
        });
        
        

        // Crear un Gridpane
        GridPane panel = new GridPane();
        
        // AÃ±adir etiquetas y campos al GridPane
        panel.addRow(0, etiqueta);
        panel.addRow(1, labelNombre, campoNombre);
        panel.addRow(2, new Label("Apellidos:"), campoApellidos);
        
        // Establecer el tamaÃ±o del panel
        panel.setMinSize(350, 250);
        // Establecer propiedades del GridPane
        panel.setStyle("-fx-padding: 10;" +
        "-fx-border-style: solid inside;" +
        "-fx-border-width: 2;" +
        "-fx-border-insets: 5;" +
        "-fx-border-radius: 5;" +
        "-fx-border-color: blue;");
        
        // Crear la escena
        Scene scene = new Scene(panel);
        
        // TÃ­tulo de la ventana
        primaryStage.setTitle("Etiquetas y campos de texto");
        // AÃ±adir la escena al escenario
        primaryStage.setScene(scene);
        // Mostrar el escenario
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}