package hr.algebra.java2.cartographers.utils;

import hr.algebra.java2.cartographers.model.Position;
import hr.algebra.java2.cartographers.thread.ReadLastGameMoveThread;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

public class FileUtils {
    private FileUtils() {}

    public static final String GAME_MOVE_HISTORY_FILE_NAME = "dat/gameMoves.dat";
    public static final AtomicBoolean FILE_ACCESS_IN_PROGRESS = new AtomicBoolean(false);

    public static Optional<Position> getGridPosition(Button button, Button[][] gridMap) {
        for (int i = 0; i < gridMap.length; i++) {
            for (int j = 0; j < gridMap[i].length; j++) {
                if (gridMap[i][j] == button) {
                    return Optional.of(new Position(i, j));
                }
            }
        }
        return Optional.empty();
    }

    public static Timeline getLastGameMoveRefreshTimeline(Label label) {
        Timeline showLastGameMoveTimeline = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            ReadLastGameMoveThread thread = new ReadLastGameMoveThread(label);
            Thread lastGameMoveThreadRunner = new Thread(thread);
            lastGameMoveThreadRunner.start();
        }), new KeyFrame(Duration.seconds(3)));

        showLastGameMoveTimeline.setCycleCount(Animation.INDEFINITE);
        return showLastGameMoveTimeline;
    }
}
