package net.regorland.squidgames.game;

import lombok.Getter;

public enum GameType {
    RED_LIGHT_GREEN_LIGHT("red_light_green_light");

    @Getter private final String identifier;

    GameType(String identifier) {
        this.identifier = identifier;
    }
}
