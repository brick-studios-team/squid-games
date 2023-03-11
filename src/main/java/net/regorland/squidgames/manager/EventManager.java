/**
 * This code has been programmed by Ailakks.
 * Please, leave this note and give me credits
 * in any project in which it is used. Have a nice day!
 *
 * @author : Ailakks
 * @mailto : hola@ailakks.com
 * @created : 11/03/2023
 */

package net.regorland.squidgames.manager;

import net.regorland.squidgames.SquidGames;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

public class EventManager {
    public static void registerListener(Listener listener) {
        SquidGames.getInstance().getServer().getPluginManager().registerEvents(listener, SquidGames.getInstance());
    }
    public static void unregisterListener(Listener listener) {
        HandlerList.unregisterAll(listener);
    }
}
