package hr.algebra.java2.cartographers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainMenuController {
    @FXML
    private Button btnSingleplayer;

    @FXML
    protected void openSingleplayer(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/hr/algebra/java2/cartographers" +
                    "/cartography" +
                    ".fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Singleplayer");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exitApp(ActionEvent actionEvent) {
        System.exit(0);
    }
}