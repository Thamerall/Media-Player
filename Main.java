package application;
	
import java.io.File;
import java.net.MalformedURLException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;


public class Main extends Application {
	
	Player user;
	FileChooser selectedFile;
	MenuBar menu;
	public void start(final Stage primaryStage) {
		
		MenuItem open = new MenuItem("Open");
		Menu file = new Menu("File");
		menu = new MenuBar();
		
		file.getItems().add(open);
		menu.getMenus().add(file);
		
		selectedFile = new FileChooser();
		
		open.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				user.player.pause();
				File file = selectedFile.showOpenDialog(primaryStage);
				if(file != null){
					try {
						user = new Player(file.toURI().toURL().toExternalForm());
						user.setTop(menu);
						Scene scene = new Scene(user, 720, 535, Color.BLACK);
						primaryStage.setScene(scene);
					} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		user = new Player("file:///C:/gotg.mp4");
		user.setTop(menu);
		Scene scene = new Scene(user, 720, 535, Color.BLACK);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
