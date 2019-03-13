package net.runelite.client.plugins.remotebankcontents;

import net.runelite.api.*;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.game.ItemManager;

import javax.inject.Inject;
import java.util.LinkedHashMap;

public class RemoteBankContentsProcess
{
    private static final int INVENTORY_ITEM_WIDGETID = WidgetInfo.INVENTORY.getPackedId();
    private LinkedHashMap<Integer, Integer> items = new LinkedHashMap<>();

    @Inject
    private Client client;

    @Inject
    private ItemManager itemManager;

    @Inject
    private ChatMessageManager chatMessageManager;

    private RemoteBankContentsConfig config;

    @Inject
    RemoteBankContentsProcess(RemoteBankContentsConfig config, Client client)
    {
        this.config = config;
        this.client = client;
    }

    void populateBankItemMap()
    {
        ItemContainer bankInventory = client.getItemContainer(InventoryID.BANK);

        if (bankInventory == null)
        {
            return;
        }

        items.clear();

        for (Item s : bankInventory.getItems())
        {
            items.put(s.getId(), s.getQuantity());
        }

    }

    public String getName(int id)
    {
        return itemManager.getItemComposition(id).getName();
    }


    public int getQuantity(int id)
    {
        return items.get(id) != null ? items.get(id) : 0;
    }


    boolean initialised()
    {
        return items.size() > 0;
    }

    void outputExamine(MenuOptionClicked event)
    {

        int id = event.getId();
        final int widgetId = event.getWidgetId();


        if (!event.getMenuOption().equals("Examine"))
        {
            return;
        }

        if (widgetId == INVENTORY_ITEM_WIDGETID)
        {

            if (!initialised())
            {

                chatMessageManager.queue(QueuedMessage.builder()
                        .type(ChatMessageType.SERVER).runeLiteFormattedMessage("<col" + ChatColorType.HIGHLIGHT + ">" + "Please open your bank to initialise.").build());

            } else
            {
                int quantity = getQuantity(id);
                String name = getName(id);

                final ChatMessageBuilder message = new ChatMessageBuilder();


                /*TODO

                Refine message based on quantity and if this necessitates a plural.

                if (quantity == 1) {
                    message.append("<col" + ChatColorType.HIGHLIGHT + ">" + "You currently have " + quantity + " " + name + " in your bank.");
                } else {

                    //Add s to the end. Need to check if the item ends in S and if it does not add S
                    //and if the item ends in Y and add "ies". Also need to check exceptions to this rule.
                    message.append("<col" + ChatColorType.HIGHLIGHT + ">" + "You currently have " + quantity + " " + name + "s in your bank.");
                }
                */

                message.append("<col" + ChatColorType.HIGHLIGHT + ">" + "You currently have " + quantity + " " + name + " in your bank.");

                chatMessageManager.queue(QueuedMessage.builder()
                        .type(ChatMessageType.EXAMINE_ITEM).runeLiteFormattedMessage(message.build()).build());
            }
        }
    }
}

