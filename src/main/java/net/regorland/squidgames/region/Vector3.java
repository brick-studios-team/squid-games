package net.regorland.squidgames.region;

import lombok.Getter;
import lombok.Setter;

public class Vector3 {
    @Getter @Setter private double x;
    @Getter @Setter private double y;
    @Getter @Setter private double z;

    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
