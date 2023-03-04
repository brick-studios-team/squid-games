package net.regorland.squidgames.player.player;

import lombok.Getter;
import lombok.Setter;
import net.regorland.squidgames.game.GameArena;
import org.bukkit.entity.Player;

public class GamePlayer {
    @Getter private final Player bukkitPlayer;

    @Getter @Setter private GameArena gameArena;

    public GamePlayer(Player bukkitPlayer) {
        this.bukkitPlayer = bukkitPlayer;
    }
}
