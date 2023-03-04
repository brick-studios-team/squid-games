package net.regorland.squidgames.game;

public interface GameActions {
    /*
    Actions that are triggered by game events
     */
    void onSpawn();
    void onStart();
    void onEnd();
    void onTimeUp();
    void onSkip();

    /*
    Actions that are triggered by player events
     */
    void onPlayerDeath();
}
