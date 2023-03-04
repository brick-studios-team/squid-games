package net.regorland.squidgames.region;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.util.Vector;

public class Vector3 {
    @Getter @Setter private double x;
    @Getter @Setter private double y;
    @Getter @Setter private double z;

    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3 clone() {
        return new Vector3(this.getX(), this.getX(), this.getZ());
    }
    public Vector toBukkitVector() {
        return new Vector(this.getX(), this.getX(), this.getZ());
    }
}
