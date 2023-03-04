package net.regorland.squidgames.listeners;

import net.regorland.squidgames.SquidGames;
import net.regorland.squidgames.game.GameZoneType;
import net.regorland.squidgames.game.games.RedGreenLightGame;
import net.regorland.squidgames.player.player.GamePlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        GamePlayer gamePlayer = SquidGames.getInstance().getGamePlayerManager().get(event.getPlayer());

        if (gamePlayer.getGameArena().getBaseGame() instanceof RedGreenLightGame) {
            RedGreenLightGame redGreenLightGame = (RedGreenLightGame) gamePlayer.getGameArena().getBaseGame();

            if (redGreenLightGame.getZone(GameZoneType.RED_GREEN_LIGHT_KILL_ZONE).isBetween(gamePlayer.getLocation())) {

            }
        }
    }
}
