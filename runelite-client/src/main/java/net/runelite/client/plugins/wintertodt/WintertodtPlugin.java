/*
 * Copyright (c) 2018, terminatusx <jbfleischman@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.wintertodt;


import java.awt.Color;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import javax.inject.Inject;
import lombok.Getter;
import static net.runelite.api.AnimationID.CONSTRUCTION;
import static net.runelite.api.AnimationID.FIREMAKING;
import static net.runelite.api.AnimationID.FLETCHING_BOW_CUTTING;
import static net.runelite.api.AnimationID.LOOKING_INTO;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemContainer;
import static net.runelite.api.ItemID.BRUMA_KINDLING;
import static net.runelite.api.ItemID.BRUMA_ROOT;
import static net.runelite.api.ItemID.COINS_995;
import static net.runelite.api.ItemID.SUPPLY_CRATE;
import net.runelite.api.MessageNode;
import net.runelite.api.Player;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.SetMessage;
import net.runelite.client.Notifier;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.woodcutting.Axe;
import net.runelite.client.plugins.xptracker.XpTrackerPlugin;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.StackFormatter;
import net.runelite.http.api.item.ItemPrice;


@AllArgsConstructor
@Getter
enum WintertodtInterruptType
{
    COLD("Damaged by Wintertodt Cold"),
    SNOWFALL("Damaged by Wintertodt Snowfall"),
    BRAZIER("Brazier Shattered"),
    INVENTORY_FULL("Inventory full of Bruma Roots"),
    OUT_OF_ROOTS("Out of Bruma Roots"),
    FIXED_BRAZIER("Fixed Brazier"),
    LIT_BRAZIER("Lit Brazier");

    private final String interruptSourceString;
}

@AllArgsConstructor
@Getter
enum WintertodtActivity
{
    IDLE("IDLE"),
    WOODCUTTING("Woodcutting"),
    FLETCHING("Fletching"),
    FEEDING_BRAZIER("Feeding"),
    FIXING_BRAZIER("Fixing"),
    LIGHTING_BRAZIER("Lighting");

    private final String actionString;
}

@PluginDescriptor(
        name = "Wintertodt",
        description = "Wintertodt description here",
        tags = {"wintertodt"}
)

@PluginDependency(XpTrackerPlugin.class)
@Slf4j
public class WintertodtPlugin extends Plugin
{
    @Inject
    private Notifier notifier;

    @Inject
    private Client client;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private WintertodtOverlay overlay;

    @Inject
    private WintertodtConfig config;

    @Inject
    private ItemManager itemManager;

    @Inject
    private ChatMessageManager chatMessageManager;

    @Getter
    private WintertodtActivity currentActivity = WintertodtActivity.IDLE;

    @Getter
    private Axe axe;

    @Getter
    private int inventoryScore = 0;

    @Getter
    private int totalPotentialinventoryScore = 0;

    @Getter
    private int numLogs = 0;

    @Getter
    private int numKindling = 0;

    @Getter
    private Instant lastActionTime;

    @Getter
    private boolean wintertodtActionInProgress = false;

    protected static final int WINTERTODT_REGION = 6462;
    private boolean lastInWintertodt = false;
    private int numSupplyCrates = 0;
    private int lastNumSupplyCrates = 0;
    private Item[] lastInventory;

    @Provides
    WintertodtConfig getConfig(ConfigManager configManager)
    {
        return configManager.getConfig(WintertodtConfig.class);
    }

    @Override
    protected void startUp() throws Exception
    {
        overlayManager.add(overlay);
    }

    @Override
    protected void shutDown() throws Exception
    {
        overlayManager.remove(overlay);
        Reset();
    }

    private void Reset()
    {
        axe = null;
        inventoryScore = 0;
        totalPotentialinventoryScore = 0;
        numLogs = 0;
        numKindling = 0;
        wintertodtActionInProgress = false;
        currentActivity = WintertodtActivity.IDLE;
    }


    private boolean isInWintertodt()
    {
        if(client != null && client.getLocalPlayer() != null)
        {
            return client.getLocalPlayer().getWorldLocation().getRegionID() == WINTERTODT_REGION;
        }

        return false;
    }


    @Subscribe
    public void onGameTick(GameTick gameTick)
    {
        if(!isInWintertodt())
        {
            if(lastInWintertodt)
            {
                Reset();
            }

            lastInWintertodt = false;
            return;
        }

        lastInWintertodt = true;

        if (wintertodtActionInProgress)
        {
            return;
        }

        CheckActionTimeout();
    }

    private void CheckActionTimeout()
    {
        if(currentActivity != WintertodtActivity.IDLE)
        {
            Duration actionTimeout = Duration.ofSeconds(1);
            Duration sinceAction = Duration.between(lastActionTime, Instant.now());

            if (sinceAction.compareTo(actionTimeout) >= 0)
            {
                wintertodtActionInProgress = false;
                currentActivity = WintertodtActivity.IDLE;
            }
        }
    }

    @Subscribe
    public void onSetMessage(SetMessage setMessage)
    {
        if(!isInWintertodt())
        {
            return;
        }

        MessageNode messageNode = setMessage.getMessageNode();
        ChatMessageType chatMessageType = setMessage.getType();
        WintertodtInterruptType interruptType = null;

        //you fix the brazier
        //you repair the brazier
        if (chatMessageType == ChatMessageType.FILTERED || chatMessageType == ChatMessageType.SERVER)
        {
            if (messageNode.getValue().startsWith("The cold of"))
            {
                interruptType = WintertodtInterruptType.COLD;
            }
            else if(messageNode.getValue().startsWith("The freezing cold attack"))
            {
                interruptType = WintertodtInterruptType.SNOWFALL;
            }
            else if(messageNode.getValue().startsWith("The brazier is broken and shrapnel"))
            {
                interruptType = WintertodtInterruptType.BRAZIER;
            }
            else if(messageNode.getValue().startsWith("You have run out of bruma roots"))
            {
                interruptType = WintertodtInterruptType.OUT_OF_ROOTS;
            }
            else if(messageNode.getValue().startsWith("Your inventory is too full"))
            {
                interruptType = WintertodtInterruptType.INVENTORY_FULL;
            }
            else if(messageNode.getValue().startsWith("You fix the brazier"))
            {
                interruptType = WintertodtInterruptType.FIXED_BRAZIER;
            }
            else if(messageNode.getValue().startsWith("You light the brazier"))
            {
                interruptType = WintertodtInterruptType.LIT_BRAZIER;
            }
            else if(messageNode.getValue().startsWith("You carefully fletch the root into a bundle of kindling"))
            {
                wintertodtActionInProgress = true;
                currentActivity = WintertodtActivity.FLETCHING;
            }

            boolean shouldNotify = false;
            boolean wasInterrupted = false;
            boolean wasDamaged = false;
            boolean neverNotify = false;

            if(interruptType != null)
            {
                switch(interruptType)
                {
                    case COLD:
                    case BRAZIER:
                    case SNOWFALL:
                        wasDamaged = true;
                        messageNode.setRuneLiteFormatMessage(wrapTextWithColour(messageNode.getValue(),config.damageNotificationColor()));
                        chatMessageManager.update(messageNode);
                        client.refreshChat();

                        if(currentActivity != WintertodtActivity.WOODCUTTING)
                        {
                            wasInterrupted = true;
                        }

                        break;
                    case INVENTORY_FULL:
                    case OUT_OF_ROOTS:
                        wasInterrupted = true;
                        break;
                    case LIT_BRAZIER:
                    case FIXED_BRAZIER:
                        wasInterrupted = true;
                        neverNotify = true;
                        break;
                }

                if(!neverNotify)
                {
                    switch (config.notifyCondition())
                    {
                        case ONLY_WHEN_INTERRUPTED:
                            if (wasInterrupted)
                            {
                                shouldNotify = true;
                            }
                            break;
                        case WHEN_DAMAGED:
                            if (wasDamaged)
                            {
                                shouldNotify = true;
                            }
                            break;
                        case EITHER:
                            shouldNotify = true;
                            break;
                    }
                }

                ActivityInterrupted(interruptType, shouldNotify, wasInterrupted);
            }
        }
    }

    private static String wrapTextWithColour(String text, Color colour)
    {
        return "<col=" + Integer.toHexString(colour.getRGB() & 0xFFFFFF) + ">" + text + "</col>";
    }

    private void ActivityInterrupted(WintertodtInterruptType interruptType, boolean shouldNotify, boolean wasActivityInterrupted)
    {
        if(shouldNotify)
        {
            final StringBuilder str = new StringBuilder();

            if(wasActivityInterrupted)
            {
                str.append(currentActivity.getActionString());
                str.append(" interrupted! ");
            }

            str.append(interruptType.getInterruptSourceString());
            notifier.notify(str.toString());
        }

        if(wasActivityInterrupted)
        {
            wintertodtActionInProgress = false;
            currentActivity = WintertodtActivity.IDLE;
            lastActionTime = Instant.now();
        }
    }

    @Subscribe
    public void onAnimationChanged(final AnimationChanged event)
    {
        if(!isInWintertodt())
        {
            return;
        }

        final Player local = client.getLocalPlayer();

        if (event.getActor() != local)
        {
            return;
        }

        final int animId = local.getAnimation();
        Axe axe = Axe.findAxeByAnimId(animId);
        wintertodtActionInProgress = false;

        if (axe != null)
        {
            this.axe = axe;
            wintertodtActionInProgress = true;
            currentActivity = WintertodtActivity.WOODCUTTING;
        }
        else if(animId == FLETCHING_BOW_CUTTING)
        {
            wintertodtActionInProgress = true;
            currentActivity = WintertodtActivity.FLETCHING;
        }
        else if(animId == LOOKING_INTO)
        {
            wintertodtActionInProgress = true;
            currentActivity = WintertodtActivity.FEEDING_BRAZIER;
        }
        else if(animId == FIREMAKING)
        {
            wintertodtActionInProgress = true;
            currentActivity = WintertodtActivity.LIGHTING_BRAZIER;
        }
        else if(animId == CONSTRUCTION)
        {
            wintertodtActionInProgress = true;
            currentActivity = WintertodtActivity.FIXING_BRAZIER;
        }

        if(!wintertodtActionInProgress)
        {
            if(currentActivity == WintertodtActivity.FEEDING_BRAZIER)
            {
                lastActionTime = Instant.now();
            }
            else
            {
                currentActivity = WintertodtActivity.IDLE;
            }
        }
    }

    @Subscribe
    public void itemContainerChanged(ItemContainerChanged event)
    {
        final ItemContainer container = event.getItemContainer();

        if (container == client.getItemContainer(InventoryID.INVENTORY))
        {

            final Item[] inv = container.getItems();


            //If we're currently fletching but there are no more logs, go ahead and abort fletching immediately
            if(numLogs == 0 && currentActivity == WintertodtActivity.FLETCHING)
            {
                wintertodtActionInProgress = false;
                currentActivity = WintertodtActivity.IDLE;
            }
            //Otherwise, if we're currently feeding the brazier but we've run out of both logs and kindling, abort the feeding activity
            else if(numLogs == 0 && numKindling == 0 && currentActivity == WintertodtActivity.FEEDING_BRAZIER)
            {
                wintertodtActionInProgress = false;
                currentActivity = WintertodtActivity.IDLE;
            }

            UpdateInventoryScoreAndCrates(inv);

            //If our current supply crate count is one lower than previous, we may have just opened a crate
            //note: this also triggers if the crate was banked. the Calculate function should be able to determine if new items were given from this transaction
            if(numSupplyCrates == lastNumSupplyCrates - 1)
            {
                CalculateSupplyCrateCost(inv, lastInventory);
            }

            lastInventory = inv;
            lastNumSupplyCrates = numSupplyCrates;
        }
    }

    private void UpdateInventoryScoreAndCrates(Item[] invItems)
    {
        numSupplyCrates = 0;
        inventoryScore = 0;
        totalPotentialinventoryScore = 0;
        numLogs = 0;
        numKindling = 0;

        for (Item item : invItems)
        {
            //We only care about score items while in Wintertodt
            if(isInWintertodt())
            {
                inventoryScore += getPoints(item.getId());
                totalPotentialinventoryScore += getPotentialPoints(item.getId());

                if(item.getId() == BRUMA_ROOT)
                {
                    numLogs++;
                }

                if(item.getId() == BRUMA_KINDLING)
                {
                    numKindling++;
                }
            }

            //Always keep track of supply crates because people can open them outside of Wintertodt
            if(item.getId() == SUPPLY_CRATE)
            {
                numSupplyCrates++;
            }
        }
    }

    private void CalculateSupplyCrateCost(Item[] newInv, Item[] oldInv)
    {
        long cratePrice = 0;
        List<Item> crateItems = new ArrayList<>();
        List<Integer> crateItemQuantity = new ArrayList<>();

        for(int index=0; index < newInv.length; index++)
        {
            final Item invItem = newInv[index];
            if(index >= oldInv.length)
            {
                crateItems.add(invItem);
                crateItemQuantity.add(invItem.getQuantity());
                continue;
            }

            if(invItem.getId() != oldInv[index].getId() )
            {
                crateItems.add(invItem);
                crateItemQuantity.add(invItem.getQuantity());
            }
            //same id, might have increased stack count of an item already in inventory
            else
            {
                int quantityDifference = invItem.getQuantity() - oldInv[index].getQuantity();
                if(quantityDifference > 0)
                {
                    crateItems.add(invItem);
                    crateItemQuantity.add(quantityDifference);
                }
            }
        }

        if(crateItems.size() > 0)
        {
            for(int index = 0; index < crateItems.size(); index++)
            {
                final Item i = crateItems.get(index);
                final Integer quantity = crateItemQuantity.get(index);
                final int itemId = i.getId();
                final ItemComposition itemComposition = itemManager.getItemComposition(itemId);
                final int realItemId = itemComposition.getNote() != -1 ? itemComposition.getLinkedNoteId() : itemId;

                if(i.getId() == COINS_995)
                {
                    cratePrice += quantity;
                    continue;
                }

                ItemPrice itemPrice = itemManager.getItemPrice(realItemId);
                if(itemPrice != null)
                {
                    long itemStack = (long) itemPrice.getPrice() * (long) quantity;
                    cratePrice += itemStack;
                }
            }

            final ChatMessageBuilder message = new ChatMessageBuilder()
                    .append(ChatColorType.HIGHLIGHT)
                    .append("Your crate is worth around ")
                    .append(StackFormatter.formatNumber(cratePrice))
                    .append(" coins.")
                    .append(ChatColorType.NORMAL);

            chatMessageManager.queue(QueuedMessage.builder()
                    .type(ChatMessageType.EXAMINE_ITEM)
                    .runeLiteFormattedMessage(message.build())
                    .build());
        }
    }

    private int getPoints(int id)
    {
        switch (id)
        {
            case BRUMA_ROOT:
                return 10;
            case BRUMA_KINDLING:
                return 25;
            default:
                return 0;
        }
    }

    private int getPotentialPoints(int id)
    {
        if(id == BRUMA_ROOT || id == BRUMA_KINDLING)
        {
            return 25;
        }

        return 0;
    }
}