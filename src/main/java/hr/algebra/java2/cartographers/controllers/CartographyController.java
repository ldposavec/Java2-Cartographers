package hr.algebra.java2.cartographers.controllers;

import hr.algebra.java2.cartographers.playables.CardsBase;
import hr.algebra.java2.cartographers.playables.ShapeOnMap;
import hr.algebra.java2.cartographers.playables.TerrainType;
import hr.algebra.java2.cartographers.utils.DialogUtils;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.Collections;

public class CartographyController {
    @FXML
    private TextField tfNum1900;
    @FXML
    private TextField tfNum1901;
    @FXML
    private TextField tfNum2000;
    @FXML
    private TextField tfNum2001;
    @FXML
    private TextField tfNum1902;
    //
    @FXML
    private TextField tfNum1903;
    @FXML
    private TextField tfNum2003;
    @FXML
    private TextField tfNum1904;
    @FXML
    private TextField tfNum2004;
    @FXML
    private TextField tfNum1905;
    //
    @FXML
    private TextField tfNum1906;
    @FXML
    private TextField tfNum2006;
    @FXML
    private TextField tfNum1907;
    @FXML
    private TextField tfNum2007;
    @FXML
    private TextField tfNum1908;
    //
    @FXML
    private TextField tfNum1909;
    @FXML
    private TextField tfNum2009;
    @FXML
    private TextField tfNum1910;
    @FXML
    private TextField tfNum2010;
    @FXML
    private TextField tfNum1911;
    //
    @FXML
    private TextField tfNum1912;

    @FXML
    private Button btnMapA1;
    @FXML
    private Button btnMapA2;
    @FXML
    private Button btnMapA3;
    @FXML
    private Button btnMapA4;
    @FXML
    private Button btnMapA5;
    @FXML
    private Button btnMapA6;
    @FXML
    private Button btnMapA7;
    @FXML
    private Button btnMapA8;
    @FXML
    private Button btnMapA9;
    @FXML
    private Button btnMapA10;
    @FXML
    private Button btnMapA11;
    @FXML
    private Button btnMapB1;
    @FXML
    private Button btnMapB2;
    @FXML
    private Button btnMapB3;
    @FXML
    private Button btnMapB4;
    @FXML
    private Button btnMapB5;
    @FXML
    private Button btnMapB6;
    @FXML
    private Button btnMapB7;
    @FXML
    private Button btnMapB8;
    @FXML
    private Button btnMapB9;
    @FXML
    private Button btnMapB10;
    @FXML
    private Button btnMapB11;
    @FXML
    private Button btnMapC1;
    @FXML
    private Button btnMapC2;
    @FXML
    private Button btnMapC3;
    @FXML
    private Button btnMapC4;
    @FXML
    private Button btnMapC5;
    @FXML
    private Button btnMapC6;
    @FXML
    private Button btnMapC7;
    @FXML
    private Button btnMapC8;
    @FXML
    private Button btnMapC9;
    @FXML
    private Button btnMapC10;
    @FXML
    private Button btnMapC11;
    @FXML
    private Button btnMapD1;
    @FXML
    private Button btnMapD2;
    @FXML
    private Button btnMapD3;
    @FXML
    private Button btnMapD4;
    @FXML
    private Button btnMapD5;
    @FXML
    private Button btnMapD6;
    @FXML
    private Button btnMapD7;
    @FXML
    private Button btnMapD8;
    @FXML
    private Button btnMapD9;
    @FXML
    private Button btnMapD10;
    @FXML
    private Button btnMapD11;
    @FXML
    private Button btnMapE1;
    @FXML
    private Button btnMapE2;
    @FXML
    private Button btnMapE3;
    @FXML
    private Button btnMapE4;
    @FXML
    private Button btnMapE5;
    @FXML
    private Button btnMapE6;
    @FXML
    private Button btnMapE7;
    @FXML
    private Button btnMapE8;
    @FXML
    private Button btnMapE9;
    @FXML
    private Button btnMapE10;
    @FXML
    private Button btnMapE11;
    @FXML
    private Button btnMapF1;
    @FXML
    private Button btnMapF2;
    @FXML
    private Button btnMapF3;
    @FXML
    private Button btnMapF4;
    @FXML
    private Button btnMapF5;
    @FXML
    private Button btnMapF6;
    @FXML
    private Button btnMapF7;
    @FXML
    private Button btnMapF8;
    @FXML
    private Button btnMapF9;
    @FXML
    private Button btnMapF10;
    @FXML
    private Button btnMapF11;
    @FXML
    private Button btnMapG1;
    @FXML
    private Button btnMapG2;
    @FXML
    private Button btnMapG3;
    @FXML
    private Button btnMapG4;
    @FXML
    private Button btnMapG5;
    @FXML
    private Button btnMapG6;
    @FXML
    private Button btnMapG7;
    @FXML
    private Button btnMapG8;
    @FXML
    private Button btnMapG9;
    @FXML
    private Button btnMapG10;
    @FXML
    private Button btnMapG11;
    @FXML
    private Button btnMapH1;
    @FXML
    private Button btnMapH2;
    @FXML
    private Button btnMapH3;
    @FXML
    private Button btnMapH4;
    @FXML
    private Button btnMapH5;
    @FXML
    private Button btnMapH6;
    @FXML
    private Button btnMapH7;
    @FXML
    private Button btnMapH8;
    @FXML
    private Button btnMapH9;
    @FXML
    private Button btnMapH10;
    @FXML
    private Button btnMapH11;
    @FXML
    private Button btnMapI1;
    @FXML
    private Button btnMapI2;
    @FXML
    private Button btnMapI3;
    @FXML
    private Button btnMapI4;
    @FXML
    private Button btnMapI5;
    @FXML
    private Button btnMapI6;
    @FXML
    private Button btnMapI7;
    @FXML
    private Button btnMapI8;
    @FXML
    private Button btnMapI9;
    @FXML
    private Button btnMapI10;
    @FXML
    private Button btnMapI11;
    @FXML
    private Button btnMapJ1;
    @FXML
    private Button btnMapJ2;
    @FXML
    private Button btnMapJ3;
    @FXML
    private Button btnMapJ4;
    @FXML
    private Button btnMapJ5;
    @FXML
    private Button btnMapJ6;
    @FXML
    private Button btnMapJ7;
    @FXML
    private Button btnMapJ8;
    @FXML
    private Button btnMapJ9;
    @FXML
    private Button btnMapJ10;
    @FXML
    private Button btnMapJ11;
    @FXML
    private Button btnMapK1;
    @FXML
    private Button btnMapK2;
    @FXML
    private Button btnMapK3;
    @FXML
    private Button btnMapK4;
    @FXML
    private Button btnMapK5;
    @FXML
    private Button btnMapK6;
    @FXML
    private Button btnMapK7;
    @FXML
    private Button btnMapK8;
    @FXML
    private Button btnMapK9;
    @FXML
    private Button btnMapK10;
    @FXML
    private Button btnMapK11;
    @FXML
    private Label lblTerrain;
    @FXML
    private Label lblShape;
    @FXML
    private Label lblRotation;
    @FXML
    private GridPane gpMain;

    private int lastNum = 0;
    private int sum = 0;
    private ArrayList<CardsBase> exploreDeck;
    private CardsBase drawnCard;

    public void initialize() {
        addNumericValidationListener(tfNum1900);
        addNumericValidationListener(tfNum1901);
        addNumericValidationListener(tfNum2000);
        addNumericValidationListener(tfNum2001);

        addNumericValidationListener(tfNum1903);
        addNumericValidationListener(tfNum1904);
        addNumericValidationListener(tfNum2003);
        addNumericValidationListener(tfNum2004);

        addNumericValidationListener(tfNum1906);
        addNumericValidationListener(tfNum1907);
        addNumericValidationListener(tfNum2006);
        addNumericValidationListener(tfNum2007);

        addNumericValidationListener(tfNum1909);
        addNumericValidationListener(tfNum1910);
        addNumericValidationListener(tfNum2009);
        addNumericValidationListener(tfNum2010);

        initializeMountains();
        initializeExploreDeck();
    }

    private void initializeExploreDeck() {
        exploreDeck = new ArrayList<>();
        CardsBase treetopVillage = new CardsBase.Builder()
                .setPoints(1)
                .setTitle("Treetop Village")
                .setTerrainType(new TerrainType[]{TerrainType.FOREST, TerrainType.VILLAGE})
                .setNumberOfShapes(2)
                .setShapes(new ShapeOnMap[]{new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                    add("E");
                    add("E");
                    add("N");
                    add("E");
                }}, false),
                        new ShapeOnMap(new ArrayList<String>() {{
                            add("X");
                        }}, false)})
                .build();
        CardsBase outpostRuins = new CardsBase.Builder()
                .setPoints(0)
                .setTitle("Outpost Ruins")
                .setTerrainType(new TerrainType[]{TerrainType.RUINS})
                .setNumberOfShapes(1)
                .setShapes(new ShapeOnMap[]{new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                }}, false)})
                .build();
        CardsBase farmland = new CardsBase.Builder()
                .setPoints(1)
                .setTitle("Farmland")
                .setTerrainType(new TerrainType[]{TerrainType.FARM})
                .setNumberOfShapes(3)
                .setShapes(new ShapeOnMap[]{new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                    add("S");
                }}, true),
                        new ShapeOnMap(new ArrayList<String>() {{
                            add("X");
                            add("N");
                            add("O");
                            add("E");
                            add("S");
                            add("O");
                            add("S");
                            add("W");
                            add("O");
                            add("W");
                            add("N");
                        }}, false), new ShapeOnMap(new ArrayList<String>() {{
                        add("X");}}, false)})
                .build();
        CardsBase forgottenForest = new CardsBase.Builder()
                .setPoints(1)
                .setTitle("Forgotten Forest")
                .setTerrainType(new TerrainType[]{TerrainType.FOREST})
                .setNumberOfShapes(3)
                .setShapes(new ShapeOnMap[]{new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                    add("O");
                    add("E");
                    add("S");
                }}, true),
                        new ShapeOnMap(new ArrayList<String>() {{
                            add("X");
                            add("S");
                            add("E");
                            add("S");
                        }}, false), new ShapeOnMap(new ArrayList<String>() {{
                        add("X");
                        }}, false)})
                .build();
        CardsBase orchard = new CardsBase.Builder()
                .setPoints(2)
                .setTitle("Orchard")
                .setTerrainType(new TerrainType[]{TerrainType.FOREST, TerrainType.FARM})
                .setNumberOfShapes(2)
                .setShapes(new ShapeOnMap[]{new ShapeOnMap(new ArrayList<String>() {
                    {
                        add("X");
                        add("E");
                        add("E");
                        add("S");
                    }}, false), new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                }}, false)})
                .build();
        CardsBase hamlet = new CardsBase.Builder()
                .setPoints(1)
                .setTitle("Hamlet")
                .setTerrainType(new TerrainType[]{TerrainType.VILLAGE})
                .setNumberOfShapes(3)
                .setShapes(new ShapeOnMap[]{new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                    add("S");
                    add("E");
                }}, true),
                        new ShapeOnMap(new ArrayList<String>() {{
                            add("X");
                            add("W");
                            add("W");
                            add("S");
                            add("E");
                        }}, false), new ShapeOnMap(new ArrayList<String>() {{
                        add("X");
                }}, false)})
                .build();
        CardsBase riftLands = new CardsBase.Builder()
                .setPoints(0)
                .setTitle("Rift Lands")
                .setTerrainType(new TerrainType[]{TerrainType.FOREST, TerrainType.VILLAGE, TerrainType.FARM,
                        TerrainType.WATER, TerrainType.MONSTER})
                .setNumberOfShapes(2)
                .setShapes(new ShapeOnMap[]{new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                }}, false), new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                }}, false)})
                .build();
        CardsBase homestead = new CardsBase.Builder()
                .setPoints(2)
                .setTitle("Homestead")
                .setTerrainType(new TerrainType[]{TerrainType.FARM, TerrainType.VILLAGE})
                .setNumberOfShapes(2)
                .setShapes(new ShapeOnMap[]{new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                    add("S");
                    add("E");
                    add("O");
                    add("S");
                    add("W");
                }}, false), new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                }}, false)})
                .build();
        CardsBase hinterlandStream = new CardsBase.Builder()
                .setPoints(2)
                .setTitle("Hinterland Stream")
                .setTerrainType(new TerrainType[]{TerrainType.FARM, TerrainType.WATER})
                .setNumberOfShapes(2)
                .setShapes(new ShapeOnMap[]{new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                    add("N");
                    add("N");
                    add("E");
                    add("E");
                }}, false), new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                }}, false)})
                .build();
        CardsBase greatRiver = new CardsBase.Builder()
                .setPoints(1)
                .setTitle("Great River")
                .setTerrainType(new TerrainType[]{TerrainType.WATER})
                .setNumberOfShapes(3)
                .setShapes(new ShapeOnMap[]{new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                    add("S");
                    add("S");
                }}, true),
                        new ShapeOnMap(new ArrayList<String>() {{
                            add("X");
                            add("E");
                            add("N");
                            add("E");
                            add("N");
                        }}, false), new ShapeOnMap(new ArrayList<String>() {{
                        add("X");
                }}, false)})
                .build();
        CardsBase templeRuins = new CardsBase.Builder()
                .setPoints(0)
                .setTitle("Temple Ruins")
                .setTerrainType(new TerrainType[]{TerrainType.RUINS})
                .setNumberOfShapes(1)
                .setShapes(new ShapeOnMap[]{new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                }}, false)})
                .build();
        CardsBase marshlands = new CardsBase.Builder()
                .setPoints(2)
                .setTitle("Marshlands")
                .setTerrainType(new TerrainType[]{TerrainType.WATER, TerrainType.FOREST})
                .setNumberOfShapes(2)
                .setShapes(new ShapeOnMap[]{new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                    add("S");
                    add("S");
                    add("O");
                    add("E");
                    add("N");
                    add("E");
                }}, false), new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                }}, false)})
                .build();
        CardsBase fishingVillage = new CardsBase.Builder()
                .setPoints(2)
                .setTitle("Fishing Village")
                .setTerrainType(new TerrainType[]{TerrainType.VILLAGE, TerrainType.WATER})
                .setNumberOfShapes(2)
                .setShapes(new ShapeOnMap[]{new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                    add("E");
                    add("E");
                    add("E");
                }}, false), new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                }}, false)})
                .build();
        CardsBase koboldOnslaught = new CardsBase.Builder()
                .setPoints(1)
                .setTitle("Kobold Onslaught")
                .setTerrainType(new TerrainType[]{TerrainType.MONSTER})
                .setNumberOfShapes(2)
                .setShapes(new ShapeOnMap[]{new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                    add("S");
                    add("E");
                    add("O");
                    add("S");
                    add("W");
                }}, false), new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                }}, false)})
                .build();
        CardsBase bugbearAssault = new CardsBase.Builder()
                .setPoints(1)
                .setTitle("Bugbear Assault")
                .setTerrainType(new TerrainType[]{TerrainType.MONSTER})
                .setNumberOfShapes(2)
                .setShapes(new ShapeOnMap[]{new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                    add("S");
                    add("O");
                    add("E");
                    add("E");
                    add("N");
                }}, false), new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                }}, false)})
                .build();
        CardsBase goblinAttack = new CardsBase.Builder()
                .setPoints(2)
                .setTitle("Goblin Attack")
                .setTerrainType(new TerrainType[]{TerrainType.MONSTER})
                .setNumberOfShapes(2)
                .setShapes(new ShapeOnMap[]{new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                    add("O");
                    add("E");
                    add("S");
                    add("O");
                    add("E");
                    add("S");
                }}, false), new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                }}, false)})
                .build();
        CardsBase gnollRaid = new CardsBase.Builder()
                .setPoints(2)
                .setTitle("Gnoll Raid")
                .setTerrainType(new TerrainType[]{TerrainType.MONSTER})
                .setNumberOfShapes(2)
                .setShapes(new ShapeOnMap[]{new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                    add("W");
                    add("S");
                    add("S");
                    add("E");
                }}, false), new ShapeOnMap(new ArrayList<String>() {{
                    add("X");
                }}, false)})
                .build();

        exploreDeck.add(treetopVillage);
        exploreDeck.add(outpostRuins);
        exploreDeck.add(farmland);
        exploreDeck.add(forgottenForest);
        exploreDeck.add(orchard);
        exploreDeck.add(hamlet);
        exploreDeck.add(riftLands);
        exploreDeck.add(homestead);
        exploreDeck.add(hinterlandStream);
        exploreDeck.add(greatRiver);
        exploreDeck.add(templeRuins);
        exploreDeck.add(marshlands);
        exploreDeck.add(fishingVillage);
        exploreDeck.add(koboldOnslaught);
        exploreDeck.add(bugbearAssault);
        exploreDeck.add(goblinAttack);
        exploreDeck.add(gnollRaid);

        Collections.shuffle(exploreDeck);

    }

    private void initializeMountains() {
        BackgroundImage mountainIcon =
                new BackgroundImage(new Image(getClass().getResource("/img/mountain-icon-hires.PNG").toExternalForm()
                        , btnMapB4.heightProperty().doubleValue(), btnMapB4.widthProperty().doubleValue(), false,
                        true, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                        new BackgroundSize(btnMapB4.getWidth(), btnMapB4.getHeight(), true, true, true, false));
        Background mountain = new Background(mountainIcon);

        btnMapB4.setBackground(mountain);
        btnMapC9.setBackground(mountain);
        btnMapF6.setBackground(mountain);
        btnMapI3.setBackground(mountain);
        btnMapJ8.setBackground(mountain);
    }

    private void addNumericValidationListener(TextField textField) {
        textField.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    String s = textField.getText();
                    char[] chs = s.toCharArray();
                    System.out.println("Length:" + oldValue.length() + "  " + newValue.length() + " " + s);
                    StringBuilder sb = new StringBuilder();
                    Boolean isNum = true;

                    for (char ch : chs) {
                        if (!(ch >= '0' && ch <= '9')) {
                            textField.setText(oldValue);
                            isNum = false;
                            break;
                        }
                        sb.append(ch);
                    }

                    if (isNum) {
                        lastNum = Integer.parseInt(sb.toString());
                        calculateTfNum1902();
                        calculateTfNum1905();
                        calculateTfNum1908();
                        calculateTfNum1911();
                        calculateTfNum1912();
                    }
                }
            });
        }

    private void calculateTfNum1912() {
        sum += Integer.parseInt(tfNum1902.getText());
        sum += Integer.parseInt(tfNum1905.getText());
        sum += Integer.parseInt(tfNum1908.getText());
        sum += Integer.parseInt(tfNum1911.getText());
        tfNum1912.setText(String.valueOf(sum));
        sum = 0;
    }

    private void calculateTfNum1911() {
        sum += Integer.parseInt(tfNum1909.getText());
        sum += Integer.parseInt(tfNum1910.getText());
        sum += Integer.parseInt(tfNum2009.getText());
        sum += Integer.parseInt(tfNum2010.getText());
        tfNum1911.setText(String.valueOf(sum));
        sum = 0;
    }

    private void calculateTfNum1908() {
        sum += Integer.parseInt(tfNum1906.getText());
        sum += Integer.parseInt(tfNum1907.getText());
        sum += Integer.parseInt(tfNum2006.getText());
        sum += Integer.parseInt(tfNum2007.getText());
        tfNum1908.setText(String.valueOf(sum));
        sum = 0;
    }

    private void calculateTfNum1905() {
        sum += Integer.parseInt(tfNum1903.getText());
        sum += Integer.parseInt(tfNum1904.getText());
        sum += Integer.parseInt(tfNum2003.getText());
        sum += Integer.parseInt(tfNum2004.getText());
        tfNum1905.setText(String.valueOf(sum));
        sum = 0;
    }

    private void calculateTfNum1902() {
        sum += Integer.parseInt(tfNum1900.getText());
        sum += Integer.parseInt(tfNum1901.getText());
        sum += Integer.parseInt(tfNum2000.getText());
        sum += Integer.parseInt(tfNum2001.getText());
        tfNum1902.setText(String.valueOf(sum));
        sum = 0;
    }

    public void revealExploreCard(ActionEvent actionEvent) {
        drawnCard = exploreDeck.getFirst();
        TerrainType[] terrainTypes = drawnCard.getTerrainType();
        StringBuilder dialogContent = new StringBuilder();
        dialogContent.append("You have drawn a card\n");
        dialogContent.append("Title: " + drawnCard.getTitle() + "\n");
        dialogContent.append("Points: " + drawnCard.getPoints() + "\n");
//        if(terrainTypes.length == 1) dialogContent.append("Terrain type: " + terrainTypes[0] + "\n");
//        else {
            dialogContent.append("Terrain types: ");
            for (TerrainType terrainType : terrainTypes) {
                dialogContent.append(terrainType + " ");
            }
            dialogContent.append("\n");
//        }
        dialogContent.append("Available shapes: ");
        for (ShapeOnMap shape : drawnCard.getShapes()) {
            dialogContent.append(shape.getDirections() + " ");
        }
        DialogUtils.showDialog("Explore Card", dialogContent.toString(), Alert.AlertType.INFORMATION);

        exploreDeck.removeFirst();

        lblTerrain.setText("Terrain: " + drawnCard.getTerrainType()[0]);
        lblShape.setText("Shape: " + drawnCard.getShapes()[0].getDirections());
        lblRotation.setText("Rotation: 0");
    }

    public void placeTerrain(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        if(checkLegallity(button)) {

        }
        else {
            DialogUtils.showDialog("Illegal move", "You can't place that terrain there", Alert.AlertType.ERROR);
        }
    }

    private boolean checkLegallity(Button button) {
        for (String direction : drawnCard.getShapes()[0].getDirections()) {
            switch (direction) {
            case "N":
                // Extract row and column from the button's ID
                int row = Character.getNumericValue(button.getId().charAt(6)); // Assuming the row is encoded in the 7th character
                int col = Character.getNumericValue(button.getId().charAt(7)); // Assuming the column is encoded in the 8th character

                // Check if the button is at the topmost row (row 0)
                if (row == 0) {
                    return false;
                }

                // Find the button in the row above
                for (Node node : gpMain.getChildren()) {
                    if (GridPane.getRowIndex(node) != null && GridPane.getColumnIndex(node) != null
                            && GridPane.getRowIndex(node) == row - 1
                            && GridPane.getColumnIndex(node) == col) {

                        Button aboveButton = (Button) node;

                        // Check if the button is not disabled
                        if (!aboveButton.isDisable()) {
                            return true; // Non-disabled button found above
                        }
                        break;
                    }
                }

                return false; // No non-disabled button found above
                case "E":
                    int rowE = Character.getNumericValue(button.getId().charAt(6));
                    int colE = Character.getNumericValue(button.getId().charAt(7));

                    // Check if the button is at the rightmost column
                    if (colE == gpMain.getColumnCount() - 1) {
                        return false;
                    }

                    // Check if there's a non-disabled button to the right
                    for (Node node : gpMain.getChildren()) {
                        if (GridPane.getRowIndex(node) != null && GridPane.getColumnIndex(node) != null
                                && GridPane.getRowIndex(node) == rowE
                                && GridPane.getColumnIndex(node) == colE + 1) {

                            Button rightButton = (Button) node;
                            return !rightButton.isDisable();
                        }
                    }
                    return false;

                case "S":
                    int rowS = Character.getNumericValue(button.getId().charAt(6));
                    int colS = Character.getNumericValue(button.getId().charAt(7));

                    // Check if the button is at the bottommost row
                    if (rowS == gpMain.getRowCount() - 1) {
                        return false;
                    }

                    // Check if there's a non-disabled button below
                    for (Node node : gpMain.getChildren()) {
                        if (GridPane.getRowIndex(node) != null && GridPane.getColumnIndex(node) != null
                                && GridPane.getRowIndex(node) == rowS + 1
                                && GridPane.getColumnIndex(node) == colS) {

                            Button belowButton = (Button) node;
                            return !belowButton.isDisable();
                        }
                    }
                    return false;

                case "W":
                    int rowW = Character.getNumericValue(button.getId().charAt(6));
                    int colW = Character.getNumericValue(button.getId().charAt(7));

                    // Check if the button is at the leftmost column
                    if (colW == 0) {
                        return false;
                    }

                    // Check if there's a non-disabled button to the left
                    for (Node node : gpMain.getChildren()) {
                        if (GridPane.getRowIndex(node) != null && GridPane.getColumnIndex(node) != null
                                && GridPane.getRowIndex(node) == rowW
                                && GridPane.getColumnIndex(node) == colW - 1) {

                            Button leftButton = (Button) node;
                            return !leftButton.isDisable();
                        }
                    }
                    return false;

                case "O":
                    int currentRow = Character.getNumericValue(button.getId().charAt(6));
                    int currentCol = Character.getNumericValue(button.getId().charAt(7));
                    for (int i = 0; drawnCard.getShapes()[0].getDirections().size() > i; i++) {
                        if (drawnCard.getShapes()[0].getDirections().get(i) == "O") {
                            i++;
                            for (int j = 0; j < i; j++) {
                                switch (drawnCard.getShapes()[0].getDirections().get(i)) {
                                    case "N":
                                        currentRow -= 1; // Move up
                                        break;
                                    case "E":
                                        currentCol += 1; // Move right
                                        break;
                                    case "S":
                                        currentRow += 1; // Move down
                                        break;
                                    case "W":
                                        currentCol -= 1; // Move left
                                        break;
                                }
                            }

                            // Check if the final target position exists and has a non-disabled button
                            for (Node node : gpMain.getChildren()) {
                                if (GridPane.getRowIndex(node) != null && GridPane.getColumnIndex(node) != null
                                        && GridPane.getRowIndex(node) == currentRow
                                        && GridPane.getColumnIndex(node) == currentCol) {

                                    Button targetButton = (Button) node;
                                    return !targetButton.isDisable();
                                }
                            }
                            return false;
                        }
            }
            }
        }
        return true;
    }
}

