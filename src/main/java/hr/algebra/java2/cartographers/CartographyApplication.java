package hr.algebra.java2.cartographers;

import hr.algebra.java2.cartographers.controllers.CartographyController;
import hr.algebra.java2.cartographers.jndi.ConfigurationKey;
import hr.algebra.java2.cartographers.jndi.ConfigurationReader;
import hr.algebra.java2.cartographers.model.CardsBase;
import hr.algebra.java2.cartographers.model.GameState;
import hr.algebra.java2.cartographers.model.LoggedInPlayerGameContext;
import hr.algebra.java2.cartographers.model.PlayerType;
import hr.algebra.java2.cartographers.utils.DialogUtils;
import hr.algebra.java2.cartographers.utils.GameUtils;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CartographyApplication extends Application {
    public static final LoggedInPlayerGameContext loggedInPlayer = new LoggedInPlayerGameContext();
    public static final Logger logger = Logger.getLogger(CartographyApplication.class.getName());
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CartographyApplication.class.getResource("main-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Cartographers: the Game");
        stage.setScene(scene);
        stage.show();

        if (!PlayerType.SINGLE_PLAYER.name().equals(loggedInPlayer.getPlayerType().name())) {
            if (PlayerType.PLAYER_1.name().equals(loggedInPlayer.getPlayerType().name())) {
                Thread serverThread = new Thread(() -> acceptRequests(
                        ConfigurationReader.getIntValueForKey(ConfigurationKey.PLAYER_1_SERVER_PORT)));
                serverThread.start();
            } else if (PlayerType.PLAYER_2.name().equals(loggedInPlayer.getPlayerType().name())) {
                Thread serverThread = new Thread(() -> acceptRequests(
                        ConfigurationReader.getIntValueForKey(ConfigurationKey.PLAYER_2_SERVER_PORT)));
                serverThread.start();
            }
        }
    }

    public static void main(String[] args) {
        String firstCommandLineArg = args[0];
        Boolean playerTypeExists = false;

        for (PlayerType playerType : PlayerType.values()) {
            if (firstCommandLineArg.equals(playerType.toString())) {
                loggedInPlayer.setPlayerType(playerType);
                playerTypeExists = true;
                logger.log(Level.INFO, "Player type: " + playerType);
                break;
            }
        }

        if (!playerTypeExists) {
            logger.log(Level.INFO, "Invalid player type");
            DialogUtils.showDialog("Invalid player type", "Invalid player type", Alert.AlertType.WARNING);
            System.exit(0);
        }
        else launch();
    }

    private static void acceptRequests(Integer port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.log(Level.INFO, "Accepting requests on port: " + serverSocket.getLocalPort());

            while (!PlayerType.SINGLE_PLAYER.name().equals(loggedInPlayer.getPlayerType().name())) {
                Socket clientSocket = serverSocket.accept();
                logger.log(Level.INFO, "Client connected: " + clientSocket.getPort());
                new Thread(() -> processSerializableClient(clientSocket)).start();
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    private static void processSerializableClient(final Socket clientSocket) {
        try (ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
             ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream())) {
//            ArrayList<String> sentExploreDeck = (ArrayList<String>) ois.readObject();
//            GameState gameStateToSave = GameUtils.generateGameState(gameState);
//            GameUtils.saveMultiplayer(gameStateToSave);
//            for (String card : sentExploreDeck) {
//                String[] cardParts = card.split("\\|");
//                CardsBase.Builder builder = new CardsBase.Builder();
//
//            }
            String playerName = (String) ois.readObject();

//            Boolean endOfGame = GameUtils.isEndOfGame;
            Platform.runLater(() -> DialogUtils.showDialog("Change turns",
                    playerName + " just played his turn.", Alert.AlertType.INFORMATION));
            oos.writeObject("Success");
        } catch (IOException | ClassNotFoundException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    public static void sendRequestFromPlayerOne(final String playerName) {
        try (Socket socket = new Socket(ConfigurationReader.getStringValueForKey(ConfigurationKey.HOSTNAME),
                ConfigurationReader.getIntValueForKey(ConfigurationKey.PLAYER_2_SERVER_PORT))) {
            logger.log(Level.INFO, "Connecting to: " + socket.getInetAddress() + ":" + socket.getPort());

            sendSerializableRequest(socket, playerName);
        } catch (IOException | ClassNotFoundException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    public static void sendRequestFromPlayerTwo(final String playerName) {
        try (Socket socket = new Socket(ConfigurationReader.getStringValueForKey(ConfigurationKey.HOSTNAME),
                ConfigurationReader.getIntValueForKey(ConfigurationKey.PLAYER_1_SERVER_PORT))) {
            logger.log(Level.INFO, "Connecting to: " + socket.getInetAddress() + ":" + socket.getPort());

            sendSerializableRequest(socket, playerName);
        } catch (IOException | ClassNotFoundException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    private static void sendSerializableRequest(Socket socket, String playerName) throws IOException,
            ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        oos.writeObject(playerName);
        logger.log(Level.INFO, "Sent game state to player");
        logger.log(Level.INFO, "Response: " + ois.readObject());
    }
}