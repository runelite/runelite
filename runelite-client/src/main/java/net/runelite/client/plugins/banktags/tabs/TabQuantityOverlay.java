package net.runelite.client.plugins.banktags.tabs;

import java.awt.Color;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.banktags.BankTagsConfig;
import net.runelite.client.plugins.banktags.TagManager;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.WidgetItemOverlay;

public class TabQuantityOverlay extends WidgetItemOverlay
{
	private final Client client;

	@Inject
	private ItemManager itemManager;

	@Inject
	private TabInterface tabInterface;

	@Inject
	private TagManager tagManager;

	@Inject
	private BankTagsConfig bankTagsConfig;

	@Inject
	TabQuantityOverlay(Client client, TabInterface tabInterface, TagManager tagManager, BankTagsConfig bankTagsConfig)
	{
		this.client = client;
		this.tabInterface = tabInterface;
		this.tagManager = tagManager;
		this.bankTagsConfig = bankTagsConfig;
		showOnBank();
	}

	@Override
	public void renderItemOverlay(Graphics2D graphics, int itemId, WidgetItem itemWidget)
	{

		if (!bankTagsConfig.useQuantityFeature() || tabInterface.getActiveTab() == null)
		{
			return;
		}

		String configValue = tagManager.getQuantityOfItemForTag(tabInterface.getActiveTab().getTag(), itemId, false);

		graphics.setFont(FontManager.getRunescapeSmallFont());
		Point location = itemWidget.getCanvasLocation();

		graphics.setColor(Color.black);
		graphics.drawString("" + configValue, location.getX() + 2,
			location.getY() + 21 + (graphics.getFontMetrics().getHeight() - 1));

		graphics.setColor(bankTagsConfig.quantityOverlayColor());
		graphics.drawString("" + configValue, location.getX() + 1,
			location.getY() + 20 + (graphics.getFontMetrics().getHeight() - 1));
	}
}
