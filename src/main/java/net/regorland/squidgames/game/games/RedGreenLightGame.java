package net.regorland.squidgames.game.games;

import net.regorland.squidgames.arena.Arena;
import net.regorland.squidgames.game.BaseGame;

public class RedGreenLightGame extends BaseGame {
    private boolean canMove;

    public RedGreenLightGame(Arena arena) {
        super(arena);
    }

    @Override
    public void onSpawn() {
        arena.teleport(this.spawnLocation);
    }

    @Override
    public void onStart() {
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
