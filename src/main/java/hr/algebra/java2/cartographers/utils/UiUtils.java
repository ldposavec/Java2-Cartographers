package hr.algebra.java2.cartographers.utils;

import hr.algebra.java2.cartographers.model.SeasonEnum;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;

public class UiUtils {
    public static void newSeason(Label lblSeason, Label lblTurnCount, Label lblScoringOne,
                                 Label lblScoringTwo, Label lblScoringThree) {
        String season;
        char letter1;
        char letter2;
        if (lblSeason.getText().equals(SeasonEnum.SPRING.name())) {
            season = SeasonEnum.SUMMER.name();
            letter1 = 'A';
            letter2 = 'B';
        } else if (lblSeason.getText().equals(SeasonEnum.SUMMER.name())) {
            season = SeasonEnum.FALL.name();
            letter1 = 'B';
            letter2 = 'C';
        } else if (lblSeason.getText().equals(SeasonEnum.FALL.name())) {
            season = SeasonEnum.WINTER.name();
            letter1 = 'C';
            letter2 = 'D';
        } else {
            letter1 = 'D';
            letter2 = 'A';
            season = SeasonEnum.WINTER.name();
            Platform.runLater(() -> DialogUtils.showDialog("End of game",
                    "End of game. \n" +
                            "Game has ended. Make sure to count your points according to '" + letter1 + "' and '" + letter2 + "' " +
                            "scoring" +
                            " cards",
                    Alert.AlertType.INFORMATION));
            return;
        }
        Platform.runLater(() -> {

            lblSeason.setText(season);
            lblTurnCount.setText("0");
            lblScoringOne.setFont(lblScoringTwo.getFont());
            lblScoringTwo.setFont(lblScoringThree.getFont());
        });
            Platform.runLater(() -> DialogUtils.showDialog("End of season",
                    "End of season. \n" +
                            lblSeason.getText() + " season has started. Make sure to count your points according to '" + letter1 + "' and '" + letter2 + "' " +
                            "scoring" +
                            " cards",
                    Alert.AlertType.INFORMATION));
        }

}
