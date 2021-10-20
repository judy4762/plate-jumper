package js.jumpnrun;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainGame extends Application {

    private Background background;
    private PlateList plates;
    private CloudList clouds;
    private int counterVal = 200;


    @Override
    public void start(Stage stage) {
        stage.setTitle("Jump N Run");
        stage.setResizable(false);

        // Show start menu scene
        showMenuScene(stage);
    }


    /**
     * Launches the game.
     */
    public static void main(String[] args) {
        launch();
    }


    /**
     * Runs the actual game after pressing the start button and counting down the counter.
     * Includes the game loop.
     *
     * @param stage handed over to put the scene on
     */
    public void run(Stage stage) {
        // Create Scene that shows the background
        background = new Background();
        Scene gameScene = new Scene(background, Const.DISPLAY_WIDTH, Const.DISPLAY_HEIGHT);

        // Show game scene on the stage
        stage.setScene(gameScene);
        stage.show();

        // Add some clouds to the background
        clouds = new CloudList();
        background.getChildren().addAll(clouds);

        // Add plates to the background group
        plates = new PlateList();
        background.getChildren().addAll(plates);

        // Game animation
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                //TODO if (!avatar.isLiving()) showGameOverScene(stage);
                clouds.move();
                plates.move();
                background.moveWater();
            }
        };
        timer.start();

        // Add Key Event Handler
        gameScene.setOnKeyPressed(ev -> {
            switch (ev.getCode()) {
                case ESCAPE -> {
                    timer.stop();
                    showGameOverScene(stage);
                }
                case SPACE -> System.out.println("avatar.jump()"); // TODO
                default -> {
                }
            }
        });

        System.out.println(">>> Game");
    }


    /**
     * Shows the start scene in the stage, with two buttons "start" and "about".
     *
     * @param stage handed over to put the scene on.
     */
    public void showMenuScene(Stage stage) {
        background = new Background();

        // Create VBox with buttons
        VBox vbox = new VBox(20);
        vbox.setMinSize(Const.DISPLAY_WIDTH, Const.DISPLAY_HEIGHT - Const.WATER_HEIGHT);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(30, 30, 30, 30));

        Button startButton = new Button("START");
        Button aboutButton = new Button("ABOUT");
        aboutButton.setMinSize(250, 30);
        startButton.setMinSize(250, 30);

        vbox.getChildren().addAll(startButton);
        vbox.getChildren().add(aboutButton);

        background.getChildren().addAll(vbox);

        // Add Action Handler for buttons
        startButton.setOnAction(ev -> showCounterScene(stage));
        aboutButton.setOnAction(ev -> showAboutScene(stage));

        // Show menu scene on the stage
        Scene startScene = new Scene(background, Const.DISPLAY_WIDTH, Const.DISPLAY_HEIGHT);
        stage.setScene(startScene);
        stage.show();
        System.out.println(">>> Menu");
    }


    /**
     * Draws the counter 3 - 1 after pushing the start button for the game.
     *
     * @param stage handed over to put the scene on.
     */
    public void showCounterScene(Stage stage) {
        background = new Background();

        // Create VBox with one Label for showing the counter
        VBox vbox = new VBox(10);
        vbox.setMinSize(Const.DISPLAY_WIDTH, Const.DISPLAY_HEIGHT - Const.WATER_HEIGHT);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(30, 30, 30, 30));

        Label counter = new Label("3");
        counter.setStyle("-fx-font-size: 50;");
        counter.setTextFill(Color.rgb(26, 143, 255));

        vbox.getChildren().addAll(counter);
        background.getChildren().addAll(vbox);

        // Show counter scene on the stage
        Scene counterScene = new Scene(background, Const.DISPLAY_WIDTH, Const.DISPLAY_HEIGHT);
        stage.setScene(counterScene);
        stage.show();

        // Animate the counter
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if (counterVal < 50) {
                    this.stop();
                    counterVal = 200;
                    run(stage);
                } else if (counterVal < 100) {
                    counter.setText("1");
                } else if (counterVal < 150) {
                    counter.setText("2");
                }
                decCounter();
            }
        };
        timer.start();
        System.out.println(">>> Counter");
    }


    /**
     * Shows the "about" scene in the stage with some information about the game.
     *
     * @param stage handed over to put the scene on.
     */
    public void showAboutScene(Stage stage) {
        background = new Background();

        // Create VBox for alignment of scene elements
        VBox vbox = new VBox(10);
        vbox.setMinSize(Const.DISPLAY_WIDTH, Const.DISPLAY_HEIGHT - Const.WATER_HEIGHT);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(30, 30, 30, 30));

        // Create content elements for the scene
        Label[] labels = {new Label("Judys Jump n Run Game"), new Label("Computer Graphics"), new Label("2021")};

        for (Label label : labels) {
            label.setStyle("-fx-font-size: 15;");
            label.setTextFill(Color.rgb(26, 143, 255));
        }

        Button menuButton = new Button("MENU");
        menuButton.setMinSize(250, 30);
        menuButton.setOnAction(ev -> showMenuScene(stage));

        // Add content to the background group
        vbox.getChildren().addAll(labels);
        vbox.getChildren().add(menuButton);
        background.getChildren().addAll(vbox);

        // Show scene on the stage
        Scene counterScene = new Scene(background, Const.DISPLAY_WIDTH, Const.DISPLAY_HEIGHT);
        stage.setScene(counterScene);
        stage.show();
        System.out.println(">>> About");
    }


    /**
     * Shows the "game over" scene with the achieved score and a button back to the menu
     *
     * @param stage handed over to put the scene on.
     */
    public void showGameOverScene(Stage stage) {
        background = new Background();

        // Create VBox for alignment of scene elements
        VBox vbox = new VBox(10);
        vbox.setMinSize(Const.DISPLAY_WIDTH, Const.DISPLAY_HEIGHT - Const.WATER_HEIGHT);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(30, 30, 30, 30));

        // Create content elements for the scene
        // TODO view points
        Label[] labels = {new Label("Game Over"), new Label("You achieved xxx points")};

        for (Label label : labels) {
            label.setStyle("-fx-font-size: 15;");
            label.setTextFill(Color.rgb(26, 143, 255));
        }

        Button[] buttons = {new Button("MENU"), new Button("START NEW GAME")};
        for (Button button : buttons) {
            button.setMinSize(250, 30);
        }
        buttons[0].setOnAction(ev -> showMenuScene(stage));
        buttons[1].setOnAction(ev -> showCounterScene(stage));

        // Add content to the background group
        vbox.getChildren().addAll(labels);
        vbox.getChildren().addAll(buttons);
        background.getChildren().addAll(vbox);

        // Show scene on the stage
        Scene counterScene = new Scene(background, Const.DISPLAY_WIDTH, Const.DISPLAY_HEIGHT);
        stage.setScene(counterScene);
        stage.show();
        System.out.println(">>> Game Over");
    }

    /**
     * Declines the counter for the counter scene.
     */
    public void decCounter() {
        counterVal--;
    }

}