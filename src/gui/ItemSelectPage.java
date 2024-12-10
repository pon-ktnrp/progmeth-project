package gui;

import java.util.Map;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
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
import logic.game.GameController;
import logic.pal.BasePal;
import logic.pal.Charmander;
import logic.pal.Squirtle;

public class ItemSelectPage {
	private static BasePal target;
	private static int position;

    public static Parent createContent(int index,BasePal entity) {
    	target = entity;
    	position = index;
    	GameController instance = GameController.getInstance();
        AnchorPane root = new AnchorPane();
        root.setPrefSize(860, 600);

        // Background Image
        ImageView img = new ImageView();
        try {
            String bgPath = ClassLoader.getSystemResource("bg1.jpg").toString();
            img.setImage(new Image(bgPath));
        } catch (Exception e) {
            System.out.println("Couldn't load background image.");
        }
        img.fitWidthProperty().bind(root.widthProperty());
        img.fitHeightProperty().bind(root.heightProperty());
        root.getChildren().add(img);

        // Creating Pokemon Info Panels
        int size = instance.getPals().size();
        if (size>=1) {
        	root.getChildren().add(createPokemonPanel(0, 13,0));
        }
        if (size >=2) {
        	root.getChildren().add(createPokemonPanel(390, 83,1));        	
        }
        if (size>=3) {
        	root.getChildren().add(createPokemonPanel(0, 160,2));        	
        }
        if (size>=4) {
        	root.getChildren().add(createPokemonPanel(390, 246,3));       	
        }
        if (size>=5) {
        	root.getChildren().add(createPokemonPanel(0, 314,4));        	
        }if (size ==6) {
        	root.getChildren().add(createPokemonPanel(390, 384,5));        	
        }
	    Back itemExit = new Back("BACK");
	    itemExit.setOnMouseClicked(e -> {
		    Parent secondPage = StartPage.createPage();
		    Scene newScene = new Scene(secondPage);

		    // Get the current stage and set the new scene
		    Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		    stage.setScene(newScene);
	    });
	    
	    
	    itemExit.setTranslateX(75);
	    itemExit.setTranslateY(500);

        return root;
    }

    private static Pane createPokemonPanel(double x, double y,int index) {
    	GameController instance = GameController.getInstance();
    	BasePal pal = instance.getPal(index);
        Pane pane = new Pane();
        pane.setLayoutX(x);
        pane.setLayoutY(y);

        // Background Rectangle
        Rectangle bg = new Rectangle(69, 26, 360, 89);
        bg.setArcWidth(5);
        bg.setArcHeight(5);
        bg.setFill(Color.web("#362d3e"));
        pane.getChildren().add(bg);

        // HP Bar
        int currentHp = pal.getHp();
        int maxHp = pal.getMaxHp();
        ProgressBar hpBar = new ProgressBar((double) currentHp / maxHp);
        hpBar.setLayoutX(263);
        hpBar.setLayoutY(59);
        hpBar.setPrefWidth(139);
        hpBar.setPrefHeight(10);
        pane.getChildren().add(hpBar);

        // HP Label
        Text hpLabel = new Text("Hp");
        hpLabel.setFont(Font.font("OCR A Extended", 23));
        hpLabel.setFill(Color.web("#3efa7d"));
        hpLabel.setLayoutX(235);
        hpLabel.setLayoutY(71);
        pane.getChildren().add(hpLabel);

        // EXP Bar
        int currentExp = pal.getExp();
        int maxExp = pal.getExpThreshold();
        ProgressBar expBar = new ProgressBar((double) currentExp / maxExp);
        expBar.setLayoutX(161);
        expBar.setLayoutY(109);
        expBar.setPrefWidth(268);
        expBar.setPrefHeight(10);
        pane.getChildren().add(expBar);

        // EXP Label
        Text expLabel = new Text("Exp");
        expLabel.setFont(Font.font("OCR A Extended", 23));
        expLabel.setFill(Color.web("#03b7ef"));
        expLabel.setLayoutX(140);
        expLabel.setLayoutY(116);
        pane.getChildren().add(expLabel);

        // Pokemon Icon
        ImageView icon = new ImageView();
        try {
            String iconPath = ClassLoader.getSystemResource("type/"+pal.getType()+".png").toString();
            icon.setImage(new Image(iconPath));
        } catch (Exception e) {
            System.out.println("Couldn't load icon image.");
        }
        icon.setFitWidth(54);
        icon.setFitHeight(52);
        icon.setLayoutX(403);
        icon.setLayoutY(38);
        pane.getChildren().add(icon);

        // Pokemon Name
        String name = pal.getName();
        Text nameLabel = new Text(name);
        nameLabel.setFont(Font.font("OCR A Extended", 25));
        nameLabel.setFill(Color.WHITE);
        nameLabel.setLayoutX(93);
        nameLabel.setLayoutY(52);
        pane.getChildren().add(nameLabel);

        // Pokemon Level
        String level = Integer.toString(pal.getLevel());
        Text levelLabel = new Text("Lv." + level);
        levelLabel.setFont(Font.font("OCR A Extended", 25));
        levelLabel.setFill(Color.WHITE);
        levelLabel.setLayoutX(302);
        levelLabel.setLayoutY(52);
        pane.getChildren().add(levelLabel);

        // HP Text
        Text hpText = new Text(currentHp + "/" + maxHp);
        hpText.setFont(Font.font("OCR A Extended", 25));
        hpText.setFill(Color.WHITE);
        hpText.setLayoutX(302);
        hpText.setLayoutY(98);
        pane.getChildren().add(hpText);

        // Pokemon Image
        ImageView pokemonImage = new ImageView();
        try {
            String imgPath = ClassLoader.getSystemResource("front/"+pal.getName()+".png").toString();
            pokemonImage.setImage(new Image(imgPath));
        } catch (Exception e) {
            System.out.println("Couldn't load Pokemon image.");
        }
        pokemonImage.setFitWidth(139);
        pokemonImage.setFitHeight(145);
        pokemonImage.setPreserveRatio(true);
        pokemonImage.setLayoutX(0);
        pokemonImage.setLayoutY(15);
        pane.getChildren().add(pokemonImage);
        

		LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE,
				new Stop[] { new Stop(0, Color.DARKVIOLET), new Stop(0.1, Color.BLACK), new Stop(0.9, Color.BLACK),
						new Stop(1, Color.DARKVIOLET) });

		pane.setOnMouseEntered(event -> {
			bg.setFill(gradient);

		});

		pane.setOnMouseExited(event -> {
			bg.setFill(Color.web("#362d3e"));

		});

		pane.setOnMousePressed(event -> {
			bg.setFill(Color.DARKVIOLET);
		});

		pane.setOnMouseReleased(event -> {
			bg.setFill(gradient);
		});
		if (position==1) {
	        pane.setOnMouseClicked(e -> {
	        	instance.getPals().set(index, target);
			    Parent secondPage = StartPage.createPage();
			    Scene newScene = new Scene(secondPage);

			    // Get the current stage and set the new scene
			    Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			    stage.setScene(newScene);
			    StartPage.setPlayerTurn(true);
	        });
		}


        return pane;
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
