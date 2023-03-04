package net.regorland.squidgames;

import lombok.Getter;
import net.regorland.squidgames.configuration.Configuration;
import net.regorland.squidgames.configuration.ConfigurationManager;
import net.regorland.squidgames.player.manager.GamePlayerManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class SquidGames extends JavaPlugin {

    @Getter private static SquidGames instance;

    @Getter private ConfigurationManager configurationManager;
    @Getter private GamePlayerManager gamePlayerManager;

    @Getter private Configuration locationsConfiguration;

    @Override
    public void onEnable() {
        instance = this;

        this.configurationManager = new ConfigurationManager();
        this.gamePlayerManager = new GamePlayerManager();

        this.locationsConfiguration = this.configurationManager.getConfig("locations.yml");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
