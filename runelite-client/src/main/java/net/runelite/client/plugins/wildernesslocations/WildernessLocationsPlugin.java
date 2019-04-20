
package net.runelite.client.plugins.wildernesslocations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameTick;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.wildernesslocations.WildernessLocationsOverlay;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.WildernessLocation;

@PluginDescriptor(name="PvP Wild Locations",
        description="Indicates the players current location in the wild",
        tags={"Wildy,", "Wilderness Location", "location", "loc", "pvp", "pklite"},
        type = "PVP")

public class WildernessLocationsPlugin extends Plugin {
    @Inject
    private Client client;
    @Inject
    OverlayManager overlayManager;
    @Inject
    private WildernessLocationsOverlay overlay;
    private final HashMap<WorldArea, String> wildLocs;
    private boolean renderLocation;
    private String locationString;
    private WorldPoint worldPoint;
    private static int UPDATE_INTERVAL = 3;

    public WildernessLocationsPlugin() {
        overlay = new WildernessLocationsOverlay(client, this);
        wildLocs = WildernessLocationsPlugin.getLocationMap();
        locationString = "";
        worldPoint = null;
    }

    @Override
    protected void startUp() throws Exception {
        overlayManager.add(overlay);
    }

    @Override
    protected void shutDown() throws Exception {
        overlayManager.add(overlay);
    }

    @Subscribe
    public void onGameTick(GameTick event) {
        if (UPDATE_INTERVAL > 0) {
            --UPDATE_INTERVAL;
            return;
        }
        boolean bl = renderLocation = client.getVar(Varbits.IN_WILDERNESS) == 1;
        if (renderLocation) {
            if (client.getLocalPlayer().getWorldLocation() != worldPoint) {
                locationString = location();
                worldPoint = client.getLocalPlayer().getWorldLocation();
            }
        } else {
            worldPoint = null;
            locationString = "";
        }
        UPDATE_INTERVAL = 3;
    }

    private String location() {
        int dist = 10000;
        String s = "";
        WorldArea closestArea = null;
        for (Map.Entry<WorldArea, String> entry : wildLocs.entrySet()) {
            WorldArea worldArea = entry.getKey();
            if (worldArea.toWorldPointList().contains(client.getLocalPlayer().getWorldLocation())) {
                s = entry.getValue();
                return s;
            }
            int distTo = worldArea.distanceTo(client.getLocalPlayer().getWorldLocation());
            if (distTo >= dist) continue;
            dist = distTo;
            closestArea = worldArea;
        }
        if (client.getLocalPlayer().getWorldLocation().getY() > ((WorldArea)Objects.requireNonNull(closestArea)).toWorldPoint().getY() + closestArea.getHeight()) {
            s = s + "N";
        }
        if (client.getLocalPlayer().getWorldLocation().getY() < closestArea.toWorldPoint().getY()) {
            s = s + "S";
        }
        if (client.getLocalPlayer().getWorldLocation().getX() < closestArea.toWorldPoint().getX()) {
            s = s + "W";
        }
        if (client.getLocalPlayer().getWorldLocation().getX() > closestArea.toWorldPoint().getX() + closestArea.getWidth()) {
            s = s + "E";
        }
        s = s + " of ";
        if ((s = s + wildLocs.get(closestArea)).startsWith(" of ")) {
            s = s.substring(3);
        }
        return s;
    }

    private static HashMap<WorldArea, String> getLocationMap() {
        HashMap<WorldArea, String> hashMap = new HashMap<WorldArea, String>();
        Arrays.stream(WildernessLocation.values()).forEach(wildernessLocation -> hashMap.put(wildernessLocation.getWorldArea(), wildernessLocation.getName()));
        return hashMap;
    }

    public boolean isRenderLocation() {
        return renderLocation;
    }

    public String getLocationString() {
        return locationString;
    }
}

