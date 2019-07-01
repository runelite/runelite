package net.runelite.client.plugins.theatre.rooms;

import com.google.common.collect.ImmutableSet;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GraphicsObject;
import net.runelite.api.NPC;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.SpotAnimationChanged;
import net.runelite.client.graphics.ModelOutlineRenderer;
import net.runelite.client.plugins.theatre.RoomHandler;
import net.runelite.client.plugins.theatre.TheatreConfig;
import net.runelite.client.plugins.theatre.TheatreConstant;
import net.runelite.client.plugins.theatre.TheatrePlugin;
import net.runelite.client.plugins.theatre.TheatreRoom;
import net.runelite.client.util.Text;

@Slf4j
public class MaidenHandler extends RoomHandler
{
	private static final ImmutableSet<WorldPoint> N1 = ImmutableSet.of(
		new WorldPoint(3182, 4457, 0),
		new WorldPoint(3174, 4457, 0)
	);
	private static final ImmutableSet<WorldPoint> N2 = ImmutableSet.of(
		new WorldPoint(3178, 4457, 0),
		new WorldPoint(3186, 4455, 0),
		new WorldPoint(3186, 4457, 0)
	);
	private static final ImmutableSet<WorldPoint> S1 = ImmutableSet.of(
		new WorldPoint(3174, 4437, 0),
		new WorldPoint(3182, 4437, 0)
	);
	private static final ImmutableSet<WorldPoint> S2 = ImmutableSet.of(
		new WorldPoint(3186, 4439, 0),
		new WorldPoint(3186, 4437, 0),
		new WorldPoint(3178, 4437, 0)
	);
	private static final ImmutableSet<Integer> FREEZEANIMS = ImmutableSet.of(
		361,
		363,
		367,
		369
	);
	private static final Color TRANSPARENT = new Color(0, 0, 0, 0);
	private static final Color FREEZE = new Color(0, 226, 255, 255);
	private List<WorldPoint> bloodThrows = new ArrayList<>();
	private List<NPC> bloodSpawns = new ArrayList<>();
	private List<WorldPoint> bloodSpawnLocation = new ArrayList<>();
	private List<WorldPoint> bloodSpawnTarget = new ArrayList<>();
	private NPC maiden;
	private String nyloCall = "n1";
	private Set<Nylos> nylos = new HashSet<>();
	private List<NPC> healers = new ArrayList<>();
	private int healerCount = 0;
	private int wave = 1;
	private long startTime = 0;
	private ModelOutlineRenderer modelOutline;

	public MaidenHandler(Client client, TheatrePlugin plugin, TheatreConfig config, ModelOutlineRenderer modelOutline)
	{
		super(client, plugin, config);
		this.modelOutline = modelOutline;
	}

	@Override
	public void onStart()
	{
		if (this.plugin.getRoom() == TheatreRoom.MAIDEN)
		{
			return;
		}
		this.reset();
		this.plugin.setRoom(TheatreRoom.MAIDEN);
		this.startTime = System.currentTimeMillis();
		log.debug("Starting Maiden Room");
	}

	@Override
	public void onStop()
	{
		this.reset();
		this.plugin.setRoom(TheatreRoom.UNKNOWN);
		log.debug("Stopping Maiden Room");
	}

	public void reset()
	{
		this.bloodThrows.clear();
		this.bloodSpawns.clear();
		this.bloodSpawnLocation.clear();
		this.bloodSpawnTarget.clear();
		this.healers.clear();
		this.healerCount = 0;
		this.startTime = -1;
		this.wave = 1;
	}

	public void render(Graphics2D graphics)
	{
		for (Nylos nylo : nylos)
		{
			if (nylo.getNpc() == null || nylo.getNpc().getId() == -1)
			{
				continue;
			}

			final String location = nylo.getSpawnLocation().getName();

			if (location.equals(nyloCall))
			{
				Color color = Color.WHITE;
				int width = 4;

				if (nylo.getNpc().getWorldArea().distanceTo(maiden.getWorldArea()) <= 3)
				{
					color = FREEZE;
					width = 8;
				}

				modelOutline.drawOutline(nylo.getNpc(), width, color, TRANSPARENT);
			}
		}

		if (config.showMaidenBloodToss())
		{
			for (WorldPoint point : bloodThrows)
			{
				drawTile(graphics, point, new Color(36, 248, 229), 2, 150, 10);
			}
		}

		if (config.showMaidenBloodSpawns())
		{
			for (WorldPoint point : bloodSpawnLocation)
			{
				drawTile(graphics, point, new Color(36, 248, 229), 2, 180, 20);
			}

			for (WorldPoint point : bloodSpawnTarget)
			{
				drawTile(graphics, point, new Color(36, 248, 229), 1, 120, 10);
			}
		}
	}

	public void onSpotAnimationChanged(SpotAnimationChanged event)
	{
		if (event.getActor() instanceof NPC)
		{
			NPC npc = (NPC) event.getActor();

			if (npc.getId() != 8366)
			{
				return;
			}

			int anim = npc.getSpotAnimation();

			if (FREEZEANIMS.contains(anim))
			{
				nylos.removeIf(c -> c.getNpc() == npc);
			}
		}
	}

	public void onNpcSpawned(NpcSpawned event)
	{
		NPC npc = event.getNpc();

		if (npc.getName() == null)
		{
			return;
		}

		switch (npc.getName())
		{
			case "The Maiden of Sugadinti":
				this.onStart();
				maiden = npc;
				break;
			case "Nylocas Matomenos":
				if (!config.showNyloFreezeHighlights())
				{
					return;
				}

				this.healers.add(npc);

				WorldPoint wp = WorldPoint.fromLocalInstance(client, npc.getLocalLocation());

				if (N1.contains(wp))
				{
					addNylo(npc, Nylos.SpawnLocation.N1);
				}
				if (N2.contains(wp))
				{
					addNylo(npc, Nylos.SpawnLocation.N2);
				}
				if (S1.contains(wp))
				{
					addNylo(npc, Nylos.SpawnLocation.S1);
				}
				if (S2.contains(wp))
				{
					addNylo(npc, Nylos.SpawnLocation.S2);
				}
				if (!N1.contains(wp) && !N2.contains(wp) && !S1.contains(wp) && !S2.contains(wp))
				{
					log.debug("------------------------");
					log.debug("No World Points Matched");
					log.debug("Dumping Location");
					log.debug("Instance Loc: " + wp);
					log.debug("------------------------");
				}
				break;
			case "Blood spawn":
				if (!bloodSpawns.contains(npc))
				{
					bloodSpawns.add(npc);
				}
				break;
		}
	}

	public void onChatMessage(ChatMessage event)
	{
		if (event.getSender() != null && !event.getSender().equals(client.getLocalPlayer().getName()))
		{
			return;
		}

		String msg = Text.standardize(event.getMessageNode().getValue());

		switch (msg)
		{
			case "n1":
			case "n2":
			case "s1":
			case "s2":
				nyloCall = msg;
				break;
		}
	}

	public void onNpcDespawned(NpcDespawned event)
	{
		NPC npc = event.getNpc();

		if (npc.getName() == null)
		{
			return;
		}

		switch (npc.getName())
		{
			case "The Maiden of Sugadinti":
				this.onStop();
				break;
			case "Blood Spawn":
				bloodSpawns.remove(npc);
				break;
		}
	}

	public void onGameTick()
	{
		if (plugin.getRoom() != TheatreRoom.MAIDEN)
		{
			return;
		}

		if (!nylos.isEmpty())
		{
			for (Nylos nylo : nylos)
			{
				nylos.removeIf(c -> c.getNpc().getId() == -1);
			}
		}

		bloodThrows.clear();

		for (GraphicsObject o : client.getGraphicsObjects())
		{
			if (o.getId() == TheatreConstant.MAIDEN_BLOOD_THROW)
			{
				bloodThrows.add(WorldPoint.fromLocal(client, o.getLocation()));
			}
		}

		bloodSpawnLocation = new ArrayList<>(bloodSpawnTarget);
		bloodSpawnTarget.clear();

		for (NPC spawn : bloodSpawns)
		{
			bloodSpawnTarget.add(spawn.getWorldLocation());
		}

		if (this.healerCount != this.healers.size())
		{
			this.healerCount = this.healers.size();

			long elapsedTime = System.currentTimeMillis() - this.startTime;
			long seconds = elapsedTime / 1000L;

			long minutes = seconds / 60L;
			seconds = seconds % 60;

			int percentage = 70 - (20 * ((wave++) - 1));
			if (config.extraTimers())
			{
				this.client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Wave 'The Maiden of Sugadinti - " + percentage + "%' completed! Duration: <col=ff0000>" + minutes + ":" + twoDigitString(seconds), null);
			}
		}
	}


	private void addNylo(NPC npc, Nylos.SpawnLocation spawnLocation)
	{
		nylos.add(new Nylos(npc, spawnLocation));
	}
}