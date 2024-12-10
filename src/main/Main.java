package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.util.List;

import gui.*;

public class Main extends Application {
	private static Stage stage;
	private static List<String> playlist = List.of("audio/background1.mp3", "audio/background2.mp3",
			"audio/background3.mp3");
	private static int currentTrackIndex = 0;
	private static MediaPlayer backgroundMusicPlayer;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		try {
			setStage(primaryStage);
			MenuScene content = new MenuScene();
			Scene scene = new Scene(content.createContent());
			primaryStage.setTitle("PalRogue");
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		Main.stage = stage;
	}

	private static void playTrack(int trackIndex) {
	    try {
	        if (backgroundMusicPlayer != null) {
	            backgroundMusicPlayer.stop(); // Stop the current track
	        }

	        // Load the new media file
	        Media music = new Media(ClassLoader.getSystemResource(playlist.get(trackIndex)).toString());
	        backgroundMusicPlayer = new MediaPlayer(music);

	        // Set up the player to play the next track when the current one ends
	        backgroundMusicPlayer.setOnEndOfMedia(() -> {
	            currentTrackIndex = (currentTrackIndex + 1) % playlist.size(); // Move to the next track
	            playTrack(currentTrackIndex); // Play the next track
	        });

	        // Play the current track
	        backgroundMusicPlayer.play();
	    } catch (Exception e) {
	        System.out.println("Error playing track: " + e.getMessage());
	    }
	}


}
