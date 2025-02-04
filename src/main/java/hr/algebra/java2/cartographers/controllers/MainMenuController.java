package hr.algebra.java2.cartographers.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Logger;

public class MainMenuController {
    public static final Logger logger = Logger.getLogger(MainMenuController.class.getName());
    @FXML
    private Button btnSingleplayer;

    @FXML
    protected void openSingleplayer(ActionEvent event) {
        try {
            openGame("Singleplayer");
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
    }

    private void openGame(String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/hr/algebra/java2/cartographers" +
                "/cartography" +
                ".fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(new Scene(root, 780, 1050));
        stage.show();
    }

    public void exitApp(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void openMultiplayer(ActionEvent actionEvent) {
        try {
            openGame("Multiplayer");
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
    }
}