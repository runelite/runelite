package net.runelite.client.plugins.theatre.rooms;

import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GraphicsObject;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.plugins.theatre.RoomHandler;
import net.runelite.client.plugins.theatre.TheatreConfig;
import net.runelite.client.plugins.theatre.TheatreConstant;
import net.runelite.client.plugins.theatre.TheatrePlugin;
import net.runelite.client.plugins.theatre.TheatreRoom;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MaidenHandler extends RoomHandler 
{

	@Getter(AccessLevel.PACKAGE)
	private List<WorldPoint> bloodThrows = new ArrayList<>();

	@Getter(AccessLevel.PACKAGE)
	private List<NPC> bloodSpawns = new ArrayList<>();

	@Getter(AccessLevel.PACKAGE)
	private List<WorldPoint> bloodSpawnLocation = new ArrayList<>();

	@Getter(AccessLevel.PACKAGE)
	private List<WorldPoint> bloodSpawnTarget = new ArrayList<>();

	private List<NPC> healers = new ArrayList<>();
	private int healerCount = 0;
	private int wave = 1;
	private long startTime = 0;

	public MaidenHandler(Client client, TheatrePlugin plugin, TheatreConfig config) 
	{
		super(client, plugin, config);
	}

	@Override
	public void onStart() 
	{
		if (this.plugin.getRoom() == TheatreRoom.MAIDEN)
			return;

		this.reset();

		this.plugin.setRoom(TheatreRoom.MAIDEN);
		this.startTime = System.currentTimeMillis();
		System.out.println("Starting Maiden Room");
	}

	@Override
	public void onStop() 
	{
		this.reset();
		this.plugin.setRoom(TheatreRoom.UNKNOWN);
		System.out.println("Stopping Maiden Room");
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

	public void onNpcSpawned(NpcSpawned event) 
	{
		NPC npc = event.getNpc();
		String name = npc.getName();
		int id = npc.getId();

		if (npc.getName() != null && name.equals("The Maiden of Sugadinti")) 
		{
			this.onStart();
		} 
		else if (plugin.getRoom() == TheatreRoom.MAIDEN) 
		{
			if (id == NpcID.BLOOD_SPAWN) 
			{
				if (!bloodSpawns.contains(npc))
					bloodSpawns.add(npc);
			} 
			else if (name != null && name.equalsIgnoreCase("Nylocas Matomenos")) 
			{
				this.healers.add(npc);
			}
		}
	}

	public void onNpcDespawned(NpcDespawned event) 
	{
		NPC npc = event.getNpc();
		String name = npc.getName();
		int id = npc.getId();

		if (npc.getName() != null && name.equals("The Maiden of Sugadinti")) 
		{
			this.onStop();
		}
		else if (plugin.getRoom() == TheatreRoom.MAIDEN) 
		{
			if (id == NpcID.BLOOD_SPAWN) 
			{
				bloodSpawns.remove(npc);
			}
		}
	}

	public void onGameTick() 
	{
		if (plugin.getRoom() != TheatreRoom.MAIDEN) 
		{
			return;
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
			this.client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Wave 'The Maiden of Sugadinti - " + percentage + "%' completed! Duration: <col=ff0000>" + minutes + ":" + twoDigitString(seconds), null);
		}
	}
}