package net.regorland.squidgames.game;

import net.regorland.squidgames.SquidGames;
import net.regorland.squidgames.arena.Arena;
import org.bukkit.Location;

import java.util.StringJoiner;

public class BaseGame {
    protected final Arena arena;

    public BaseGame(Arena arena) {
        this.arena = arena;
    }
    protected Location getSpawn() {
        return SquidGames.getInstance().getLocationsConfiguration().getLocation(
                new StringJoiner(".").add("games").add("spawn").add(arena.getArenaType().getIdentifier()).toString());
    }
}
