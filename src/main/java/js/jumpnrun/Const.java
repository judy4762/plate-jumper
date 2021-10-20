package js.jumpnrun;

final class Const {
    // DISPLAY
    static final int DISPLAY_WIDTH = 600;
    static final int DISPLAY_HEIGHT = 400;
    static final int SPEED = 1;

    // PLATES
    static final int PLATE_HEIGHT = 15;
    static final int MAX_PLATE_WIDTH = 100;
    static final int MIN_PLATE_WIDTH = 50;
    static final int SPACE_BETWEEN_PLATES = 120;
    static final int AMOUNT_PLATES_IN_SCENE = DISPLAY_WIDTH * 2 / SPACE_BETWEEN_PLATES;

    // BACKGROUND
    static final int WATER_HEIGHT = Const.DISPLAY_HEIGHT / 5;
    static final int WATER_Y = (Const.DISPLAY_HEIGHT - Const.DISPLAY_HEIGHT / 6);
    static final int SKY_HEIGHT = WATER_Y;

    // CLOUDS
    static final double CLOUD_SPEED = 0.5;
    static final int MAX_CLOUD_WIDTH = 180;
    static final int MIN_CLOUD_WIDTH = 100;
    static final int SPACE_BETWEEN_CLOUDS = 250;
    static final int AMOUNT_CLOUDS_IN_SCENE = DISPLAY_WIDTH * 2 / SPACE_BETWEEN_CLOUDS;


    // AVATAR
    static final int MAX_AMOUNT_OF_JUMPS = 5;
    static final int AVATAR_X = DISPLAY_WIDTH / 4;
    static final int AVATAR_SIZE = 30;

}
