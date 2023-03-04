package net.regorland.squidgames.task;

import net.regorland.squidgames.SquidGames;

public class DelayedTask {
    public DelayedTask(Runnable runnable, int delay) {
        SquidGames.getInstance().getServer().getScheduler().scheduleSyncDelayedTask(SquidGames.getInstance(), runnable, delay);
    }
}
