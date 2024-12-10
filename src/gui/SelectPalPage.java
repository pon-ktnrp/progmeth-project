package gui;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
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

import java.util.ArrayList;
import java.util.Map;

import logic.game.GameController;
import logic.pal.*;

public class SelectPalPage {

    public static Parent createPage() {
        Pane root = new Pane();
        root.setPrefSize(860, 600);

        // Background
        
        ImageView img = new ImageView();
		try {
			String classLoaderPath = ClassLoader.getSystemResource("bg.jpg").toString();
            img.setImage(new Image(classLoaderPath));
		} catch (Exception e) {
            System.out.println("Couldn't load image");
		}
        
        img.fitWidthProperty().bind(root.widthProperty());
        img.fitHeightProperty().bind(root.heightProperty());
        GaussianBlur blur = new GaussianBlur(20); 
        img.setEffect(blur);
        root.getChildren().add(img);

        // Title
        Title title = new Title("Choose Your Pokémon");
        title.setTranslateX(250);
        title.setTranslateY(50);
        root.getChildren().add(title);

        // Pokémon Buttons
        HBox pokemonButtons = new HBox(20);
        pokemonButtons.setTranslateX(100);
        pokemonButtons.setTranslateY(150);
        pokemonButtons.setAlignment(Pos.CENTER);

        BasePal Bulbasaur = new Bulbasaur(5);
        BasePal Charmander = new Charmander(14);
        BasePal Squirtle = new Squirtle(5);
        pokemonButtons.getChildren().addAll(
            createPokemonButton(Bulbasaur),
            createPokemonButton(Charmander),
            createPokemonButton(Squirtle)
        );

        root.getChildren().add(pokemonButtons);
        
	    Back itemExit = new Back("BACK");
	    itemExit.setOnMouseClicked(event -> {
	        MenuScene content = new MenuScene();
	        Scene scene = new Scene(content.createContent());
	        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        stage.setScene(scene);
	    });
	    
	    
	    itemExit.setTranslateX(75);
	    itemExit.setTranslateY(500);
        root.getChildren().add(itemExit);
	    
        return root;
    }

    private static VBox createPokemonButton(BasePal pal) {
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);

        // Image
        ImageView img = new ImageView();
		try {
			String classLoaderPath = ClassLoader.getSystemResource("front/"+pal.getName()+".png").toString();
            img.setImage(new Image(classLoaderPath));
		} catch (Exception e) {
            System.out.println("Couldn't load image");
		}
        img.setFitWidth(100);
        img.setFitHeight(100);

        // Label
        MenuItem name = new MenuItem(pal.getName());

        // Button
        Button selectButton = new Button("Select");
        selectButton.setOnAction(e -> {
            GameController.getInstance().addPals(pal);
            GameController.getInstance().addPals(new Charizard(50));
            GameController.getInstance().addPals(new Blastoise(50));
            GameController.getInstance().addPals(new Arcanine(50));
            GameController.getInstance().addPals(new Bidoof(50));
            GameController.getInstance().addPals(new Caterpie(50));
		    Parent secondPage = StartPage.createPage();
		    Scene newScene = new Scene(secondPage);

		    // Get the current stage and set the new scene
		    Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		    stage.setScene(newScene);
        });

        vbox.getChildren().addAll(img, name, selectButton);
        return vbox;
    }
    
    private static class Title extends StackPane {
		public Title(String name) {
			Rectangle bg = new Rectangle(350, 60);
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
			Rectangle bg = new Rectangle(200, 30);
			bg.setOpacity(0.4);

			Text text = new Text(name);
			text.setFill(Color.WHITE);
			text.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 22));

			setAlignment(Pos.CENTER);
			getChildren().addAll(bg, text);


		}
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
