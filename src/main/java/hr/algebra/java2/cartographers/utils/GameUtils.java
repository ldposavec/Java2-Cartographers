package hr.algebra.java2.cartographers.utils;

import hr.algebra.java2.cartographers.model.GameMove;
import hr.algebra.java2.cartographers.model.GameState;
import hr.algebra.java2.cartographers.model.Position;
import hr.algebra.java2.cartographers.model.SeasonEnum;
import hr.algebra.java2.cartographers.thread.SaveLastGameMoveThread;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class GameUtils {
    public static final int NUMBER_OF_ROWS_COLUMNS = 11;
    public static Boolean isEndOfGame = false;

    private GameUtils() {}

    private static final String SAVE_GAME_FILES_PATH = "game/save.dat";
    private static final String SAVE_MULTIPLAYER_FILES_PATH = "game/saveMultiplayer.dat";

//    private ArrayList<String> playerInfo;
//    private ArrayList<String> scoringCards;
//    private ArrayList<String> exploreDeck;
//    private String drawnCard;
//    private int turnCount;
//    private SeasonEnum currentSeason;
//    private ArrayList<String> mountains;
//    private String[][] map;
//    private int coinCount;
//    private String[][] points;
//    private Boolean newGame;

    public static void startNewGame(GameState gameState) {
        gameState.getPlayerInfo().forEach(tf -> tf = "");
        gameState.getScoringCards().forEach(tf -> tf = "");
        gameState.getExploreDeck().forEach(tf -> tf = "");
        gameState.setDrawnCard("");
        gameState.setTurnCount(0);
        gameState.setCurrentSeason(SeasonEnum.SPRING);
        gameState.getMountains().forEach(btn -> btn = "|false");
        for (int i = 0; i < gameState.getMap().length; i++) {
            for (int j = 0; j < gameState.getMap()[i].length; j++) {
                gameState.getMap()[i][j] = "";
            }
        }
        gameState.setCoinCount(0);
        for (int i = 0; i < gameState.getPoints().length; i++) {
            for (int j = 0; j < gameState.getPoints()[i].length; j++) {
                gameState.getPoints()[i][j] = "0";
            }
        }
        gameState.setNewGame(true);

        GameState gState = generateGameState(gameState);
    }

    public static void saveGame(GameState gameState) {
        File saveFile = new File(SAVE_GAME_FILES_PATH);

        if (!saveFile.getParentFile().exists()) {
            saveFile.getParentFile().mkdirs();
        }
        if (!saveFile.exists()) {
            try {
                saveFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_GAME_FILES_PATH))) {
            oos.writeObject(gameState);
        } catch (IOException e) {
            System.out.println("Error saving game: " + e.getMessage());
        }
    }

    public static void saveMultiplayer(GameState gameState) {
        File saveFile = new File(SAVE_MULTIPLAYER_FILES_PATH);

        if (!saveFile.getParentFile().exists()) {
            saveFile.getParentFile().mkdirs();
        }
        if (!saveFile.exists()) {
            try {
                saveFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_MULTIPLAYER_FILES_PATH))) {
            oos.writeObject(gameState);
        } catch (IOException e) {
            System.out.println("Error saving game: " + e.getMessage());
        }
    }

    public static GameState loadGame() {
        GameState loadedGameState;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SAVE_GAME_FILES_PATH))) {
            loadedGameState = (GameState) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading game: " + e.getMessage());
            return null;
        }

        return loadedGameState;
    }

    public static GameState loadMultiplayer() {
        GameState loadedGameState;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SAVE_MULTIPLAYER_FILES_PATH))) {
            loadedGameState = (GameState) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading game: " + e.getMessage());
            return null;
        }

        return loadedGameState;
    }

    public static GameState generateGameState(GameState gameState) {
        ArrayList<String> playerInfo = new ArrayList<>(gameState.getPlayerInfo());
        ArrayList<String> scoringCards = new ArrayList<>(gameState.getScoringCards());
        ArrayList<String> exploreDeck = new ArrayList<>(gameState.getExploreDeck());
        String drawnCard = gameState.getDrawnCard();
        int turnCount = gameState.getTurnCount();
        SeasonEnum currentSeason = gameState.getCurrentSeason();
        ArrayList<String> mountains = new ArrayList<>(gameState.getMountains());
        String[][] map = new String[gameState.getMap().length][gameState.getMap()[0].length];
        for (int i = 0; i < gameState.getMap().length; i++) {
            for (int j = 0; j < gameState.getMap()[i].length; j++) {
                map[i][j] = gameState.getMap()[i][j];
            }
        }
        int coinCount = gameState.getCoinCount();
        String[][] points = new String[gameState.getPoints().length][gameState.getPoints()[0].length];
        for (int i = 0; i < gameState.getPoints().length; i++) {
            for (int j = 0; j < gameState.getPoints()[i].length; j++) {
                points[i][j] = gameState.getPoints()[i][j];
            }
        }
        Boolean newGame = gameState.getNewGame();

        return new GameState(playerInfo, scoringCards, exploreDeck, drawnCard, turnCount, currentSeason, mountains, map, coinCount, points, newGame);
    }

    public static void createGameAndSaveWithThread(GameMove gameMove) {
        XmlUtils.saveNewMove(gameMove);
        SaveLastGameMoveThread thread = new SaveLastGameMoveThread(gameMove);
        Thread saveLastGameMoveThreadRunner = new Thread(thread);
        saveLastGameMoveThreadRunner.start();
    }

    public static GameState loadGameState(GameState gameState) {
        return gameState;
    }

    public static void isEndOfGame(Boolean endOfGame) {
        isEndOfGame = endOfGame;
    }
//    public static void startNewGame(GameState gState) {
//        /*
//        private ArrayList<TextField> player;
////    private String activeScoringLetters;
//    private ArrayList<String> scoringCards;
//    private ArrayList<CardsBase> exploreDeck;
//    private CardsBase drawnCard;
//    private int turnCount;
//    private SeasonEnum currentSeason;
//    private ArrayList<Button> mountains;
//    private Button[][] map;
//    private int coinCount;
//    private TextField[][] points;
//         */
//        TextField tfCartographer = gState.getPlayer().getFirst();
//        gState.getPlayer().removeFirst();
//        tfCartographer.setText("");
//        TextField tfPlayerTitle = gState.getPlayer().getFirst();
//        gState.getPlayer().removeFirst();
//        tfPlayerTitle.setText("");
//        TextField tfKingdomName = gState.getPlayer().getFirst();
//        gState.getPlayer().removeFirst();
//        tfKingdomName.setText("");
//
//        gState.setPlayer(new ArrayList<>(Arrays.asList(tfCartographer, tfPlayerTitle, tfKingdomName)));
//        gState.setScoringCards(gState.getScoringCards());
//        gState.setExploreDeck(gState.getExploreDeck());
//        gState.setDrawnCard(null);
//        gState.setTurnCount(0);
//        gState.setCurrentSeason(SeasonEnum.SPRING);
//        gState.setMountains(gState.getMountains());
//        gState.setMap(gState.getMap());
//        gState.setCoinCount(0);
//        gState.setPoints(gState.getPoints());
//    }

//    public static void startNewGame(GameState gState) {
//        gState.getGrid().getChildren().forEach(node -> {
//            if (node instanceof TextField) {
//                if (((TextField) node).getId().contains("tfNum")) {
//                    ((TextField) node).setText("0");
//                }
//                ((TextField) node).setText("");
//            } else if (node instanceof Button) {
//                ((Button) node).setDisable(false);
//                ((Button) node).setBackground(null);
//            } else if (node instanceof Slider) {
//                ((Slider) node).setValue(0);
//            }
//        });
//    }
}
