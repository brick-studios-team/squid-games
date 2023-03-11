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
import net.regorland.squidgames.game.GameType;
import org.bukkit.entity.Player;

@CommandAlias("game")
@CommandPermission("squid-games.command.admin")
@RequiredArgsConstructor
public class GameCommand extends BaseCommand {

    @Subcommand("phase start")
    public void startPhase(Player player, GameType gameType) {
        SquidGames.getInstance().getArena().startGame(gameType);
    }
}