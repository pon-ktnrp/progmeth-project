package gui;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class SecondPage {

    public static Parent createPage(String message) {
        StackPane root = new StackPane();
        root.setPrefSize(860, 600);

        Label label = new Label(message);
        label.setStyle("-fx-font-size: 24px; -fx-text-fill: black;");
        root.getChildren().add(label);

        return root;
    }
}

