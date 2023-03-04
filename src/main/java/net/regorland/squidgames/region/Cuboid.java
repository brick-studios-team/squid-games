package net.regorland.squidgames.region;

import lombok.Getter;

public class Cuboid {
    @Getter private final Vector3 firstPoint;
    @Getter private final Vector3 secondPoint;

    public Cuboid(Vector3 firstPoint, Vector3 secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

}
