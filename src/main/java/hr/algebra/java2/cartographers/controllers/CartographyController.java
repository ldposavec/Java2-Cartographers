package hr.algebra.java2.cartographers.controllers;

import hr.algebra.java2.cartographers.model.*;
import hr.algebra.java2.cartographers.utils.DialogUtils;
import hr.algebra.java2.cartographers.utils.DocumentationUtils;
import hr.algebra.java2.cartographers.utils.GameUtils;
import hr.algebra.java2.cartographers.utils.XmlUtils;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

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
    @FXML
    private Label lblScoringA;
    @FXML
    private Label lblScoringB;
    @FXML
    private Label lblScoringC;
    @FXML
    private Label lblScoringD;
    @FXML
    private Label lblSeason;
    @FXML
    private Label lblTurnCount;
    @FXML
    private Button btnScoringInfo;
    @FXML
    private Slider slCoin;
    @FXML
    private TextField tfCartographer;
    @FXML
    private TextField tfPlayerTitle;
    @FXML
    private TextField tfKingdomName;

    private int lastNum = 0;
    private int sum = 0;
    private ArrayList<CardsBase> exploreDeck;
    private CardsBase drawnCard;
    private int terrainIterator = 0;
    private int shapeIterator = 0;
    private int rotationIterator = 0;
    private int turnCount = 0;
    private ArrayList<String> pressedButtons = new ArrayList<>();
    //    private GridPane defaultGrid;
    private Boolean hasCoin = false;
    //    private ArrayList<Button> mountains = new ArrayList<>(Arrays.asList(btnMapB4, btnMapC9, btnMapF6, btnMapI3, btnMapJ8));
    private ArrayList<Button> mountains = new ArrayList<>();
    private ArrayList<String> scoringCards = new ArrayList<>(Arrays.asList("Earn one reputation star for each row and" +
                    " column with at least one forest space. The same forest space may be scored in a row and a column.",
            "Earn two reputation stars for each water space adjacent to a mountain space. Earn one reputation star " +
                    "for each farm space adjacent to a mountain space.", " Earn eight reputation stars for each " +
                    "cluster of six or more village spaces.", "Earn six reputation stars for each complete row or complete column of filled spaces."));

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

        gpMain.addEventFilter(KeyEvent.KEY_PRESSED, this::addKeyListeners);
        Collections.shuffle(scoringCards);

        lblSeason.setText(SeasonEnum.SPRING.name());

//        defaultGrid = deepCopyGridPane(gpMain);
//        GameState gState = deepClone(gpMain);
//        defaultGrid = gState.getGrid();
    }

//    private GameState deepClone(GridPane gpMain) {
//        try {
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            ObjectOutputStream oos = new ObjectOutputStream(baos);
//            GameState gState = new GameState(gpMain);
//            oos.writeObject(gState);
//            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
//            return (GameState) ois.readObject();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//            return null;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    private GridPane deepCopyGridPane(GridPane source) {
//        GridPane copy = new GridPane();
//
//        copy.getRowConstraints().addAll(source.getRowConstraints());
//        copy.getColumnConstraints().addAll(source.getColumnConstraints());
//
//        for (Node node : source.getChildren()) {
//            Integer row = GridPane.getRowIndex(node);
//            Integer column = GridPane.getColumnIndex(node);
//            Integer rowSpan = GridPane.getRowSpan(node);
//            Integer columnSpan = GridPane.getColumnSpan(node);
//
//            Node clonedNode = cloneNode(node);
//            if (clonedNode != null) {
//                GridPane.setRowIndex(clonedNode, row);
//                GridPane.setColumnIndex(clonedNode, column);
//                if (rowSpan != null) GridPane.setRowSpan(clonedNode, rowSpan);
//                if (columnSpan != null) GridPane.setColumnSpan(clonedNode, columnSpan);
//                copy.getChildren().add(clonedNode);
//            }
//        }
//
//        return copy;
//    }
//
//    private Node cloneNode(Node node) {
//        if (node instanceof TextField) {
//            TextField original = (TextField) node;
//            TextField copy = new TextField(original.getText());
//            copy.setPrefSize(original.getPrefWidth(), original.getPrefHeight());
//            copy.setMaxSize(original.getMaxWidth(), original.getMaxHeight());
//            copy.setId(original.getId());
//            return copy;
//        } else if (node instanceof Label) {
//            Label original = (Label) node;
//            Label copy = new Label(original.getText());
//            copy.setPrefSize(original.getPrefWidth(), original.getPrefHeight());
//            copy.setMaxSize(original.getMaxWidth(), original.getMaxHeight());
//            copy.setId(original.getId());
//            return copy;
//        } else if (node instanceof Button) {
//            Button original = (Button) node;
//            Button copy = new Button(original.getText());
//            copy.setPrefSize(original.getPrefWidth(), original.getPrefHeight());
//            copy.setMaxSize(original.getMaxWidth(), original.getMaxHeight());
//            copy.setOnAction(original.getOnAction());
//            copy.setId(original.getId());
//            return copy;
//        } else if (node instanceof Slider) {
//            Slider original = (Slider) node;
//            Slider copy = new Slider(original.getMin(), original.getMax(), original.getValue());
//            copy.setPrefSize(original.getPrefWidth(), original.getPrefHeight());
//            copy.setMaxSize(original.getMaxWidth(), original.getMaxHeight());
//            copy.setId(original.getId());
//            return copy;
//        }
//        if (node instanceof TextField) {
//            TextField original = (TextField) node;
//            TextField copy = original;
//            return copy;
//        } else if (node instanceof Label) {
//            Label original = (Label) node;
//            Label copy = original;
//            return copy;
//        } else if (node instanceof Button) {
//            Button original = (Button) node;
//            Button copy = original;
//            return copy;
//        } else if (node instanceof Slider) {
//            Slider original = (Slider) node;
//            Slider copy = original;
//            return copy;
//        }
//
//        return null;
//    }

    public void addKeyListeners(KeyEvent event) {
//        Scene scene = gpMain.getScene();
//        scene.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
        if (event.getCode() == KeyCode.TAB) {
            handleTabPress();
            event.consume();
        }
        if (event.getCode() == KeyCode.SHIFT) {
            handleShiftPress();
            event.consume();
        }
        if (event.getCode() == KeyCode.CONTROL) {
            handleControlPress();
            event.consume();
        }
    }

    private void handleControlPress() {
        drawnCard.getShapes()[shapeIterator].rotateClockwise();
        lblShape.setText(drawnCard.getShapes()[shapeIterator].getDirections().toString());
        rotationIterator += 90;
        if (rotationIterator >= 360) {
            rotationIterator = 0;
        }
        lblRotation.setText(rotationIterator + " degrees");
    }

    private void handleShiftPress() {
        shapeIterator++;
        if (shapeIterator >= drawnCard.getShapes().length) {
            shapeIterator = 0;
        }
        lblShape.setText(drawnCard.getShapes()[shapeIterator].getDirections().toString());
    }

    private void handleTabPress() {
        terrainIterator++;
        if (terrainIterator >= drawnCard.getTerrainType().length) {
            terrainIterator = 0;
        }
        System.out.println("Terrain iterator: " + terrainIterator);
        lblTerrain.setText(drawnCard.getTerrainType()[terrainIterator].toString());
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
                    add("X");
                }}, false)})
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
                    }
                }, false), new ShapeOnMap(new ArrayList<String>() {{
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

        if (!mountains.isEmpty())
        {
            mountains.clear();
        }

        mountains.add(btnMapB4);
        mountains.add(btnMapC9);
        mountains.add(btnMapF6);
        mountains.add(btnMapI3);
        mountains.add(btnMapJ8);

        btnMapB4.setBackground(mountain);
        btnMapB4.setDisable(true);
        btnMapC9.setBackground(mountain);
        btnMapC9.setDisable(true);
        btnMapF6.setBackground(mountain);
        btnMapF6.setDisable(true);
        btnMapI3.setBackground(mountain);
        btnMapI3.setDisable(true);
        btnMapJ8.setBackground(mountain);
        btnMapJ8.setDisable(true);
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
        if (exploreDeck.isEmpty()) {
            DialogUtils.showDialog("Deck is empty", "You have explored all cards. \n Shuffling deck...",
                    Alert.AlertType.INFORMATION);
            initializeExploreDeck();
            return;
        }
        drawnCard = exploreDeck.getFirst();
        TerrainType[] terrainTypes = drawnCard.getTerrainType();
        StringBuilder dialogContent = new StringBuilder();
        dialogContent.append("You have drawn a card\n");
        dialogContent.append("Title: " + drawnCard.getTitle() + "\n");
        dialogContent.append("Points: " + drawnCard.getPoints() + "\n");
        dialogContent.append("Terrain types: ");
        for (TerrainType terrainType : terrainTypes) {
            dialogContent.append(terrainType + " ");
        }
        dialogContent.append("\n");
        dialogContent.append("Available shapes: ");
        for (ShapeOnMap shape : drawnCard.getShapes()) {
            if (shape.getHasCoin()) {
                dialogContent.append("Coin on ");
            }
            dialogContent.append(shape.getDirections() + " ");
        }
        DialogUtils.showDialog("Explore Card", dialogContent.toString(), Alert.AlertType.INFORMATION);

        exploreDeck.removeFirst();

        lblTerrain.setText(drawnCard.getTerrainType()[terrainIterator].toString());
        lblShape.setText(drawnCard.getShapes()[shapeIterator].getDirections().toString());
        lblRotation.setText("0 degrees");

        terrainIterator = 0;
    }

    public void placeTerrain(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        if (!checkLegallity(button)) {
            DialogUtils.showDialog("Illegal move", "You can't place that terrain there", Alert.AlertType.ERROR);
            return;
        }
        else {
            hasCoin = drawnCard.getShapes()[shapeIterator].getHasCoin();
            if (hasCoin) {
                slCoin.adjustValue(slCoin.getValue() + 1);
                hasCoin = false;
            }
            if (checkMountainAdjacents()) {
                slCoin.adjustValue(slCoin.getValue() + 1);
            }
            turnCount += drawnCard.getPoints();
            lblTurnCount.setText(String.valueOf(turnCount));
            checkEndOfSeason();
        }
        Position position = new Position();
        position.setRow(Character.toUpperCase(button.getId().charAt(6)) - 'A');
        position.setColumn(Character.getNumericValue(button.getId().charAt(7)) - 1);
        GameMove gameMove = new GameMove(turnCount, SeasonEnum.valueOf(lblSeason.getText().toString()), position,
                (int)slCoin.getValue());
        XmlUtils.saveNewMove(gameMove);
    }

    private boolean checkMountainAdjacents() {
        int allFilled = 0;
//        btnMapB4.setDisable(false);
//        btnMapC9.setDisable(false);
//        btnMapF6.setDisable(false);
//        btnMapI3.setDisable(false);
//        btnMapJ8.setDisable(false);
        for (Button btnMountain : mountains) {
            int row = Character.toUpperCase(btnMountain.getId().charAt(6)) - 'A' + 1;
            int col = Character.getNumericValue(btnMountain.getId().charAt(7));
            for (Node node : gpMain.getChildren()) {
                if (node instanceof Button button && node.getId().equals("btnMap" + (char) ('A' + row - 2) + col) && button.isDisabled()) {
                    allFilled++;
                    if (allFilled == 4) {
                        mountains.remove(btnMountain);
                        return true;
                    }
                }
                if (node instanceof Button button && node.getId().equals("btnMap" + (char) ('A' + row) + col) && button.isDisabled()) {
                    allFilled++;
                    if (allFilled == 4) {
                        mountains.remove(btnMountain);
                        return true;
                    }
                }
                if (node instanceof Button button && node.getId().equals("btnMap" + (char) ('A' + row - 1) + (col + 1)) && button.isDisabled()) {
                    allFilled++;
                    if (allFilled == 4) {
                        mountains.remove(btnMountain);
                        return true;
                    }
                }
                if (node instanceof Button button && node.getId().equals("btnMap" + (char) ('A' + row - 1) + (col - 1)) && button.isDisabled()) {
                    allFilled++;
                    if (allFilled == 4) {
                        mountains.remove(btnMountain);
                        return true;
                    }
                }
//                else return false;
            }
        }
//        btnMapB4.setDisable(true);
//        btnMapC9.setDisable(true);
//        btnMapF6.setDisable(true);
//        btnMapI3.setDisable(true);
//        btnMapJ8.setDisable(true);
        return false;
    }

    private void checkEndOfSeason() {
        if (lblSeason.getText().equals(SeasonEnum.SPRING.name()) && (lblTurnCount.getText().equals("8") || lblTurnCount.getText().equals("9"))) {
            lblSeason.setText(SeasonEnum.SUMMER.name());
            DialogUtils.showDialog("End of season", "End of Spring season. \n" +
                            "Summer season has started. Make sure to count your points according to 'A' and 'B' scoring cards",
                    Alert.AlertType.INFORMATION);
            lblTurnCount.setText("0");
            turnCount = 0;
            lblScoringC.setFont(lblScoringA.getFont());
            lblScoringA.setFont(lblScoringD.getFont());
        }
        if (lblSeason.getText().equals(SeasonEnum.SUMMER.name()) && (lblTurnCount.getText().equals("8") || lblTurnCount.getText().equals("9"))) {
            lblSeason.setText(SeasonEnum.FALL.name());
            DialogUtils.showDialog("End of season", "End of Summer season. \n" +
                            "Fall season has started. Make sure to count your points according to 'B' and 'C' scoring" +
                            " cards",
                    Alert.AlertType.INFORMATION);
            lblTurnCount.setText("0");
            turnCount = 0;
            lblScoringD.setFont(lblScoringB.getFont());
            lblScoringB.setFont(lblScoringA.getFont());
        }
        if (lblSeason.getText().equals(SeasonEnum.FALL.name()) && (lblTurnCount.getText().equals("7") || lblTurnCount.getText().equals("8"))) {
            lblSeason.setText(SeasonEnum.WINTER.name());
            DialogUtils.showDialog("End of season", "End of Fall season. \n" +
                            "Winter season has started. Make sure to count your points according to 'C' and 'D' " +
                            "scoring" +
                            " cards",
                    Alert.AlertType.INFORMATION);
            lblTurnCount.setText("0");
            turnCount = 0;
            lblScoringA.setFont(lblScoringC.getFont());
            lblScoringC.setFont(lblScoringB.getFont());
        }
        if (lblSeason.getText().equals(SeasonEnum.WINTER.name()) && (lblTurnCount.getText().equals("6") || lblTurnCount.getText().equals("7"))) {
            DialogUtils.showDialog("End of season", "End of Winter season. \n" +
                            "The game has ended! Make sure to count your points according to 'D' and 'A' scoring" +
                            " cards",
                    Alert.AlertType.INFORMATION);
            calculateTfNum1912();
            disableAllButtons();
        }
    }

    private void disableAllButtons() {
        for (Node node : gpMain.getChildren()) {
            if (node instanceof Button button) {
                if (button.getId().equals(btnScoringInfo.getId())) {
                    continue;
                }
                button.setDisable(true);
            }
        }
    }

    private boolean checkLegallity(Button button) {
        ArrayList<Button> buttons = new ArrayList<>();
        buttons.add(button);
        if (drawnCard.getShapes()[shapeIterator].getDirections().size() == 1) {
            setIconToButton(button);
            button.setDisable(true);
            return true;
        }
        Boolean isLegal = false;
        Boolean skipButton = false;
        int row = Character.toUpperCase(button.getId().charAt(6)) - 'A' + 1;
        int col;
        if (button.getId().length() != 8) col = 10 + Character.getNumericValue(button.getId().charAt(8));
        else col = Character.getNumericValue(button.getId().charAt(7));

        for (String direction : drawnCard.getShapes()[shapeIterator].getDirections()) {
            System.out.println("Direction: " + direction);
            if (direction == "O") {
                skipButton = true;
                continue;
            }
            Map<Boolean, Map<String, Integer>> result = checkIfDisabled(direction, row, col, buttons);
            if (result != null) {
                if (skipButton) {
                    buttons.removeLast();
                    skipButton = false;
                }
                if (result.containsKey(true)) {
                    isLegal = true;
                    if (result.get(true).get("row") != null) {
                        row = result.get(true).get("row");
                    } else col = result.get(true).get("col");
                } else {
                    if (!skipButton) {
                        isLegal = false;
                        return isLegal;
                    }
                }
            }
        }
        if (isLegal) {
            for (Button buttonDisable : buttons) {
                StringBuilder sb = new StringBuilder();
                sb.append(buttonDisable.getId());
                sb.append("|");
                sb.append(drawnCard.getTerrainType()[terrainIterator].toString());
                pressedButtons.add(sb.toString());
                setIconToButton(buttonDisable);
                buttonDisable.setDisable(true);
            }
        }
        return isLegal;
    }

    private void setIconToButton(Button iconToButton) {
        TerrainType terrainType = drawnCard.getTerrainType()[terrainIterator];
        BackgroundImage icon =
                new BackgroundImage(new Image(getClass().getResource("/img/" + terrainType.toString().toLowerCase() +
                        "-icon-hires" +
                        ".PNG").toExternalForm()
                        , btnMapB4.heightProperty().doubleValue(), btnMapB4.widthProperty().doubleValue(), false,
                        true, true),
                        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                        new BackgroundSize(btnMapB4.getWidth(), btnMapB4.getHeight(), true, true, true, false));
        Background bgIcon = new Background(icon);

        iconToButton.setBackground(bgIcon);
    }


    @Nullable
    private Map<Boolean, Map<String, Integer>> checkIfDisabled(String direction, int row, int col, ArrayList<Button> buttons) {
        if (direction.equals("N")) {
            return checkIfDisabledNorth(row, col, buttons);
        } else if (direction.equals("E")) {
            return checkIfDisabledEast(row, col, buttons);
        }
        else if (direction.equals("S")) {
            return checkIfDisabledSouth(row, col, buttons);
        } else if (direction.equals("W")) {
            return checkIfDisabledWest(row, col, buttons);
        }
        return null;
    }


    @Nullable
    private Map<Boolean, Map<String, Integer>> checkIfDisabledNorth(int row, int col, ArrayList<Button> buttons) {
        for (Node node : gpMain.getChildren()) {
            if (node instanceof Button buttonFound && node.getId().equals("btnMap" + (char) ('A' + row - 2) + col)) {

                if (buttonFound != null && !buttonFound.isDisable()) {
                    buttons.add(buttonFound);
                    return Map.of(true, Map.of("row", row - 1));
                } else {
                    return Map.of(false, Map.of("row", row));
                }
            }
        }
        return null;
    }

    @Nullable
    private Map<Boolean, Map<String, Integer>> checkIfDisabledEast(int row, int col, ArrayList<Button> buttons) {
        for (Node node : gpMain.getChildren()) {
            if (node instanceof Button buttonFound && node.getId().equals("btnMap" + (char) ('A' + row - 1) + (col + 1))) {

                if (buttonFound != null && !buttonFound.isDisable()) {
                    buttons.add(buttonFound);
                    return Map.of(true, Map.of("col", col + 1));
                }
                else {
                    return Map.of(false, Map.of("col", col));

                }
            }
        }
        return null;
    }

    @Nullable
    private Map<Boolean, Map<String, Integer>> checkIfDisabledSouth(int row, int col, ArrayList<Button> buttons) {
        for (Node node : gpMain.getChildren()) {
            if (node instanceof Button buttonFound && node.getId().equals("btnMap" + (char) ('A' + row) + col)) {

                if (buttonFound != null && !buttonFound.isDisable()) {
                    buttons.add(buttonFound);
                    return Map.of(true, Map.of("row", row + 1));
                }
                else {
                    return Map.of(false, Map.of("row", row));

                }
            }
        }
        return null;
    }

    @Nullable
    private Map<Boolean, Map<String, Integer>> checkIfDisabledWest(int row, int col, ArrayList<Button> buttons) {
        for (Node node : gpMain.getChildren()) {
            if (node instanceof Button buttonFound && node.getId().equals("btnMap" + (char) ('A' + row - 1) + (col - 1))) {

                if (buttonFound != null && !buttonFound.isDisable()) {
                    buttons.add(buttonFound);
                    return Map.of(true, Map.of("col", col - 1));
                }
                else {
                    return Map.of(false, Map.of("col", col));

                }
            }
        }
        return null;
    }

    public void showScoringInfo(ActionEvent actionEvent) {
        StringBuilder dialogContent = new StringBuilder();
        dialogContent.append("Scoring info:\n");
        dialogContent.append("A: " + scoringCards.getFirst() + "\n");
        scoringCards.removeFirst();
        dialogContent.append("B: " + scoringCards.getFirst() + "\n");
        scoringCards.removeFirst();
        dialogContent.append("C: " + scoringCards.getFirst() + "\n");
        scoringCards.removeFirst();
        dialogContent.append("D: " + scoringCards.getFirst() + "\n");
        scoringCards.removeFirst();
        DialogUtils.showDialog("Scoring", dialogContent.toString(), Alert.AlertType.INFORMATION);
    }

    public void startNewGame(ActionEvent actionEvent) {
////        GameState gState = generateGameState();
////        GameState gState = new GameState(defaultGrid);
////        GameUtils.startNewGame(gState);
//        gpMain.getChildren().clear();
//        GridPane newGrid = deepCopyGridPane(defaultGrid);
////        gpMain = deepCopyGridPane(defaultGrid);
//        gpMain.getChildren().addAll(newGrid.getChildren());
//        initialize();

        ArrayList<String> playerInfo = new ArrayList<>();
        playerInfo.add(tfCartographer.getText());
        playerInfo.add(tfPlayerTitle.getText());
        playerInfo.add(tfKingdomName.getText());

        ArrayList<String> scoringCardsGameState = new ArrayList<>(scoringCards);

        ArrayList<String> exploreDeckGameState = new ArrayList<>();
        for (CardsBase card : exploreDeck) {
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
            exploreDeckGameState.add(exploreCard.toString());
        }

        StringBuilder drawnCardGameState = new StringBuilder();
        drawnCardGameState.append(drawnCard.getPoints());
        drawnCardGameState.append("|");
        drawnCardGameState.append(drawnCard.getTitle());
        drawnCardGameState.append("|");
        for (TerrainType terrainType : drawnCard.getTerrainType()) {
            drawnCardGameState.append(terrainType);
            drawnCardGameState.append(",");
        }
        drawnCardGameState.append("|");
        drawnCardGameState.append(drawnCard.getNumberOfShapes());
        drawnCardGameState.append("|");
        for (ShapeOnMap shape : drawnCard.getShapes()) {
            for (String direction : shape.getDirections()) {
                drawnCardGameState.append(direction);
                drawnCardGameState.append(",");
            }
            drawnCardGameState.append(";");
        }
        drawnCardGameState.append("|");
        drawnCardGameState.append(drawnCard.getShapes()[0].getHasCoin() ? "true" : "false");

        int turnCountGameState = turnCount;

        SeasonEnum currentSeasonGameState = SeasonEnum.valueOf(lblSeason.getText());

        ArrayList<String> mountainsGameState = new ArrayList<>();
        for (Button mountain : mountains) {
            StringBuilder mountainArea = new StringBuilder();
            mountainArea.append(mountain.getId());
            mountainArea.append("|");
            mountainArea.append(mountain.isDisabled() ? "true" : "false");
            mountainsGameState.add(mountainArea.toString());
        }

//        ArrayList<String> mapGameState = new ArrayList<>();
//        Button[][] mapButtons = extractFromGridPane(gpMain, 5, 15, 5, 15, Button.class);
//        for (Button[] row : mapButtons) {
//            for (Button button : row) {
//                StringBuilder mapArea = new StringBuilder();
//                mapArea.append(button.getId());
//                mapArea.append("|");
//                mapArea.append(button.isDisabled() ? "true" : "false");
//                if (button.isDisable())
//                {
//                    mapArea.append("|");
//                    mapArea.append(button.getBackground().toString());
//                }
//                mapGameState.add(mapArea.toString());
//            }
//        }
        String[][] mapGameState = new String[11][11];
        Button[][] mapButtons = extractFromGridPane(gpMain, 5, 15, 1, 11, Button.class);
        for (int i = 0; i < mapButtons.length; i++) {
            for (int j = 0; j < mapButtons[i].length; j++) {
                StringBuilder mapArea = new StringBuilder();
                if (mapButtons[i][j] != null) {
                    mapArea.append(mapButtons[i][j].getId());
                    mapArea.append("|");
                    mapArea.append(mapButtons[i][j].isDisabled() ? "true" : "false");
                    if (mapButtons[i][j].isDisable())
                    {
                        mapArea.append("|");
                        mapArea.append(mapButtons[i][j].getBackground().toString());
                    }
                }
                else {
//                    mapArea.append("btnMap" + (char) ('A' + i) + (j + 5));
//                    mapArea.append("|");
//                    mapArea.append("false");
                    mapArea.append(pressedButtons.getFirst().split("\\|")[0]);
                    mapArea.append("|");
                    mapArea.append("true");
                    mapArea.append("|");
                    mapArea.append(pressedButtons.getFirst().split("\\|")[1]);
                }
                mapGameState[i][j] = mapArea.toString();
            }
        }
//        for (Node node : gpMain.getChildren()) {
//            if (node instanceof Button button) {
//                StringBuilder mapArea = new StringBuilder();
//                mapArea.append(button.getId());
//                mapArea.append("|");
//                mapArea.append(button.isDisabled() ? "true" : "false");
//                mapGameState.add(mapArea.toString());
//            }
//        }

        int coinCountGameState = (int) slCoin.getValue();

//        ArrayList<String> pointsGameState = new ArrayList<>();
//        TextField[][] points = extractFromGridPane(gpMain, 19, 20, 0, 12, TextField.class);
//        for (TextField[] row : points) {
//            for (TextField textField : row) {
//                StringBuilder pointsArea = new StringBuilder();
//                pointsArea.append(textField.getId());
//                pointsArea.append("|");
//                pointsArea.append(textField.getText());
//                pointsGameState.add(pointsArea.toString());
//            }
//        }

        String[][] pointsGameState = new String[2][13];
        TextField[][] points = extractFromGridPane(gpMain, 19, 20, 0, 12, TextField.class);
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                StringBuilder pointsArea = new StringBuilder();
                if (!(i == 1 && (j == 2 || j == 5 || j == 8 || j == 11 || j == 12))) {
                    pointsArea.append(points[i][j].getId());
                    pointsArea.append("|");
                    pointsArea.append(points[i][j].getText());
                    pointsGameState[i][j] = pointsArea.toString();
                }
            }
        }

        GameState gameState = new GameState(playerInfo, scoringCardsGameState, exploreDeckGameState,
                drawnCardGameState.toString(), turnCountGameState, currentSeasonGameState, mountainsGameState,
                mapGameState, coinCountGameState, pointsGameState, true);

        GameUtils.startNewGame(gameState);


        initialize();
    }

    public static <T extends Node> T[][] extractFromGridPane(
            GridPane sourceGrid,
            int startRow,
            int endRow,
            int startCol,
            int endCol,
            Class<T> nodeType
    ) {
        int rows = endRow - startRow + 1;
        int cols = endCol - startCol + 1;

        // Create a generic 2D array using reflection
        @SuppressWarnings("unchecked")
        T[][] nodes = (T[][]) java.lang.reflect.Array.newInstance(nodeType, rows, cols);

        for (Node node : sourceGrid.getChildren()) {
            // Ensure the node is of the specified type
            if (nodeType.isInstance(node)) {
                Integer rowIndex = GridPane.getRowIndex(node);
                Integer colIndex = GridPane.getColumnIndex(node);

                // Default to 0 if no index is set
                rowIndex = (rowIndex == null) ? 0 : rowIndex;
                colIndex = (colIndex == null) ? 0 : colIndex;

                // Check if the node falls within the specified range
                if (rowIndex >= startRow && rowIndex <= endRow && colIndex >= startCol && colIndex <= endCol) {
                    // Add the node to the correct position in the array
                    nodes[rowIndex - startRow][colIndex - startCol] = nodeType.cast(node);
                }
            }
        }

        return nodes;
    }

    private GameState generateGameState() {
//        return new GameState(
//                new ArrayList<>(Arrays.asList(tfCartographer, tfPlayerTitle, tfKingdomName)),
//                scoringCards,
//                exploreDeck,
//                drawnCard,
//                turnCount,
//                SeasonEnum.valueOf(lblSeason.getText()),
//                mountains,
//                extractFromGridPane(gpMain, 5, 15, 5, 15, Button.class),
//                (int) slCoin.getValue(),
//                extractFromGridPane(gpMain, 19, 20, 0, 12, TextField.class)
//        );
        /*
        private ArrayList<String> player;
    private String activeScoringLetters;
    private ArrayList<String> scoringCards;
    private ArrayList<CardsBase> exploreDeck;
    private CardsBase drawnCard;
    private int turnCount;
    private SeasonEnum currentSeason;
    private ArrayList<Button> mountains;
    private Button[][] map;
    private int coinCount;
    private TextField[][] points;
         */
//        return new GameState(defaultGrid);
        return null;
    }

    public void saveGame(ActionEvent actionEvent) {

        ArrayList<String> playerInfo = new ArrayList<>();
        playerInfo.add(tfCartographer.getText());
        playerInfo.add(tfPlayerTitle.getText());
        playerInfo.add(tfKingdomName.getText());

        ArrayList<String> scoringCardsGameState = new ArrayList<>(scoringCards);

        ArrayList<String> exploreDeckGameState = new ArrayList<>();
        for (CardsBase card : exploreDeck) {
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
            exploreDeckGameState.add(exploreCard.toString());
        }

        StringBuilder drawnCardGameState = new StringBuilder();
        drawnCardGameState.append(drawnCard.getPoints());
        drawnCardGameState.append("|");
        drawnCardGameState.append(drawnCard.getTitle());
        drawnCardGameState.append("|");
        for (TerrainType terrainType : drawnCard.getTerrainType()) {
            drawnCardGameState.append(terrainType);
            drawnCardGameState.append(",");
        }
        drawnCardGameState.append("|");
        drawnCardGameState.append(drawnCard.getNumberOfShapes());
        drawnCardGameState.append("|");
        for (ShapeOnMap shape : drawnCard.getShapes()) {
            for (String direction : shape.getDirections()) {
                drawnCardGameState.append(direction);
                drawnCardGameState.append(",");
            }
            drawnCardGameState.append(";");
        }
        drawnCardGameState.append("|");
        drawnCardGameState.append(drawnCard.getShapes()[0].getHasCoin() ? "true" : "false");

        int turnCountGameState = turnCount;

        SeasonEnum currentSeasonGameState = SeasonEnum.valueOf(lblSeason.getText());

        ArrayList<String> mountainsGameState = new ArrayList<>();
        for (Button mountain : mountains) {
            StringBuilder mountainArea = new StringBuilder();
            mountainArea.append(mountain.getId());
            mountainArea.append("|");
            mountainArea.append(mountain.isDisabled() ? "true" : "false");
            mountainsGameState.add(mountainArea.toString());
        }

//        ArrayList<String> mapGameState = new ArrayList<>();
//        Button[][] mapButtons = extractFromGridPane(gpMain, 5, 15, 5, 15, Button.class);
//        for (Button[] row : mapButtons) {
//            for (Button button : row) {
//                StringBuilder mapArea = new StringBuilder();
//                mapArea.append(button.getId());
//                mapArea.append("|");
//                mapArea.append(button.isDisabled() ? "true" : "false");
//                if (button.isDisable())
//                {
//                    mapArea.append("|");
//                    mapArea.append(button.getBackground().toString());
//                }
//                mapGameState.add(mapArea.toString());
//            }
//        }
        String[][] mapGameState = new String[11][11];
        Button[][] mapButtons = extractFromGridPane(gpMain, 5, 15, 1, 11, Button.class);
        for (int i = 0; i < mapButtons.length; i++) {
            for (int j = 0; j < mapButtons[i].length; j++) {
                StringBuilder mapArea = new StringBuilder();
                if (mapButtons[i][j] != null) {
                    mapArea.append(mapButtons[i][j].getId());
                    mapArea.append("|");
                    mapArea.append(mapButtons[i][j].isDisabled() ? "true" : "false");
                    if (mapButtons[i][j].isDisable())
                    {
                        mapArea.append("|");
                        mapArea.append(((Background) ( mapButtons[i][j].backgroundProperty()).getValue()).getImages().getFirst().getImage().getUrl());
                    }
                }
                else {
//                    mapArea.append("btnMap" + (char) ('A' + i) + (j + 5));
//                    mapArea.append("|");
//                    mapArea.append("false");
                    mapArea.append(pressedButtons.getFirst().split("\\|")[0]);
                    mapArea.append("|");
                    mapArea.append("true");
                    mapArea.append("|");
                    mapArea.append(pressedButtons.getFirst().split("\\|")[1]);
                }
                mapGameState[i][j] = mapArea.toString();
            }
        }
//        for (Node node : gpMain.getChildren()) {
//            if (node instanceof Button button) {
//                StringBuilder mapArea = new StringBuilder();
//                mapArea.append(button.getId());
//                mapArea.append("|");
//                mapArea.append(button.isDisabled() ? "true" : "false");
//                mapGameState.add(mapArea.toString());
//            }
//        }

        int coinCountGameState = (int) slCoin.getValue();

//        ArrayList<String> pointsGameState = new ArrayList<>();
//        TextField[][] points = extractFromGridPane(gpMain, 19, 20, 0, 12, TextField.class);
//        for (TextField[] row : points) {
//            for (TextField textField : row) {
//                StringBuilder pointsArea = new StringBuilder();
//                pointsArea.append(textField.getId());
//                pointsArea.append("|");
//                pointsArea.append(textField.getText());
//                pointsGameState.add(pointsArea.toString());
//            }
//        }

        String[][] pointsGameState = new String[2][13];
        TextField[][] points = extractFromGridPane(gpMain, 19, 20, 0, 12, TextField.class);
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                StringBuilder pointsArea = new StringBuilder();
                if (!(i == 1 && (j == 2 || j == 5 || j == 8 || j == 11 || j == 12))) {
                    pointsArea.append(points[i][j].getId());
                    pointsArea.append("|");
                    pointsArea.append(points[i][j].getText());
                    pointsGameState[i][j] = pointsArea.toString();
                }
            }
        }

        GameState gameState = new GameState(playerInfo, scoringCardsGameState, exploreDeckGameState,
                drawnCardGameState.toString(), turnCountGameState, currentSeasonGameState, mountainsGameState,
                mapGameState, coinCountGameState, pointsGameState, true);

        GameState gameStateToSave = GameUtils.generateGameState(gameState);
        GameUtils.saveGame(gameStateToSave);
    }

    public void loadGame(ActionEvent actionEvent) {
        GameState loadedGame = GameUtils.loadGame();

        tfCartographer.setText(loadedGame.getPlayerInfo().get(0));
        tfPlayerTitle.setText(loadedGame.getPlayerInfo().get(1));
        tfKingdomName.setText(loadedGame.getPlayerInfo().get(2));

        scoringCards = loadedGame.getScoringCards();

        exploreDeck.clear();
        for (String card : loadedGame.getExploreDeck()) {
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
            exploreDeck.add(cardBuilder.build());
        }

        String[] drawnCardParts = loadedGame.getDrawnCard().split("\\|");
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
        drawnCard = drawnCardBuilder.build();

        turnCount = loadedGame.getTurnCount();
        lblTurnCount.setText(String.valueOf(turnCount));

        lblSeason.setText(loadedGame.getCurrentSeason().name());
        checkEndOfSeason();

        // Might need fixing:
        mountains.clear();
        for (String mountain : loadedGame.getMountains()) {
            String[] mountainParts = mountain.split("\\|");
            Button mountainButton = new Button();
            mountainButton.setId(mountainParts[0]);
            mountainButton.setDisable(Boolean.parseBoolean(mountainParts[1]));
            mountains.add(mountainButton);
        }

        Button[][] mapButtons = extractFromGridPane(gpMain, 5, 15, 1, 11, Button.class);
        for (int i = 0; i < mapButtons.length; i++) {
            for (int j = 0; j < mapButtons[i].length; j++) {
                String[] mapAreaParts = loadedGame.getMap()[i][j].split("\\|");
                Button mapButton = new Button();
                mapButton.setId(mapAreaParts[0]);
                Button existingButton = (Button) gpMain.lookup("#" + mapAreaParts[0]);
                mapButton.setDisable(Boolean.parseBoolean(mapAreaParts[1]));
                if (mapButton.isDisable()) {
                    BackgroundImage icon =
                            new BackgroundImage(new Image(mapAreaParts[2], mapButton.heightProperty().doubleValue(), mapButton.widthProperty().doubleValue(), false,
                                    true, true),
                                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                                    new BackgroundSize(mapButton.getWidth(), mapButton.getHeight(), true, true, true, false));
                    Background bgIcon = new Background(icon);
                    mapButton.setBackground(bgIcon);
                    existingButton.setDisable(mapButton.isDisable());
                    existingButton.setBackground(mapButton.getBackground());
                }
                mapButtons[i][j] = mapButton;
            }
        }

        slCoin.adjustValue(loadedGame.getCoinCount());

        TextField[][] points = extractFromGridPane(gpMain, 19, 20, 0, 12, TextField.class);
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                if (loadedGame.getPoints()[i][j] == null) {
                    continue;
                }
                String[] pointsAreaParts = loadedGame.getPoints()[i][j].split("\\|");
                points[i][j].setId(pointsAreaParts[0]);
                points[i][j].setText(pointsAreaParts[1]);
            }
        }
    }

    public void replayGame(ActionEvent actionEvent) {
    }

    public void generateDocumentation(ActionEvent actionEvent) {
        try {
            DocumentationUtils.generateHtmlDocumentationFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

