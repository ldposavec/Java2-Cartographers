package hr.algebra.java2.cartographers.model;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

@Data
@Getter
public class CardsBase {
    private int points;
    private String title;
    private TerrainType[] terrainType;
    private int numberOfShapes;
    private ShapeOnMap[] shapes;

    private CardsBase(Builder builder) {
        this.points = builder.points;
        this.title = builder.title;
        this.terrainType = builder.terrainType;
        this.numberOfShapes = builder.numberOfShapes;
        this.shapes = builder.shapes;
    }

    // Static nested Builder class
    public static class Builder {
        private int points;
        private String title;
        private TerrainType[] terrainType;
        private int numberOfShapes;
        private ShapeOnMap[] shapes;

        public Builder setPoints(int points) {
            this.points = points;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setTerrainType(TerrainType[] terrainType) {
            this.terrainType = terrainType;
            return this;
        }

        public Builder setNumberOfShapes(int numberOfShapes) {
            this.numberOfShapes = numberOfShapes;
            return this;
        }

        public Builder setShapes(ShapeOnMap[] shapes) {
            this.shapes = shapes;
            return this;
        }

        public CardsBase build() {
            return new CardsBase(this);
        }
    }

    // Getters for the fields (optional for immutability)
//    public int getPoints() {
//        return points;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public TerrainType[] getTerrainType() {
//        return terrainType;
//    }
//
//    public int getNumberOfShapes() {
//        return numberOfShapes;
//    }
//
//    public ShapeOnMap[] getShapes() {
//        return shapes;
//    }
}
