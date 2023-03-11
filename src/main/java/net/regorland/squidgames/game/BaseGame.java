package net.regorland.squidgames.game;

import lombok.Getter;
import net.regorland.squidgames.SquidGames;
import net.regorland.squidgames.arena.Arena;
import net.regorland.squidgames.region.Cuboid;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.Listener;

import java.util.StringJoiner;

public abstract class BaseGame implements Listener {
    @Getter protected final Arena arena;
    @Getter protected final ConfigurationSection configurationSection;

    protected final Location spawnLocation;

    public BaseGame(Arena arena) {
        this.arena = arena;

        this.spawnLocation = getLocation("spawn");
        this.configurationSection = SquidGames.getInstance().getConfig().getConfigurationSection(new StringJoiner(".")
                .add("games").add(this.arena.getGameType().getIdentifier()).toString());
    }
    public Cuboid getZone(GameZoneType gameZoneType) {
        return SquidGames.getInstance().getLocationsConfiguration().getCuboid(this.arena.getResourceKey(gameZoneType.getIdentifier()));
    }
    public Location getLocation(String identifier) {
        return SquidGames.getInstance().getLocationsConfiguration().getLocation(this.configurationSection.get(identifier).toString());
    }

    public void onEnable() {
        SquidGames.getInstance().getServer().getPluginManager().registerEvents(this, SquidGames.getInstance());
        onStart();
    }

    public void onDisable() {

        onEnd();
    }

    public void onStart() {
    }

    public void onEnd() {
    }
}