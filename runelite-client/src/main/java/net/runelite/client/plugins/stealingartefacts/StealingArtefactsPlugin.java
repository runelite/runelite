package net.runelite.client.plugins.stealingartefacts;

import com.google.common.collect.ImmutableSet;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.*;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.stream.Stream;

@PluginDescriptor(
		name = "Stealing Artefacts",
		description = "Show the location and status of your stealing artefact task.",
		tags = {"thieving"},
		enabledByDefault = false
)
public class StealingArtefactsPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private StealingArtefactsOverlay overlay;

	@Getter(AccessLevel.PACKAGE)
	private StealingArtefactState stealingArtefactState;

	@Getter(AccessLevel.PACKAGE)
	private boolean isInPortPiscariliusRegion;

	private static final ImmutableSet<Integer> PORT_PISCARILIUS_REGIONS = ImmutableSet.of(6970, 7226);

	private static final ImmutableSet<Integer> ARTEFACT_ITEM_IDS = ImmutableSet.of(ItemID.STOLEN_PENDANT,
			ItemID.STOLEN_GARNET_RING, ItemID.STOLEN_CIRCLET, ItemID.STOLEN_FAMILY_HEIRLOOM, ItemID.STOLEN_JEWELRY_BOX);

	private NPC captainKhaled;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);

		if (client.getGameState() == GameState.LOGGED_IN)
		{
			clientThread.invoke(() ->
					stealingArtefactState = StealingArtefactState.getStealingArtefactState(client.getVar(Varbits.STEALING_ARTEFACT_STATE)));
		}
		else
		{
			stealingArtefactState = null;
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		client.clearHintArrow();
		overlayManager.remove(overlay);
	}



	private boolean hasArtefact()
	{
		ItemContainer inventory = client.getItemContainer(InventoryID.INVENTORY);

		if (inventory != null)
		{
			final Stream<Item> items = Arrays.stream(inventory.getItems());
			return items.anyMatch(item -> ARTEFACT_ITEM_IDS.contains(item.getId()));
		}

		return false;
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		int stealingArtefactStateVarbit = client.getVar(Varbits.STEALING_ARTEFACT_STATE);
		StealingArtefactState state = StealingArtefactState.getStealingArtefactState(stealingArtefactStateVarbit);

		if (state != StealingArtefactState.DELIVER_ARTEFACT) {

			stealingArtefactState = state;

			if (state != StealingArtefactState.NO_TASK && state != StealingArtefactState.FAILURE) {
				client.setHintArrow(stealingArtefactState.getWorldPoint());
			} else {
				client.clearHintArrow();
			}

		} else {
			client.setHintArrow(captainKhaled);
		}

	}

	@Subscribe
	public void onItemContainerChanged(final ItemContainerChanged event)
	{
		if (event.getItemContainer() == client.getItemContainer(InventoryID.INVENTORY))
		{
			if (hasArtefact())
			{
				stealingArtefactState = StealingArtefactState.DELIVER_ARTEFACT;
			}
			else if (stealingArtefactState == StealingArtefactState.DELIVER_ARTEFACT)
			{
				stealingArtefactState = StealingArtefactState.FAILURE;
			}
		}
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned event)
	{
		if (event.getNpc().getId() == NpcID.CAPTAIN_KHALED)
		{
			captainKhaled = event.getNpc();
		}
	}

	@Subscribe
	public void onGameTick(GameTick tick)
	{
		Player player = client.getLocalPlayer();
		if (player != null)
		{
			isInPortPiscariliusRegion = PORT_PISCARILIUS_REGIONS.contains(player.getWorldLocation().getRegionID());
		}
	}
}
