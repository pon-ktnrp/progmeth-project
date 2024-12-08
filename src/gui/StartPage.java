package gui;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class StartPage {

    public static Parent createPage() {
        AnchorPane root = new AnchorPane();
        root.setPrefSize(860, 600);
        
        // Background Rectangle
        Rectangle backgroundRect = new Rectangle(860, 600);
        backgroundRect.setFill(Color.web("#362d3e"));
        backgroundRect.setStroke(Color.web("#362d3e"));
        root.getChildren().add(backgroundRect);

        // Background Image
        ImageView img = new ImageView();
        try (InputStream is = Files.newInputStream(Paths.get("res/field1.jpg"))) {
            img.setImage(new Image(is));
        } catch (IOException e) {
            System.out.println("Couldn't load image");
        }
        img.setFitWidth(860);
        img.setFitHeight(600);
        img.setPreserveRatio(true);
        AnchorPane.setTopAnchor(img, 0.0);
        AnchorPane.setLeftAnchor(img, 0.0);
        root.getChildren().add(img);



        // Bottom Rectangles
        Rectangle bottomRect1 = createRectangle(0, 462, 593, 124, "#362d3e", "#c73525", 8);
        Rectangle bottomRect2 = createRectangle(592, 462, 268, 124, "#362d3e", "#c73525", 8);
        root.getChildren().addAll(bottomRect1, bottomRect2);

        // Info Boxes
        Rectangle infoBox1 = createRectangle(60, 52, 360, 89, "#362d3e", "BLACK", 0);
        Rectangle infoBox2 = createRectangle(462, 359, 360, 89, "#362d3e", "BLACK", 0);
        root.getChildren().addAll(infoBox1, infoBox2);

        // HP Bars
        Rectangle hpBar1 = createRectangle(60, 127, 360, 12, "WHITE", "BLACK", 0);
        Rectangle hpBar2 = createRectangle(462, 391, 360, 12, "WHITE", "BLACK", 0);
        root.getChildren().addAll(hpBar1, hpBar2);

        // ProgressBars
        ProgressBar hpProgress1 = createProgressBar(251, 129, 139, 10, 0.0);
        ProgressBar hpProgress2 = createProgressBar(656, 392, 139, 10, 0.0);
        ProgressBar expProgress = createProgressBar(554, 442, 268, 10, 0.0);
        root.getChildren().addAll(hpProgress1, hpProgress2, expProgress);

        // Text Labels
        Text hpLabel1 = createText("Hp", 223, 141, "#3efa7d");
        Text hpLabel2 = createText("Hp", 628, 404, "#3efa7d");
        Text expLabel = createText("Exp", 533, 442, "#03b7ef");
        root.getChildren().addAll(hpLabel1, hpLabel2, expLabel);
        
        createButton(root, "Fight", 599, 469, 252, 52);
        createButton(root, "Cage", 725, 524, 127, 52);
        createButton(root, "Pal", 598, 524, 127, 52);


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

    private static ProgressBar createProgressBar(double x, double y, double width, double height, double progress) {
        ProgressBar progressBar = new ProgressBar(progress);
        progressBar.setLayoutX(x);
        progressBar.setLayoutY(y);
        progressBar.setPrefWidth(width);
        progressBar.setPrefHeight(height);
        return progressBar;
    }
    
    private static void createButton(AnchorPane root, String text, double x, double y, double width, double height) {
        Button button = new Button(text);
        button.setPrefSize(width, height);
        button.setLayoutX(x);
        button.setLayoutY(y);
        root.getChildren().add(button);
    }

    private static Text createText(String content, double x, double y, String fillColor) {
        Text text = new Text(content);
        text.setLayoutX(x);
        text.setLayoutY(y);
        text.setFill(Color.web(fillColor));
        text.setStroke(Color.BLACK);
        text.setStrokeWidth(1.25);
        text.setFont(Font.font("OCR A Extended", 25));
        return text;
    }
}
