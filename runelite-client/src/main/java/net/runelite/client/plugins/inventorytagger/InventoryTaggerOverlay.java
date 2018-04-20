package net.runelite.client.plugins.inventorytagger;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Query;
import net.runelite.api.queries.InventoryWidgetItemQuery;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.TextComponent;
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

			for (TaggedItems tI: plugin.taggedItems)
			{
				if (tI.containsItem(item.getId()))
				{
					graphics.setColor(tI.overlayColor);
					graphics.setStroke(new BasicStroke(3));
					graphics.draw(bounds);
				}
			}

		}

		return null;
	}
}
