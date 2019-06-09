package net.runelite.client.plugins.theatre;

import net.runelite.api.*;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.OverlayUtil;
import java.awt.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class RoomHandler 
{

	protected final Client client;
	protected final TheatrePlugin plugin;
	protected final TheatreConfig config;

	public RoomHandler(Client client, TheatrePlugin plugin, TheatreConfig config)
	{
		this.client = client;
		this.plugin = plugin;
		this.config = config;
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
		graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), outlineAlpha));
		graphics.setStroke(new BasicStroke(strokeWidth));
		graphics.draw(poly);
		graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), fillAlpha));
		graphics.fill(poly);

	}

	protected void renderProjectiles(Graphics2D graphics, Map<Projectile, String> projectiles)
	{

		Iterator<Map.Entry<Projectile, String>> itr = projectiles.entrySet().iterator();
		while (itr.hasNext())
		{
			Map.Entry<Projectile, String> entry = itr.next();
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

		if (point.distanceTo(playerLocation) >= 32)
			return;

		LocalPoint lp = LocalPoint.fromWorld(client, point);
		if (lp == null)
			return;

		Polygon poly = Perspective.getCanvasTilePoly(client, lp);
		if (poly == null)
			return;

		graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), outlineAlpha));
		graphics.setStroke(new BasicStroke(strokeWidth));
		graphics.draw(poly);
		graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), fillAlpha));
		graphics.fill(poly);
	}

	protected void renderNpcOverlay(Graphics2D graphics, NPC actor, Color color, int outlineWidth, int outlineAlpha, int fillAlpha) 
	{
		int size = 1;

		NPCDefinition composition = actor.getTransformedDefinition();
		if (composition != null)
			size = composition.getSize();

		LocalPoint lp = actor.getLocalLocation();
		Polygon tilePoly = Perspective.getCanvasTileAreaPoly(client, lp, size);

		if (tilePoly != null)
		{
			graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), outlineAlpha));
			graphics.setStroke(new BasicStroke(outlineWidth));
			graphics.draw(tilePoly);
			graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), fillAlpha));
			graphics.fill(tilePoly);
		}
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

	protected List<WorldPoint> getHitSquares(WorldPoint npcLoc, int npcSize, int thickness, boolean includeUnder)
	{
		List<WorldPoint> little = new WorldArea(npcLoc, npcSize, npcSize).toWorldPointList();
		List<WorldPoint> big = new WorldArea(npcLoc.getX() - thickness, npcLoc.getY() - thickness, npcSize + (thickness * 2), npcSize + (thickness * 2), npcLoc.getPlane()).toWorldPointList();

		if (!includeUnder)
		{
			for (Iterator<WorldPoint> it = big.iterator(); it.hasNext(); )
			{
				WorldPoint p = it.next();
				if (little.contains(p))
				{
					it.remove();
				}
			}
		}

		return big;
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