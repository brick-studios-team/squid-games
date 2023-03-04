package net.regorland.squidgames.player.manager;

import net.regorland.squidgames.player.player.GamePlayer;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class GamePlayerManager {
    private final HashMap<UUID, GamePlayer> gamePlayerMap;

    public GamePlayerManager() {
        this.gamePlayerMap = new HashMap<>();
    }

    public GamePlayer get(Player player) {
        return gamePlayerMap.computeIfAbsent(player.getUniqueId(), uuid -> new GamePlayer(player));
    }
    public GamePlayer destroy(Player player) {
        return gamePlayerMap.remove(player.getUniqueId());
    }
}
