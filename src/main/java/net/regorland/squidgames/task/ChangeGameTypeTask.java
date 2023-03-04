package net.regorland.squidgames.task;

import net.regorland.squidgames.game.GameArena;
import net.regorland.squidgames.game.GameType;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ChangeGameTypeTask {
    private static final List<GameType> gameTypeList = Arrays.asList(GameType.values());

    public ChangeGameTypeTask(GameArena gameArena) {
        new DelayedTask(() -> {
            GameType gameType = Optional.ofNullable(gameArena.getGameType())
                    .map(value -> gameTypeList.get(gameTypeList.size() < value.ordinal() ? value.ordinal() + 1 : 0))
                    .orElse(GameType.RED_LIGHT_GREEN_LIGHT);

            gameArena.setGameType(gameType);
        }, 60);
    }
}
