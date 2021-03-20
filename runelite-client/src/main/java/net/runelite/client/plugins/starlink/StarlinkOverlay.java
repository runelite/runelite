package net.runelite.client.plugins.starlink;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

public class StarlinkOverlay extends Overlay
{

	private final Client client;
	private final ShootingStars shootingStars;

	@Inject
	public StarlinkOverlay(Client client, ShootingStars shootingStars)
	{
		this.client = client;
		this.shootingStars = shootingStars;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.UNDER_WIDGETS);
		setPriority(OverlayPriority.MED);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		CrashedStar crashedStar = shootingStars.getCrashedStar();
		if (crashedStar != null && crashedStar.getWorldPoint().isInScene(client))
		{
			LocalPoint location = LocalPoint.fromWorld(client, crashedStar.getWorldPoint());

			if (location == null)
			{
				return null;
			}
			graphics.setFont(FontManager.getRunescapeBoldFont());
			String text = "T" + crashedStar.getTier();
			location = new LocalPoint(location.getX() + 64, location.getY() + 64);
			Point point = Perspective.getCanvasTextLocation(client, graphics, location, text, 60);

			if (point != null)
			{
				graphics.setColor(Color.ORANGE);
				OverlayUtil.renderTextLocation(graphics, point, text, Color.ORANGE);
			}
		}
		return null;
	}
}
