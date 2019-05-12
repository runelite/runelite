/*
 * Copyright (c) 2019, Alex <https://github.com/Barragek0>
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
package net.runelite.client.plugins.mining;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Provides;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.ObjectID;
import static net.runelite.api.ObjectID.CRYSTALS;
import static net.runelite.api.ObjectID.CRYSTALS_30372;
import static net.runelite.api.ObjectID.EMPTY_WALL;
import static net.runelite.api.ObjectID.ORE_VEIN_26661;
import static net.runelite.api.ObjectID.ORE_VEIN_26662;
import static net.runelite.api.ObjectID.ORE_VEIN_26663;
import static net.runelite.api.ObjectID.ORE_VEIN_26664;
import net.runelite.api.Player;
import net.runelite.api.WallObject;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.WallObjectDespawned;
import net.runelite.api.events.WallObjectSpawned;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@Slf4j
@PluginDescriptor(
	name = "Mining",
	description = "Show ore respawn timers",
	tags = {"overlay", "skilling", "timers"}
)
public class MiningPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private MiningOverlay overlay;

	@Inject
	private Notifier notifier;

	@Inject
	private MiningConfig config;

	@Provides
	MiningConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(MiningConfig.class);
	}

	public class Obj
	{
		GameObject gameObject;
		long spawnTime;
		double respawnTime;

		Obj(GameObject gameObject, long spawnTime, double respawnTime)
		{
			this.gameObject = gameObject;
			this.spawnTime = spawnTime;
			this.respawnTime = respawnTime;
		}

		public GameObject getGameObject()
		{
			return gameObject;
		}

		public long getSpawnTime()
		{
			return spawnTime;
		}

		public double getRespawnTime()
		{
			return respawnTime;
		}
	}

	public class WallObj
	{
		WallObject wallObject;
		long spawnTime;
		double respawnTime;

		WallObj(WallObject wallObject, long spawnTime, double respawnTime)
		{
			this.wallObject = wallObject;
			this.spawnTime = spawnTime;
			this.respawnTime = respawnTime;
		}

		public WallObject getWallObject()
		{
			return wallObject;
		}

		public long getSpawnTime()
		{
			return spawnTime;
		}

		public double getRespawnTime()
		{
			return respawnTime;
		}
	}

	@Getter(AccessLevel.PACKAGE)
	public ArrayList<Obj> objects = new ArrayList<Obj>();
	@Getter(AccessLevel.PACKAGE)
	ArrayList<WallObj> wallObjects = new ArrayList<WallObj>();

	@Getter(AccessLevel.PACKAGE)
	String currentNode = "";

	@Override
	protected void startUp()
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOADING ||
			event.getGameState() == GameState.HOPPING ||
			event.getGameState() == GameState.LOGGING_IN)
		{
			objects.clear();
			wallObjects.clear();
		}
	}


	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.SPAM)
		{
			return;
		}

		if (event.getMessage().toLowerCase().contains("you just mined an"))
		{
			currentNode = "Gem";
		}
		else if (event.getMessage().toLowerCase().contains("you manage to mine"))
		{
			currentNode = event.getMessage().replace("You manage to mine some", "").replace(".", "").replaceAll(" ", "");
		}
	}

	public String convertObjectToNodeName(int id)
	{
		switch (id)
		{
			case ObjectID.ROCKS_7463: // Gem
			case ObjectID.ROCKS_7464: // Gem
				return "Gem";
			case ObjectID.ROCKS_7454: // Clay
			case ObjectID.ROCKS_7487: // Clay
				return "Clay";
			case ObjectID.ROCKS_7453: // Copper
			case ObjectID.ROCKS_7484: // Copper
				return "Copper";
			case ObjectID.ROCKS_7485: // Tin
			case ObjectID.ROCKS_7486: // Tin
				return "Tin";
			case ObjectID.ROCKS_7455: // Iron
			case ObjectID.ROCKS_7488: // Iron
				return "Iron";
			case ObjectID.ROCKS_7467: // Granite
				return "Granite";
			case ObjectID.ROCKS_8727: // Sandstone
				return "Sandstone";
			case ObjectID.ROCKS_7457: // Silver
			case ObjectID.ROCKS_7490: // Silver
				return "Silver";
			case ObjectID.ROCKS_7456: // Coal
			case ObjectID.ROCKS_7489: // Coal
				return "Coal";
			case ObjectID.ROCKS_7458: // Gold
			case ObjectID.ROCKS_7491: // Gold
				return "Gold";
			case ObjectID.ROCKS_7459: // Mithril
			case ObjectID.ROCKS_7492: // Mithril
				return "Mithril";
			case ObjectID.ROCKS_7460: // Adamant
			case ObjectID.ROCKS_7493: // Adamant
				return "Adamantite";
			case ObjectID.ROCKS_7461: // Rune
			case ObjectID.ROCKS_7494: // Rune
				return "Runite";
			case ORE_VEIN_26661: // Motherlode vein
			case ORE_VEIN_26662: // Motherlode vein
			case ORE_VEIN_26663: // Motherlode vein
			case ORE_VEIN_26664: // Motherlode vein
				return "Pay-dirt";
			case CRYSTALS: // Amethyst crystals
			case CRYSTALS_30372: // Amethyst crystals
				return "Amethyst";
		}
		return "";
	}

	@Subscribe
	public void onGameObjectDespawned(GameObjectDespawned event)
	{
		final GameObject object = event.getGameObject();
		final Player player = client.getLocalPlayer();

		if (object.getWorldLocation().distanceTo(player.getWorldLocation()) > 20)
		{
			return;
		}
		objects = removeDuplicates(objects);
		if (isDepleted(object))
		{
			Iterator<Obj> iterator = objects.stream().distinct().iterator();
			while (iterator.hasNext())
			{
				Obj obj = iterator.next();
				GameObject o = obj.getGameObject();
				if (object.getX() == o.getX() && object.getY() == o.getY() && object.getPlane() == o.getPlane())
				{
					objects.set(objects.indexOf(obj), new Obj(object, System.currentTimeMillis(), 0));
				}
			}
		}
		else if (isRock(object))
		{
			objects.add(new Obj(object, System.currentTimeMillis(), getRespawnTime(object)));
		}
	}

	@Subscribe
	public void onWallObjectSpawned(WallObjectSpawned event)
	{
		final WallObject object = event.getWallObject();
		final Player player = client.getLocalPlayer();

		if (object.getWorldLocation().distanceTo(player.getWorldLocation()) > 20)
		{
			return;
		}
		if (isDepleted(object))
		{
			wallObjects.add(new WallObj(object, System.currentTimeMillis(), getRespawnTime(object)));
		}
		else if (isRock(object))
		{
			Iterator<WallObj> iterator = wallObjects.stream().distinct().iterator();
			while (iterator.hasNext())
			{
				WallObj obj = iterator.next();
				WallObject o = obj.getWallObject();
				if (object.getX() == o.getX() && object.getY() == o.getY() && object.getPlane() == o.getPlane())
				{
					wallObjects.set(wallObjects.indexOf(obj), new WallObj(object, System.currentTimeMillis(), 0));
				}
			}
		}
	}

	@Subscribe
	public void onWallObjectDespawned(WallObjectDespawned event)
	{
		final WallObject object = event.getWallObject();
		final Player player = client.getLocalPlayer();

		if (object.getWorldLocation().distanceTo(player.getWorldLocation()) > 20)
		{
			return;
		}
		if (isDepleted(object))
		{
			wallObjects.add(new WallObj(object, System.currentTimeMillis(), getRespawnTime(object)));
		}
		else if (isRock(object))
		{
			Iterator<WallObj> iterator = wallObjects.stream().distinct().iterator();
			while (iterator.hasNext())
			{
				WallObj obj = iterator.next();
				WallObject o = obj.getWallObject();
				if (object.getX() == o.getX() && object.getY() == o.getY() && object.getPlane() == o.getPlane())
				{
					wallObjects.set(wallObjects.indexOf(obj), new WallObj(object, System.currentTimeMillis(), 0));
				}
			}
		}
	}

	private static final Set<Integer> MINING_GUILD_MAP_REGIONS = ImmutableSet.of(11927, 11928, 11929, 12183, 12184, 12185, 12439, 12440, 12441);

	private boolean inMiningGuild()
	{
		int[] currentMapRegions = client.getMapRegions();

		for (int region : currentMapRegions)
		{
			if (!MINING_GUILD_MAP_REGIONS.contains(region))
			{
				return false;
			}
		}
		return true;
	}

	private final int second = 1_000;
	private final int minute = 60_000;

	public double getRespawnTime(GameObject object)
	{
		switch (object.getId())
		{
			case ObjectID.ROCKS_7454: // Clay
			case ObjectID.ROCKS_7487: // Clay
				return second * 1.1;
			case ObjectID.ROCKS_7453: // Copper
			case ObjectID.ROCKS_7484: // Copper
				return second * 2.2;
			case ObjectID.ROCKS_7485: // Tin
			case ObjectID.ROCKS_7486: // Tin
				return second * 2.3;
			case ObjectID.ROCKS_7455: // Iron
			case ObjectID.ROCKS_7488: // Iron
				return second * (inMiningGuild() ? 2.2 : 5.3);
			case ObjectID.ROCKS_7467: // Granite
			case ObjectID.ROCKS_8727: // Sandstone
				return second * 5.2;
			case ObjectID.ROCKS_7456: // Coal
			case ObjectID.ROCKS_7489: // Coal
				return second * (inMiningGuild() ? 14.5 : 40);
			case ObjectID.ROCKS_7463: // Gem rocks
			case ObjectID.ROCKS_7464: // Gem rocks
			case ObjectID.ROCKS_7457: // Silver
			case ObjectID.ROCKS_7490: // Silver
			case ObjectID.ROCKS_7458: // Gold
			case ObjectID.ROCKS_7491: // Gold
				return second * 59.5;
			case ObjectID.ROCKS_7459: // Mithril
			case ObjectID.ROCKS_7492: // Mithril
				return second * (inMiningGuild() ? 1 : 2);
			case ObjectID.ROCKS_7460: // Adamant
			case ObjectID.ROCKS_7493: // Adamant
				return minute * (inMiningGuild() ? 2 : 4);
			case ObjectID.ROCKS_7461: // Rune
			case ObjectID.ROCKS_7494: // Rune
				return minute * (inMiningGuild() ? 6 : 12);
		}
		return 0;
	}

	public long getRespawnTime(WallObject object)
	{
		switch (object.getId())
		{
			case ORE_VEIN_26661: // Motherlode vein
			case ORE_VEIN_26662: // Motherlode vein
			case ORE_VEIN_26663: // Motherlode vein
			case ORE_VEIN_26664: // Motherlode vein
			case 26665: // Depleted motherlode vein
			case 26666: // Depleted motherlode vein
			case 26667: // Depleted motherlode vein
			case 26668: // Depleted motherlode vein
				return (minute * 1) + (second * 48);
			case CRYSTALS: // Amethyst crystals
			case CRYSTALS_30372: // Amethyst crystals
			case EMPTY_WALL: // Depleted amethyst crystals
				return second * 75;
		}
		return 0;
	}

	public boolean isRock(GameObject object)
	{
		switch (object.getId())
		{
			case ObjectID.ROCKS_7463: // Gem
			case ObjectID.ROCKS_7464: // Gem
			case ObjectID.ROCKS_7454: // Clay
			case ObjectID.ROCKS_7487: // Clay
			case ObjectID.ROCKS_7453: // Copper
			case ObjectID.ROCKS_7484: // Copper
			case ObjectID.ROCKS_7485: // Tin
			case ObjectID.ROCKS_7486: // Tin
			case ObjectID.ROCKS_7455: // Iron
			case ObjectID.ROCKS_7488: // Iron
			case ObjectID.ROCKS_7467: // Granite
			case ObjectID.ROCKS_8727: // Sandstone
			case ObjectID.ROCKS_7457: // Silver
			case ObjectID.ROCKS_7490: // Silver
			case ObjectID.ROCKS_7456: // Coal
			case ObjectID.ROCKS_7489: // Coal
			case ObjectID.ROCKS_7458: // Gold
			case ObjectID.ROCKS_7491: // Gold
			case ObjectID.ROCKS_7459: // Mithril
			case ObjectID.ROCKS_7492: // Mithril
			case ObjectID.ROCKS_7460: // Adamant
			case ObjectID.ROCKS_7493: // Adamant
			case ObjectID.ROCKS_7461: // Rune
			case ObjectID.ROCKS_7494: // Rune
				return true;
		}
		return false;
	}

	public boolean isRock(WallObject object)
	{
		switch (object.getId())
		{
			case ORE_VEIN_26661: // Motherlode vein
			case ORE_VEIN_26662: // Motherlode vein
			case ORE_VEIN_26663: // Motherlode vein
			case ORE_VEIN_26664: // Motherlode vein
			case CRYSTALS: // Amethyst crystals
			case CRYSTALS_30372: // Amethyst crystals
				return true;
		}
		return false;
	}

	public boolean isDepleted(GameObject object)
	{
		switch (object.getId())
		{
			case ObjectID.ROCKS_7468:
			case ObjectID.ROCKS_7469:
				return true;
		}
		return false;
	}

	public boolean isDepleted(WallObject object)
	{
		switch (object.getId())
		{
			case 26665:
			case 26666:
			case 26667:
			case 26668:
			case EMPTY_WALL:
				return true;
		}
		return false;
	}

	public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list)
	{
		Set<T> set = new LinkedHashSet<>();
		set.addAll(list);
		list.clear();
		list.addAll(set);
		return list;
	}
}
