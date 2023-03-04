package net.regorland.squidgames.listeners;

import net.regorland.squidgames.SquidGames;
import net.regorland.squidgames.game.GameType;
import net.regorland.squidgames.player.player.GamePlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        GamePlayer gamePlayer = SquidGames.getInstance().getGamePlayerManager().get(event.getPlayer());

        if (gamePlayer.getGameArena().getGameType().equals(GameType.RED_LIGHT_GREEN_LIGHT) &&
                gamePlayer.getGameArena().getBaseGame()) {

        }
    }
}
