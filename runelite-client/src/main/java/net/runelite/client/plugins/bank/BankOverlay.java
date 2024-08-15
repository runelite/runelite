package net.runelite.client.plugins.bank;

import com.google.inject.Inject;
import net.runelite.api.ItemID;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.WidgetItemOverlay;
import net.runelite.client.ui.overlay.components.TextComponent;

import java.awt.*;
import net.runelite.client.util.QuantityFormatter;

public class BankOverlay extends WidgetItemOverlay
{

	private final BankConfig config;
	private final BankPlugin plugin;
	private final ItemManager itemManager;

	@Inject
	BankOverlay(BankConfig config, ItemManager itemManager, BankPlugin plugin)
	{
		this.config = config;
		this.plugin = plugin;
		this.itemManager = itemManager;
		showOnBank();
	}

	@Override
	public void renderItemOverlay(Graphics2D graphics, int itemId, WidgetItem widgetItem)
	{
		graphics.setFont(FontManager.getRunescapeSmallFont());
		renderText(graphics, widgetItem.getCanvasBounds(), widgetItem);
	}


	private void renderText(Graphics2D graphics, Rectangle bounds, WidgetItem iden)
	{
		if (plugin.isHotKeyPressed())
		{
			long gePrice = 0, haPrice = 0, priceToShow;
			String priceText = "";
			final net.runelite.client.ui.overlay.components.TextComponent textComponent = new TextComponent();
			// Positions text in the middle of the items bounds
			textComponent.setPosition(new Point(bounds.x - 1, (bounds.y + bounds.height / 2) + 5));

			if (config.showHAPerItem())
			{
				haPrice = getHaPrice(iden.getId());
			}

			if (config.showGEPerItem())
			{
				gePrice = itemManager.getItemPrice(iden.getId());
			}

			// Show greater of HA/GE price on item
			priceToShow = Math.max(haPrice, gePrice);

			if (haPrice > gePrice)
			{
				textComponent.setColor(config.haPerItemColor());
			}
			else
			{
				textComponent.setColor(config.gePerItemColor());
			}

			if (priceToShow > 0)
			{
				priceText += QuantityFormatter.quantityToStackSize(priceToShow * iden.getQuantity());

				textComponent.setText(priceText);
				textComponent.render(graphics);
			}
		}
	}

	private int getHaPrice(int itemId)
	{
		switch (itemId)
		{
			case ItemID.COINS_995:
				return 1;
			case ItemID.PLATINUM_TOKEN:
				return 1000;
			default:
				return itemManager.getItemComposition(itemId).getHaPrice();
		}
	}
}
