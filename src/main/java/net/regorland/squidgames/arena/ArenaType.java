package net.regorland.squidgames.arena;

import lombok.Getter;

public enum ArenaType {
    RED_LIGHT_GREEN_LIGHT("red_green_light");

    @Getter private final String identifier;

    ArenaType(String identifier) {
        this.identifier = identifier;
    }
}
