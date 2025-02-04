package hr.algebra.java2.cartographers.utils;

import hr.algebra.java2.cartographers.model.CardsBase;
import hr.algebra.java2.cartographers.model.TerrainType;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Map;

public class MapUtils {
    private MapUtils() {}

    public static void fromStringToMountains(ArrayList<String> fromList, ArrayList<Button> toList) {
        for (String mountain : fromList) {
            String[] mountainParts = mountain.split("\\|");
            Button mountainButton = new Button();
            mountainButton.setId(mountainParts[0]);
            mountainButton.setDisable(Boolean.parseBoolean(mountainParts[1]));
            toList.add(mountainButton);
        }
    }

    public static void fromMountainsToString(ArrayList<Button> fromList, ArrayList<String> toList) {
        for (Button mountain : fromList) {
            StringBuilder mountainArea = new StringBuilder();
            mountainArea.append(mountain.getId());
            mountainArea.append("|");
            mountainArea.append(mountain.isDisabled() ? "true" : "false");
            toList.add(mountainArea.toString());
        }
    }

    @Nullable
    public static Map<Boolean, Map<String, Integer>> checkIfDisabled(String direction, int row, int col,
                                                               ArrayList<Button> buttons, GridPane gpMain) {
        Map<String, int[]> directionOffsets = Map.of(
                "X", new int[]{0, 0},
                "O", new int[]{0, 0},
                "N", new int[]{-1, 0},
                "E", new int[]{0, 1},
                "S", new int[]{1, 0},
                "W", new int[]{0, -1}
        );

        if (!directionOffsets.containsKey(direction)) {
            return null;
        }

        int[] offset = directionOffsets.get(direction);
        int newRow = row + offset[0];
        int newCol = col + offset[1];

        if (newRow < 0 || newRow >= GameUtils.NUMBER_OF_ROWS_COLUMNS + 1 || newCol < 0 || newCol >= GameUtils.NUMBER_OF_ROWS_COLUMNS + 1) {
            return null;
        }

        String targetId = "btnMap" + (char) ('A' + newRow - 1) + newCol;

        for (Node node : gpMain.getChildren()) {
            if (node instanceof Button buttonFound && targetId.equals(node.getId())) {
                if (!buttonFound.isDisable()) {
                    buttons.add(buttonFound);
                    return Map.of(true, Map.of(offset[0] != 0 ? "row" : "col", offset[0] != 0 ? newRow : newCol));
                } else {
                    return Map.of(false, Map.of(offset[0] != 0 ? "row" : "col", offset[0] != 0 ? row : col));
                }
            }
        }

        return null;
    }

    public static void setIconToButton(Button iconToButton, CardsBase drawnCard, int terrainIterator) {
        TerrainType terrainType = drawnCard.getTerrainType()[terrainIterator];
        BackgroundImage icon =
                new BackgroundImage(new Image(MapUtils.class.getResource("/img/" + terrainType.toString().toLowerCase() +
                        "-icon-hires" +
                        ".PNG").toExternalForm()
                        , iconToButton.heightProperty().doubleValue(), iconToButton.widthProperty().doubleValue(), false,
                        true, true),
                        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                        new BackgroundSize(iconToButton.getWidth(), iconToButton.getHeight(), true, true, true, false));
        Background bgIcon = new Background(icon);

        iconToButton.setBackground(bgIcon);
    }

    public static void terrainOnButtons(ArrayList<Button> buttons, CardsBase drawnCard, int terrainIterator, ArrayList<String> pressedButtons) {
        for (Button buttonDisable : buttons) {
            StringBuilder sb = new StringBuilder();
            sb.append(buttonDisable.getId());
            sb.append("|");
            sb.append(drawnCard.getTerrainType()[terrainIterator].toString());
            pressedButtons.add(sb.toString());
            MapUtils.setIconToButton(buttonDisable, drawnCard, terrainIterator);
            buttonDisable.setDisable(true);
        }
    }

//    public static void fromStringToButtons(String[][] fromMap, Button toButton) {
//        String[] mapAreaParts = fromMap.toString().split("\\|");
//        Button mapButton = new Button();
//        mapButton.setId(mapAreaParts[0]);
//        Button existingButton = (Button) gpMain.lookup("#" + mapAreaParts[0]);
//        mapButton.setDisable(Boolean.parseBoolean(mapAreaParts[1]));
//        if (mapButton.isDisable()) {
//            BackgroundImage icon =
//                    new BackgroundImage(new Image(mapAreaParts[2], mapButton.heightProperty().doubleValue(), mapButton.widthProperty().doubleValue(), false,
//                            true, true),
//                            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
//                            new BackgroundSize(mapButton.getWidth(), mapButton.getHeight(), true, true, true, false));
//            Background bgIcon = new Background(icon);
//            mapButton.setBackground(bgIcon);
//            existingButton.setDisable(mapButton.isDisable());
//            existingButton.setBackground(mapButton.getBackground());
//        }
//    }
}
