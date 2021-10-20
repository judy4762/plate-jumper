package js.jumpnrun;

import java.util.LinkedList;

public class PlateList extends LinkedList<Plate> {

    /**
     * Constructor for PlateList, which adds some Plate-Objects to it.
     */
    public PlateList() {
        Plate startPlate = new Plate(Const.AVATAR_X, 250, Const.MIN_PLATE_WIDTH + 20, Const.PLATE_HEIGHT);
        this.add(startPlate);
        for (int i = 0; i < Const.AMOUNT_PLATES_IN_SCENE; i++) {
            this.add(new Plate((int) this.get(i).getX() + Const.SPACE_BETWEEN_PLATES));
        }
    }

    /**
     * Moves all Plates.
     */
    public void move() {
        for (int i = 0; i < this.size(); i++) {
            // Move plates
            this.get(i).moveLeft();

            // Is plate out of scene?
            if (this.get(i).passedBy()) {
                // Determine the previos plate (previous plate of the plate with index 0 is the last plate)
                int prevPlateIndex = i != 0 ? i - 1 : this.size() - 1;

                // Set new position and length for plate
                this.get(i).setNewProperties(this.get(prevPlateIndex).getX() + Const.SPACE_BETWEEN_PLATES);
            }
        }
    }

}
