package hr.algebra.java2.cartographers.thread;

import hr.algebra.java2.cartographers.model.GameMove;
import lombok.AllArgsConstructor;

import java.io.FileNotFoundException;

@AllArgsConstructor
public class SaveLastGameMoveThread extends AbstractLastGameMoveThread implements Runnable {
    private GameMove gameMove;

    @Override
    public void run() {
        try {
            saveLastGameMove(gameMove);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
