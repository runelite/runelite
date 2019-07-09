package net.runelite.client.plugins.theatre;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.Map;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.Projectile;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.OverlayUtil;

public abstract class RoomHandler
{

	protected final Client client;
	protected final TheatrePlugin plugin;

	protected RoomHandler(final Client client, final TheatrePlugin plugin)
	{
		this.client = client;
		this.plugin = plugin;
	}

	public abstract void onStart();

	public abstract void onStop();

	protected void drawTile2(Graphics2D graphics, WorldPoint point, Color color, int strokeWidth, int outlineAlpha, int fillAlpha)
	{
		WorldPoint playerLocation = client.getLocalPlayer().getWorldLocation();
		if (point.distanceTo(playerLocation) >= 32)
		{
			return;
		}
		LocalPoint lp = LocalPoint.fromWorld(client, point);
		if (lp == null)
		{
			return;
		}

		Polygon poly = Perspective.getCanvasTileAreaPoly(client, lp, 7);
		if (poly == null)
		{
			return;
		}
		//OverlayUtil.renderPolygon(graphics, poly, color);
		OverlayUtil.drawStrokeAndFillPoly(graphics, color, strokeWidth, outlineAlpha, fillAlpha, poly);

	}

	protected void renderProjectiles(Graphics2D graphics, Map<Projectile, String> projectiles)
	{
		for (Map.Entry<Projectile, String> entry : projectiles.entrySet())
		{
			int projectileId = entry.getKey().getId();
			String text = entry.getValue();
			int x = (int) entry.getKey().getX();
			int y = (int) entry.getKey().getY();
			LocalPoint projectilePoint = new LocalPoint(x, y);
			Point textLocation = Perspective.getCanvasTextLocation(client, graphics, projectilePoint, text, 0);
			if (textLocation != null)
			{
				if (projectileId == 1607)
				{ // range
					renderTextLocation(graphics, text, 17, Font.BOLD, new Color(57, 255, 20, 255), textLocation);
				}
				else if (projectileId == 1606)
				{ //mage
					renderTextLocation(graphics, text, 17, Font.BOLD, new Color(64, 224, 208, 255), textLocation);
				}
				else
				{ //Orb of death? i hope
					renderTextLocation(graphics, text, 20, Font.BOLD, Color.WHITE, textLocation);
				}
			}
		}
	}

	protected void drawTile(Graphics2D graphics, WorldPoint point, Color color, int strokeWidth, int outlineAlpha, int fillAlpha)
	{
		WorldPoint playerLocation = client.getLocalPlayer().getWorldLocation();

		OverlayUtil.drawTiles(graphics, client, point, playerLocation, color, strokeWidth, outlineAlpha, fillAlpha);
	}

	protected void renderNpcOverlay(Graphics2D graphics, NPC actor, Color color, int outlineWidth, int outlineAlpha, int fillAlpha)
	{
		OverlayUtil.renderNpcOverlay(graphics, actor, color, outlineWidth, outlineAlpha, fillAlpha, client);
	}

	protected void renderTextLocation(Graphics2D graphics, String txtString, int fontSize, int fontStyle, Color fontColor, Point canvasPoint)
	{
		graphics.setFont(new Font("Arial", fontStyle, fontSize));
		if (canvasPoint != null)
		{
			final Point canvasCenterPoint = new Point(canvasPoint.getX(), canvasPoint.getY());
			final Point canvasCenterPointShadow = new Point(canvasPoint.getX() + 1, canvasPoint.getY() + 1);

			OverlayUtil.renderTextLocation(graphics, canvasCenterPointShadow, txtString, Color.BLACK);
			OverlayUtil.renderTextLocation(graphics, canvasCenterPoint, txtString, fontColor);
		}
	}

	protected String twoDigitString(long number)
	{

		if (number == 0)
		{
			return "00";
		}

		if (number / 10 == 0)
		{
			return "0" + number;
		}

		return String.valueOf(number);
	}
}