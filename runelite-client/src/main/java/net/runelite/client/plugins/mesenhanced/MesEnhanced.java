package net.runelite.client.plugins.mesenhanced;

import com.google.common.collect.ImmutableSet;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.MenuEntry;
import net.runelite.api.MenuOpcode;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;

@PluginDescriptor(
	name = "Mes Enhanced",
	description = "1 Click MES Features -DO NOT ABUSE/AUTOCLICK THESE-",
	type = PluginType.UTILITY
)
public class MesEnhanced extends Plugin
{
	private static final int GOBLIN_SALUTE = 2128;
	private static final String LIGHT = "Light";
	private static final String QUICK_BONE = "Quick Bone";
	private static final Set<Integer> TINDER = ImmutableSet.of(ItemID.TINDERBOX, ItemID.GOLDEN_TINDERBOX);
	private static final Set<Integer> LIGHTABLE_LOGS = ImmutableSet.of(
		ItemID.LOGS, ItemID.ACHEY_TREE_LOGS, ItemID.OAK_LOGS,
		ItemID.WILLOW_LOGS, ItemID.TEAK_LOGS, ItemID.ARCTIC_PINE_LOGS, ItemID.MAPLE_LOGS,
		ItemID.MAHOGANY_LOGS, ItemID.YEW_LOGS, ItemID.MAGIC_LOGS, ItemID.REDWOOD_LOGS
	);
	private static final Set<Integer> BONES = ImmutableSet.of(
		ItemID.BONES, ItemID.BIG_BONES, ItemID.JOGRE_BONES, ItemID.ZOGRE_BONES,
		ItemID.BABYDRAGON_BONES, ItemID.WYRM_BONES, ItemID.DRAGON_BONES,
		ItemID.WYVERN_BONES, ItemID.DRAKE_BONES, ItemID.LAVA_DRAGON_BONES,
		ItemID.FAYRG_BONES, ItemID.RAURG_BONES, ItemID.HYDRA_BONES,
		ItemID.DAGANNOTH_BONES, ItemID.OURG_BONES, ItemID.SUPERIOR_DRAGON_BONES
	);

	@Inject
	private Client client;
	@Inject
	private EventBus eventBus;
	private boolean tinder;
	private boolean bones;
	private boolean tick;
	private int tinderIdx;
	private int tinderId;
	private int bonesIdx;
	private int bonesId;

	@Override
	public void startUp()
	{
		eventBus.subscribe(ItemContainerChanged.class, this, this::onItemContainerChanged);
		eventBus.subscribe(MenuEntryAdded.class, this, this::onMenuEntryAdded);
		eventBus.subscribe(MenuOptionClicked.class, this, this::onMenuOptionClicked);
		eventBus.subscribe(AnimationChanged.class, this, this::onAnimationChanged);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
	}

	@Override
	public void shutDown()
	{
		eventBus.unregister(this);
	}

	private void onGameTick(GameTick event)
	{
		if (tick)
		{
			tick = false;
		}
	}

	private void onAnimationChanged(AnimationChanged event)
	{
		if (event.getActor() != client.getLocalPlayer() || event.getActor().getAnimation() != 3705 || !bones)
		{
			return;
		}

		event.getActor().setActionFrame(0);
		event.getActor().setAnimation(GOBLIN_SALUTE);
	}

	private void onMenuEntryAdded(MenuEntryAdded event)
	{
		final int id = event.getIdentifier();

		if (tinder && event.getType() == MenuOpcode.ITEM_USE.getId() && LIGHTABLE_LOGS.contains(id))
		{
			event.getMenuEntry().setOption(LIGHT);
			event.setWasModified(true);
		}
		else if (bones && event.getType() == MenuOpcode.GAME_OBJECT_FIRST_OPTION.getId() && event.getTarget().toLowerCase().contains("altar"))
		{
			event.getMenuEntry().setOption(QUICK_BONE);
			event.setWasModified(true);
		}
	}

	private void onMenuOptionClicked(MenuOptionClicked event)
	{
		final MenuEntry entry = event.getMenuEntry();

		if (tinder && event.getOpcode() == MenuOpcode.ITEM_USE.getId() && event.getOption().equals(LIGHT))
		{
			entry.setOpcode(MenuOpcode.ITEM_USE_ON_WIDGET_ITEM.getId());
			client.setSelectedItemWidget(WidgetInfo.INVENTORY.getId());
			client.setSelectedItemSlot(tinderIdx);
			client.setSelectedItemID(tinderId);
		}
		else if (bones && event.getOption().equals(QUICK_BONE) && tick)
		{
			event.consume();
		}
		else if (bones && event.getOpcode() == MenuOpcode.GAME_OBJECT_FIRST_OPTION.getId() && event.getOption().equals(QUICK_BONE))
		{
			entry.setOpcode(MenuOpcode.ITEM_USE_ON_GAME_OBJECT.getId());
			client.setSelectedItemWidget(WidgetInfo.INVENTORY.getId());
			client.setSelectedItemSlot(bonesIdx);
			client.setSelectedItemID(bonesId);
			tick = true;
		}
	}

	private void onItemContainerChanged(ItemContainerChanged event)
	{
		final ItemContainer itemContainer = event.getItemContainer();
		final List<Item> items = Arrays.asList(itemContainer.getItems());

		if (itemContainer != client.getItemContainer(InventoryID.INVENTORY) ||
			(!Collections.disjoint(items, BONES) && !Collections.disjoint(items, LIGHTABLE_LOGS)))
		{
			return;
		}

		tinderIdx = -1;
		tinderId = -1;
		bonesIdx = -1;
		bonesId = -1;
		tinder = false;
		bones = false;

		for (int i = 0; i < items.size(); i++)
		{
			final int itemId = items.get(i).getId();

			if (TINDER.contains(itemId))
			{
				tinderIdx = i;
				tinderId = itemId;
				tinder = true;
			}
			else if (BONES.contains(itemId))
			{
				bonesIdx = i;
				bonesId = itemId;
				bones = true;
				break;
			}
		}
	}
}