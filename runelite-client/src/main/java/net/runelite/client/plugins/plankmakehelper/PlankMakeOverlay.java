package net.runelite.client.plugins.plankmakehelper;

import net.runelite.api.*;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.ui.overlay.*;

import javax.inject.Inject;
import java.awt.*;

public class PlankMakeOverlay extends Overlay {

	private final PlankMakePlugin plugin;
	private final Client client;

	@Inject
	public PlankMakeOverlay(final PlankMakePlugin plugin, final Client client) {
		super(plugin);
		this.plugin = plugin;
		this.client = client;

		setPosition(OverlayPosition.DETACHED);
		setLayer(OverlayLayer.ALWAYS_ON_TOP);
		setPriority(OverlayPriority.MED);
	}

	@Override
	public Dimension render(Graphics2D graphics) {
		if (hasPlankableItems()) {
			renderInventory(graphics);
			renderPlankMakeSpell(graphics);
		}
		return null;
	}

	private void renderInventory(Graphics2D graphics) {
		Widget inventory = client.getWidget(WidgetInfo.INVENTORY);

		int firstItemSeenIndex = -1;

		if (inventory != null) {
			for (WidgetItem item : inventory.getWidgetItems()) {
				if (PlankMakePlugin.isLogAndPlankable(item.getId())) {
					if (firstItemSeenIndex == -1) {
						firstItemSeenIndex = item.getIndex();
					}
					if (!inventory.isHidden()) {
						if (item.getIndex() != firstItemSeenIndex) {
							OverlayUtil.renderPolygon(graphics, RectangleToPolygon(item.getCanvasBounds()), Color.BLUE);
						}
					}
				}
			}
			if (firstItemSeenIndex != -1) {
				OverlayUtil.renderPolygon(graphics, RectangleToPolygon(inventory.getWidgetItem(firstItemSeenIndex).getCanvasBounds()), Color.CYAN);
			}
		}
	}

	private void renderPlankMakeSpell(Graphics2D graphics) {
		Widget plankMakeSpell = client.getWidget(218,128);
		if (plankMakeSpell != null && (plankMakeSpell.getCanvasLocation().getX() != 29 & plankMakeSpell.getCanvasLocation().getY() != 32)) {
			OverlayUtil.renderPolygon(graphics, RectangleToPolygon(plankMakeSpell.getBounds()), Color.CYAN);
		}
	}

	private boolean hasPlankableItems() {
		ItemContainer invo = client.getItemContainer(InventoryID.INVENTORY);
		if (invo != null) {
			if (invo.getItems().length > 0) {
				for (Item item : invo.getItems()) {
					if (PlankMakePlugin.isLogAndPlankable(item.getId())) {
						return true;
					}
				}
			}
		}
		return false;
	}

	static Polygon RectangleToPolygon(Rectangle rect) {
		int[] xpoints = {rect.x, rect.x + rect.width, rect.x + rect.width, rect.x};
		int[] ypoints = {rect.y, rect.y, rect.y + rect.height, rect.y + rect.height};
		return new Polygon(xpoints, ypoints, 4);
	}

}
