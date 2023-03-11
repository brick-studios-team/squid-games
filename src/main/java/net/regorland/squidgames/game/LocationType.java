/**
 * This code has been programmed by Ailakks.
 * Please, leave this note and give me credits
 * in any project in which it is used. Have a nice day!
 *
 * @author : Ailakks
 * @mailto : hola@ailakks.com
 * @created : 11/03/2023
 */

package net.regorland.squidgames.game;

import lombok.Getter;

public enum LocationType {
    SPAWN("spawn");

    @Getter private final String identifier;

    LocationType(String identifier) {
        this.identifier = identifier;
    }
}
