package net.regorland.squidgames.game.games;

import lombok.Getter;
import net.regorland.squidgames.arena.Arena;
import net.regorland.squidgames.game.BaseGame;
import net.regorland.squidgames.task.BasicRepeatableTask;

import java.util.concurrent.ThreadLocalRandom;

public class RedGreenLightGame extends BaseGame {
    @Getter private boolean canMove = true;

    public RedGreenLightGame(Arena arena) {
        super(arena);

        this.canMove = true;
    }

    @Override
    public void onSpawn() {
        arena.teleport(this.spawnLocation);
    }

    @Override
    public void onStart() {
        new BasicRepeatableTask(() -> {
            canMove = !canMove;
        }, 0, () -> ThreadLocalRandom.current().nextInt(3, 5));
    }

    @Override
    public void onEnd() {

    }

    @Override
    public void onTimeUp() {

    }

    @Override
    public void onSkip() {

    }

    @Override
    public void onPlayerDeath() {

    }
}
