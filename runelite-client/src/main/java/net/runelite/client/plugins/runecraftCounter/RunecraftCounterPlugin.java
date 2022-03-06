package net.runelite.client.plugins.runecraftCounter;

import com.google.common.collect.ImmutableSet;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.Item;
import net.runelite.api.ItemID;
import net.runelite.api.Skill;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.StatChanged;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@PluginDescriptor(
        name = "RunecraftCounter",
        description = "Show runes crafted this session",
        tags = {"rifts", "rc", "runecrafting"}
)
public class RunecraftCounterPlugin extends Plugin
{
    private static final Set<Integer> RUNE_TYPES = ImmutableSet.of(ItemID.FIRE_RUNE, ItemID.WATER_RUNE,
            ItemID.AIR_RUNE, ItemID.EARTH_RUNE, ItemID.MIND_RUNE, ItemID.BODY_RUNE, ItemID.DEATH_RUNE,
            ItemID.NATURE_RUNE, ItemID.CHAOS_RUNE, ItemID.LAW_RUNE, ItemID.COSMIC_RUNE, ItemID.BLOOD_RUNE,
            ItemID.SOUL_RUNE, ItemID.ASTRAL_RUNE, ItemID.WRATH_RUNE);
    private static String RUNECRAFTING = "Runecraft";
    private boolean isRuneCrafting = false;

    @Inject
    private RunecraftCounterSession session;
    private HashMap<Integer, Integer> inventorySnapshot;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private RunecraftCounterOverlay overlay;

    @Inject
    private Client client;

    @Override
    protected void startUp()
    {
        overlayManager.add(overlay);
        isRuneCrafting = false;
    }

    @Override
    protected void shutDown()
    {
        overlayManager.remove(overlay);
        session.reset();
    }

    @Subscribe
    public void onItemContainerChanged(ItemContainerChanged event)
    {
        Item[] items = event.getItemContainer().getItems();

        // Build set of current inventory
        HashMap<Integer, Integer> currentInventory = new HashMap<>();
        Arrays.stream(items)
                .filter(item -> RUNE_TYPES.contains(item.getId()))
                .forEach(item -> currentInventory.put(item.getId(), item.getQuantity()));

        if(inventorySnapshot == null)
        {
            inventorySnapshot = new HashMap<>();
            inventorySnapshot = currentInventory;
            isRuneCrafting = false;

            return;
        }

        // Update session with difference between previous and current inventory
        if(isRuneCrafting)
        {
            for(Map.Entry<Integer, Integer> entry : currentInventory.entrySet())
            {
                if(inventorySnapshot.containsKey(entry.getKey()))
                {
                    int delta = entry.getValue() - inventorySnapshot.get(entry.getKey());
                    session.incrementRunesCrafted(entry.getKey(), delta);
                }
                else
                {
                    session.incrementRunesCrafted(entry.getKey(), entry.getValue());
                }
            }
        }

        inventorySnapshot = currentInventory;
        isRuneCrafting = false;
    }

    @Subscribe
    public void onStatChanged(StatChanged statChanged)
    {
        Skill skill = statChanged.getSkill();

        if(skill.getName().equals(RUNECRAFTING))
        {
            isRuneCrafting = true;
        }
    }
}