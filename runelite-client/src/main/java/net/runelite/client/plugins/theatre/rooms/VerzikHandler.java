package net.runelite.client.plugins.theatre.rooms;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Actor;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GraphicsObject;
import net.runelite.api.NPC;
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.Projectile;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.ProjectileMoved;
import net.runelite.client.plugins.theatre.RoomHandler;
import net.runelite.client.plugins.theatre.TheatreConstant;
import net.runelite.client.plugins.theatre.TheatrePlugin;
import net.runelite.client.plugins.theatre.TheatreRoom;

public class VerzikHandler extends RoomHandler
{

	@Getter(AccessLevel.PACKAGE)
	private final Map<Projectile, WorldPoint> Verzik_RangeProjectiles = new HashMap<>();
	//My variables
	private int redCrabsTimer;
	@Getter(AccessLevel.PUBLIC)
	private int versikCounter = 0;
	private int attacksLeft = 0;
	@Getter(AccessLevel.PUBLIC)
	private NPC npc;
	private int lastId = -1;
	private int yellows;
	private boolean tornados;
	private long startTime = 0;

	public VerzikHandler(final Client client, final TheatrePlugin plugin)
	{
		super(client, plugin);
	}

	@Override
	public void onStart()
	{
		if (this.plugin.getRoom() == TheatreRoom.VERSIK)
		{
			return;
		}

		this.reset();
		this.plugin.setRoom(TheatreRoom.VERSIK);
	}

	@Override
	public void onStop()
	{
		this.reset();
		this.plugin.setRoom(TheatreRoom.UNKNOWN);
	}

	private void reset()
	{
		this.redCrabsTimer = 13;
		this.Verzik_RangeProjectiles.clear();
		this.versikCounter = 19;
		this.attacksLeft = 0;
		this.npc = null;
		this.yellows = 0;
		this.lastId = -1;
		this.tornados = false;
		this.startTime = 0;
	}

	public void render(Graphics2D graphics)
	{
		if (npc == null)
		{
			return;
		}

		int id = npc.getId();
		if (plugin.isVerzikRangeAttacks())
		{
			for (WorldPoint p : getVerzik_RangeProjectiles().values())
			{
				drawTile(graphics, p, Color.RED, 2, 180, 50);
			}
		}
		if (plugin.isShowVerzikAttacks())
		{

			if (id == TheatreConstant.VERZIK_ID_P1)
			{
				if (plugin.isP1attacks() && this.versikCounter >= 0)
				{
					String str = Integer.toString(versikCounter);

					LocalPoint lp = npc.getLocalLocation();
					Point point = Perspective.getCanvasTextLocation(client, graphics, lp, str, 0);

					renderTextLocation(graphics, str, 20, Font.BOLD, Color.CYAN, point);
				}
			}
			else if (id == TheatreConstant.VERZIK_ID_P2)
			{
				if (plugin.isP2attacks() && this.versikCounter >= 0)
				{
					String str = Integer.toString(versikCounter);

					LocalPoint lp = npc.getLocalLocation();
					Point point = Perspective.getCanvasTextLocation(client, graphics, lp, str, 0);

					renderTextLocation(graphics, str, 20, Font.BOLD, Color.CYAN, point);
				}
			}

			else if (id == TheatreConstant.VERZIK_ID_P3 && plugin.isP3attacks() && versikCounter > 0 && versikCounter < 8)
			{
				String str = Math.max(versikCounter, 0) + "";// + " | " + model.getModelHeight();// + " | " + model.getRadius();

				LocalPoint lp = npc.getLocalLocation();
				Point point = Perspective.getCanvasTextLocation(client, graphics, lp, str, 0);

				renderTextLocation(graphics, str, 15, Font.BOLD, Color.WHITE, point);
			}
		}

		if (plugin.isVerzikTankTile() && id == TheatreConstant.VERZIK_ID_P3)
		{
			WorldPoint wp = new WorldPoint(npc.getWorldLocation().getX() + 3, npc.getWorldLocation().getY() + 3, client.getPlane());
			drawTile2(graphics, wp, new Color(75, 0, 130), 2, 255, 0);
			//renderNpcOverlay(graphics, boss, new Color(75, 0, 130), 1, 255, 0);
		}


		if (plugin.isShowVerzikYellows() && this.yellows > 0)
		{
			String text = Integer.toString(this.yellows);

			for (GraphicsObject object : client.getGraphicsObjects())
			{
				if (object.getId() == TheatreConstant.GRAPHIC_ID_YELLOWS)
				{
					drawTile(graphics, WorldPoint.fromLocal(client, object.getLocation()), Color.YELLOW, 3, 255, 0);
					LocalPoint lp = object.getLocation();
					Point point = Perspective.getCanvasTextLocation(client, graphics, lp, text, 0);
					renderTextLocation(graphics, text, 12, Font.BOLD, Color.WHITE, point);
				}
			}
		}

		if (plugin.isShowCrabTargets())
		{
			Player local = client.getLocalPlayer();
			if (local != null && local.getName() != null)
			{
				for (NPC npc : client.getNpcs())
				{
					if (npc.getName() == null)
					{
						continue;
					}

					Pattern p = Pattern.compile("Nylocas (Hagios|Toxobolos|Ischyros)");
					Matcher m = p.matcher(npc.getName());
					if (!m.matches())
					{
						continue;
					}

					Actor target = npc.getInteracting();
					if (target == null || target.getName() == null)
					{
						continue;
					}

					LocalPoint lp = npc.getLocalLocation();
					Color color = local.getName().equals(target.getName()) ? Color.RED : Color.GREEN;

					Point point = Perspective.getCanvasTextLocation(client, graphics, lp, target.getName(), 0);
					renderTextLocation(graphics, target.getName(), 14, Font.BOLD, color, point);
				}
			}
		}

	}

	public void onProjectileMoved(ProjectileMoved event)
	{
		Projectile projectile = event.getProjectile();
		if (projectile.getId() == 1583)
		{
			WorldPoint p = WorldPoint.fromLocal(client, event.getPosition());
			Verzik_RangeProjectiles.put(projectile, p);
		}
	}

	public void onNpcSpawned(NpcSpawned event)
	{
		NPC npc = event.getNpc();
		int id = npc.getId();

		if (npc.getName() != null && npc.getName().equals("Verzik Vitur"))
		{
			this.npc = npc;
			if (id == TheatreConstant.VERZIK_ID_P3_BAT)
			{
				this.onStop();
			}
			else
			{
				this.onStart();

				if (id == TheatreConstant.VERZIK_ID_P1)
				{
					this.versikCounter = 19;
				}
				else if (id == TheatreConstant.VERZIK_ID_P2)
				{
					this.versikCounter = 3;
				}
				else if (id == TheatreConstant.VERZIK_ID_P3)
				{
					this.versikCounter = -1;
					this.attacksLeft = 9;
				}
			}
		}
	}

	public void onAnimationChanged(AnimationChanged event)
	{
		if (plugin.getRoom() != TheatreRoom.VERSIK)
		{
			return;
		}

		Actor actor = event.getActor();
		if (!(actor instanceof NPC))
		{
			return;
		}

		NPC npc = (NPC) actor;
		int id = npc.getId();

		if (event.getActor().getAnimation() == 8117)
		{
			redCrabsTimer = 11;
		}

		if (id == TheatreConstant.VERZIK_ID_P1)
		{
			int animation = npc.getAnimation();
			if (animation == TheatreConstant.ANIMATION_ID_P1_ATTACK)
			{
//				System.out.println("Verzik is shooting her attack on P1.");
				versikCounter = 15;
			}
		}
		else if (id == TheatreConstant.VERZIK_ID_P2)
		{
			int animation = npc.getAnimation();
			if (animation == TheatreConstant.ANIMATION_ID_P2_ATTACK_RANGE || animation == TheatreConstant.ANIMATION_ID_P2_ATTACK_MELEE)
			{
//				System.out.println("Verzik is shooting her attack on P2.");
				versikCounter = 5;
			}
			else if (animation == TheatreConstant.ANIMATION_ID_P2_SHIELD)
			{
//				System.out.println("Verzik is healing on P2.");
				versikCounter = 13;
			}
		}
	}

	public void onGameTick()
	{
		if (plugin.getRoom() != TheatreRoom.VERSIK)
		{
			return;
		}
		if (!Verzik_RangeProjectiles.isEmpty())
		{
			Verzik_RangeProjectiles.keySet().removeIf(p -> p.getRemainingCycles() < 1);
		}
		if (this.yellows == 0)
		{
			//if (this.autosSinceYellows > 0){
			for (GraphicsObject object : client.getGraphicsObjects())
			{
				if (object.getId() == TheatreConstant.GRAPHIC_ID_YELLOWS)
				{
					this.yellows = 14;
//						this.versikCounter = 22;
					break;
				}
			}
			//}
		}
		else
		{
			this.yellows--;
		}

		if (npc != null && npc.getAnimation() == 8117)
		{
			redCrabsTimer = redCrabsTimer - 1;
		}


		boolean foundVerzik = false;
		boolean foundTornado = false;

		for (NPC npc : client.getNpcs())
		{
			if (npc.getName() != null && npc.getName().equals("Verzik Vitur"))
			{
				foundVerzik = true;
				this.npc = npc;
			}
			else if (npc.getId() == TheatreConstant.NPC_ID_TORNADO)
			{
				foundTornado = true;
			}

			if (foundTornado && foundVerzik)
			{
				break;
			}
		}

		if (!foundVerzik)
		{
			this.onStop();
			return;
		}

		if (npc == null)
		{
			return;
		}

		int id = npc.getId();

		if (this.lastId != id)
		{
			this.lastId = id;

			if (id == TheatreConstant.VERZIK_ID_P1)
			{
				this.startTime = System.currentTimeMillis();
			}
			else if (id == TheatreConstant.VERZIK_ID_P1_WALK && this.startTime != 0)
			{
				long elapsedTime = System.currentTimeMillis() - this.startTime;
				long seconds = elapsedTime / 1000L;

				long minutes = seconds / 60L;
				seconds = seconds % 60;
				if (plugin.isExtraTimers())
				{
					this.client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Wave 'The Final Challenge - Part 1' completed! Duration: <col=ff0000>" + minutes + ":" + twoDigitString(seconds), null);
				}
			}
			else if (id == TheatreConstant.VERZIK_ID_P2_TRANSFORM && this.startTime != 0)
			{
				long elapsedTime = System.currentTimeMillis() - this.startTime;
				long seconds = elapsedTime / 1000L;

				long minutes = seconds / 60L;
				seconds = seconds % 60;

				this.versikCounter = -1;
				this.attacksLeft = 9;
				if (plugin.isExtraTimers())
				{
					this.client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Wave 'The Final Challenge - Part 2' completed! Duration: <col=ff0000>" + minutes + ":" + twoDigitString(seconds), null);
				}
			}
		}

		if (id == TheatreConstant.VERZIK_ID_P3_BAT)
		{
			this.onStop();
			return;
		}
		else if (id == TheatreConstant.VERZIK_ID_P1_WALK)
		{
			versikCounter = 4;
			return;
		}

		if (id == TheatreConstant.VERZIK_ID_P1 || id == TheatreConstant.VERZIK_ID_P2)
		{
			versikCounter--;
			if (versikCounter < 0)
			{
				versikCounter = 0;
			}
		}
		else if (id == TheatreConstant.VERZIK_ID_P3)
		{
			if (foundTornado && !this.tornados)
			{
				this.tornados = true;
			}

			boolean isGreenBall = false;
			for (Projectile projectile : client.getProjectiles())
			{
				if (projectile.getId() == TheatreConstant.PROJECTILE_ID_P3_GREEN)
				{
					isGreenBall = projectile.getRemainingCycles() > 210;
					break;
				}
			}

			versikCounter--;

			int animation = npc.getAnimation();

			switch (animation)
			{
				case TheatreConstant.ANIMATION_ID_P3_MELEE:
				case TheatreConstant.ANIMATION_ID_P3_MAGE:
					if (versikCounter < 2)
					{
						this.attacksLeft--;
						if (this.tornados)
						{
							versikCounter = 5;
						}
						else
						{
							versikCounter = 7;
						}

						if (attacksLeft < 1)
						{
							versikCounter = 24;
						}
					}
					break;
				case TheatreConstant.ANIMATION_ID_P3_RANGE:
					if (versikCounter < 2)
					{
						attacksLeft--;
						if (this.tornados)
						{
							versikCounter = 5;
						}
						else
						{
							versikCounter = 7;
						}

						if (attacksLeft < 1)
						{
							versikCounter = 30;
						}

						if (isGreenBall)
						{
							versikCounter = 12;
						}
					}
					break;
				case TheatreConstant.ANIMATION_ID_P3_WEB:
					attacksLeft = 4;
					versikCounter = 11;
					break;
				case TheatreConstant.ANIMATION_ID_P3_YELLOW:
					attacksLeft = 14;
					versikCounter = 11;
					break;
			}
		}
	}
}