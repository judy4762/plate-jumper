package js.jumpnrun;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

public class Avatar extends ImageView {

    // Time the avatar jumps.
    private int counterVal = 20;

    // Reference to itself (the Avatar-ImageView);
    private ImageView thisImageView = this;

    /**
     * Constructor for Avatar
     */
    public Avatar() {
        try {
            this.setImage(new Image(new FileInputStream(getImagePath())));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.setX(Const.AVATAR_X);
        this.setY(250 - Const.AVATAR_SIZE);
        this.setFitWidth(Const.AVATAR_SIZE);
        this.setPreserveRatio(true);
    }

    /**
     * Checks if the avatar left the scene on the top or bottom.
     *
     * @return if living -> true, if dead -> false
     */
    public boolean isLiving() {
        return (this.getY() + (Const.AVATAR_SIZE / 2) <= Const.WATER_Y + 10) &&
                (this.getY() + Const.AVATAR_SIZE + 20 >= 0);
    }

    /**
     * Moves the avatar image like it would jump.
     */
    public void jump() {
        counterVal = 20;
        // Animate the counter
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if (counterVal < 0) {
                    this.stop();
                    try {
                        thisImageView.setImage(new Image(new FileInputStream(getImagePath())));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    counterVal = 20;
                } else if (counterVal < 20 && getY() > 0) {
                    setY(getY() - Const.JUMP_SPEED);
                    try {
                        thisImageView.setImage(new Image(new FileInputStream(getJumpImagePath())));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                decCounter();
            }
        };
        timer.start();
    }

    /**
     * Decreases the Y-Coordinate of the avatar, so it looks like falling down.
     */
    public void fall() {
        this.setY(getY() + Const.FALLING_SPEED);
    }

    /**
     * @return the Y-Position of the avatars feet for detecting collisions with plates.
     */
    public double getFeetYPosition() {
        return this.getY() + Const.AVATAR_SIZE;
    }

    /**
     * @return an X-Position which is the middle of the avatar (necessary for detecting collisions with plates).
     */
    public double getFeetXPosition() {
        return this.getX() + (Const.AVATAR_SIZE / 2.0);
    }


    /**
     * Gets the path of the standing avatar image.
     *
     * @return the path as String
     */
    public String getImagePath() {
        return ".\\src\\main\\images\\Avatar2.png";
    }

    /**
     * Gets the path of the jumping avatar image.
     *
     * @return the path as String
     */
    public String getJumpImagePath() {
        return ".\\src\\main\\images\\Avatar2.png";
    }

    /**
     * Declines the counter for the counter scene.
     */
    public void decCounter() {
        counterVal--;
    }

}
