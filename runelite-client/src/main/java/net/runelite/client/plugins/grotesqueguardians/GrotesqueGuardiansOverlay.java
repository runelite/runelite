package net.runelite.client.plugins.grotesqueguardians;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GraphicsObject;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

public class GrotesqueGuardiansOverlay extends Overlay
{
	private final Client client;
	private final GrotesqueGuardiansConfig config;

	@Inject
	private GrotesqueGuardiansOverlay(Client client, GrotesqueGuardiansConfig config)
	{
		this.client = client;
		this.config = config;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		setPriority(OverlayPriority.LOW);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		for (GraphicsObject graphicsObject : client.getGraphicsObjects())
		{
			LocalPoint lp = graphicsObject.getLocation();
			Polygon poly = Perspective.getCanvasTilePoly(client, lp);
			Color color = null;
			String text = "";

			if (poly == null)
			{
				return null;
			}

			if (config.displayLightning())
			{
				if (graphicsObject.getId() >= 1416 && graphicsObject.getId() <= 1431)
				{
					color = config.lightningColor();

					if (config.displayTextOverlays())
					{
						text = "Lightning";
					}
				}
			}

			if (config.displayStoneOrb())
			{
				if (graphicsObject.getId() == 160)
				{
					color = config.stoneOrbColor();

					if (config.displayTextOverlays())
					{
						text = "Stone Orb";
					}
				}
			}

			if (config.displayFallingRocks())
			{
				if (graphicsObject.getId() == 1436)
				{
					color = config.fallingRocksColor();

					if (config.displayTextOverlays())
					{
						text = "Falling Rocks";
					}
				}
			}

			if (color != null)
			{
				OverlayUtil.renderPolygon(graphics, poly, color);

				Point textLocation = Perspective.getCanvasTextLocation(client, graphics, lp, text, 0);

				if (textLocation != null)
				{
					OverlayUtil.renderTextLocation(graphics, textLocation, text, color);
				}
			}
		}
		return null;
	}
}
