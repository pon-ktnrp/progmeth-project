package gui;

import javafx.animation.AnimationTimer;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class BouncingBallGame {
    public static Parent createGame() {
        Pane root = new Pane();
        root.setPrefSize(860, 600);

        Canvas canvas = new Canvas(860, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Ball properties
        double[] x = {100}, y = {100}; // Position
        double[] dx = {2}, dy = {2};   // Speed
        final double RADIUS = 20;

        // Add the canvas to the root
        root.getChildren().add(canvas);

        // Game loop
        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                // Clear the canvas
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

                // Update ball position
                x[0] += dx[0];
                y[0] += dy[0];

                // Bounce off walls
                if (x[0] <= 0 || x[0] >= canvas.getWidth() - RADIUS * 2) dx[0] = -dx[0];
                if (y[0] <= 0 || y[0] >= canvas.getHeight() - RADIUS * 2) dy[0] = -dy[0];

                // Draw the ball
                gc.setFill(Color.BLUE);
                gc.fillOval(x[0], y[0], RADIUS * 2, RADIUS * 2);
            }
        };

        gameLoop.start();
        return root;
    }
}
