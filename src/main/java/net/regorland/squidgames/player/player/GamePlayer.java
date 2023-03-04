package net.regorland.squidgames.player.player;

import lombok.Getter;
import org.bukkit.entity.Player;

public class GamePlayer {
    @Getter private final Player bukkitPlayer;

    public GamePlayer(Player bukkitPlayer) {
        this.bukkitPlayer = bukkitPlayer;
    }
}
