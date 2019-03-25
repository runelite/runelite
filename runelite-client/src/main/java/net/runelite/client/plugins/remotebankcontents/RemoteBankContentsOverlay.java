package net.runelite.client.plugins.remotebankcontents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.ItemComposition;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.vars.AccountType;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;
import net.runelite.client.util.ColorUtil;

public class RemoteBankContentsOverlay extends Overlay
{

	private final TooltipManager tooltipManager;
	@Inject
	private Client client;
	@Inject
	private RemoteBankContentsConfig config;
	private RemoteBankContentsProcess remoteBankContentsProcess;


	@Inject
	RemoteBankContentsOverlay(Client client, TooltipManager tooltipManager)
	{
		setPosition(OverlayPosition.DYNAMIC);
		this.client = client;
		this.tooltipManager = tooltipManager;
	}

	void setRemoteBankContentsProcess(RemoteBankContentsProcess remoteBankContentsProcess)
	{
		this.remoteBankContentsProcess = remoteBankContentsProcess;
	}


	@Override
	public Dimension render(Graphics2D graphics)
	{

		//A lot of this code in this method is based on the code from the ItemOverlay plugin. Credit goes to the author of that.
		//Hide if the right click menu is open or if the overlay option is off.
		if (client.isMenuOpen() || !config.overlay())
		{
			return null;
		}


		final MenuEntry[] menuEntries = client.getMenuEntries();
		final int lastMenuEntry = menuEntries.length - 1;

		if (lastMenuEntry < 0)
		{
			return null;

		}

		final MenuEntry menuEntry = menuEntries[lastMenuEntry];
		final MenuAction action = MenuAction.of(menuEntry.getType());
		final int widgetId = menuEntry.getParam1();
		final int groupId = WidgetInfo.TO_GROUP(widgetId);


		// Tooltip action type handling
		switch (action)
		{
			case ITEM_USE:
			case ITEM_FIRST_OPTION:
			case ITEM_SECOND_OPTION:
			case ITEM_THIRD_OPTION:
			case ITEM_FOURTH_OPTION:
			case ITEM_FIFTH_OPTION:
			case GROUND_ITEM_FIRST_OPTION:
			case GROUND_ITEM_SECOND_OPTION:
			case GROUND_ITEM_THIRD_OPTION:
			case GROUND_ITEM_FOURTH_OPTION:
			case GROUND_ITEM_FIFTH_OPTION:


				// Item tooltip values
				if (groupId != WidgetID.BANK_GROUP_ID && groupId != WidgetID.BANK_INVENTORY_GROUP_ID)
				{
					//Find the quantity in the bank
					int quantity = remoteBankContentsProcess.getQuantityInBank(getUnnotedId(menuEntry.getIdentifier()));
					final String text = quantity + " in bank";

					if (isUltimateIronman())
					{
						tooltipManager.add(new Tooltip(ColorUtil.prependColorTag("UIM BTW", new Color(238, 238, 238))));
					}
					else if (remoteBankContentsProcess.initialised())
					{
						tooltipManager.add(new Tooltip(ColorUtil.prependColorTag(text, new Color(238, 238, 238))));
					}
					else
					{
						tooltipManager.add(new Tooltip(ColorUtil.prependColorTag("Open bank to initialise", new Color(238, 238, 238))));
					}

				}
				break;
		}

		return null;

	}


	/**
	 * Returns the unnoted id of the item id inserted as the parameter.
	 * <p>
	 * If the id of the item inserted as a parameter is already noted it will return the unnoted id.
	 * If the id of the item inserted as a parameter is not noted it will return the id inserted.
	 *
	 * @param id - The ID of the item that you would like to get the unnoted id of.
	 * @return - The Unnoted item ID.
	 */
	private int getUnnotedId(int id)
	{
		ItemComposition item = client.getItemDefinition(id);

		return item.getNote() == -1 ? id : item.getLinkedNoteId();
	}


	/**
	 * @return - True if the player is an Ultimate Ironman.
	 */
	private boolean isUltimateIronman()
	{
		return client.getAccountType().equals(AccountType.ULTIMATE_IRONMAN);
	}


}