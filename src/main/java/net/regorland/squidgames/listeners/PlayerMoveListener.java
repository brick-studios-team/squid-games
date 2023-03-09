package net.regorland.squidgames.listeners;

import net.regorland.squidgames.SquidGames;
import net.regorland.squidgames.game.GameZoneType;
import net.regorland.squidgames.game.games.GlassGame;
import net.regorland.squidgames.game.games.RedGreenLightGame;
import net.regorland.squidgames.player.player.GamePlayer;
import net.regorland.squidgames.region.Cuboid;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Objects;
import java.util.Optional;

public class PlayerMoveListener implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        GamePlayer gamePlayer = SquidGames.getInstance().getGamePlayerManager().get(event.getPlayer());

        if (gamePlayer.getGameArena().getBaseGame() instanceof RedGreenLightGame) {
            RedGreenLightGame redGreenLightGame = (RedGreenLightGame) gamePlayer.getGameArena().getBaseGame();

            if (redGreenLightGame.getZone(GameZoneType.RED_GREEN_LIGHT_KILL_ZONE).isBetween(gamePlayer.getLocation()) && !redGreenLightGame.isCanMove()) {
                gamePlayer.kill();
            }
        }

        if (gamePlayer.getGameArena().getBaseGame() instanceof GlassGame) {
            GlassGame glassGame = (GlassGame) gamePlayer.getGameArena().getBaseGame();

            if (!Objects.isNull(glassGame.getDangerousCuboidList())) {
                glassGame.getDangerousCuboidList().stream().filter(target -> target.isBetween(gamePlayer.getBukkitPlayer().getLocation())).findFirst().ifPresent(cuboid -> {
                    cuboid.makeFallingBlock(gamePlayer.getBukkitPlayer().getLocation().getWorld());
                });
            }

            if (event.getTo().getY() < glassGame.getConfigurationSection().getInt("death-height")) {
                gamePlayer.kill();
            }
        }
    }
}
