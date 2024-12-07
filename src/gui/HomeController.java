package gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class HomeController {
	private Stage stage;
	private Scene scene;
	private Parent root;

	public void startGame(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Game.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("PalRogue");
		stage.setScene(new Scene(root));
		stage.show();
	}

	public void switchToUpgrade(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("UpgradeScene.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("PalRogue");
		stage.setScene(new Scene(root));
		stage.show();
	}

}
