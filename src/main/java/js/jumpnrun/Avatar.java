package js.jumpnrun;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Avatar extends ImageView {

    //Speed of jumping
    public double jumpSpeed = Const.JUMP_SPEED;

    //Is avatar jumping at the moment?
    public boolean jumping = false;

    //Recent amount of jumps
    public int jumps = 0;

    //Time the avatar jumps
    public double jumpTime = 0;

    //Min falling time after exceeding the max number of direct following jumps
    public double minFallingTime = Const.STANDARD_MIN_FALLING_TIME;

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
        return (this.getY() + ((float) Const.AVATAR_SIZE / 2) <= Const.WATER_Y + 10) &&
                (this.getY() + Const.AVATAR_SIZE + 20 >= 0);
    }

    /**
     * Decreases the Y-Coordinate of the avatar if it is not already out of sight on the top of the scene.
     */
    public void jump() {
        if (getY() > -(Const.AVATAR_SIZE + 5)) {
            setY(getY() - jumpSpeed);
        }
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
        return ".\\src\\main\\images\\avatar_stand.png";
    }

    /**
     * Gets the path of the jumping avatar image.
     *
     * @return the path as String
     */
    public String getJumpImagePath() {
        return ".\\src\\main\\images\\avatar_jump.png";
    }

    /**
     * Sets the jumping avatar image.
     */
    public void setJumpImage() {
        try {
            thisImageView.setImage(new Image(new FileInputStream(getJumpImagePath())));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets the standing avatar image.
     */
    public void setStandingImage() {
        try {
            thisImageView.setImage(new Image(new FileInputStream(getImagePath())));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
