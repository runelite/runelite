package net.runelite.client.plugins.tabsviewer;

import net.runelite.api.Client;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.tabsviewer.config.ViewerMode;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ImageComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

import javax.inject.Inject;
import java.awt.*;
import java.awt.image.BufferedImage;

public class EquipmentViewerOverlay extends Overlay {

    private static final int INVENTORY_SIZE = 28;
    private static final int PLACEHOLDER_WIDTH = 36;
    private static final int PLACEHOLDER_HEIGHT = 32;
    private static final ImageComponent PLACEHOLDER_IMAGE = new ImageComponent(new BufferedImage(PLACEHOLDER_WIDTH, PLACEHOLDER_HEIGHT, BufferedImage.TYPE_4BYTE_ABGR));

    private final ItemManager itemManager;
    private final TabsViewerConfig config;
    private final Client client;

    private final PanelComponent panelComponent = new PanelComponent();

    @Inject
    private EquipmentViewerOverlay(Client client, ItemManager itemManager, TabsViewerConfig config)
    {
        this.itemManager = itemManager;
        this.config = config;
        this.client = client;

        setPosition(OverlayPosition.BOTTOM_RIGHT);
        panelComponent.setWrapping(4);
        panelComponent.setOrientation(PanelComponent.Orientation.HORIZONTAL);
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        if(config.tabsViewMode() == ViewerMode.INV)
            return null;

        return null;
    }
}
