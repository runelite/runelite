package net.runelite.client.plugins.remotebankcontents;

import net.runelite.api.*;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;
import net.runelite.client.util.ColorUtil;

import javax.inject.Inject;
import java.awt.*;

public class RemoteBankContentsOverlay extends Overlay {

    //Inventory widget id
    private static final int INVENTORY_ITEM_WIDGETID = WidgetInfo.INVENTORY.getPackedId();

    private final TooltipManager tooltipManager;
    @Inject
    private Client client;
    @Inject
    private RemoteBankContentsConfig config;
    private RemoteBankContentsProcess remoteBankContentsProcess;


    @Inject
    RemoteBankContentsOverlay(Client client, TooltipManager tooltipManager) {
        setPosition(OverlayPosition.DYNAMIC);
        this.client = client;
        this.tooltipManager = tooltipManager;
    }

    void setRemoteBankContentsProcess(RemoteBankContentsProcess remoteBankContentsProcess) {
        this.remoteBankContentsProcess = remoteBankContentsProcess;
    }


    @Override
    public Dimension render(Graphics2D graphics) {

        //A lot of this code in this method is based on the code from the ItemOverlay plugin. Credit goes to the author of that.

        //Hide if the right click menu is open
        if (client.isMenuOpen()) {
            return null;
        }


        final MenuEntry[] menuEntries = client.getMenuEntries();
        final int last = menuEntries.length - 1;

        if (last < 0) {
            return null;
        }

        final MenuEntry menuEntry = menuEntries[last];
        final MenuAction action = MenuAction.of(menuEntry.getType());
        final int widgetId = menuEntry.getParam1();
        final int groupId = WidgetInfo.TO_GROUP(widgetId);

        // Tooltip action type handling
        switch (action) {
            case WIDGET_DEFAULT:
            case ITEM_USE:
            case ITEM_FIRST_OPTION:
            case ITEM_SECOND_OPTION:
            case ITEM_THIRD_OPTION:
            case ITEM_FOURTH_OPTION:
            case ITEM_FIFTH_OPTION:
                // Item tooltip values
                if (groupId == WidgetID.INVENTORY_GROUP_ID) {

                    if (!config.overlay()) {
                        return null;
                    }

                    //Find the quantity in the bank
                    int quantity = remoteBankContentsProcess.getQuantity(getItemID(menuEntry));
                    final String text = quantity + " in bank";


                    //If the hashmap has been populated at least once before.
                    if (remoteBankContentsProcess.initialised()) {

                        //Is text always null here? Keep this as a failsafe.
                        if (text != null) {
                            tooltipManager.add(new Tooltip(ColorUtil.prependColorTag(text, new Color(238, 238, 238))));
                        }

                        // If it hasn't been populated, tell them to initialise by opening the bank.
                    } else {
                        tooltipManager.add(new Tooltip(ColorUtil.prependColorTag("Open bank to initialise", new Color(238, 238, 238))));
                    }
                }
                break;
        }

        return null;

    }


    /**
     * Returns the ID of the item possessing the passed menu entry.
     *
     * @param menuEntry - Pass a menu entry
     * @return The id of the item with the passed menu entry
     */
    private int getItemID(MenuEntry menuEntry) {

        final int widgetId = menuEntry.getParam1();
        ItemContainer container = null;

        // Inventory item
        if (widgetId == INVENTORY_ITEM_WIDGETID) {
            container = client.getItemContainer(InventoryID.INVENTORY);
        }

        //If inventory is not open (somehow)
        if (container == null) {
            return -1;
        }

        // Find the item in the container
        final Item[] items = container.getItems();
        final int index = menuEntry.getParam0();

        if (index < items.length) {

            //get the item ID
            return items[index].getId();

        }

        return -1;
    }

}
