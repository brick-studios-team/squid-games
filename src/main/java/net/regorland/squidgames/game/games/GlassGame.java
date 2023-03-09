/**
 * This code has been programmed by Ailakks.
 * Please, leave this note and give me credits
 * in any project in which it is used. Have a nice day!
 *
 * @author : Ailakks
 * @mailto : hola@ailakks.com
 * @created : 09/03/2023
 */

package net.regorland.squidgames.game.games;

import net.regorland.squidgames.arena.Arena;
import net.regorland.squidgames.game.BaseGame;
import net.regorland.squidgames.region.Cuboid;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.util.Vector;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

public class GlassGame extends BaseGame {
    public GlassGame(Arena arena) {
        super(arena);
    }

    @Override
    public void onSpawn() {

    }

    @Override
    public void onStart() {
        IntStream.range(0, this.configurationSection.getInt("glass-platforms")).forEach(platform -> {
            AtomicBoolean isWalkable = new AtomicBoolean(ThreadLocalRandom.current().nextBoolean());

            IntStream.range(0, 1).forEach(index -> {
                Location glassLocation = this.getLocation("glass-generation").add(new Vector(index * this.configurationSection
                                .getInt("glass-separation-aisle"), 0, platform * this.configurationSection.getInt("glass-separation-platforms")));
                int cuboidSize = this.configurationSection.getInt("size");

                new Cuboid(glassLocation, glassLocation.add(new Vector(cuboidSize, 0, cuboidSize)))
                        .fill(glassLocation.getWorld(), isWalkable.get() ? Material.GLASS : Material.STONE);
                isWalkable.set(!isWalkable.get());
            });
        });
    }

    @Override
    public void onEnd() {

    }

    @Override
    public void onTimeUp() {

    }

    @Override
    public void onSkip() {

    }

    @Override
    public void onPlayerDeath() {

    }
}
