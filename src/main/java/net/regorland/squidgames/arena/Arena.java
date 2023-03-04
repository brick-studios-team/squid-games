package net.regorland.squidgames.arena;

import lombok.Getter;
import lombok.Setter;
import net.regorland.squidgames.SquidGames;
import net.regorland.squidgames.player.player.GamePlayer;
import org.bukkit.Location;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Arena {
    @Getter @Setter private ArenaState gameState;
    @Getter @Setter private ArenaType gameType;

    public Arena() {
        this.gameState = ArenaState.WAITING;
    }
    public List<GamePlayer> getPlayers() {
        return SquidGames.getInstance().getGamePlayerManager().getList().stream()
                .filter(target -> target.getGameArena().equals(this)).collect(Collectors.toList());
    }
    public void doGlobally(Consumer<GamePlayer> consumer) {
        getPlayers().forEach(consumer);
    }
    public void teleport(Location bukkitLocation) {
        doGlobally(gamePlayer -> gamePlayer.getBukkitPlayer().teleport(bukkitLocation));
    }
}
