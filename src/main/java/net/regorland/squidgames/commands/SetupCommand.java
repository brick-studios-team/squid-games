/**
 * This code has been programmed by Ailakks.
 * Please, leave this note and give me credits
 * in any project in which it is used. Have a nice day!
 *
 * @author : Ailakks
 * @mailto : hola@ailakks.com
 * @created : 11/03/2023
 */

package net.regorland.squidgames.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Subcommand;
import lombok.RequiredArgsConstructor;
import net.regorland.squidgames.SquidGames;
import net.regorland.squidgames.game.LocationType;
import org.bukkit.entity.Player;

@CommandAlias("setup")
@CommandPermission("squid-games.command.admin")
@RequiredArgsConstructor
public class SetupCommand extends BaseCommand {

    @Subcommand("setup spawn")
    public void setupSpawn(Player player, LocationType locationType) {
        SquidGames.getInstance().getArena().getBaseGame().setLocation(locationType.getIdentifier(), player.getLocation());
    }
}