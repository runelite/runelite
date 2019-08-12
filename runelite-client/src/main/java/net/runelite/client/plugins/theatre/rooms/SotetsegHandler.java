package net.runelite.client.plugins.theatre.rooms;

import com.google.common.collect.ImmutableSet;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.GroundObject;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.Point;
import net.runelite.api.Projectile;
import net.runelite.api.ProjectileID;
import net.runelite.api.Tile;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GroundObjectSpawned;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.ProjectileSpawned;
import net.runelite.client.plugins.theatre.RoomHandler;
import net.runelite.client.plugins.theatre.TheatreConstant;
import net.runelite.client.plugins.theatre.TheatrePlugin;
import net.runelite.client.plugins.theatre.TheatreRoom;
import net.runelite.client.ui.overlay.OverlayUtil;

public class SotetsegHandler extends RoomHandler
{
	private static final Set<Integer> SOTE_PROJ = ImmutableSet.of(
		ProjectileID.SOTETSEG_MAGE, ProjectileID.SOTETSEG_RANGE
	);
	@Getter(AccessLevel.PUBLIC)
	private final Map<GroundObject, Tile> redTiles = new LinkedHashMap<>();
	@Getter(AccessLevel.PUBLIC)
	private List<WorldPoint> redOverworld = new ArrayList<>();
	private final List<WorldPoint> blackOverworld = new ArrayList<>();
	private final List<WorldPoint> blackUnderworld = new ArrayList<>();
	private final List<WorldPoint> redUnderworld = new ArrayList<>();
	private final List<Point> gridPath = new ArrayList<>();
	private final Set<Projectile> soteyProjectiles = new HashSet<>();
	private NPC npc;

	public SotetsegHandler(final Client client, final TheatrePlugin plugin)
	{
		super(client, plugin);
	}

	@Override
	public void onStart()
	{
		if (this.plugin.getRoom() == TheatreRoom.SOTETSEG)
		{
			return;
		}

		this.reset();
		this.plugin.setRoom(TheatreRoom.SOTETSEG);
	}

	@Override
	public void onStop()
	{
		this.reset();
		this.plugin.setRoom(TheatreRoom.UNKNOWN);
	}

	private void reset()
	{
		npc = null;
		redTiles.clear();
		redOverworld.clear();
		blackOverworld.clear();
		blackUnderworld.clear();
		redUnderworld.clear();
		gridPath.clear();
	}

	public void render(Graphics2D graphics)
	{
		if (plugin.isShowSotetsegMaze())
		{
			int i = 1;
			for (GroundObject o : redTiles.keySet())
			{
				Polygon poly = o.getCanvasTilePoly();

				if (poly != null)
				{
					graphics.setColor(plugin.getMazeTileColour());
					graphics.setStroke(new BasicStroke(2));
					graphics.draw(poly);
				}

				Point textLocation = o.getCanvasTextLocation(graphics, String.valueOf(i), 0);
				if (textLocation != null)
				{
					OverlayUtil.renderTextLocation(graphics, textLocation, String.valueOf(i), Color.WHITE);
				}

				i++;
			}
		}

		if (plugin.isShowSotetsegSolo())
		{
			for (WorldPoint p : redOverworld)
			{
				drawTile(graphics, p, plugin.getMazeTileColour(), 2, 255, 10);
			}
		}

		if (plugin.isShowSotetsegAttacks())
		{

			Map<Projectile, String> projectileMap = new HashMap<>();
			for (Projectile p : soteyProjectiles)
			{
				final int ticksRemaining = p.getRemainingCycles() / 30;
				int id = p.getId();
				String countdownStr;
				if (id == 1607)
				{
					countdownStr = "R " + ticksRemaining;
				}
				else
				{
					countdownStr = "M " + ticksRemaining;
				}

				projectileMap.put(p, countdownStr);
			}
			renderProjectiles(graphics, projectileMap);
		}
	}

	public void onProjectileSpawned(ProjectileSpawned event)
	{
		final Projectile projectile = event.getProjectile();

		if (SOTE_PROJ.contains(projectile.getId()) && projectile.getInteracting() == client.getLocalPlayer())
		{
			soteyProjectiles.add(projectile);
		}
		else if (projectile.getId() == ProjectileID.SOTETSEG_BOMB)
		{
			soteyProjectiles.add(projectile);
		}
	}


	public void onNpcSpawned(NpcSpawned event)
	{
		npc = event.getNpc();

		if (npc.getName() != null && npc.getName().equals("Sotetseg"))
		{
			this.onStart();
		}
	}

	public void onNpcDespawned(NpcDespawned event)
	{
		npc = event.getNpc();

		if (npc.getName() != null && npc.getName().equals("Sotetseg"))
		{
			redTiles.clear();
			if (client.getPlane() != 3)
			{
				this.onStop();
			}
		}
	}

	public void onGroundObjectSpawned(GroundObjectSpawned event)
	{
		if (plugin.getRoom() != TheatreRoom.SOTETSEG)
		{
			return;
		}

		GroundObject o = event.getGroundObject();
		if (o.getId() == TheatreConstant.GROUNDOBJECT_ID_BLACKMAZE)
		{
			Tile t = event.getTile();
			WorldPoint p = t.getWorldLocation();
			if (t.getPlane() == 0)
			{
				if (!blackOverworld.contains(p))
				{
					blackOverworld.add(p);
				}
			}
			else
			{
				if (!blackUnderworld.contains(p))
				{
					blackUnderworld.add(p);
				}
			}
		}

		if (o.getId() == TheatreConstant.GROUNDOBJECT_ID_REDMAZE)
		{
			Tile t = event.getTile();
			WorldPoint p = t.getWorldLocation();
			if (p.getPlane() == 0)
			{
				if (!redTiles.containsValue(t))
				{
					redTiles.put(o, t);
				}
			}
			else
			{
				if (!redUnderworld.contains(p))
				{
					redUnderworld.add(p);
				}
			}
		}
	}

	public void onGameTick()
	{
		if (plugin.getRoom() != TheatreRoom.SOTETSEG)
		{
			return;
		}

		if (!soteyProjectiles.isEmpty())
		{
			soteyProjectiles.removeIf(p -> p.getRemainingCycles() <= 0);
		}

		boolean sotetsegFighting = false;

		for (NPC npc : client.getNpcs())
		{
			if (npc.getId() == NpcID.SOTETSEG_8388)
			{
				this.reset();
				sotetsegFighting = true;
				break;
			}
		}

		if (!sotetsegFighting)
		{
			if (!blackUnderworld.isEmpty() && !redUnderworld.isEmpty() && gridPath.isEmpty())
			{
				int minX = 99999;
				int minY = 99999;

				for (WorldPoint p : blackUnderworld)
				{
					int x = p.getX();
					int y = p.getY();
					if (x < minX)
					{
						minX = x;
					}
					if (y < minY)
					{
						minY = y;
					}
				}

				boolean messageSent = false;
				for (WorldPoint p : redUnderworld)
				{
					WorldPoint pN = new WorldPoint(p.getX(), p.getY() + 1, p.getPlane());
					WorldPoint pS = new WorldPoint(p.getX(), p.getY() - 1, p.getPlane());
					WorldPoint pE = new WorldPoint(p.getX() + 1, p.getY(), p.getPlane());
					WorldPoint pW = new WorldPoint(p.getX() - 1, p.getY(), p.getPlane());

					if (!((redUnderworld.contains(pN) && redUnderworld.contains(pS)) ||
						(redUnderworld.contains(pE) && redUnderworld.contains(pW))))
					{
						gridPath.add(new Point(p.getX() - minX, p.getY() - minY));
						if (!messageSent)
						{
							//client.addChatMessage(ChatMessageType.SERVER, "", "Maze path acquired.", null);
							messageSent = true;
						}
					}

				}
			}

			if (!blackOverworld.isEmpty() && !gridPath.isEmpty() && redOverworld.isEmpty())
			{
				int minX = 99999;
				int minY = 99999;

				for (WorldPoint p : blackOverworld)
				{
					int x = p.getX();
					int y = p.getY();
					if (x < minX)
					{
						minX = x;
					}
					if (y < minY)
					{
						minY = y;
					}
				}

				for (Point p : gridPath)
				{
					redOverworld.add(new WorldPoint(minX + p.getX(), minY + p.getY(), 0));
				}
			}
		}
	}
}