package net.runelite.client.plugins.masterfarmer;

import java.awt.image.BufferedImage;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import javax.inject.Inject;
import com.google.common.eventbus.Subscribe;
import net.runelite.api.ItemID;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.Notifier;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

@PluginDescriptor(name = "Master Farmer")
public class MasterFarmerPlugin extends Plugin
{
	private static final int MOVE_TIMER_SECONDS = 280;

	@Inject
	private Notifier notifier;

	@Inject
	private ItemManager itemManager;

	@Inject
	private InfoBoxManager infoBoxManager;

	private BufferedImage seedIcon;
	private NPC farmer;
	private WorldPoint position;
	private Instant moveTime;

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (this.seedIcon == null)
		{
			this.seedIcon = itemManager.getImage(ItemID.RANARR_SEED);
		}

		if (farmer != null)
		{
			if (position == null || !position.equals(farmer.getWorldLocation()))
			{
				position = farmer.getWorldLocation();
				moveTime = Instant.now().plus(MOVE_TIMER_SECONDS, ChronoUnit.SECONDS);
				resetTimer();
			}
			else if (moveTime != null && position != null && position.equals(farmer.getWorldLocation()))
			{
				if (Instant.now().compareTo(moveTime) >= 0)
				{
					notifier.notify("You need to move to keep the master farmer in place");
					moveTime = null;
				}
			}
		}
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned event)
	{
		NPC spawned = event.getNpc();

		if (spawned.getId() == NpcID.MASTER_FARMER
				|| spawned.getId() == NpcID.MASTER_FARMER_3258)
		{
			farmer = spawned;
			moveTime = Instant.now().plus(MOVE_TIMER_SECONDS, ChronoUnit.SECONDS);;
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned event)
	{
		if (farmer == event.getNpc())
		{
			farmer = null;
			moveTime = null;
		}
	}

	private void resetTimer()
	{
		infoBoxManager.removeIf(e -> e instanceof MasterFarmerTimer);
		infoBoxManager.addInfoBox(new MasterFarmerTimer(this, seedIcon));
	}

}
