package net.regorland.squidgames.game.games;

import lombok.Getter;
import net.regorland.squidgames.SquidGames;
import net.regorland.squidgames.arena.Arena;
import net.regorland.squidgames.game.BaseGame;
import net.regorland.squidgames.game.GameZoneType;
import net.regorland.squidgames.player.player.GamePlayer;
import net.regorland.squidgames.task.BasicRepeatableTask;
import net.regorland.squidgames.task.DelayedTask;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.concurrent.ThreadLocalRandom;

public class RedGreenLightGame extends BaseGame {
    @Getter private boolean canMove;

    public RedGreenLightGame(Arena arena) {
        super(arena);

        this.canMove = true;
    }

    @Override
    public void onSpawn() {
        arena.teleport(this.spawnLocation);
    }

    @Override
    public void onStart() {
        new BasicRepeatableTask(() -> {
            if (canMove) {
                this.arena.doGlobally(target -> target.sendTitle(this.arena.getResourceKey("red_light.title")));
                this.arena.doGlobally(target -> target.getBukkitPlayer().getInventory().clear());
            } else {
                this.arena.doGlobally(target -> target.sendTitle(this.arena.getResourceKey("green_light.title")));
                this.arena.doGlobally(target -> target.getBukkitPlayer().getInventory().clear());
            }

            new DelayedTask(() -> {
                canMove = !canMove;
            }, 20);
        }, 0, () -> ThreadLocalRandom.current().nextInt(3, 5));
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

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        GamePlayer gamePlayer = SquidGames.getInstance().getGamePlayerManager().get(event.getPlayer());

        if (this.getZone(GameZoneType.RED_GREEN_LIGHT_KILL_ZONE).isBetween(gamePlayer.getLocation()) && !this.isCanMove()) {
            gamePlayer.kill();
        }
    }
}
