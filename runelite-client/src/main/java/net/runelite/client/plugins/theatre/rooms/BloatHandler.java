package net.runelite.client.plugins.theatre.rooms;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.Random;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.GraphicsObject;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.Point;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.plugins.theatre.RoomHandler;
import net.runelite.client.plugins.theatre.TheatrePlugin;
import net.runelite.client.plugins.theatre.TheatreRoom;

public class BloatHandler extends RoomHandler
{

	private int bloatTimer;
	@Getter(AccessLevel.PUBLIC)
	private NPC bloat;
	private int counter;
	private boolean bloatFlag;
	private Color color;
	@Getter(AccessLevel.PUBLIC)
	private BloatState bloatState;

	public BloatHandler(final Client client, final TheatrePlugin plugin)
	{
		super(client, plugin);
	}

	@Override
	public void onStart()
	{
		if (this.plugin.getRoom() == TheatreRoom.BLOAT)
		{
			return;
		}

		this.reset();
		this.plugin.setRoom(TheatreRoom.BLOAT);
	}

	@Override
	public void onStop()
	{
		this.reset();
		this.plugin.setRoom(TheatreRoom.UNKNOWN);
	}

	private void reset()
	{
		bloat = null;
		bloatFlag = false;
		bloatTimer = 0;
		counter = 0;
		bloatState = BloatState.UP;
	}

	public void render(Graphics2D graphics)
	{
		if (bloat == null)
		{
			return;
		}

		if (plugin.isShowBloatIndicator())
		{
			switch (bloatState)
			{
				case DOWN:
					renderNpcOverlay(graphics, bloat, Color.GREEN, 3, 150, 0);
					break;
				case WARN:
					renderNpcOverlay(graphics, bloat, Color.YELLOW, 3, 150, 0);
					break;
				case UP:
					renderNpcOverlay(graphics, bloat, new Color(223, 109, 255), 3, 150, 0);
					break;
			}
		}

		if (plugin.isShowBloatHands())
		{
			for (GraphicsObject object : client.getGraphicsObjects())
			{
				int id = object.getId();
				if (id >= 1560 && id <= 1590)
				{
					WorldPoint point = WorldPoint.fromLocal(client, object.getLocation());
					if (!plugin.isBloatFeetIndicatorRaveEdition())
					{
						drawTile(graphics, point, new Color(36, 248, 229), 2, 255, 10);
					}
					else
					{
						drawTile(graphics, point, color, 2, 255, 10);
					}

				}
			}
		}

		if (plugin.isShowBloatTimer())
		{
			final String tickCounter = String.valueOf(bloatTimer);
			int secondConversion = (int) (bloatTimer * .6);
			if (bloat != null)
			{
				Point canvasPoint = bloat.getCanvasTextLocation(graphics, tickCounter, 60);
				if (bloatTimer <= 37)
				{
					renderTextLocation(graphics, tickCounter + "( " + secondConversion + " )", 15, Font.BOLD, Color.WHITE, canvasPoint);
				}
				else
				{
					renderTextLocation(graphics, tickCounter + "( " + secondConversion + " )", 15, Font.BOLD, Color.RED, canvasPoint);
				}
			}
		}
	}

	public void onVarbitChanged(VarbitChanged event)
	{
		if (client.getVar(Varbits.BLOAT_DOOR) == 1 && !bloatFlag)
		{
			bloatTimer = 0;
			bloatFlag = true;
		}
	}

	public void onNpcSpawned(NpcSpawned event)
	{
		NPC npc = event.getNpc();
		int id = npc.getId();

		if (id == NpcID.PESTILENT_BLOAT)
		{
			this.onStart();
			bloatTimer = 0;
			bloat = npc;
		}
	}

	public void onNpcDespawned(NpcDespawned event)
	{
		NPC npc = event.getNpc();
		int id = npc.getId();

		if (id == NpcID.PESTILENT_BLOAT)
		{
			this.onStop();
			bloatTimer = 0;
			bloat = null;
		}
	}

	public void onGameTick()
	{
		if (plugin.getRoom() != TheatreRoom.BLOAT)
		{
			return;
		}

		//Color generating code for bloat feet rave edition
		int R = (int) (Math.random() * 256);
		int G = (int) (Math.random() * 256);
		int B = (int) (Math.random() * 256);
		color = new Color(R, G, B); //random color, but can be bright or dull
		Random random = new Random();
		final float hue = random.nextFloat();
		final float saturation = 0.9f;//1.0 for brilliant, 0.0 for dull
		final float luminance = 1.0f; //1.0 for brighter, 0.0 for black
		color = Color.getHSBColor(hue, saturation, luminance);


		counter++;

		if (bloat.getAnimation() == -1)
		{
			bloatTimer++;
			counter = 0;
			if (bloat.getHealth() == 0)
			{
				bloatState = BloatState.DOWN;
			}
			else
			{
				bloatState = BloatState.UP;
			}
		}
		else
		{
			if (25 < counter && counter < 35)
			{
				bloatState = BloatState.WARN;
			}
			else if (counter < 26)
			{
				bloatTimer = 0;
				bloatState = BloatState.DOWN;
			}
			else if (bloat.getModelHeight() == 568)
			{
				bloatTimer = 0;
				bloatState = BloatState.DOWN;
			}
			else
			{
				bloatState = BloatState.UP;
			}
		}
	}

	public enum BloatState
	{
		DOWN,
		UP,
		WARN
	}
}