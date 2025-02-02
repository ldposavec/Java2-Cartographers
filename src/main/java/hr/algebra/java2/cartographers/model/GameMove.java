package hr.algebra.java2.cartographers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameMove implements Serializable {
    private int turnCount;
    private SeasonEnum season;
    private Position position;
    private int coinCount;
//    private String[][] points;
}
