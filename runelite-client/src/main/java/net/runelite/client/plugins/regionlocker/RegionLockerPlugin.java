package net.runelite.client.plugins.regionlocker;

import com.google.inject.Provides;
import lombok.AccessLevel;
import lombok.Setter;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.Point;
import net.runelite.api.RenderOverview;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.WidgetMenuOptionClicked;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.input.KeyManager;
import net.runelite.client.input.MouseAdapter;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;

@PluginDescriptor(
    name = RegionLockerPlugin.PLUGIN_NAME,
    description = "Adds graphical effect to locked regions.",
    tags = {"region", "locker", "chunk", "map square"}
)
public class RegionLockerPlugin extends Plugin {
    static final String PLUGIN_NAME = "Region Locker";
    static final String CONFIG_KEY = "regionlocker";

    @Inject
    private Client client;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private RegionLockerConfig config;

    @Inject
    private RegionLockerOverlay regionLockerOverlay;

    @Inject
    private RegionLockerInput inputListener;

    @Inject
    private KeyManager keyManager;

    @Inject
    private ConfigManager configManager;

    @Setter(AccessLevel.PACKAGE)
    private boolean hotKeyPressed = false;

    private RegionLocker regionLocker;

    @Provides
    RegionLockerConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(RegionLockerConfig.class);
    }

    @Override
    protected void startUp() throws Exception {
        regionLocker = new RegionLocker(client, config, configManager);
        overlayManager.add(regionLockerOverlay);
        keyManager.registerKeyListener(inputListener);
    }

    @Override
    protected void shutDown() throws Exception {
        overlayManager.remove(regionLockerOverlay);
        keyManager.unregisterKeyListener(inputListener);
    }

    @Subscribe
    public void onConfigChanged(ConfigChanged event)
    {
        if (!event.getGroup().equals(RegionLockerPlugin.CONFIG_KEY))
        {
            return;
        }

        regionLocker.readConfig();
    }

    @Subscribe
    public void onFocusChanged(FocusChanged focusChanged)
    {
        if (!focusChanged.isFocused())
        {
            hotKeyPressed = false;
        }
    }

    @Subscribe
    public void onMenuOptionClicked(MenuOptionClicked event) {
        Widget map = client.getWidget(WidgetInfo.WORLD_MAP_VIEW);
        if (!hotKeyPressed || map == null) return;

        RenderOverview ro = client.getRenderOverview();
        Float pixelsPerTile = ro.getWorldMapZoom();

        Rectangle worldMapRect = map.getBounds();
        int widthInTiles = (int) Math.ceil(worldMapRect.getWidth() / pixelsPerTile);
        int heightInTiles = (int) Math.ceil(worldMapRect.getHeight() / pixelsPerTile);

        Point worldMapPosition = ro.getWorldMapPosition();

        int yTileMin = worldMapPosition.getY() - heightInTiles / 2;

        Point mousePos = client.getMouseCanvasPosition();

        int tx = (int)((mousePos.getX() - worldMapRect.getX()) / pixelsPerTile);
        int ty = (int)((mousePos.getY() - worldMapRect.getX() - worldMapRect.height) / pixelsPerTile);

        int x = tx - widthInTiles/2 + worldMapPosition.getX();
        int y = -ty + yTileMin;

        int regionId = ((x >> 6) << 8) | (y >> 6);

        System.out.println(regionId);
        regionLocker.addRegion(regionId);
    }
}
