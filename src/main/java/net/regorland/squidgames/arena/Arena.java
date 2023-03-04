package net.regorland.squidgames.arena;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import net.regorland.squidgames.SquidGames;
import net.regorland.squidgames.game.BaseGame;
import net.regorland.squidgames.game.GameType;
import net.regorland.squidgames.player.player.GamePlayer;
import org.bukkit.Location;

import java.util.List;
import java.util.StringJoiner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Accessors(chain = true)
public class Arena {
    @Getter @Setter private ArenaState arenaState;
    @Getter @Setter private GameType gameType;
    @Getter @Setter private BaseGame baseGame;

    public Arena() {
        this.arenaState = ArenaState.WAITING;

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
    public String getResourceKey(String key) {
        return new StringJoiner(".").add(this.gameType.getIdentifier()).add(key).toString();
    }
    public Arena initializeGame(GameType gameType) {
        this.gameType = gameType;

        try {
            this.baseGame = (BaseGame) gameType.getBaseGame().newInstance();
        } catch (InstantiationException | IllegalAccessException exception) {
            throw new RuntimeException(exception);
        }

        return this;
    }
}
