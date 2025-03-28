package hr.algebra.java2.cartographers.controllers;

import hr.algebra.java2.cartographers.CartographyApplication;
import hr.algebra.java2.cartographers.model.*;
import hr.algebra.java2.cartographers.rmi.ChatRemoteService;
import hr.algebra.java2.cartographers.thread.SaveLastGameMoveThread;
import hr.algebra.java2.cartographers.utils.*;
import javafx.animation.Timeline;
import javafx.application.Platform;
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
import java.util.*;
import java.util.stream.Collectors;

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

    @FXML
    private TextField tfNum1912;
    @FXML
    private Button btnMapB4;
    @FXML
    private Button btnMapC9;
    @FXML
    private Button btnMapF6;
    @FXML
    private Button btnMapI3;
    @FXML
    private Button btnMapJ8;
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
    @FXML
    private Label lblLastGameMove;
    @FXML
    private Button btnChatMessage;
    @FXML
    private TextField tfChatMessage;
    @FXML
    private TextArea taChatMessage;

    private ChatRemoteService chatRemoteService;
    private int lastNum = 0;
    public static ArrayList<CardsBase> exploreDeck;
    public static CardsBase drawnCard;
    private int terrainIterator = 0, shapeIterator = 0, rotationIterator = 0, turnCount = 0;
    private ArrayList<String> pressedButtons = new ArrayList<>();
    private Boolean hasCoin = false;
    private ArrayList<Button> mountains = new ArrayList<>();
    public PlayerType loggedInPlayer = CartographyApplication.loggedInPlayer.getPlayerType();
    private ArrayList<String> scoringCards = new ArrayList<>(Arrays.asList("Earn one reputation star for each row and" +
                    " column with at least one forest space. The same forest space may be scored in a row and a column.",
            "Earn two reputation stars for each water space adjacent to a mountain space. Earn one reputation star " +
                    "for each farm space adjacent to a mountain space.", " Earn eight reputation stars for each " +
                    "cluster of six or more village spaces.", "Earn six reputation stars for each complete row or complete column of filled spaces."));

    public void initialize() {
        ArrayList<TextField> textFields = new ArrayList<>(Arrays.asList(tfNum1900, tfNum1901, tfNum2000, tfNum2001,
                tfNum1902, tfNum1903, tfNum2003, tfNum1904, tfNum2004, tfNum1905, tfNum1906, tfNum2006, tfNum1907,
                tfNum2007, tfNum1908, tfNum1909, tfNum2009, tfNum1910, tfNum2010, tfNum1911, tfNum1912));

        textFields.forEach(this::addNumericValidationListener);

        InitializeUtils.initializeMountains(mountains, btnMapB4, btnMapC9, btnMapF6, btnMapI3, btnMapJ8);
        exploreDeck = InitializeUtils.initializeExploreDeck();

        gpMain.addEventFilter(KeyEvent.KEY_PRESSED, this::addKeyListeners);
        Collections.shuffle(scoringCards);

        lblSeason.setText(SeasonEnum.SPRING.name());

        setUpChat();

        setTimeline();
    }

    private void setUpChat() {
        if (!CartographyApplication.loggedInPlayer.getPlayerType().name().equals(PlayerType.SINGLE_PLAYER.name())) {
            Optional<ChatRemoteService> chatRemoteServiceOptional = ChatUtils.initializeChatRemoteService();
            chatRemoteServiceOptional.ifPresent(remoteService -> chatRemoteService = remoteService);
            Timeline chatRefreshTimeline = ChatUtils.getChatRefreshTimeline(chatRemoteService, taChatMessage);
            chatRefreshTimeline.play();
        } else {
            btnChatMessage.setVisible(false);
            tfChatMessage.setVisible(false);
            taChatMessage.setVisible(false);
        }
    }

    public void addKeyListeners(KeyEvent event) {
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
        Platform.runLater(() -> lblRotation.setText(rotationIterator + " degrees"));
    }

    private void handleShiftPress() {
        shapeIterator++;
        if (shapeIterator >= drawnCard.getShapes().length) {
            shapeIterator = 0;
        }
        Platform.runLater(() -> lblShape.setText(drawnCard.getShapes()[shapeIterator].getDirections().toString()));
    }

    private void handleTabPress() {
        terrainIterator++;
        if (terrainIterator >= drawnCard.getTerrainType().length) {
            terrainIterator = 0;
        }
        System.out.println("Terrain iterator: " + terrainIterator);
        Platform.runLater(() -> lblTerrain.setText(drawnCard.getTerrainType()[terrainIterator].toString()));
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
                    updateCalculations();
                }
            }
        });
    }

    private void updateCalculations() {
        calculateSum(tfNum1902, tfNum1900, tfNum1901, tfNum2000, tfNum2001);
        calculateSum(tfNum1905, tfNum1903, tfNum1904, tfNum2003, tfNum2004);
        calculateSum(tfNum1908, tfNum1906, tfNum1907, tfNum2006, tfNum2007);
        calculateSum(tfNum1911, tfNum1909, tfNum1910, tfNum2009, tfNum2010);
        calculateSum(tfNum1912, tfNum1902, tfNum1905, tfNum1908, tfNum1911);
    }

    private void calculateSum(TextField resultField, TextField... fields) {
        int sum = 0;
        for (TextField field : fields) {
            if (!field.getText().isEmpty()) {
                sum += Integer.parseInt(field.getText());
            }
        }
        resultField.setText(String.valueOf(sum));
    }

    public void revealExploreCard(ActionEvent actionEvent) {
        if (exploreDeck.isEmpty()) {
            DialogUtils.showDialog("Deck is empty", "You have explored all cards. \n Shuffling deck...",
                    Alert.AlertType.INFORMATION);
            exploreDeck = InitializeUtils.initializeExploreDeck();
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
        Platform.runLater(() -> DialogUtils.showDialog("Explore Card", dialogContent.toString(),
                Alert.AlertType.INFORMATION));

        exploreDeck.removeFirst();

        Platform.runLater(() -> lblTerrain.setText(drawnCard.getTerrainType()[terrainIterator].toString()));
        Platform.runLater(() -> lblShape.setText(drawnCard.getShapes()[shapeIterator].getDirections().toString()));
        Platform.runLater(() -> lblRotation.setText("0 degrees"));

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

        GameUtils.createGameAndSaveWithThread(gameMove);
        ArrayList<String> sendExploreDeck = new ArrayList<>();
        CardsBaseUtils.exploreDeckToString(exploreDeck, sendExploreDeck);
        if (CartographyApplication.loggedInPlayer.getPlayerType().name().equals(PlayerType.PLAYER_1.name())) {

            CartographyApplication.sendRequestFromPlayerOne(tfCartographer.getText(), sendExploreDeck,
                    CardsBaseUtils.drawnCardToString(drawnCard));
        } else if (CartographyApplication.loggedInPlayer.getPlayerType().name().equals(PlayerType.PLAYER_2.name())) {
            CartographyApplication.sendRequestFromPlayerTwo(tfCartographer.getText(), sendExploreDeck, CardsBaseUtils.drawnCardToString(drawnCard));
        }
    }

    private void setTimeline() {
        Timeline showLastGameMoveTimeline = FileUtils.getLastGameMoveRefreshTimeline(lblLastGameMove);
        showLastGameMoveTimeline.play();
    }

    private boolean checkMountainAdjacents() {
        Map<String, Button> buttonMap = gpMain.getChildren().stream()
                .filter(Button.class::isInstance)
                .map(Button.class::cast)
                .collect(Collectors.toMap(Button::getId, button -> button));

        Iterator<Button> iterator = mountains.iterator();

        while (iterator.hasNext()) {
            Button btnMountain = iterator.next();
            int row = Character.toUpperCase(btnMountain.getId().charAt(6)) - 'A' + 1;
            int col = Character.getNumericValue(btnMountain.getId().charAt(7));

            int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

            int allFilled = 0;

            for (int[] dir : directions) {
                String adjacentId = "btnMap" + (char) ('A' + row + dir[0] - 1) + (col + dir[1]);
                Button adjacentButton = buttonMap.get(adjacentId);

                if (adjacentButton != null && adjacentButton.isDisabled()) {
                    allFilled++;
                    if (allFilled == 4) {
                        iterator.remove();
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private void checkEndOfSeason() {
        if (lblSeason.getText().equals(SeasonEnum.SPRING.name()) && (lblTurnCount.getText().equals("8") || lblTurnCount.getText().equals("9"))) {
            UiUtils.newSeason(lblSeason, lblTurnCount, lblScoringC, lblScoringA, lblScoringD);
            turnCount = 0;
        }
        if (lblSeason.getText().equals(SeasonEnum.SUMMER.name()) && (lblTurnCount.getText().equals("8") || lblTurnCount.getText().equals("9"))) {
            UiUtils.newSeason(lblSeason, lblTurnCount, lblScoringD, lblScoringB, lblScoringA);
            turnCount = 0;
        }
        if (lblSeason.getText().equals(SeasonEnum.FALL.name()) && (lblTurnCount.getText().equals("7") || lblTurnCount.getText().equals("8"))) {
            UiUtils.newSeason(lblSeason, lblTurnCount, lblScoringA, lblScoringC, lblScoringB);
            turnCount = 0;
        }
        if (lblSeason.getText().equals(SeasonEnum.WINTER.name()) && (lblTurnCount.getText().equals("6") || lblTurnCount.getText().equals("7"))) {
            UiUtils.newSeason(lblSeason, lblTurnCount, lblScoringB, lblScoringD, lblScoringC);
            calculateSum(tfNum1912, tfNum1902, tfNum1905, tfNum1908, tfNum1911);
            disableAllButtons();
        }
    }

    public void disableAllButtons() {
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
            MapUtils.setIconToButton(button, drawnCard, terrainIterator);
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
            Map<Boolean, Map<String, Integer>> result = MapUtils.checkIfDisabled(direction, row, col, buttons, gpMain);
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
            } else return false;
        }
        if (isLegal) {
            MapUtils.terrainOnButtons(buttons, drawnCard, terrainIterator, pressedButtons);
        }
        return isLegal;
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

    public static <T extends Node> T[][] extractFromGridPane(GridPane sourceGrid, int startRow, int endRow,
                                                             int startCol, int endCol, Class<T> nodeType) {
        int rows = endRow - startRow + 1;
        int cols = endCol - startCol + 1;

        @SuppressWarnings("unchecked")
        T[][] nodes = (T[][]) java.lang.reflect.Array.newInstance(nodeType, rows, cols);

        for (Node node : sourceGrid.getChildren()) {
            if (nodeType.isInstance(node)) {
                Integer rowIndex = GridPane.getRowIndex(node);
                Integer colIndex = GridPane.getColumnIndex(node);
                rowIndex = (rowIndex == null) ? 0 : rowIndex;
                colIndex = (colIndex == null) ? 0 : colIndex;

                if (rowIndex >= startRow && rowIndex <= endRow && colIndex >= startCol && colIndex <= endCol) {
                    nodes[rowIndex - startRow][colIndex - startCol] = nodeType.cast(node);
                }
            }
        }

        return nodes;
    }

    public void saveGame(ActionEvent actionEvent) {

        ArrayList<String> playerInfo = new ArrayList<>();
        playerInfo.add(tfCartographer.getText());
        playerInfo.add(tfPlayerTitle.getText());
        playerInfo.add(tfKingdomName.getText());

        ArrayList<String> scoringCardsGameState = new ArrayList<>(scoringCards);

        ArrayList<String> exploreDeckGameState = new ArrayList<>();
        CardsBaseUtils.exploreDeckToString(exploreDeck, exploreDeckGameState);

        String drawnCardGameState = CardsBaseUtils.drawnCardToString(drawnCard);

        int turnCountGameState = turnCount;

        SeasonEnum currentSeasonGameState = SeasonEnum.valueOf(lblSeason.getText());

        ArrayList<String> mountainsGameState = new ArrayList<>();
        MapUtils.fromMountainsToString(mountains, mountainsGameState);

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
                    mapArea.append(pressedButtons.getFirst().split("\\|")[0]);
                    mapArea.append("|");
                    mapArea.append("true");
                    mapArea.append("|");
                    mapArea.append(pressedButtons.getFirst().split("\\|")[1]);
                }
                mapGameState[i][j] = mapArea.toString();
            }
        }

        int coinCountGameState = (int) slCoin.getValue();

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
                drawnCardGameState, turnCountGameState, currentSeasonGameState, mountainsGameState,
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
        CardsBaseUtils.stringToExploreDeck(loadedGame.getExploreDeck(), exploreDeck);

        drawnCard = CardsBaseUtils.stringToDrawnCard(loadedGame.getDrawnCard());

        turnCount = loadedGame.getTurnCount();
        lblTurnCount.setText(String.valueOf(turnCount));

        lblSeason.setText(loadedGame.getCurrentSeason().name());
        checkEndOfSeason();

        mountains.clear();
        MapUtils.fromStringToMountains(loadedGame.getMountains(), mountains);

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

    public void generateDocumentation(ActionEvent actionEvent) {
        try {
            DocumentationUtils.generateHtmlDocumentationFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendChatMessage(ActionEvent actionEvent) {
        ChatUtils.sendChatMessage(chatRemoteService, tfChatMessage);
    }
}

