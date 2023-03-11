package net.regorland.squidgames;

import co.aikar.commands.PaperCommandManager;
import lombok.Getter;
import net.regorland.squidgames.arena.Arena;
import net.regorland.squidgames.commands.GameCommand;
import net.regorland.squidgames.configuration.Configuration;
import net.regorland.squidgames.configuration.ConfigurationManager;
import net.regorland.squidgames.player.manager.GamePlayerManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class SquidGames extends JavaPlugin {

    @Getter private static SquidGames instance;

    @Getter private Arena arena;

    @Getter private PaperCommandManager paperCommandManager;
    @Getter private ConfigurationManager configurationManager;
    @Getter private GamePlayerManager gamePlayerManager;

    @Getter private Configuration locationsConfiguration;

    @Override
    public void onEnable() {
        instance = this;

        this.arena = new Arena();

        this.paperCommandManager = new PaperCommandManager(this);
        this.configurationManager = new ConfigurationManager();
        this.gamePlayerManager = new GamePlayerManager();

        this.paperCommandManager.registerCommand(new GameCommand());

        this.locationsConfiguration = this.configurationManager.getConfig("locations.yml");
    }

    @Override
    public void onDisable() {

    }
}
