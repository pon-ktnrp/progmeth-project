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
import logic.game.GameController;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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

public class Win {

	public static Parent createPage() {
	    Pane root = new Pane();

	    root.setPrefSize(860, 600);
	    // Create an ImageView for the background
        ImageView img = new ImageView();
		try {
			String classLoaderPath = ClassLoader.getSystemResource("victory.jpg").toString();
            img.setImage(new Image(classLoaderPath));
		} catch (Exception e) {
            System.out.println("Couldn't load image");
		}
	    img.fitWidthProperty().bind(root.widthProperty());
	    img.fitHeightProperty().bind(root.heightProperty());
	    MenuItem itemExit = new MenuItem("BACK");
	    itemExit.setOnMouseClicked(event -> {
			GameController.getInstance().resetGame();
	        MenuScene content = new MenuScene();
	        Scene scene = new Scene(content.createContent());
	        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        stage.setScene(scene);
	    });


	    itemExit.setTranslateX(330);
	    itemExit.setTranslateY(330);
	    root.getChildren().addAll(img,itemExit);

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
		GameController gameInstance = GameController.getInstance();
		private final Rectangle[] boxes = new Rectangle[3]; // Three blank boxes
		private final int[] costs = { 50, 100, 500 }; // Costs for each box
		private final Label[] costLabels = new Label[3]; // Labels to display costs

		private String variableName;
		private Label moneyDisplay; // Reference to money display label

		public UpgradeItem(String name, Label moneyDisplay) {
		    this.moneyDisplay = moneyDisplay; // Assign the label
		    this.variableName = name;
		    MenuItem itemStart = new MenuItem(name);

		    HBox boxContainer = new HBox(5); 
	        boxContainer.setAlignment(Pos.CENTER);// Add spacing between boxes
		    for (int i = 0; i < 3; i++) {
		        VBox boxWithCost = new VBox(2); // Container for box and its label
		        Rectangle box = new Rectangle(50, 30); // Box dimensions
		        box.setFill(Color.TRANSPARENT); // Initially blank
		        box.setStroke(Color.BLACK); // Border for visibility
		        box.setStrokeWidth(3);
		        boxes[i] = box;

		        Label costLabel = new Label("$" + costs[i]); // Display cost
		        costLabel.setTextFill(Color.WHITE);
		        costLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
		        costLabels[i] = costLabel;

		        boxWithCost.setAlignment(Pos.CENTER);
		        boxWithCost.getChildren().addAll(box, costLabel);
		        boxContainer.getChildren().add(boxWithCost);
		    }
		    
	        initializeBoxes();
		    // Set click event for the UpgradeItem
		    itemStart.setOnMouseClicked(event -> fillBox());

		    getChildren().addAll(itemStart, boxContainer);
		}
		
	    private void initializeBoxes() {
	        int currentLevel = getGameControllerVariable();
	        for (int i = 0; i < currentLevel && i < boxes.length; i++) {
	            boxes[i].setFill(Color.RED); // Mark the box as filled
	            costLabels[i].setText(""); // Clear the cost label
	        }
	    }
	    
	    private int getGameControllerVariable() {
	        switch (variableName) {
	            case "xHp":
	                return gameInstance.getxHp();
	            case "xAtt":
	                return gameInstance.getxAtt();
	            case "xDef":
	                return gameInstance.getxDef();
	            case "xSpAtt":
	                return gameInstance.getxSpAtt();
	            case "xSpDef":
	                return gameInstance.getxSpDef();
	            case "xSpeed":
	                return gameInstance.getxSpeed();
	            default:
	                System.out.println("Unknown variable: " + variableName);
	                return 0;
	        }
	    }


		private void fillBox() {
			int playerMoney = GameController.getInstance().getMoney();
			for (int i = 0; i < boxes.length; i++) {
				if (boxes[i].getFill() == Color.TRANSPARENT) {
					if (playerMoney >= costs[i]) {
						boxes[i].setFill(Color.RED);
						GameController.getInstance().setMoney(playerMoney -= costs[i]);
						costLabels[i].setText(""); // Update label to show "Filled"
	                    updateGameControllerVariable(i + 1);
					} else {
						showDialog("Failure", "Not enough money! You need $" + costs[i] + ".", Alert.AlertType.ERROR);
					}
					updatePlayerMoneyDisplay(); // Update the money display
					break; // Stop after filling one box
				}
			}
		}
		
	    private void updateGameControllerVariable(int newValue) {
	        switch (variableName) {
	            case "xHp":
	                gameInstance.setxHp(newValue);
	                break;
	            case "xAtt":
	                gameInstance.setxAtt(newValue);
	                break;
	            case "xDef":
	                gameInstance.setxDef(newValue);
	                break;
	            case "xSpAtt":
	                gameInstance.setxSpAtt(newValue);
	                break;
	            case "xSpDef":
	                gameInstance.setxSpDef(newValue);
	                break;
	            case "xSpeed":
	                gameInstance.setxSpeed(newValue);
	                break;
	            default:
	                System.out.println("Unknown variable: " + variableName);
	        }
	    }

		private void updatePlayerMoneyDisplay() {
		    moneyDisplay.setText("Point: $" + GameController.getInstance().getMoney());
		}


		private void showDialog(String title, String message, Alert.AlertType type) {
			Alert alert = new Alert(type);
			alert.setTitle(title);
			alert.setHeaderText(null); // No header text
			alert.setContentText(message);
			alert.showAndWait(); // Wait for the user to close the dialog
		}

	}

}
