package net.runelite.client.plugins.invalue;

import com.google.inject.Provides;
import net.runelite.api.*;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.game.ItemManager;
import java.awt.Color;
import javax.inject.Inject;

@PluginDescriptor(
        name = "Inventory Item Value",
        description = "Highlight items in inventory to indicate their stack value.",
        tags = {"grand", "exchange", "high", "alchemy", "prices", "highlight", "overlay", "inventory", "overlay"},
        enabledByDefault = false
        )

public class InventoryValuePlugin extends Plugin {
    @Inject
    private Client client;

    @Inject
    private ConfigManager configManager;

    @Inject
    private InventoryValueConfig config;

    @Inject
    private InventoryValueOverlay overlay;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private ItemManager itemManager;

    @Provides
    InventoryValueConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(InventoryValueConfig.class);
    }

    @Override
    protected void startUp() { overlayManager.add(overlay); }

    @Override
    protected void shutDown() { overlayManager.remove(overlay); }

    // Retrieves GE value for items
    // Works with coins and platinum tokens
    // Excludes untradables
    public int getValue(int itemID) {
        if (itemID == ItemID.COINS_995) { return 1; }
        if (itemID == ItemID.PLATINUM_TOKEN) { return 1000; }
        if (itemManager.getItemPrice(itemID) == null) { return 0; }
        return itemManager.getItemPrice(itemID).getPrice();
    }

    // Retrieves color config for low to insane value items
    Color getLVColor() { return config.getLVColor(); }
    Color getMVColor() { return config.getMVColor(); }
    Color getHVColor() { return config.getHVColor(); }
    Color getEVColor() { return config.getEVColor(); }
    Color getIVColor() { return config.getIVColor(); }

    // Retrieves config for low to insane value definitions
    int getLValue() { return config.getLValue(); }
    int getMValue() { return config.getMValue(); }
    int getHValue() { return config.getHValue(); }
    int getEValue() { return config.getEValue(); }
    int getIValue() { return config.getIValue(); }

}
