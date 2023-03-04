package net.regorland.squidgames.task.tasks;

import net.regorland.squidgames.arena.Arena;
import net.regorland.squidgames.arena.ArenaType;
import net.regorland.squidgames.task.DelayedTask;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ChangeGameTypeTask {
    private static final List<ArenaType> gameTypeList = Arrays.asList(ArenaType.values());

    public ChangeGameTypeTask(Arena arena) {
        new DelayedTask(() -> {
            ArenaType arenaType = Optional.ofNullable(arena.getArenaType())
                    .map(value -> gameTypeList.get(gameTypeList.size() < value.ordinal() ? value.ordinal() + 1 : 0))
                    .orElse(ArenaType.RED_LIGHT_GREEN_LIGHT);

            try {
                arena.setArenaType(arenaType).getArenaType().getBaseGame().newInstance().onSpawn();
            } catch (InstantiationException | IllegalAccessException exception) {
                throw new RuntimeException(exception);
            }
        }, 60);
    }
}
