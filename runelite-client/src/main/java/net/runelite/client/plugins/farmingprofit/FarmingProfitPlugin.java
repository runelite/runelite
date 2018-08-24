package net.runelite.client.plugins.farmingprofit;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.AnimationID;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.SpriteID;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.AnimationChanged;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;

import javax.inject.Inject;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@PluginDescriptor(
        name = "Farming Profit",
        description = "Calculates the profit of a farm run",
        tags = {"farm", "farming", "profit"}
)

@Slf4j
public class FarmingProfitPlugin extends Plugin
{
    @Inject
    private Client client;

    @Inject
    private ClientToolbar clientToolbar;

    @Inject
    private ItemManager itemManager;

    @Inject
    private ChatMessageManager chatMessageManager;

    @Inject
    private SpriteManager spriteManager;

    private FarmingProfitPanel panel;
    private NavigationButton navButton;

    private final Set<Integer> harvestAnimations = new HashSet<>();

    private Item[] previousItems;
    private boolean harvesting;

    private FarmingProfitRun latestRun = null;

    private static int MAX_PATCH_DISTANCE = 8;

    @Override
    protected void startUp()
    {
        log.info("Starting Farming Profit Plugin");

        harvestAnimations.add(AnimationID.FARMING_HARVEST_BUSH);
        harvestAnimations.add(AnimationID.FARMING_HARVEST_FLOWER);
        harvestAnimations.add(AnimationID.FARMING_HARVEST_FRUIT_TREE);
        harvestAnimations.add(AnimationID.FARMING_HARVEST_HERB);

        previousItems = new Item[0];

        // Farming Profit Panel
        panel = new FarmingProfitPanel(itemManager);
        spriteManager.getSpriteAsync(SpriteID.SKILL_FARMING, 0, panel::loadHeaderIcon);

        final BufferedImage icon = ImageUtil.getResourceStreamFromClass(getClass(), "farming.png");

        navButton = NavigationButton.builder()
                .tooltip("Farming Profit")
                .icon(icon)
                .priority(5)
                .panel(panel)
                .build();

        clientToolbar.addNavigation(navButton);

    }

    @Override
    protected void shutDown() throws Exception
    {
        log.info("Shut down Farming Profit Plugin");
    }

    @Subscribe
    public void onAnimationChanged(final AnimationChanged event)
    {
        // Check for null actor
        if (event.getActor() == null)
        {
            return;
        }

        // Get animation ID
        int animationID = event.getActor().getAnimation();

        // Check whether the animation corresponds to the player
        if (event.getActor() != client.getLocalPlayer())
        {
            return;
        }

        log.debug("AnimID: " + animationID + " by: " + event.getActor().getName());

        // Check whether the player is harvesting
        if (isHarvestAnim(animationID))
        {
            // Player is harvesting, store current inventory
            previousItems = client.getItemContainer(InventoryID.INVENTORY).getItems();

        } else if (animationID == AnimationID.IDLE) {
            // Player idle, find new items
            Item[] currentItems = client.getItemContainer(InventoryID.INVENTORY).getItems();
            Item[] newItems = getItemContainerAddedItems(previousItems,
                    currentItems);

            if (newItems.length == 0)
            {
                return;
            }

            int productId = newItems[0].getId();
            int seedId = Seeds.seedOf(productId);
            int amount = newItems.length;
            WorldPoint harvestLocation = client.getLocalPlayer().getWorldLocation();

            if (latestRun == null)
            {
                if (seedId != -1)
                {
                    latestRun = new FarmingProfitRun(productId, seedId, amount, harvestLocation);
                    //TODO remove later
                    SwingUtilities.invokeLater(() -> panel.addRun(latestRun));
                }
            } else {
                // If harvest is same type
                if (latestRun.getProductId() == productId)
                {
                    int distance = harvestLocation.distanceTo(latestRun.getLatestHarvestWorldPoint());
                    // Check whether the patch is close to the latest run, check for the same patch
                    if (distance < MAX_PATCH_DISTANCE)
                    {
                        latestRun.addAmount(amount, harvestLocation);
                        //TODO remove later
                        SwingUtilities.invokeLater(() -> panel.addRun(latestRun));

                    // Harvesting other patch, add latest run and start new run
                    } else {
                        SwingUtilities.invokeLater(() -> panel.addRun(latestRun));
                        latestRun = new FarmingProfitRun(productId, seedId, amount, harvestLocation);
                    }
                // Harvesting other patch type, add latest run and start new run
                } else {
                    SwingUtilities.invokeLater(() -> panel.addRun(latestRun));
                    latestRun = new FarmingProfitRun(productId, seedId, amount, harvestLocation);
                }
            }

            previousItems = client.getItemContainer(InventoryID.INVENTORY).getItems();

            chatItems(newItems);

        }
    }

    private Item[] getItemContainerAddedItems(Item[] prev, Item[] next)
    {
        if (prev == null || prev.length == 0)
        {
            return next;
        }

        ArrayList<Item> prevList = new ArrayList<>(Arrays.asList(prev));
        ArrayList<Item> nextList = new ArrayList<>(Arrays.asList(next));

        for (Item item : prevList)
        {
            AtomicInteger index = new AtomicInteger(0);
            int itemId = item.getId();
            nextList.removeIf(p -> (p.getId() == itemId && index.getAndIncrement() < 1));
        }

        nextList.removeIf(item -> item.getQuantity() == 0);

        return nextList.toArray(new Item[nextList.size()]);
    }

    private boolean isHarvestAnim(int animId)
    {
        return (animId == AnimationID.FARMING_HARVEST_BUSH ||
                animId == AnimationID.FARMING_HARVEST_FLOWER ||
                animId == AnimationID.FARMING_HARVEST_FRUIT_TREE ||
                animId == AnimationID.FARMING_HARVEST_HERB);
    }

    private void chatHighlighted(String msg)
    {
        String chatMessage = new ChatMessageBuilder()
                .append(ChatColorType.HIGHLIGHT)
                .append(msg)
                .build();

        chatMessageManager
                .queue(QueuedMessage.builder()
                        .type(ChatMessageType.GAME)
                        .runeLiteFormattedMessage(chatMessage)
                        .build());
    }

    private void chatItems(Item[] items)
    {
        for (Item item : items)
        {
            if (item.getQuantity() > 0)
            {
                final ItemComposition itemComposition = itemManager.getItemComposition(item.getId());
                final int realItemId = itemComposition.getNote() != -1 ? itemComposition.getLinkedNoteId() : item.getId();
                final long price = (long)itemManager.getItemPrice(realItemId) * (long)item.getQuantity();

                String chatMessage = new ChatMessageBuilder()
                        .append(ChatColorType.HIGHLIGHT)
                        .append(item.getQuantity() + "x ")
                        .append(ChatColorType.NORMAL)
                        .append(itemComposition.getName() + " worth ")
                        .append(ChatColorType.HIGHLIGHT)
                        .append(Long.toString(price))
                        .append(ChatColorType.NORMAL)
                        .append(" gp")
                        .build();

                chatMessageManager
                        .queue(QueuedMessage.builder()
                                .type(ChatMessageType.GAME)
                                .runeLiteFormattedMessage(chatMessage)
                                .build());
            }
        }
    }

}
