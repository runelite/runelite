package net.runelite.client.plugins.inventorytagger;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Map;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Query;
import net.runelite.api.queries.InventoryWidgetItemQuery;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.util.QueryRunner;

public class InventoryTaggerOverlay extends Overlay
{
	private final QueryRunner queryRunner;

	private final Client client;

	private final InventoryTaggerPlugin plugin;

	private final InventoryTaggerConfig config;

	@Inject
	InventoryTaggerOverlay(QueryRunner queryRunner, Client client, InventoryTaggerConfig config, InventoryTaggerPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		this.queryRunner = queryRunner;
		this.client = client;
		this.config = config;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		Query query = new InventoryWidgetItemQuery();
		WidgetItem[] widgetItems = queryRunner.runQuery(query);
		graphics.setFont(FontManager.getRunescapeSmallFont());

		for (WidgetItem item : widgetItems)
		{
			final Rectangle bounds = item.getCanvasBounds();

			for (Map.Entry<String, TaggedItems> tI: plugin.taggedItems.entrySet())
			{
				if (tI.getValue().containsItem(item.getId()))
				{
					ItemOutline pic = new ItemOutline(client, item.getId(), 2, tI.getValue().overlayColor);
					graphics.drawImage(pic.getPicture(), item.getCanvasLocation().getX() + 1, item.getCanvasLocation().getY() + 1, null);
				}
			}

		}

		return null;
	}
}
