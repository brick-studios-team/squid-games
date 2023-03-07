package net.regorland.squidgames.task.tasks;

import net.regorland.squidgames.arena.Arena;
import net.regorland.squidgames.game.GameType;
import net.regorland.squidgames.task.DelayedTask;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ChangeGameTypeTask {
    private static final List<GameType> gameTypeList = Arrays.asList(GameType.values());

    public ChangeGameTypeTask(Arena arena) {
        new DelayedTask(() -> {
            GameType gameType = Optional.ofNullable(arena.getGameType())
                    .map(value -> gameTypeList.get(gameTypeList.size() < value.ordinal() ? value.ordinal() + 1 : 0))
                    .orElse(GameType.RED_LIGHT_GREEN_LIGHT);

            arena.getBaseGame().onSpawn();
        }, 60);
    }
}
