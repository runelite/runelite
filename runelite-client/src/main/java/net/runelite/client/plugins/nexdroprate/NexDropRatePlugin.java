package net.runelite.client.plugins.nexdroprate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.PlayerDespawned;
import net.runelite.api.events.PlayerSpawned;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Nex Drop Rate",
	description = "Tracks average drop rates from Nex",
	tags = {"combat", "droprate", "tracking"}
)

public class NexDropRatePlugin extends Plugin
{
	@Inject
	private Client client;
	private int[] damageRatio;
	private final int[] NEX_ID = {
		NpcID.NEX,
		NpcID.NEX_11279,
		NpcID.NEX_11280,
		NpcID.NEX_11281,
		NpcID.NEX_11282
	};
	private List<Double> dropRates;
	private List<String> playerCount;
	private double averageDropRate;

	private double dropRate()
	{
		return 43 * playerCount.size() * damageRatio();
	}

	private double damageRatio()
	{
		return damageRatio[1] == 0 ? 0 : (double) damageRatio[0] / damageRatio[1];
	}

	@Subscribe
	public void onHitsplatApplied(HitsplatApplied event)
	{
		if (event.getActor() instanceof NPC)
		{
			int nex = ((NPC) event.getActor()).getComposition().getId();
			// Compare NPC ID directly
			if (IntStream.of(NEX_ID).anyMatch(id -> id == nex))
			{
				int damage = event.getHitsplat().getAmount();
				damageRatio[1] += damage;
				if (event.getHitsplat().isMine())
				{
					damageRatio[0] += damage;
				}
			}
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned event)
	{
		int nex = event.getNpc().getComposition().getId();
		// Compare NPC ID directly
		if (IntStream.of(NEX_ID).anyMatch(id -> id == nex))
		{
			double dropRate = dropRate() == 0 ? 0 : 100 / dropRate();
			dropRates.add(dropRate);
			averageDropRate =
				dropRates.stream().mapToDouble(Double::doubleValue).sum() / dropRates.size();
			damageRatio = new int[2]; // Reset for next kill
		}
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned event)
	{
		int nex = event.getNpc().getComposition().getId();
		// Compare NPC ID directly
		if (IntStream.of(NEX_ID).anyMatch(id -> id == nex))
		{
			damageRatio = new int[2]; // Reset damage ratio when Nex spawns
		}
	}

	@Subscribe
	public void onPlayerSpawned(PlayerSpawned event)
	{
		playerCount.add(event.getPlayer().getName());
	}

	@Subscribe
	public void onPlayerDespawned(PlayerDespawned event)
	{
		playerCount.remove(event.getPlayer().getName());
	}

	@Override
	protected void startUp() throws Exception
	{
		this.damageRatio = new int[2];
		this.dropRates = new ArrayList<>();
		this.playerCount = new ArrayList<>();
		this.averageDropRate = 0;
	}
}
