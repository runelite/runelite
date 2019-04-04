package net.runelite.client.plugins.regionlocker;

import com.google.inject.Provides;
import lombok.AccessLevel;
import lombok.Setter;
import net.runelite.api.*;
import net.runelite.api.Point;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatCommandManager;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.Text;

import javax.inject.Inject;
import java.awt.*;

@PluginDescriptor(
    name = RegionLockerPlugin.PLUGIN_NAME,
    description = "Adds graphical effect to locked regions.",
    tags = {"region", "locker", "chunk", "map square"}
)
public class RegionLockerPlugin extends Plugin {
    static final String PLUGIN_NAME = "Region Locker";
    static final String CONFIG_KEY = "regionlocker";
    private static final String CHUNK_COMMAND = "!chunks";

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

    @Inject
    private ChatMessageManager chatMessageManager;

    @Inject
    private ChatCommandManager chatCommandManager;

    @Setter(AccessLevel.PACKAGE)
    private boolean unlockKeyPressed = false;

    @Setter(AccessLevel.PACKAGE)
    private boolean blockKeyPressed = false;

    private RegionLocker regionLocker;

    @Provides
    RegionLockerConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(RegionLockerConfig.class);
    }

    @Override
    protected void startUp() throws Exception {
        chatCommandManager.registerCommandAsync(CHUNK_COMMAND, this::chunkAmountLookup);
        regionLocker = new RegionLocker(client, config, configManager);
        overlayManager.add(regionLockerOverlay);
        keyManager.registerKeyListener(inputListener);
        setKeys();
    }

    @Override
    protected void shutDown() throws Exception {
        chatCommandManager.unregisterCommand(CHUNK_COMMAND);
        overlayManager.remove(regionLockerOverlay);
        keyManager.unregisterKeyListener(inputListener);
        RegionLocker.renderLockedRegions = false;
    }

    @Subscribe
    public void onConfigChanged(ConfigChanged event)
    {
        if (!event.getGroup().equals(RegionLockerPlugin.CONFIG_KEY))
        {
            return;
        }

        setKeys();

        regionLocker.readConfig();
    }

    @Subscribe
    public void onFocusChanged(FocusChanged focusChanged)
    {
        if (!focusChanged.isFocused())
        {
            unlockKeyPressed = false;
            blockKeyPressed = false;
        }
    }

    @Subscribe
    public void onMenuOptionClicked(MenuOptionClicked event) {
        Widget map = client.getWidget(WidgetInfo.WORLD_MAP_VIEW);
        if (!(unlockKeyPressed || blockKeyPressed) || map == null) return;

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

        if (unlockKeyPressed) regionLocker.addRegion(regionId);
        if (blockKeyPressed) regionLocker.blockRegion(regionId);
    }

    private void setKeys() {
        RegionLockerInput.UNLOCK_KEY = config.unlockKey();
        RegionLockerInput.BLOCK_KEY = config.blacklistKey();
    }

    private void chunkAmountLookup(ChatMessage chatMessage, String message)
    {
        if (!config.chunkCommand()) return;

        int totalChunks = Text.fromCSV(config.unlockedRegions()).size();

        String response = new ChatMessageBuilder()
                .append(ChatColorType.NORMAL)
                .append("Total chunks")
                .append(ChatColorType.NORMAL)
                .append(" unlocked: ")
                .append(ChatColorType.HIGHLIGHT)
                .append(String.valueOf(totalChunks))
                .build();

        final MessageNode messageNode = chatMessage.getMessageNode();
        messageNode.setRuneLiteFormatMessage(response);
        chatMessageManager.update(messageNode);
        client.refreshChat();
    }
}
