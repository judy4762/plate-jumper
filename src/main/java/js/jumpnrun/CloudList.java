package js.jumpnrun;

import java.util.LinkedList;

public class CloudList extends LinkedList<Cloud> {

    /**
     * Constructor for CloudList, which adds some Cloud-Objects to it.
     */
    public CloudList() {
        Cloud firstCloud = new Cloud(40);
        this.add(firstCloud);
        for (int i = 0; i < Const.AMOUNT_CLOUDS_IN_SCENE; i++) {
            this.add(new Cloud(this.get(i).getX() + Const.SPACE_BETWEEN_CLOUDS));
        }
    }

    /**
     * Moves all Clouds.
     */
    public void move() {
        for (int i = 0; i < this.size(); i++) {
            // Move clouds
            this.get(i).moveLeft();

            // Is cloud out of scene?
            if (this.get(i).passedBy()) {
                // Determine the previous cloud
                int prevCloudIndex = i != 0 ? i - 1 : this.size() - 1;

                // Set new position and width for the cloud
                this.get(i).setNewProperties(this.get(prevCloudIndex).getX() + Const.SPACE_BETWEEN_CLOUDS);
            }
        }
    }

}
