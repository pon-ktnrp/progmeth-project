package gui;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class MenuScene {

	public Parent createContent() {
		Pane root = new Pane();

        root.setPrefSize(860, 600);
        // Create an ImageView for the background
        ImageView img = new ImageView();
        try (InputStream is = Files.newInputStream(Paths.get("res/bg.jpg"))) {
            img.setImage(new Image(is));
        } catch (IOException e) {
            System.out.println("Couldn't load image");
        }

        // Bind the size of the ImageView to the Pane's size
        img.fitWidthProperty().bind(root.widthProperty());
        img.fitHeightProperty().bind(root.heightProperty());

        // Add the ImageView as the first child of the root
        root.getChildren().add(img);

		Title title = new Title("P A L R O G U E");
		title.setTranslateX(75);
		title.setTranslateY(200);

		MenuItem itemExit = new MenuItem("EXIT");
		itemExit.setOnMouseClicked(event -> System.exit(0));
		MenuItem itemStart = new MenuItem("START");
		itemStart.setOnMouseClicked(event -> {

			    Parent secondPage = SecondPage.createPage("Welcome to the START page!");
			    Scene newScene = new Scene(secondPage);

			    // Get the current stage and set the new scene
			    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			    stage.setScene(newScene);


		});
		MenuItem itemUpgrade = new MenuItem("UPGRADE");
		itemStart.setOnMouseClicked(event -> {

		    Parent secondPage = SecondPage.createPage("Welcome to the START page!");
		    Scene newScene = new Scene(secondPage);

		    // Get the current stage and set the new scene
		    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		    stage.setScene(newScene);


	});
		MenuBox menu = new MenuBox(itemStart, itemUpgrade, itemExit);
		menu.setTranslateX(100);
		menu.setTranslateY(300);

		root.getChildren().addAll(title, menu);
		return root;
	}

	private static class Title extends StackPane {
		public Title(String name) {
			Rectangle bg = new Rectangle(250, 60);
			bg.setOpacity(0.4);
			bg.setFill(Color.WHITE);
			bg.setStroke(Color.BLACK);
			bg.setStrokeWidth(2);

			Text text = new Text(name);
			text.setFill(Color.BLACK);
			text.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 50));

			setAlignment(Pos.CENTER);
			getChildren().addAll(bg, text);
		}
	}

	private static class MenuBox extends VBox {
		public MenuBox(MenuItem... items) {
			getChildren().add(createSeparator());

			for (MenuItem item : items) {
				getChildren().addAll(item, createSeparator());
			}
		}

		private Line createSeparator() {
			Line sep = new Line();
			sep.setEndX(200);
			sep.setStroke(Color.DARKGREY);
			return sep;
		}
	}

	private static class MenuItem extends StackPane {
		public MenuItem(String name) {
			LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE,
					new Stop[] { new Stop(0, Color.DARKVIOLET), new Stop(0.1, Color.BLACK), new Stop(0.9, Color.BLACK),
							new Stop(1, Color.DARKVIOLET) });

			Rectangle bg = new Rectangle(200, 30);
			bg.setOpacity(0.4);

			Text text = new Text(name);
			text.setFill(Color.WHITE);
			text.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 22));

			setAlignment(Pos.CENTER);
			getChildren().addAll(bg, text);

			setOnMouseEntered(event -> {
				bg.setFill(gradient);
				text.setFill(Color.WHITE);
			});

			setOnMouseExited(event -> {
				bg.setFill(Color.BLACK);
				text.setFill(Color.WHITE);
			});

			setOnMousePressed(event -> {
				bg.setFill(Color.DARKVIOLET);
			});

			setOnMouseReleased(event -> {
				bg.setFill(gradient);
			});
		}
	}
}
