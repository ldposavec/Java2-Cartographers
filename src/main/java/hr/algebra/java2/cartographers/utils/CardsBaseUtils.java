package hr.algebra.java2.cartographers.utils;

import hr.algebra.java2.cartographers.model.CardsBase;
import hr.algebra.java2.cartographers.model.ShapeOnMap;
import hr.algebra.java2.cartographers.model.TerrainType;

import java.util.ArrayList;
import java.util.Arrays;

public class CardsBaseUtils {
    private CardsBaseUtils() {}

    public static void stringToExploreDeck(ArrayList<String> fromList, ArrayList<CardsBase> toList) {
        for (String card : fromList) {
            String[] cardParts = card.split("\\|");
            CardsBase.Builder cardBuilder = new CardsBase.Builder();
            cardBuilder.setPoints(Integer.parseInt(cardParts[0]));
            cardBuilder.setTitle(cardParts[1]);
            String[] terrainTypes = cardParts[2].split(",");
            TerrainType[] terrainTypesArray = new TerrainType[terrainTypes.length];
            for (int i = 0; i < terrainTypes.length; i++) {
                terrainTypesArray[i] = TerrainType.valueOf(terrainTypes[i]);
            }
            cardBuilder.setTerrainType(terrainTypesArray);
            cardBuilder.setNumberOfShapes(Integer.parseInt(cardParts[3]));
            String[] shapes = cardParts[4].split(";");
            ShapeOnMap[] shapesArray = new ShapeOnMap[shapes.length];
            for (int i = 0; i < shapes.length; i++) {
                String[] directions = shapes[i].split(",");
                ArrayList<String> directionsList = new ArrayList<>(Arrays.asList(directions));
                if (i == 0 && Boolean.parseBoolean(cardParts[5])) {
                    shapesArray[i] = new ShapeOnMap(directionsList, true);
                } else {
                    shapesArray[i] = new ShapeOnMap(directionsList, false);
                }
            }
            cardBuilder.setShapes(shapesArray);
            toList.add(cardBuilder.build());
        }
    }

    public static void exploreDeckToString(ArrayList<CardsBase> fromList, ArrayList<String> toList) {
        for (CardsBase card : fromList) {
            StringBuilder exploreCard = new StringBuilder();
            exploreCard.append(card.getPoints());
            exploreCard.append("|");
            exploreCard.append(card.getTitle());
            exploreCard.append("|");
            for (TerrainType terrainType : card.getTerrainType()) {
                exploreCard.append(terrainType);
                exploreCard.append(",");
            }
            exploreCard.append("|");
            exploreCard.append(card.getNumberOfShapes());
            exploreCard.append("|");
            for (ShapeOnMap shape : card.getShapes()) {
                for (String direction : shape.getDirections()) {
                    exploreCard.append(direction);
                    exploreCard.append(",");
                }
                exploreCard.append(";");
            }
            exploreCard.append("|");
            exploreCard.append(card.getShapes()[0].getHasCoin() ? "true" : "false");
            toList.add(exploreCard.toString());
        }
    }

    public static CardsBase stringToDrawnCard(String fromString) {
        String[] drawnCardParts = fromString.split("\\|");
        CardsBase.Builder drawnCardBuilder = new CardsBase.Builder();
        drawnCardBuilder.setPoints(Integer.parseInt(drawnCardParts[0]));
        drawnCardBuilder.setTitle(drawnCardParts[1]);
        String[] terrainTypes = drawnCardParts[2].split(",");
        TerrainType[] terrainTypesArray = new TerrainType[terrainTypes.length];
        for (int i = 0; i < terrainTypes.length; i++) {
            terrainTypesArray[i] = TerrainType.valueOf(terrainTypes[i]);
        }
        drawnCardBuilder.setTerrainType(terrainTypesArray);
        drawnCardBuilder.setNumberOfShapes(Integer.parseInt(drawnCardParts[3]));
        String[] shapes = drawnCardParts[4].split(";");
        ShapeOnMap[] shapesArray = new ShapeOnMap[shapes.length];
        for (int i = 0; i < shapes.length; i++) {
            String[] directions = shapes[i].split(",");
            ArrayList<String> directionsList = new ArrayList<>(Arrays.asList(directions));
            if (i == 0 && Boolean.parseBoolean(drawnCardParts[5])) {
                shapesArray[i] = new ShapeOnMap(directionsList, true);
            } else {
                shapesArray[i] = new ShapeOnMap(directionsList, false);
            }
        }
        drawnCardBuilder.setShapes(shapesArray);
        return drawnCardBuilder.build();

//        CardsBase.Builder cardBuilder = new CardsBase.Builder();
//        cardBuilder.setPoints(Integer.parseInt(fromString[0]));
//        cardBuilder.setTitle(fromString[1]);
//        String[] terrainTypes = fromString[2].split(",");
//        TerrainType[] terrainTypesArray = new TerrainType[terrainTypes.length];
//        for (int i = 0; i < terrainTypes.length; i++) {
//            terrainTypesArray[i] = TerrainType.valueOf(terrainTypes[i]);
//        }
//        cardBuilder.setTerrainType(terrainTypesArray);
//        cardBuilder.setNumberOfShapes(Integer.parseInt(fromString[3]));
//        String[] shapes = fromString[4].split(";");
//        ShapeOnMap[] shapesArray = new ShapeOnMap[shapes.length];
//        for (int i = 0; i < shapes.length; i++) {
//            String[] directions = shapes[i].split(",");
//            ArrayList<String> directionsList = new ArrayList<>(Arrays.asList(directions));
//            if (i == 0 && Boolean.parseBoolean(fromString[5])) {
//                shapesArray[i] = new ShapeOnMap(directionsList, true);
//            } else {
//                shapesArray[i] = new ShapeOnMap(directionsList, false);
//            }
//        }
//        cardBuilder.setShapes(shapesArray);
//        toCard = cardBuilder.build();
    }

    public static String drawnCardToString(CardsBase fromCard) {
        StringBuilder drawnCardGameState = new StringBuilder();
        drawnCardGameState.append(fromCard.getPoints());
        drawnCardGameState.append("|");
        drawnCardGameState.append(fromCard.getTitle());
        drawnCardGameState.append("|");
        for (TerrainType terrainType : fromCard.getTerrainType()) {
            drawnCardGameState.append(terrainType);
            drawnCardGameState.append(",");
        }
        drawnCardGameState.append("|");
        drawnCardGameState.append(fromCard.getNumberOfShapes());
        drawnCardGameState.append("|");
        for (ShapeOnMap shape : fromCard.getShapes()) {
            for (String direction : shape.getDirections()) {
                drawnCardGameState.append(direction);
                drawnCardGameState.append(",");
            }
            drawnCardGameState.append(";");
        }
        drawnCardGameState.append("|");
        drawnCardGameState.append(fromCard.getShapes()[0].getHasCoin() ? "true" : "false");
        return drawnCardGameState.toString();
    }
}
