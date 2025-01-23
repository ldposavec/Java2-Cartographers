package hr.algebra.java2.cartographers.playables;

import java.util.ArrayList;

public class ShapeOnMap {
    private ArrayList<String> directions;
    private Boolean hasCoin;

    public ShapeOnMap(ArrayList<String> directions, Boolean hasCoin) {
        this.directions = directions;
        this.hasCoin = hasCoin;
    }

    public ArrayList<String> getDirections() {
        return directions;
    }

    public Boolean getHasCoin() {
        return hasCoin;
    }

    public void setDirections(ArrayList<String> directions) {
        this.directions = directions;
    }

    public void setHasCoin(Boolean hasCoin) {
        this.hasCoin = hasCoin;
    }

    public void rotateClockwise() {
        // X represents base block, O represents what direction to go without placing a block
        ArrayList<String> newDirections = new ArrayList<>();
        for (String direction : directions) {
                switch (direction) {
                    case "X":
                        newDirections.add("X");
                        break;
                    case "N":
                        newDirections.add("E");
                        break;
                    case "E":
                        newDirections.add("S");
                        break;
                    case "S":
                        newDirections.add("W");
                        break;
                    case "W":
                        newDirections.add("N");
                        break;
                    case "O":
                        newDirections.add("O");
                        break;
                }
        }
        directions = newDirections;
    }
}
