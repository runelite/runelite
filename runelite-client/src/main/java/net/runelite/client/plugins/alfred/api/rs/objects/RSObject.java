package net.runelite.client.plugins.alfred.api.rs.objects;

import lombok.Getter;
import net.runelite.api.*;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.plugins.alfred.api.rs.menu.RSMenu;

import java.awt.*;
import java.util.Arrays;
import java.util.Objects;

public class RSObject {

    @Getter
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

    public LocalPoint getLocalLocation() {
        if (rsObject instanceof GameObject) {
            return ((GameObject) rsObject).getLocalLocation();

        } else if (rsObject instanceof GroundObject) {
            return ((GroundObject) rsObject).getLocalLocation();

        } else if (rsObject instanceof WallObject) {
            return ((WallObject) rsObject).getLocalLocation();

        } else if (rsObject instanceof DecorativeObject) {
            return ((DecorativeObject) rsObject).getLocalLocation();

        } else {
            return null;
        }
    }

    public int getPlane() {
        if (rsObject instanceof GameObject) {
            return ((GameObject) rsObject).getPlane();

        } else if (rsObject instanceof GroundObject) {
            return ((GroundObject) rsObject).getPlane();

        } else if (rsObject instanceof WallObject) {
            return ((WallObject) rsObject).getPlane();

        } else if (rsObject instanceof DecorativeObject) {
            return ((DecorativeObject) rsObject).getPlane();

        } else {
            return -1;
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

    public boolean leftClick() {
        LocalPoint localPoint = getLocalLocation();
        int plane = getPlane();

        if (Alfred.api.screen().isPointOnScreen(localPoint, plane)) {
            Point screenPoint = Alfred.api.screen().getLocalPointToScreenPoint(localPoint, plane);
            Alfred.getMouse().leftClick(screenPoint);
            return true;
        }

        return false;
    }

    public boolean rightClick() {
        LocalPoint localPoint = getLocalLocation();
        int plane = getPlane();

        if (Alfred.api.screen().isPointOnScreen(localPoint, plane)) {
            Point screenPoint = Alfred.api.screen().getLocalPointToScreenPoint(localPoint, plane);
            Alfred.getMouse().rightClick(screenPoint);
            return true;
        }

        return false;
    }

    public boolean clickAction(String action) {
        Alfred.setStatus("Clicking " + action + " on " + getName());

        if (!rightClick()) {
            return false;
        }

        Alfred.sleep(200, 400);
        RSMenu rsMenu = Alfred.api.menu().getMenu();

        if (rsMenu == null) {
            return false;
        }

        return rsMenu.clickAction(action, getName());
    }
}
