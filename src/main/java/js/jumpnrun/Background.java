package js.jumpnrun;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Background extends Pane {

    private final Rectangle water;
    private int waterMovement;
    private boolean waterUp;

    /**
     * Constructor for Background.
     * Sets the color of the sky and adds water to the bottom.
     */
    public Background() {
        this.setStyle("-fx-background-color: rgb(200, 222, 255)");
        water = new Rectangle(0, Const.WATER_Y, Const.DISPLAY_WIDTH, Const.WATER_HEIGHT);
        water.setFill(Color.rgb(157, 198, 255));

        this.getChildren().addAll(water);
        this.waterMovement = 0;
    }

    /**
     * Moves the water up and down and rotates it a little.
     */
    public void moveWater() {
        waterMovement = (waterMovement + 1) % 60;
        if (waterMovement == 0) {
            waterUp = !waterUp;
        }
        if (waterUp) {
            waterUp();
        } else {
            waterDown();
        }
    }

    /**
     * Moves the water up.
     */
    public void waterUp() {
        water.setY(water.getY() - 0.1);
        water.setRotate(water.getRotate() + 0.0005);
    }

    /**
     * Moves the water down.
     */
    public void waterDown() {
        water.setY(water.getY() + 0.1);
        water.setRotate(water.getRotate() - 0.0005);
    }

}
