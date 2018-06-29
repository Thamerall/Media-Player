package application;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Player extends BorderPane {
	
	Media mainMedia;
	MediaPlayer users;
	MediaView mediaView;
	Pane mpane;
	MediaBar bar;
	public Player(String file){
		mainMedia = new Media(file);
		users = new  MediaPlayer(mainMedia);
		mediaView = new MediaView(users);
		mpane = new Pane();
		
		mpane.getChildren().add(mediaView);
		
		setCenter(mpane);
		
		bar = new MediaBar(users);
		
		setBottom(bar);
		
		setStyle("-fx-background-color: #bfc2c7");
		
		users.play();
	}
}
