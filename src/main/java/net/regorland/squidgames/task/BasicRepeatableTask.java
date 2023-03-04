package net.regorland.squidgames.task;

import lombok.Getter;
import lombok.experimental.Accessors;
import net.regorland.squidgames.SquidGames;

import java.util.function.Supplier;

@Accessors(chain = true)
public class BasicRepeatableTask {
    @Getter private static int bukkitTaskId = 0;

    public BasicRepeatableTask(Runnable runnable, int start, Supplier<Integer> delay) {
        bukkitTaskId = SquidGames.getInstance().getServer().getScheduler().scheduleSyncRepeatingTask(SquidGames.getInstance(), runnable, start, delay.get());
    }
}
