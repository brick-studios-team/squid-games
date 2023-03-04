package net.regorland.squidgames.task;

import net.regorland.squidgames.SquidGames;

public class DelayedTask {
    public DelayedTask(int delay, Runnable runnable) {
        SquidGames.getInstance().getServer().getScheduler().scheduleSyncDelayedTask(SquidGames.getInstance(), runnable, delay);
    }
}
