package gui;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
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
import javafx.util.Duration;
import logic.game.GameController;
import logic.pal.BasePal;

public class StartPage {

	private static ImageView backgroundImage;
	private static ImageView frontImage;
	private static ImageView backImage;
	private static ProgressBar hpProgress1;
	private static ProgressBar hpProgress2;
	private static ProgressBar expProgress;
	private static ImageView playerType;
	private static ImageView enemyType;
	private static Text pocket;
	private static Text wave;
	private static Text context;
	private static Text playerName;
	private static Text playerLevel;
	private static Text enemyName;
	private static Text enemyLevel;
	private static Text levelFractionText;
	private static Boolean playerTurn;
	private static boolean isAnimating = false;
	private static Timeline currentAnimation;
	private static Button fightButton;
	private static Button palButton;
	private static Button cageButton;
	private static String fulltext;

	GameController instance = GameController.getInstance();

	public static Parent createPage() {
		GameController instance = GameController.getInstance();
		AnchorPane root = new AnchorPane();
		root.setPrefSize(860, 600);
		playerTurn = true;
		// Background Rectangle
		Rectangle background = new Rectangle(860, 600);
		background.setFill(Color.web("#362d3e"));
		background.setStroke(Color.web("#362d3e"));
		root.getChildren().add(background);

		// Background Image
		backgroundImage = createImageView("field1.jpg", 860, 600, 0, 0);
		backgroundImage.fitWidthProperty().bind(root.widthProperty());
		backgroundImage.fitHeightProperty().bind(root.heightProperty());
		root.getChildren().add(backgroundImage);

		// Foreground Images
		frontImage = createImageView("front/" + instance.getEnemy().get(0).getName() + ".png", 287, 279, 502, 127);
		frontImage.setLayoutX(502); // Ensure layout is set properly
		frontImage.setLayoutY(127);// Start off-screen
		addSlideInAnimation(frontImage, 502, 127, 860); // Animate to the target position

		backImage = createImageView("back/" + GameController.getInstance().getPals().get(0).getName() + ".png", 287,
				279, 84, 295);
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
		hpProgress1 = createProgressBar(251, 129, 139, 10,
				Double.valueOf(GameController.getInstance().getEnemy().get(0).getHp())
						/ Double.valueOf(GameController.getInstance().getEnemy().get(0).getMaxHp()));
		hpProgress2 = createProgressBar(656, 392, 139, 10,
				Double.valueOf(GameController.getInstance().getPals().get(0).getHp())
						/ Double.valueOf(GameController.getInstance().getPals().get(0).getMaxHp()));
		expProgress = createProgressBar(554, 442, 268, 10, GameController.getInstance().getPals().get(0).getExp()
				/ GameController.getInstance().getPals().get(0).getExpThreshold());
		hpProgress1.setStyle("-fx-accent: green;");
		hpProgress2.setStyle("-fx-accent: green;");
		root.getChildren().addAll(hpProgress1, hpProgress2, expProgress);

		playerType = createImageView("type/" + GameController.getInstance().getPals().get(0).getType() + ".png", 52, 54,
				436, 376);
		enemyType = createImageView("type/" + GameController.getInstance().getEnemy().get(0).getType() + ".png", 52, 54,
				394, 76);
		root.getChildren().addAll(playerType, enemyType);

		// Buttons

		// Text
		Text hpText1 = createText("Hp", 223, 141, "#3efa7d", 23);
		hpText1.setStroke(Color.BLACK);
		hpText1.setStrokeWidth(1);
		Text hpText2 = createText("Hp", 628, 404, "#3efa7d", 23);
		hpText2.setStroke(Color.BLACK);
		hpText2.setStrokeWidth(1);
		Text expText = createText("Exp", 533, 442, "#03b7ef", 23);
		expText.setStroke(Color.BLACK);
		expText.setStrokeWidth(1);
		root.getChildren().addAll(hpText1, hpText2, expText);

		wave = createText("Wave 1/50", 690, 36, "WHITE", 25);
		wave.setStroke(Color.BLACK);
		wave.setStrokeWidth(1);
		pocket = createText("$" + Integer.toString(instance.getPocket()), 690, 70, "WHITE", 25);
		pocket.setStroke(Color.BLACK);
		pocket.setStrokeWidth(1);
		playerName = createText(GameController.getInstance().getPals().get(0).getName(), 486, 384, "WHITE", 25);
		playerLevel = createText("Lv." + GameController.getInstance().getPals().get(0).getLevel(), 694, 383, "WHITE",
				25);
		enemyName = createText(GameController.getInstance().getEnemy().get(0).getName(), 71, 110, "WHITE", 25);
		enemyLevel = createText("Lv." + GameController.getInstance().getEnemy().get(0).getLevel(), 290, 110, "WHITE",
				25);

		levelFractionText = createText((GameController.getInstance().getPals().get(0).getExp()) + "/"
				+ (GameController.getInstance().getPals().get(0).getExpThreshold()), 694, 436, "WHITE", 25);
		context = createText("", 42, 503, "WHITE", 25);
		root.getChildren().addAll(playerName, playerLevel, enemyLevel, enemyName, levelFractionText, context, wave,
				pocket);
		fightButton = createButton("Fight", 599, 469, 252, 52);
		fightButton.setOnAction(e -> {
			if (playerTurn) {
				BasePal enemy = GameController.getInstance().getEnemy().get(GameController.getInstance().getWave());
				enemy.setHp(0); // Reduce HP or apply attack damage
				// Switch to enemy turn
			}
		});
		cageButton = createButton("Cage", 725, 524, 127, 52);
		palButton = createButton("Pal", 598, 524, 127, 52);
		root.getChildren().addAll(fightButton, cageButton, palButton);

		startGameLoop();

		return root;
	}

	private static void startGameLoop() {
		Timeline gameLoop = new Timeline(new KeyFrame(Duration.seconds(0.5), e -> {
			GameController instance = GameController.getInstance();
			BasePal enemy = instance.getEnemy().get(instance.getWave());

			if (playerTurn) {

				String desiredText = "What will " + instance.getPals().get(0).getName() + " do?";
				if (!desiredText.equals(context.getText()) && !isAnimating) { // Check flag
					isAnimating = true;
					addWriteOnAnimation(context, desiredText, Duration.seconds(0.5), () -> {
						isAnimating = false; // Reset flag after animation completes
						setPlayerControlsEnabled(true);
					});
				}
			} else {
				// Handle enemy turn logic

			}

			// Check if the enemy is defeated
			if (enemy.getHp() <= 0) {
				instance.nextWave();
				if (instance.getWave() > 50) {
					context.setText("You Win!");
					return; // Stop game loop; game over
				}

				loadNextEnemy();
			}

			// Update wave text
			wave.setText("Wave " + instance.getWave() + "/50");
		}));

		gameLoop.setCycleCount(Timeline.INDEFINITE); // Run indefinitely
		gameLoop.play();
	}

	private static void animateHpBar(ProgressBar progressBar, double newProgress, Duration duration) {
		Timeline timeline = new Timeline();
		timeline.getKeyFrames().add(new KeyFrame(duration, new KeyValue(progressBar.progressProperty(), newProgress)));
		timeline.play();
	}

	private static void loadNextEnemy() {
		GameController instance = GameController.getInstance();
		int waveIndex = instance.getWave();


		if (waveIndex < instance.getEnemy().size()) {
			BasePal enemy = instance.getEnemy().get(waveIndex);

			// Update enemy UI
			enemyLevel.setText("Lv." + enemy.getLevel());
			enemyName.setText(enemy.getName());
			hpProgress1.setProgress((double) enemy.getHp() / enemy.getMaxHp());

			// Add more debug statements here

			try {
				String enemyImagePath = "front/" + enemy.getName() + ".png";
				frontImage.setImage(new Image(ClassLoader.getSystemResource(enemyImagePath).toString()));
			} catch (Exception e) {
			}

			try {
				String enemyTypePath = "type/" + enemy.getType() + ".png";
				enemyType.setImage(new Image(ClassLoader.getSystemResource(enemyTypePath).toString()));
			} catch (Exception e) {
				System.out.println("Couldn't load enemy type image: " + e.getMessage());
			}

			// Add animation
			addSlideInAnimation(frontImage, 502, 127, 860);
			String desiredText = "You defeated " + instance.getEnemy().get(instance.getWave() - 1).getName() + " !!"
					+ "\n" + "A wild " + enemy.getName() + " appears!";
			if (!desiredText.equals(context.getText()) && !isAnimating) {
				isAnimating = true;
				addWriteOnAnimation(context, desiredText, Duration.seconds(1.5), () -> {
					isAnimating = false;
				});
			}
		} else {
			System.out.println("No enemy available for the current wave!");
		}
	}

	private static void addWriteOnAnimation(Text textNode, String fullText, Duration duration, Runnable onComplete) {
		int textLength = fullText.length();
		Timeline timeline = new Timeline();

		// Disable controls during animation
		setPlayerControlsEnabled(false);

		for (int i = 0; i <= textLength; i++) {
			final int currentIndex = i;
			KeyFrame keyFrame = new KeyFrame(duration.divide(textLength).multiply(currentIndex),
					e -> textNode.setText(fullText.substring(0, currentIndex)));
			timeline.getKeyFrames().add(keyFrame);
		}

		timeline.setOnFinished(e -> {
			// Enable controls after animation
			onComplete.run(); // Execute callback
		});
		timeline.play();
	}

	private static void setPlayerControlsEnabled(boolean enabled) {
		fightButton.setDisable(!enabled);
		cageButton.setDisable(!enabled);
		palButton.setDisable(!enabled);
	}

	private static void addSlideInAnimation(ImageView imageView, double targetX, double targetY, double screenWidth) {
		TranslateTransition slideIn = new TranslateTransition();
		slideIn.setNode(imageView);
		slideIn.setDuration(Duration.seconds(1.25)); // Duration of the animation

		// Start off-screen on the right
		slideIn.setFromX(screenWidth); // Screen width to ensure it's off the right edge
		slideIn.setToX(targetX - imageView.getLayoutX()); // Target position relative to layout

		// Vertical movement (optional, if needed)
		slideIn.setFromY(targetY - imageView.getLayoutY());
		slideIn.setToY(targetY - imageView.getLayoutY());

		slideIn.play(); // Start the animation
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
}
