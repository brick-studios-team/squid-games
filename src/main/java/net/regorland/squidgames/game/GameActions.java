package net.regorland.squidgames.game;

public interface GameActions {
    void onSpawn();
    void onStart();
    void onEnd();
    void onTimeUp();
    void onSkip();

    void onPlayerDeath();
}
