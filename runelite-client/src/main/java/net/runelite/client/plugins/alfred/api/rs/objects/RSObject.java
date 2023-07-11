package net.runelite.client.plugins.alfred.api.rs.objects;

import net.runelite.api.*;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.alfred.Alfred;

import java.awt.*;
import java.util.Arrays;
import java.util.Objects;

public class RSObject {

    private final Object rsObject;

    public RSObject(GameObject gameObject) {
        this.rsObject = gameObject;
    }

    public RSObject(GroundObject groundObject) {
        this.rsObject = groundObject;
    }

    public RSObject(WallObject wallObject) {
        this.rsObject = wallObject;
    }

    public RSObject(DecorativeObject decorativeObject) {
        this.rsObject = decorativeObject;
    }

    public String getRuneliteVariableName() {
        return Alfred.api.objects().getObjectIdVariableName(this.getId());
    }

    public String getType() {
        if (rsObject instanceof GameObject) {
            return GameObject.class.getSimpleName();

        } else if (rsObject instanceof GroundObject) {
            return GroundObject.class.getSimpleName();

        } else if (rsObject instanceof WallObject) {
            return WallObject.class.getSimpleName();

        } else if (rsObject instanceof DecorativeObject) {
            return DecorativeObject.class.getSimpleName();

        } else {
            return null;
        }
    }

    public int getId() {
        if (rsObject instanceof GameObject) {
            return ((GameObject) rsObject).getId();

        } else if (rsObject instanceof GroundObject) {
            return ((GroundObject) rsObject).getId();

        } else if (rsObject instanceof WallObject) {
            return ((WallObject) rsObject).getId();

        } else if (rsObject instanceof DecorativeObject) {
            return ((DecorativeObject) rsObject).getId();

        } else {
            return -1;
        }
    }

    public String getName() {
        ObjectComposition objectComposition = Alfred.getClientThread().invokeOnClientThread(() -> Alfred.getClient().getObjectDefinition(this.getId()));
        return objectComposition.getName();
    }

    public WorldPoint getWorldLocation() {
        if (rsObject instanceof GameObject) {
            return ((GameObject) rsObject).getWorldLocation();

        } else if (rsObject instanceof GroundObject) {
            return ((GroundObject) rsObject).getWorldLocation();

        } else if (rsObject instanceof WallObject) {
            return ((WallObject) rsObject).getWorldLocation();

        } else if (rsObject instanceof DecorativeObject) {
            return ((DecorativeObject) rsObject).getWorldLocation();

        } else {
            return null;
        }
    }

    public Rectangle getClickBox() {
        if (rsObject instanceof GameObject) {
            return ((GameObject) rsObject).getClickbox().getBounds();

        } else if (rsObject instanceof GroundObject) {
            return ((GroundObject) rsObject).getClickbox().getBounds();

        } else if (rsObject instanceof WallObject) {
            return ((WallObject) rsObject).getClickbox().getBounds();

        } else if (rsObject instanceof DecorativeObject) {
            return ((DecorativeObject) rsObject).getClickbox().getBounds();

        } else {
            return null;
        }
    }

    public Shape getConvexHull() {
        if (rsObject instanceof GameObject) {
            return ((GameObject) rsObject).getConvexHull();

        } else if (rsObject instanceof GroundObject) {
            return ((GroundObject) rsObject).getConvexHull();

        } else if (rsObject instanceof WallObject) {
            return ((WallObject) rsObject).getConvexHull();

        } else if (rsObject instanceof DecorativeObject) {
            return ((DecorativeObject) rsObject).getConvexHull();

        } else {
            return null;
        }
    }

    public String[] getActions() {
        ObjectComposition objectComposition = Alfred.getClientThread().invokeOnClientThread(() -> Alfred.getClient().getObjectDefinition(this.getId()));
        return Arrays.stream(objectComposition.getActions()).filter(Objects::nonNull).toArray(String[]::new);
    }


}
