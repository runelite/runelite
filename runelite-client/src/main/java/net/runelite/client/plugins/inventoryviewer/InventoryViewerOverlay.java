package net.runelite.client.plugins.inventoryviewer;

import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.queries.InventoryItemQuery;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ImagePanelComponent;
import net.runelite.client.util.QueryRunner;
import javax.inject.Inject;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class InventoryViewerOverlay extends Overlay
{
	private final QueryRunner queryRunner;
	private final ItemManager itemManager;

	private static final int PLACEHOLDER_WIDTH = 36;
	private static final int PLACEHOLDER_HEIGHT = 32;

	private static final int INVENTORY_SIZE = 28;

	private final ImagePanelComponent imagePanelComponent = new ImagePanelComponent(4);

	@Inject
	InventoryViewerOverlay(QueryRunner queryRunner, ItemManager itemManager)
	{
		setPosition(OverlayPosition.BOTTOM_LEFT);
		this.itemManager = itemManager;
		this.queryRunner = queryRunner;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		imagePanelComponent.getImages().clear();

		Item[] items = queryRunner.runQuery(new InventoryItemQuery(InventoryID.INVENTORY));

		for (int i = 0; i < INVENTORY_SIZE; i ++)
		{
			if (items != null && i < items.length)
			{
				BufferedImage image = getImage(items[i]);
				if (image != null && items[i].getQuantity() > 0)
				{
					imagePanelComponent.getImages().add(image);
					continue;
				}
			}
			imagePanelComponent.getImages().add(new BufferedImage(PLACEHOLDER_WIDTH, PLACEHOLDER_HEIGHT, BufferedImage.TYPE_4BYTE_ABGR));
		}
		return imagePanelComponent.render(graphics);
	}

	private BufferedImage getImage(Item item)
	{
		return itemManager.getImage(item.getId(), item.getQuantity(), item.getQuantity() > 1);
	}
}

