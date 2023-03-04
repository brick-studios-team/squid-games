package net.regorland.squidgames;

import lombok.Getter;
import net.regorland.squidgames.player.manager.GamePlayerManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class SquidGames extends JavaPlugin {

    @Getter private static SquidGames instance;

    @Getter private GamePlayerManager gamePlayerManager;

    @Override
    public void onEnable() {
        instance = this;

        this.gamePlayerManager = new GamePlayerManager();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
