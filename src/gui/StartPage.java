package gui;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.game.GameController;

public class StartPage {

    public static Parent createPage() {
    	GameController instance = GameController.getInstance(); 
        AnchorPane root = new AnchorPane();
        root.setPrefSize(860, 600);

        // Background Rectangle
        Rectangle background = new Rectangle(860, 600);
        background.setFill(Color.web("#362d3e"));
        background.setStroke(Color.web("#362d3e"));
        root.getChildren().add(background);

        // Background Image
        ImageView backgroundImage = createImageView("field1.jpg", 860, 600, 0, 0);
	    backgroundImage.fitWidthProperty().bind(root.widthProperty());
	    backgroundImage.fitHeightProperty().bind(root.heightProperty());
        root.getChildren().add(backgroundImage);

        // Foreground Images
        ImageView frontImage = createImageView("front/"+GameController.getInstance().getPals().get(0).getName()+".png", 287, 279, 502, 127);
        ImageView backImage = createImageView("back/"+GameController.getInstance().getPals().get(0).getName()+".png", 287, 279, 84, 295);
        root.getChildren().addAll(frontImage, backImage);

        // Rectangles
        Rectangle bottomLeftRect = createRectangle(0, 462, 593, 124, "#362d3e", "#c73525", 8);
        Rectangle bottomRightRect = createRectangle(592, 462, 268, 124, "#362d3e", "#c73525", 8);
        root.getChildren().addAll(bottomLeftRect, bottomRightRect);

        Rectangle infoBox1 = createRectangle(60, 73, 360, 68, "#362d3e", "BLACK", 2);
        Rectangle infoBox2 = createRectangle(462, 359, 360, 89, "#362d3e", "BLACK", 2);
        root.getChildren().addAll(infoBox1, infoBox2);

        Rectangle hpBar1 = createRectangle(60, 127, 360, 12, "WHITE", "BLACK", 0);
        Rectangle hpBar2 = createRectangle(462, 391, 360, 12, "WHITE", "BLACK", 0);
        root.getChildren().addAll(hpBar1, hpBar2);

        // ProgressBars
        ProgressBar hpProgress1 = createProgressBar(251, 129, 139, 10, 0.0);
        ProgressBar hpProgress2 = createProgressBar(656, 392, 139, 10, 0.0);
        ProgressBar expProgress = createProgressBar(554, 442, 268, 10, 0.0);
        root.getChildren().addAll(hpProgress1, hpProgress2, expProgress);

        ImageView playerType = createImageView("type/"+GameController.getInstance().getPals().get(0).getType()+".png", 52, 54, 436, 376);
        ImageView enemyType = createImageView("type/"+GameController.getInstance().getPals().get(0).getType()+".png", 52, 54, 394, 76);
        root.getChildren().addAll(playerType, enemyType);

        // Buttons
        Button fightButton = createButton("Fight", 599, 469, 252, 52);
        Button cageButton = createButton("Cage", 725, 524, 127, 52);
        Button palButton = createButton("Pal", 598, 524, 127, 52);
        root.getChildren().addAll(fightButton, cageButton, palButton);

        // Text
        Text hpText1 = createText("Hp", 223, 141, "#3efa7d",23);
        hpText1.setStroke(Color.BLACK);
        hpText1.setStrokeWidth(1);
        Text hpText2 = createText("Hp", 628, 404, "#3efa7d",23);
        hpText2.setStroke(Color.BLACK);
        hpText2.setStrokeWidth(1);
        Text expText = createText("Exp", 533, 442, "#03b7ef",23);
        expText.setStroke(Color.BLACK);
        expText.setStrokeWidth(1);
        root.getChildren().addAll(hpText1, hpText2, expText);
        
        Text wave = createText("Wave 1/50", 690, 36, "WHITE", 25);
        wave.setStroke(Color.BLACK);
        wave.setStrokeWidth(1);
        Text pocket = createText("$"+Integer.toString(instance.getPocket()), 690, 70, "WHITE", 25);
        pocket.setStroke(Color.BLACK);
        pocket.setStrokeWidth(1);
        Text playerName = createText("Bulbasaur", 71, 110, "WHITE", 25);
        Text playerLevel = createText("Lv.5", 290, 110, "WHITE", 25);
        Text playerName = createText(GameController.getInstance().getPals().get(0).getName(), 71, 110, "WHITE", 25);
        Text playerLevel = createText("Lv." + GameController.getInstance().getPals().get(0).getLevel(), 290, 110, "WHITE", 25);
        Text enemyName = createText("Bulbasaur", 486, 384, "WHITE", 25);
        Text enemyLevel = createText("Lv.5", 694, 383, "WHITE", 25);
        Text levelFractionText = createText("12/23", 694, 436, "WHITE", 25);
        Text context = createText("What will " + GameController.getInstance().getPals().get(0).getName() + " do?", 42, 503, "WHITE", 25);
        root.getChildren().addAll(playerName, playerLevel, enemyLevel, enemyName, levelFractionText,context);

        return root;
    }

    private static Rectangle createRectangle(double x, double y, double width, double height, String fillColor, String strokeColor, double strokeWidth) {
        Rectangle rect = new Rectangle(width, height);
        rect.setLayoutX(x);
        rect.setLayoutY(y);
        rect.setFill(Color.web(fillColor));
        rect.setStroke(Color.web(strokeColor));
        rect.setStrokeWidth(strokeWidth);
        rect.setArcHeight(5);
        rect.setArcWidth(5);
        return rect;
    }

    private static ImageView createImageView(String path, double width, double height, double x, double y) {
        ImageView imageView = new ImageView();
		try {
			String classLoaderPath = ClassLoader.getSystemResource(path).toString();
            imageView.setImage(new Image(classLoaderPath));
		} catch (Exception e) {
            System.out.println("Couldn't load image");
		}
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        imageView.setPreserveRatio(true);
        imageView.setLayoutX(x);
        imageView.setLayoutY(y);
        return imageView;
    }

    private static ProgressBar createProgressBar(double x, double y, double width, double height, double progress) {
        ProgressBar progressBar = new ProgressBar(progress);
        progressBar.setLayoutX(x);
        progressBar.setLayoutY(y);
        progressBar.setPrefWidth(width);
        progressBar.setPrefHeight(height);
        return progressBar;
    }

    private static Button createButton(String text, double x, double y, double width, double height) {
        Button button = new Button(text);
        button.setLayoutX(x);
        button.setLayoutY(y);
        button.setPrefWidth(width);
        button.setPrefHeight(height);
        return button;
    }

    private static Text createText(String content, double x, double y, String fillColor, double fontSize) {
        Text text = new Text(content);
        text.setLayoutX(x);
        text.setLayoutY(y);
        text.setFill(Color.web(fillColor));
        text.setFont(Font.font("OCR A Extended", fontSize));
        return text;
    }
}
