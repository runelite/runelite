package net.runelite.client.plugins.alfred.api.rs.bank;

import net.runelite.api.GameObject;
import net.runelite.api.coords.WorldPoint;

import java.awt.*;


public class RSBank {
    private final GameObject bankObject;

    public RSBank(GameObject gameObject) {
        this.bankObject = gameObject;
    }

    public WorldPoint getWorldLocation() {
        return bankObject.getWorldLocation();
    }

    public Shape getClickbox() {
        return bankObject.getClickbox();
    }
}
