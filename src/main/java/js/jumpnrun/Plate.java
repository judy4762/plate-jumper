package js.jumpnrun;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Plate extends Rectangle {

    /**
     * Constructor for Plate with delivered parameters:
     *
     * @param x      = X-Coordinate
     * @param y      = Y-Coordinate
     * @param width  = Width
     * @param height = Height
     */
    public Plate(double x, double y, double width, double height) {
        super(x, y, width, height);
        this.setFill(Color.rgb(100, 84, 71));
    }

    /**
     * Constructor for Plate.
     * The Y-Coordinate, width and height are chosen randomly with defined boundaries.
     *
     * @param x = X-Coordinate
     */
    public Plate(double x) {
        super(x,
                (new Random().nextInt(Const.SKY_HEIGHT - 80) + 40),
                (new Random().nextInt((Const.MAX_PLATE_WIDTH - Const.MIN_PLATE_WIDTH) + 1) + Const.MIN_PLATE_WIDTH),
                Const.PLATE_HEIGHT);

        this.setFill(Color.rgb(100, 84, 71));
    }

    /**
     * Moves the Plate one step (SPEED) to the left.
     */
    public void moveLeft() {
        this.setX(this.getX() - Const.SPEED);
    }

    /**
     * Sets new properties to the Plate.
     * The parameters y and width are chosen randomly, height always remains the same.
     *
     * @param x = X-Coordinate
     */
    public void setNewProperties(double x) {
        this.setX(x);
        this.setY(new Random().nextInt(Const.SKY_HEIGHT - 80) + 40);
        this.setWidth(new Random().nextInt((Const.MAX_PLATE_WIDTH - Const.MIN_PLATE_WIDTH) + 1) + Const.MIN_PLATE_WIDTH);
    }

    /**
     * Checks if the plate is not the scene (not visible) anymore.
     *
     * @return true if passed by, false if still in the scene
     */
    public boolean passedBy() {
        return getX() < -(Const.MAX_PLATE_WIDTH + 20);
    }

}
