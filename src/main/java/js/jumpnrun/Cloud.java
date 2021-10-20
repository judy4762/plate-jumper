package js.jumpnrun;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

public class Cloud extends ImageView {

    /**
     * Constructor for Cloud with delivered parameter:
     * The Y-Coordinate and width are chosen randomly with defined boundaries.
     *
     * @param x = X-Coordinate
     */
    public Cloud(double x) {
        try {
            this.setImage(new Image(new FileInputStream(getImagePath())));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.setX(x);
        this.setY((new Random().nextInt(Const.SKY_HEIGHT - 200) + 40));
        this.setFitWidth(new Random().nextInt((Const.MAX_CLOUD_WIDTH - Const.MIN_CLOUD_WIDTH) + 1) + Const.MIN_CLOUD_WIDTH);
        this.setPreserveRatio(true);
    }

    /**
     * Moves the cloud one step (CLOUD_SPEED) to the left.
     */
    public void moveLeft() {
        this.setX(this.getX() - Const.CLOUD_SPEED);
    }

    /**
     * Sets new properties to the cloud.
     * The Y-Coordinate and width are chosen randomly with defined boundaries.
     *
     * @param x = X-Coordinate
     */
    public void setNewProperties(double x) {
        this.setX(x);
        this.setY(new Random().nextInt(Const.SKY_HEIGHT - 200) + 40);
        this.setFitWidth(new Random().nextInt((Const.MAX_CLOUD_WIDTH - Const.MIN_CLOUD_WIDTH) + 1) + Const.MIN_CLOUD_WIDTH);
    }

    /**
     * Checks if the cloud is not the scene (not visible) anymore.
     *
     * @return true if passed by, false if still in the scene
     */
    public boolean passedBy() {
        return getX() < -(Const.MAX_CLOUD_WIDTH + 20);
    }

    /**
     * Gets the path of a cloud image randomly chosen between two different pictures.
     *
     * @return the path as String
     */
    public String getImagePath() {
        if (new Random().nextInt(4) % 2 == 0) return ".\\src\\main\\images\\cloud2.png";
        return ".\\src\\main\\images\\cloud1.png";
    }

}
