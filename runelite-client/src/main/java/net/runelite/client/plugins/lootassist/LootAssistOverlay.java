package net.runelite.client.plugins.lootassist;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.text.DecimalFormat;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

@Singleton
public class LootAssistOverlay extends Overlay
{
	private final Client client;
	private final DecimalFormat d = new DecimalFormat("##.#");

	@Inject
	public LootAssistOverlay(final Client client)
	{
		this.client = client;
		setLayer(OverlayLayer.ABOVE_SCENE);
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.MED);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		for (Map.Entry<WorldPoint, LootPile> entry : LootAssistPlugin.lootPiles.entrySet())
		{
			WorldPoint localPoint = entry.getKey();
			LootPile pile = entry.getValue();
			int x;
			int y;
			LocalPoint lp = LocalPoint.fromWorld(client, pile.getLocation());
			if (lp != null)
			{
				x = lp.getSceneX();
				y = lp.getSceneY();
			}
			else
			{
				continue;
			}

			if (!localPoint.isInScene(client))
			{
				continue;
			}

			int timeRemaining = (int) ((pile.getTimeAppearing() - System.currentTimeMillis()) / 1000);

			if (timeRemaining < 0)
			{
				LootAssistPlugin.lootPiles.remove(localPoint);
				client.clearHintArrow();
			}
			else
			{
				String nameOverlay = pile.getPlayerName();
				String timeOverlay = d.format((pile.getTimeAppearing() - System.currentTimeMillis()) / 1000f);
				final Polygon poly = Perspective.getCanvasTilePoly(client,
					client.getScene().getTiles()[client.getPlane()][x][y].getLocalLocation());
				if (poly != null)
				{
					Point textLoc = Perspective.getCanvasTextLocation(client, graphics, lp,
						nameOverlay, graphics.getFontMetrics().getHeight() * 7);
					Point timeLoc = Perspective.getCanvasTextLocation(client, graphics, lp,
						timeOverlay, graphics.getFontMetrics().getHeight());
					OverlayUtil.renderPolygon(graphics, poly, Color.WHITE);
					if (timeRemaining < 5 && timeRemaining > 0)
					{
						OverlayUtil.renderTextLocation(graphics, timeLoc, timeOverlay, Color.RED);
						OverlayUtil.renderTextLocation(graphics, textLoc, nameOverlay, Color.RED);
					}
					else if (timeRemaining <= 60)
					{
						OverlayUtil.renderTextLocation(graphics, timeLoc, timeOverlay, Color.WHITE);
						OverlayUtil.renderTextLocation(graphics, textLoc, nameOverlay, Color.WHITE);
					}
					if (timeRemaining < 2)
					{
						client.setHintArrow(WorldPoint.fromLocal(client, lp));
					}


				}
			}
		}
		return null;
	}
}
