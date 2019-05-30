package net.runelite.client.plugins.theatre.rooms;

import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.*;
import net.runelite.api.Point;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GroundObjectSpawned;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.ProjectileMoved;
import net.runelite.client.plugins.theatre.RoomHandler;
import net.runelite.client.plugins.theatre.TheatreConfig;
import net.runelite.client.plugins.theatre.TheatreConstant;
import net.runelite.client.plugins.theatre.TheatrePlugin;
import net.runelite.client.plugins.theatre.TheatreRoom;
import net.runelite.client.ui.overlay.OverlayUtil;

import java.awt.*;
import java.util.*;
import java.util.List;

public class SotetsegHandler extends RoomHandler
{

	@Getter(AccessLevel.PUBLIC)
	private final Map<GroundObject, Tile> redTiles = new LinkedHashMap<>();

	@Getter(AccessLevel.PUBLIC)
	private List<WorldPoint> redOverworld = new ArrayList<>();

	private List<WorldPoint> blackOverworld = new ArrayList<>();

	private List<WorldPoint> blackUnderworld = new ArrayList<>();

	private List<WorldPoint> redUnderworld = new ArrayList<>();

	private List<Point> gridPath = new ArrayList<>();

	//My variables
	int playerX;
	int playerY;
	private Map<Projectile, WorldPoint> soteyProjectiles = new HashMap<>();
	private NPC npc;
	private long startTime = 0;
	public SotetsegHandler(Client client, TheatrePlugin plugin, TheatreConfig config)
	{
		super(client, plugin, config);
	}

	@Override
	public void onStart()
	{
		if (this.plugin.getRoom() == TheatreRoom.SOTETSEG)
			return;

		this.reset();
		this.plugin.setRoom(TheatreRoom.SOTETSEG);
		System.out.println("Starting Sotetseg Room");
	}

	@Override
	public void onStop()
	{
		this.reset();
		this.plugin.setRoom(TheatreRoom.UNKNOWN);
		System.out.println("Stopping Sotetseg Room");
	}

	public void reset()
	{
		startTime = 0;
		npc = null;
		soteyProjectiles.clear();
		redTiles.clear();
		redOverworld.clear();
		blackOverworld.clear();
		blackUnderworld.clear();
		redUnderworld.clear();
		gridPath.clear();
	}

	public void render(Graphics2D graphics)
	{
		if (config.showSotetsegMaze())
		{
			int i = 1;
			for (GroundObject o : redTiles.keySet())
			{
				Polygon poly = o.getCanvasTilePoly();

				if (poly != null)
				{
					graphics.setColor(config.mazeTileColour());
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

		if (config.showSotetsegSolo())
		{
			for (WorldPoint p : redOverworld)
			{
				drawTile(graphics, p, config.mazeTileColour(), 2, 255, 10);
			}
		}

		if (config.showSotetsegAttacks())
		{

			Map<Projectile, String> projectileMap = new HashMap<>();
			for (Projectile p : soteyProjectiles.keySet())
			{
				final int ticksRemaining = p.getRemainingCycles() / 30;
				int id = p.getId();
				String countdownStr;
				if (id == 1607)
				{
					countdownStr = "R " + String.valueOf(ticksRemaining);
				}
				else
				{
					countdownStr = "M " + String.valueOf(ticksRemaining);
				}

				projectileMap.put(p, countdownStr);
			}
			renderProjectiles(graphics, projectileMap);
			//Legacy code from yuri, works great but shows all projectiles not just ones targetting local player
			/**
			 for (Projectile projectile : client.getProjectiles())
			 {
			 int id = projectile.getId();

			 String name = null;
			 Color color = null;

			 double millis = projectile.getRemainingCycles();
			 double ticks = millis / 60; // 10 millis per cycle, 0.6 ticks per second, 10/0.6 = 60
			 double round = Math.round(ticks * 10d) / 10d;
			 if (id == TheatreConstant.SOTETSEG_BOMB)
			 {
			 name = "" + round;
			 color = Color.WHITE;
			 } 
			 else if (id == TheatreConstant.SOTETSEG_MAGE)
			 {

			 name = "" + round;
			 color = new Color(64, 224, 208, 255);
			 } 
			 else if (id == TheatreConstant.SOTETSEG_RANGE)
			 {
			 name = "" + round;
			 color = new Color(57, 255, 20, 255);
			 }

			 if (name != null)
			 {
			 int x = (int) projectile.getX();
			 int y = (int) projectile.getY();

			 LocalPoint point = new LocalPoint(x, y);
			 Point loc = Perspective.getCanvasTextLocation(client, graphics, point, name, 0);

			 if (loc != null)
			 {
			 if (id == TheatreConstant.SOTETSEG_BOMB)
			 {
			 graphics.setFont(new Font("Arial", Font.BOLD, 20));
			 }
			 else
			 {
			 graphics.setFont(new Font("Arial", Font.BOLD, 17));
			 }

			 OverlayUtil.renderTextLocation(graphics, loc, name, color);
			 }
			 }
			 }**/
		}
	}

	public void onProjectileMoved(ProjectileMoved event)
	{
		Projectile projectile = event.getProjectile();

		//1604 ball
		if (event.getPosition().getX() == playerX && event.getPosition().getY() == playerY || event.getProjectile().getId() == 1604)
		{
			WorldPoint p = WorldPoint.fromLocal(client, event.getPosition());
			soteyProjectiles.put(projectile, p);
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
					blackOverworld.add(p);
			}
			else
			{
				if (!blackUnderworld.contains(p))
					blackUnderworld.add(p);
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
					redUnderworld.add(p);
			}
		}
	}

	public void onGameTick()
	{
		if (plugin.getRoom() != TheatreRoom.SOTETSEG)
		{
			return;
		}

		//Update player position every game tick
		playerX = client.getLocalPlayer().getLocalLocation().getX();
		playerY = client.getLocalPlayer().getLocalLocation().getY();




		//Remove projectiles that are about to die
		if (!soteyProjectiles.isEmpty())
		{
			for (Iterator<Projectile> it = soteyProjectiles.keySet().iterator(); it.hasNext(); )
			{
				Projectile projectile = it.next();
				if (projectile.getRemainingCycles() < 1)
				{
					it.remove();
				}
			}
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
