package net.runelite.client.plugins.tabsviewer;

import net.runelite.api.*;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.tabsviewer.config.ViewerMode;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ImageComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

import javax.inject.Inject;
import java.awt.*;
import java.awt.Point;
import java.awt.image.BufferedImage;

public class EquipmentViewerOverlay extends Overlay {

    private static final int EQUIPMENT_SIZE = 15;
    private static final int PLACEHOLDER_WIDTH = 36;
    private static final int PLACEHOLDER_HEIGHT = 36;
    private static final ImageComponent PLACEHOLDER_IMAGE = new ImageComponent(new BufferedImage(PLACEHOLDER_WIDTH, PLACEHOLDER_HEIGHT, BufferedImage.TYPE_4BYTE_ABGR));

    private final Client client;
    private final ItemManager itemManager;
    private final TabsViewerConfig config;
    private final SpriteManager spriteManager;

    private final PanelComponent panelComponent = new PanelComponent();

    @Inject
    private EquipmentViewerOverlay(Client client, ItemManager itemManager, TabsViewerConfig config, SpriteManager spriteManager)
    {
        this.client = client;
        this.itemManager = itemManager;
        this.config = config;
        this.spriteManager = spriteManager;

        setPosition(OverlayPosition.BOTTOM_RIGHT);
        panelComponent.setWrapping(3);
        panelComponent.setOrientation(PanelComponent.Orientation.HORIZONTAL);
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        if(config.tabsViewMode() == ViewerMode.INV)
            return null;

        final ItemContainer itemContainer = client.getItemContainer(InventoryID.EQUIPMENT);

        if (itemContainer == null) {
            return null;
        }

        panelComponent.getChildren().clear();

        final Item[] items = itemContainer.getItems();

        for (int i = 0; i < EQUIPMENT_SIZE; i++)
        {
            EquipmentToViewerMap mapping = EquipmentToViewerMap.findMapping(i);
            if(mapping != null)
            {
                final int equipmentPos = mapping.getEquipmentPosition();
                if (equipmentPos < items.length)
                {
                    final Item item = items[equipmentPos];
                    if (item != null && item.getQuantity() > 0)
                    {
                        BufferedImage itemImage = getImage(item);
                        addChildrenImage(panelComponent, createCombinedImage(itemImage));
                        continue;
                    }
                    else
                    {
                        BufferedImage slotImage = getSpriteImage(mapping.getPlaceholder());
                        addChildrenImage(panelComponent, createCombinedImage(slotImage));
                        continue;
                    }
                }
                else
                {
                    BufferedImage slotImage = getSpriteImage(mapping.getPlaceholder());
                    addChildrenImage(panelComponent, createCombinedImage(slotImage));
                    continue;
                }
            }
            panelComponent.getChildren().add(PLACEHOLDER_IMAGE);
        }
        return panelComponent.render(graphics);
    }

    private void addChildrenImage(PanelComponent panelComponent, BufferedImage image)
    {
        if (image != null) {
            panelComponent.getChildren().add(new ImageComponent(image));
        }
    }

    private BufferedImage createCombinedImage(BufferedImage topImage)
    {
        BufferedImage combinedImage = new BufferedImage(PLACEHOLDER_WIDTH, PLACEHOLDER_HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
        final Graphics imgGraphics = combinedImage.getGraphics();
        BufferedImage tileImage = getSpriteImage(SpriteID.EQUIPMENT_SLOT_TILE);
        imgGraphics.drawImage(tileImage, 0,0, null);
        imgGraphics.drawImage(topImage,((PLACEHOLDER_WIDTH - topImage.getWidth()) / 2) + 1,((PLACEHOLDER_HEIGHT - topImage.getHeight()) / 2) + 1,null);
        return combinedImage;
    }

    private BufferedImage getImage(Item item)
    {
        return itemManager.getImage(item.getId(), item.getQuantity(), item.getQuantity() > 1);
    }

    private BufferedImage getSpriteImage(int spriteID)
    {
        return spriteManager.getSprite(spriteID, 0);
    }
}