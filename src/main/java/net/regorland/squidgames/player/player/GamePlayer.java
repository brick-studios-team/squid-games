package net.regorland.squidgames.player.player;

import lombok.Getter;
import lombok.Setter;
import net.regorland.squidgames.arena.Arena;
import net.regorland.squidgames.region.Vector3;
import org.bukkit.entity.Player;

public class GamePlayer {
    @Getter private final Player bukkitPlayer;

    @Getter @Setter private Arena gameArena;

    public GamePlayer(Player bukkitPlayer) {
        this.bukkitPlayer = bukkitPlayer;
    }
    public Vector3 getLocation() {
        return new Vector3(this.bukkitPlayer.getLocation());
    }
    public void sendTitle(String key) {

    }
    public void kill() {
        this.bukkitPlayer.setHealth(0);
    }
}
