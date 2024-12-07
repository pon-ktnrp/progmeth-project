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
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UpgradePage {

	public static Parent createPage() {
		Pane root = new Pane();

		root.setPrefSize(860, 600);
		// Create an ImageView for the background
		ImageView img = new ImageView();
		try (InputStream is = Files.newInputStream(Paths.get("res/bg1.jpg"))) {
			img.setImage(new Image(is));
		} catch (IOException e) {
			System.out.println("Couldn't load image");
		}

		// Bind the size of the ImageView to the Pane's size
		img.fitWidthProperty().bind(root.widthProperty());
		img.fitHeightProperty().bind(root.heightProperty());

		// Add the ImageView as the first child of the root
		root.getChildren().add(img);

		Title title = new Title("U p g r a d e");
		title.setTranslateX(75);
		title.setTranslateY(75);

		MenuItem itemExit = new MenuItem("EXIT");
		itemExit.setOnMouseClicked(event -> System.exit(0));
		UpgradeItem Hp = new UpgradeItem("Hp");
		UpgradeItem SpAtt = new UpgradeItem("Sp. Attack");
		UpgradeItem SpDef = new UpgradeItem("Sp. Defense");
		UpgradeItem Att = new UpgradeItem("Attack");
		UpgradeItem Def = new UpgradeItem("DEfense");
		UpgradeItem Luck = new UpgradeItem("Luck");		
		MenuBox menu1 = new MenuBox(Hp, SpAtt, SpDef);
		MenuBox menu2 = new MenuBox(Att, Def, Luck);

		menu1.setTranslateX(75);
		menu1.setTranslateY(200);
		menu2.setTranslateX(75);
		menu2.setTranslateY(300);

		root.getChildren().addAll(menu1,menu2,title);

		return root;
	}

	private static class MenuBox extends HBox {
		public MenuBox(UpgradeItem... items) {
			getChildren().add(createSeparator());

			for (UpgradeItem item : items) {
				getChildren().addAll(item, createSeparator());
			}
		}

		private Line createSeparator() {
			Line sep = new Line();
			sep.setEndX(10);
			sep.setStroke(Color.DARKGREY);
			return sep;
		}
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
	
	private static class UpgradeItem extends VBox {
		public UpgradeItem(String name) {
			MenuItem itemStart = new MenuItem(name);
			itemStart.setOnMouseClicked(event -> {

				Parent secondPage = UpgradePage.createPage();
				Scene newScene = new Scene(secondPage);

				// Get the current stage and set the new scene
				Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				stage.setScene(newScene);

			});
			getChildren().addAll(itemStart);
		}

	}
}
