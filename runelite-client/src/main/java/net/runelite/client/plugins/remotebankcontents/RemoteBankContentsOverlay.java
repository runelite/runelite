package net.runelite.client.plugins.remotebankcontents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.ItemComposition;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;
import net.runelite.client.util.ColorUtil;

public class RemoteBankContentsOverlay extends Overlay
{

	//Inventory widget id
	private static final int INVENTORY_ITEM_WIDGETID = WidgetInfo.INVENTORY.getPackedId();

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

		//Hide if the right click menu is open
		if (client.isMenuOpen() || !config.overlay())
		{
			return null;
		}


		final MenuEntry[] menuEntries = client.getMenuEntries();
		final int last = menuEntries.length - 1;

		if (last < 0)
		{
			return null;

		}

		final MenuEntry menuEntry = menuEntries[last];
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
					int quantity = remoteBankContentsProcess.getQuantity(unnnotedId(menuEntry.getIdentifier()));
					final String text = quantity + " in bank";

					if (isUltimateIronman())
					{
						tooltipManager.add(new Tooltip(ColorUtil.prependColorTag("UIM BTW", new Color(238, 238, 238))));
						return null;
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


	private int unnnotedId(int id)
	{
		ItemComposition item = client.getItemDefinition(id);
		return item.getNote() == -1 ? id : item.getLinkedNoteId();
	}


	/*
	TODO
	 * BUG - currently things people with a 3 at character 5 in name are UIM
	 *
	 *
	 */
	private boolean isUltimateIronman()
	{

		char c = 5;
		Widget w = client.getWidget(WidgetInfo.CHATBOX_INPUT);

		return w.getText().charAt(c) == '3';
	}

}