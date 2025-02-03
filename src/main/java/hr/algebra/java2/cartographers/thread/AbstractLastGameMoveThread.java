package hr.algebra.java2.cartographers.thread;

import hr.algebra.java2.cartographers.model.GameMove;
import hr.algebra.java2.cartographers.utils.FileUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbstractLastGameMoveThread {
    protected synchronized void saveLastGameMove(GameMove gameMove) throws FileNotFoundException {
        while (Boolean.TRUE.equals(FileUtils.FILE_ACCESS_IN_PROGRESS)) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }

        File gameMovesDat = new File(FileUtils.GAME_MOVE_HISTORY_FILE_NAME);
        if (!gameMovesDat.getParentFile().exists()) {
            gameMovesDat.getParentFile().mkdirs();
        }

        List<GameMove> gameMoves = new ArrayList<>();
        if (Files.exists(Path.of(FileUtils.GAME_MOVE_HISTORY_FILE_NAME))) {
            gameMoves.addAll(loadGameMoves());
        }
        gameMoves.add(gameMove);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FileUtils.GAME_MOVE_HISTORY_FILE_NAME))) {
            oos.writeObject(gameMoves);
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileUtils.FILE_ACCESS_IN_PROGRESS.set(false);

        notifyAll();
    }

    protected synchronized List<GameMove> loadGameMoves() {
        while (Boolean.TRUE.equals(FileUtils.FILE_ACCESS_IN_PROGRESS)) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }

        FileUtils.FILE_ACCESS_IN_PROGRESS.set(true);

        List<GameMove> gameMoves = new ArrayList<>();

        if(Files.exists(Path.of(FileUtils.GAME_MOVE_HISTORY_FILE_NAME))) {
            try (ObjectInputStream ois =
                         new ObjectInputStream(new FileInputStream(FileUtils.GAME_MOVE_HISTORY_FILE_NAME))) {
                gameMoves.addAll((List<GameMove>) ois.readObject());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        FileUtils.FILE_ACCESS_IN_PROGRESS.set(false);

        notifyAll();

        return gameMoves;
    }
}
