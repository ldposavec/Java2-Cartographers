package hr.algebra.java2.cartographers.model;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@AllArgsConstructor
public class GameState implements Serializable {
//    private ArrayList<TextField> player;
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
//    private GridPane grid;

    private ArrayList<String> playerInfo;
    private ArrayList<String> scoringCards;
    private ArrayList<String> exploreDeck;
    private String drawnCard;
    private int turnCount;
    private SeasonEnum currentSeason;
    private ArrayList<String> mountains;
    private String[][] map;
    private int coinCount;
    private String[][] points;
    private Boolean newGame;
}
