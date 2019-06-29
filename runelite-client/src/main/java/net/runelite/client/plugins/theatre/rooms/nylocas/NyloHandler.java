package net.runelite.client.plugins.theatre.rooms.nylocas;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NyloHandler extends RoomHandler 
{

	@Getter(AccessLevel.PUBLIC)
	private Map<NPC, Integer> pillars = new HashMap<>();

	@Getter(AccessLevel.PUBLIC)
	private Map<NPC, Integer> spiders = new HashMap<>();

	@Getter
	@Setter
	private int wave = 0;

	private NyloOverlay overlay = null;
	private NyloPredictor predictor = null;

	private Point south = new Point(64, 41);
	private Point west = new Point(49, 56);
	private Point east = new Point(78, 56);

	public long startTime = 0L;
	public int startTick = 0;

	public ArrayList<NPC> waveSpawns = new ArrayList<NPC>();
	public ArrayList<NPC> waveAgros = new ArrayList<NPC>();

	public NyloHandler(Client client, TheatrePlugin plugin, TheatreConfig config)
	{
		super(client, plugin, config);
	}

	@Override
	public void onStart()
	{
		if (this.plugin.getRoom() == TheatreRoom.NYLOCAS)
			return;

		this.reset();

		this.plugin.setRoom(TheatreRoom.NYLOCAS);
		if (overlay == null && config.showNylocasAmount())
		{
			overlay = new NyloOverlay(client, plugin, config, this);
			plugin.getOverlayManager().add(overlay);
		}

		System.out.println("Starting Nylocas Room");
		this.startTime = System.currentTimeMillis();
		this.startTick = this.client.getTickCount();
	}

	@Override
	public void onStop()
	{
		this.reset();

		this.plugin.setRoom(TheatreRoom.UNKNOWN);

		if (overlay != null)
		{
			plugin.getOverlayManager().remove(overlay);
			overlay = null;
		}

		this.predictor = null;

		long elapsedTime = System.currentTimeMillis() - this.startTime;
		long seconds = elapsedTime / 1000L;

		long minutes = seconds / 60L;
		seconds = seconds % 60;

		if (this.startTime != 0)
		{
			if (config.extraTimers())
			this.client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Wave 'The Nylocas - Waves' completed! Duration: <col=ff0000>" + minutes + ":" + twoDigitString(seconds), null);
		}
		System.out.println("Stopping Nylocas Room");
	}

	public void reset()
	{
		this.pillars.clear();
		this.spiders.clear();

		this.wave = 0;

		this.predictor = new NyloPredictor(client, this);
		this.waveSpawns.clear();
		this.waveAgros.clear();
		this.predictor.reset();
	}

	public void onConfigChanged()
	{
		if (plugin.getRoom() != TheatreRoom.NYLOCAS)
		{
			return;
		}

		if (overlay == null && config.showNylocasAmount())
		{
			overlay = new NyloOverlay(client, plugin, config, this);
			plugin.getOverlayManager().add(overlay);
		}
		else if (overlay != null && !config.showNylocasAmount())
		{
			plugin.getOverlayManager().remove(overlay);
			overlay = null;
		}
	}

	private Color healthColorCode(int health)
	{
		health = Math.max(health, 0);
		health = Math.min(health, 100);

		double rMod = 130.0 * health / 100.0;
		double gMod = 255.0 * health / 100.0;
		double bMod = 125.0 * health / 100.0;
		Color c = new Color((int) (255 - rMod), (int) (0 + gMod), (int) (0 + bMod));

		return c;
	}

	public void render(Graphics2D graphics)
	{
		if (config.showNyloPillarHealth())
		{
			for (NPC npc : pillars.keySet())
			{
				final int health = pillars.get(npc);
				final String healthStr = String.valueOf(health) + "%";
				WorldPoint p = npc.getWorldLocation();
				LocalPoint lp = LocalPoint.fromWorld(client, p.getX() + 1, p.getY() + 1);

				Color c = this.healthColorCode(health);
				Point canvasPoint = Perspective.localToCanvas(client, lp, client.getPlane(), 65);
				renderTextLocation(graphics, healthStr, 13, Font.BOLD, c, canvasPoint);
			}
		}

		switch (config.showNylocasExplosions())
		{
			case TILE:
				for (NPC npc : spiders.keySet())
				{
					int ticksLeft = spiders.get(npc);
					if (ticksLeft > -1 && ticksLeft < 6)
					{
						Color color = new Color(255, 255, 0, 180);
						int outlineWidth = 2;
						int outlineAlpha = 150;
						renderNpcOverlay(graphics, npc, color, outlineWidth, outlineAlpha, 15);
					}
				}
				break;
			case TIMER:
				for (NPC npc : spiders.keySet())
				{
					int ticksLeft = spiders.get(npc);
					if (ticksLeft > -1 && ticksLeft < 15)
					{
						String str = Integer.toString(ticksLeft);
						LocalPoint lp = npc.getLocalLocation();
						Point point = Perspective.getCanvasTextLocation(client, graphics, lp, str, 0);
						renderTextLocation(graphics, str, 13, Font.BOLD, this.healthColorCode(ticksLeft), point);
					}
				}
				break;
			case NONE:
				break;
		}

		Set<NPC> toHighlight = new HashSet<NPC>();

		/**
		if (config.highlightNyloParents()) 
		{
			for (NPC npc : new ArrayList<NPC>(this.waveSpawns)) 
			{
				try 
				{
					if (npc.getHealthRatio() == 0 || npc.isDead()) 
					{
						this.waveSpawns.remove(npc);
						continue;
					}

					if (!toHighlight.contains(npc))
						toHighlight.add(npc);
				} 
				catch (Exception ex)
				{

				}
			}
		}**/

		if (config.highlightNyloAgros()) 
		{
			for (NPC npc : new ArrayList<NPC>(this.waveAgros))
			{
				try
				{
					if (npc.getHealthRatio() == 0 || npc.isDead()) 
					{
						this.waveAgros.remove(npc);
						continue;
					}

					if (!toHighlight.contains(npc))
						toHighlight.add(npc);
				} 
				catch (Exception ex) 
				{

				}
			}
		}

		for (NPC npc : toHighlight)
		{
			try
			{
				Polygon objectClickbox = npc.getConvexHull();

				Color color;
				String name = npc.getName() != null ? npc.getName() : "";

				if (name.contains("Hagios"))
					color = Color.CYAN;
				else if (name.contains("Toxobolos"))
					color = Color.GREEN;
				else
					color = Color.LIGHT_GRAY;

				renderPoly(graphics, color, objectClickbox);
			} 
			catch (Exception ex)
			{

			}
		}
/**
		if (config.showNylocasSpawns() && predictor != null)
		{
			NyloPredictor.Wave nextWave = predictor.getNextWave();
			if (nextWave != null)
			{
				TheatreConfig.NYLOCAS mark = config.highlightNyloRoles();

				String southStr = predictor.getSpawnStr(NyloPredictor.Spawn.SOUTH, nextWave);
				if (southStr != null && south != null)
				{
					LocalPoint lp = LocalPoint.fromScene(south.getX(), south.getY());
					Point point = Perspective.getCanvasTextLocation(client, graphics, lp, southStr, 1);
					Color color = mark != TheatreConfig.NYLOCAS.NONE ? (((southStr.contains("Mage") && mark == TheatreConfig.NYLOCAS.MAGE) || (southStr.contains("Range") && mark == TheatreConfig.NYLOCAS.RANGER) || (southStr.contains("Melee") && mark == TheatreConfig.NYLOCAS.MELEE)) ? Color.MAGENTA : Color.RED) : Color.RED;
					renderTextLocation(graphics, southStr, 18, Font.BOLD, color, point);
//					drawTile(graphics, WorldPoint.fromLocal(client, lp), new Color(0, 150, 200), 2, 150, 10);
				}

				String westStr = predictor.getSpawnStr(NyloPredictor.Spawn.WEST, nextWave);
				if (westStr != null && west != null)
				{
					LocalPoint lp = LocalPoint.fromScene(west.getX(), west.getY());
					Point point = Perspective.getCanvasTextLocation(client, graphics, lp, westStr, 1);
					Color color = mark != TheatreConfig.NYLOCAS.NONE ? (((westStr.contains("Mage") && mark == TheatreConfig.NYLOCAS.MAGE) || (westStr.contains("Range") && mark == TheatreConfig.NYLOCAS.RANGER) || (westStr.contains("Melee") && mark == TheatreConfig.NYLOCAS.MELEE)) ? Color.MAGENTA : Color.RED) : Color.RED;
					renderTextLocation(graphics, westStr, 18, Font.BOLD, color, point);
//					drawTile(graphics, WorldPoint.fromLocal(client, lp), new Color(0, 150, 200), 2, 150, 10);
				}

				String eastStr = predictor.getSpawnStr(NyloPredictor.Spawn.EAST, nextWave);
				if (eastStr != null && east != null)
				{
					LocalPoint lp = LocalPoint.fromScene(east.getX(), east.getY());
					Point point = Perspective.getCanvasTextLocation(client, graphics, lp, eastStr, 1);
					Color color = mark != TheatreConfig.NYLOCAS.NONE ? (((eastStr.contains("Mage") && mark == TheatreConfig.NYLOCAS.MAGE) || (eastStr.contains("Range") && mark == TheatreConfig.NYLOCAS.RANGER) || (eastStr.contains("Melee") && mark == TheatreConfig.NYLOCAS.MELEE)) ? Color.MAGENTA : Color.RED) : Color.RED;
					renderTextLocation(graphics, eastStr, 18, Font.BOLD, color, point);
//					drawTile(graphics, WorldPoint.fromLocal(client, lp), new Color(0, 150, 200), 2, 150, 10);
				}
			}
		}**/
	}

	public void onNpcSpawned(NpcSpawned event)
	{
		NPC npc = event.getNpc();
		int id = npc.getId();

		if (id == TheatreConstant.NPC_ID_NYLOCAS_PILLAR)
		{
			this.onStart();
			this.pillars.put(npc, 100);
			this.recalculateLocal();
		}
		else if (npc.getName() != null)
		{
			if (this.plugin.getRoom() == TheatreRoom.NYLOCAS)
			{
				Pattern p = Pattern.compile("Nylocas (Hagios|Toxobolos|Ischyros)");
				Matcher m = p.matcher(npc.getName());
				if (m.matches())
				{
					this.spiders.put(npc, 52);

					if (this.predictor != null)
					{
						this.predictor.onNpcSpawned(event);
					}
				}
				else if (npc.getName().equals("Nylocas Vasilias"))
				{
					this.onStop();
				}
			}
		}
	}

	public void onNpcDespawned(NpcDespawned event)
	{
		NPC npc = event.getNpc();
		int id = npc.getId();

		if (this.waveSpawns.contains(npc))
		{
			this.waveSpawns.remove(npc);
		}

		if (this.waveAgros.contains(npc))
		{
			this.waveAgros.remove(npc);
		}

		if (id == TheatreConstant.NPC_ID_NYLOCAS_PILLAR)
		{
			this.pillars.remove(npc);
		}
		else if (npc.getName() != null && this.plugin.getRoom() == TheatreRoom.NYLOCAS)
		{
			Pattern p = Pattern.compile("Nylocas (Hagios|Toxobolos|Ischyros)");
			Matcher m = p.matcher(npc.getName());
			if (m.matches())
			{
				this.spiders.remove(npc);
			}
		}
	}

	private void renderPoly(Graphics2D graphics, Color color, Polygon polygon)
	{
		if (polygon != null)
		{
			graphics.setColor(color);
			graphics.setStroke(new BasicStroke(2));
			graphics.draw(polygon);
			graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 20));
			graphics.fill(polygon);
		}
	}

	public void onGameTick()
	{
		if (plugin.getRoom() != TheatreRoom.NYLOCAS)
		{
			return;
		} 
		else
		{
			boolean findPillar = false;

			for (NPC npc : client.getNpcs())
			{
				if (npc.getId() == 8358)
				{
					findPillar = true;
					break;
				}
			}

			if (!findPillar)
			{
				this.onStop();
				return;
			}
		}

		for (NPC spider : new ArrayList<>(spiders.keySet()))
		{
			int ticksLeft = spiders.get(spider);

			if (ticksLeft < 0)
			{
				spiders.remove(spider);
				continue;
			}

			spiders.replace(spider, ticksLeft - 1);
		}

		this.recalculateLocal();
		for (NPC pillar : pillars.keySet())
		{
			int healthPercent = pillar.getHealthRatio();
			if (healthPercent > -1)
			{
				pillars.replace(pillar, healthPercent);
			}
		}
	}

	private void recalculateLocal()
	{
		if (this.pillars != null && this.pillars.size() == 4)
		{
			int minX = Integer.MAX_VALUE;
			int minY = Integer.MAX_VALUE;
			for (NPC npc : pillars.keySet())
			{
				LocalPoint lp = npc.getLocalLocation();
				if (lp.getSceneX() < minX)
				{
					minX = lp.getSceneX();
				}

				if (lp.getSceneY() < minY)
				{
					minY = lp.getSceneY();
				}
			}

			int centerX = minX + 5;
			int centerY = minY + 5;

			south = new Point(centerX + 1, centerY - 14);
			east = new Point(centerX + 15, centerY);
			west = new Point(centerX - 14, centerY);

			if (this.predictor != null)
			{
				this.predictor.southBound = centerY - 12;
				this.predictor.eastBound = centerX + 13;
				this.predictor.westBound = centerX - 12;
			}
		}
	}
}