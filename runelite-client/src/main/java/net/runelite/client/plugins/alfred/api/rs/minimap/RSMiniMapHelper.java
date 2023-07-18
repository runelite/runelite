package net.runelite.client.plugins.alfred.api.rs.minimap;

import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.alfred.Alfred;

public class RSMiniMapHelper {

    public RSMiniMapHelper() {
    }

    public Point getLocalPointToScreenPoint(LocalPoint localPoint, int plane) {
        return Perspective.localToMinimap(Alfred.getClient(), localPoint, plane);
    }

    public Point getWorldPointToScreenPoint(WorldPoint worldPoint) {
        LocalPoint localPoint = LocalPoint.fromWorld(Alfred.getClient(), worldPoint);
        return Perspective.localToMinimap(Alfred.getClient(), localPoint);
    }

}
