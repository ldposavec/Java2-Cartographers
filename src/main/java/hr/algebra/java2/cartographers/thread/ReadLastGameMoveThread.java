package hr.algebra.java2.cartographers.thread;

import hr.algebra.java2.cartographers.model.GameMove;
import javafx.application.Platform;
import javafx.scene.control.Label;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode
@AllArgsConstructor
@Data
public class ReadLastGameMoveThread extends AbstractLastGameMoveThread implements Runnable {
    private Label label;
    @Override
    public void run() {
        List<GameMove> gameMoves = loadGameMoves();

        if (!gameMoves.isEmpty()) {
            GameMove lastGameMove = gameMoves.getLast();
            Platform.runLater(() -> label.setText("Base(" + (char)(lastGameMove.getPosition().getRow() + 'A')
                    + lastGameMove.getPosition().getColumn() + ")"));
        }
    }
}
