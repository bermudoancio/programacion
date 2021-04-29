package tema8.javaFX.componentes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PruebaMenu extends Application {

	@Override
	public void start(Stage primaryStage) {
		// Crear barra de menú
        MenuBar menuBar = new MenuBar();
        // Añadir la barra a un panel contenedor
        VBox vBox = new VBox(menuBar);
        
        // Crear un menú llamado Archivo
        Menu menu = new Menu("Archivo");
        // Añadir dos elementos de menú       
        MenuItem menuItem1 = new MenuItem("Abrir");
        // Insertamos un atajo de teclado
        menuItem1.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.SHORTCUT_DOWN));
        MenuItem menuItem2 = new MenuItem("Cerrar");
        // Añadir los elementos de menú al menú
        menu.getItems().add(menuItem1);
        menu.getItems().add(menuItem2);
        
        // Especificamos las acciones a tomar si se pincha en las opciones 
        // de menú
        menuItem1.setOnAction(e -> {
            System.out.println("Se seleccionó la opción abrir");
        });
        menuItem2.setOnAction(e -> {
            System.out.println("Se seleccionó la opción cerrar");
            primaryStage.close();
        });
        
        // Crear un menú llamado Archivo
        Menu menu2 = new Menu("_Edición");
        // Mediante el mnemonic podemos usar los menús con la tecla alt
        menu2.setMnemonicParsing(true);
        // Añadir dos elementos de menú       
        MenuItem menuItem3 = new MenuItem("_Cortar");
        menuItem3.setMnemonicParsing(true);
        
        menuItem3.setOnAction(e -> {
            System.out.println("Se seleccionó la opción cortar");
        });
        
        menu2.getItems().add(menuItem3);
        

        // Añadimos los menús a la barra
        menuBar.getMenus().addAll(menu, menu2);

        // Crear la escena
        Scene scene = new Scene(vBox, 700, 500);
        primaryStage.setTitle("Barra de menú");
        primaryStage.setScene(scene);
        primaryStage.show();		
	}
	
	public static void main(String[] args) {
        launch(args);
    }

}
