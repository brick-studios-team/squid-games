package net.regorland.squidgames.task;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import net.regorland.squidgames.SquidGames;

@Accessors(chain = true)
public class RepeatableTask {
    @Getter @Setter private Runnable end;

    public RepeatableTask(Runnable runnable, int start, int delay) {
        SquidGames.getInstance().getServer().getScheduler().scheduleSyncRepeatingTask(SquidGames.getInstance(), runnable, start, delay);
    }
}
