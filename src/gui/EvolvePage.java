package gui;


import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import logic.game.GameController;
import logic.pal.BasePal;
import utils.Evolvable;

public class EvolvePage {

	public static Parent createPage(BasePal player) {
		GameController instance = GameController.getInstance();
		AnchorPane root = new AnchorPane();
		root.setPrefSize(860, 600);

		// Background Rectangle

		// Background Image
		ImageView backgroundImage = createImageView("evolve.jpg", 860, 600, 0, 0);
		backgroundImage.fitWidthProperty().bind(root.widthProperty());
		backgroundImage.fitHeightProperty().bind(root.heightProperty());
		backgroundImage.setPreserveRatio(false);
		root.getChildren().add(backgroundImage);
		ImageView frontImage = createImageView("front/" + ((Evolvable) player).evolve().getName() + ".png", 296, 250, 502,
				55);
		frontImage.setLayoutX(502); // Ensure layout is set properly
		frontImage.setLayoutY(55);// Start off-screen // Animate to the target position
		
		ImageView backImage = createImageView(
				"back/" + player.getName() + ".png", 287, 279, 84,
				295);
		// Animate front image from its starting position to the middle
		// Animate front image from its starting position to the middle
		addSlideAnimation(frontImage, -500, -500, 296, 150, 3); // Starts off-screen to the right (860, 55)

		// Animate back image from the middle to its final position
		addSlideAnimation(backImage, 296, 150, 2000, 2000, 3); // Starts from the middle (296, 250) and moves to (84, 295)


		root.getChildren().addAll(frontImage, backImage);
		Rectangle bottomLeftRect = createRectangle(0, 462, 630, 124, "#362d3e", "#c73525", 8);
		root.getChildren().addAll(bottomLeftRect);
		Text context = createText("What hapeening???"+"\n"+player.getName()+" is evolved into "+((Evolvable) player).evolve().getName(), 42, 503, "WHITE", 25);
		root.getChildren().addAll(context);
	    Back itemExit = new Back("BACK");
	    itemExit.setOnMouseClicked(e -> {
		    Parent secondPage = StartPage.createPage();
		    Scene newScene = new Scene(secondPage);

		    // Get the current stage and set the new scene
		    Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		    stage.setScene(newScene);
	    });
	    
	    
	    itemExit.setTranslateX(650);
	    itemExit.setTranslateY(500);
        root.getChildren().add(itemExit);

		return root;
}
	private static void addSlideAnimation(ImageView imageView, double startX, double startY, double targetX, double targetY, double durationSeconds) {
	    TranslateTransition slide = new TranslateTransition();
	    slide.setNode(imageView);
	    slide.setDuration(Duration.seconds(durationSeconds));

	    // Set starting and ending positions
	    slide.setFromX(startX - imageView.getLayoutX());
	    slide.setFromY(startY - imageView.getLayoutY());
	    slide.setToX(targetX - imageView.getLayoutX());
	    slide.setToY(targetY - imageView.getLayoutY());

	    slide.play(); // Start the animation
	}


	private static Rectangle createRectangle(double x, double y, double width, double height, String fillColor,
			String strokeColor, double strokeWidth) {
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
	
	private static class Back extends StackPane {
		public Back(String name) {
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
