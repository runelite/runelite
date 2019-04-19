package net.runelite.client.plugins.easy.util;

import lombok.Getter;
import net.runelite.api.Player;
import net.runelite.api.coords.WorldPoint;

public class Markable {

    @Getter
    private Player player;

    @Getter
    private WorldPoint location;

    @Getter
    private long frozenTime;

    @Getter
    private long frozenUntil;

    public Markable(Player player, WorldPoint location, long frozenTime, long frozenLength) {
        this.player = player;
        this.location = location;
        this.frozenTime = frozenTime;
        this.frozenUntil = frozenTime + frozenLength + 3000;
    }

}
