package net.regorland.squidgames.region;

import lombok.Getter;
import org.bukkit.util.Vector;

public class Cuboid {
    @Getter private final Vector firstPoint;
    @Getter private final Vector secondPoint;

    public Cuboid(Vector firstPoint, Vector secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }
}
