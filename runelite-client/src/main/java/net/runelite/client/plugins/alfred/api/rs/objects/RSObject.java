package net.runelite.client.plugins.alfred.api.rs.objects;

import net.runelite.api.GameObject;
import net.runelite.api.ObjectComposition;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.alfred.Alfred;

import java.awt.*;

public class RSObject {

    private final GameObject gameObject;

    public RSObject(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    public int getId() {
        return gameObject.getId();
    }

    public String getName() {
        ObjectComposition objectComposition = Alfred.getClientThread().invokeOnClientThread(() -> Alfred.getClient().getObjectDefinition(gameObject.getId()));
        return objectComposition.getName();
    }

    public WorldPoint getWorldLocation() {
        return gameObject.getWorldLocation();
    }

    public Rectangle getClickBox() {
        return gameObject.getClickbox().getBounds();
    }

    public Shape getConvexHull() {
        return gameObject.getConvexHull();
    }

    public String[] getActions() {
        ObjectComposition objectComposition = Alfred.getClientThread().invokeOnClientThread(() -> Alfred.getClient().getObjectDefinition(gameObject.getId()));
        return objectComposition.getActions();
    }


}
