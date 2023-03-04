package net.regorland.squidgames.region;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.bukkit.Location;
import org.bukkit.util.Vector;

@Accessors(chain = true)
public class Cuboid {
    @Getter @Setter private Vector3 firstPoint;
    @Getter @Setter private Vector3 secondPoint;

    public Cuboid(Vector3 firstPoint, Vector3 secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }
    public Cuboid(Vector firstPoint, Vector secondPoint) {
        this.firstPoint = new Vector3(firstPoint);
        this.firstPoint = new Vector3(secondPoint);
    }
    public Cuboid(Location firstPoint, Location secondPoint) {
        this.firstPoint = new Vector3(firstPoint);
        this.firstPoint = new Vector3(secondPoint);
    }
    public boolean isBetween(double x, double z) {
        double x1 = this.firstPoint.getX();
        double z1 = this.firstPoint.getZ();

        double x2 = this.secondPoint.getX();
        double z2 = this.secondPoint.getZ();

        return ((x1 < x && x < x2) || (x1 > x && x > x2)) && ((z1 < z && z < z2) || (z1 > z && z > z2));
    }
    public boolean isBetween(Vector3 vector3) {
        return isBetween(vector3.getX(), vector3.getZ());
    }
    public boolean isBetween(Vector bukkitVector) {
        return isBetween(bukkitVector.getX(), bukkitVector.getZ());
    }
    public boolean isBetween(Location bukkitLocation) {
        return isBetween(bukkitLocation.getX(), bukkitLocation.getZ());
    }
}
