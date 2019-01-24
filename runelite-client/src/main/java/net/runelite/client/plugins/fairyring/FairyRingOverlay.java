package net.runelite.client.plugins.fairyring;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

public class FairyRingOverlay extends Overlay
{

	private static final int OBJECT_INTERACTION_FAR = 35; // Max distance, in tiles, from camera
	private static final int FUDGE_FACTOR = 8; // Can't seem to exactly replicate the distance check in ClickboxMixin

	private Client client;
	private final FairyRingPlugin plugin;
	private final FairyRingConfig config;

	@Inject
	private FairyRingOverlay(Client client, FairyRingPlugin plugin ,FairyRingConfig config)
	{
		super(plugin);
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		Point mousePosition = client.getMouseCanvasPosition();
		plugin.getRings().forEach((object, tile) -> {
			if (Rings.FAIRY_RING_IDS.contains(object.getId()) && !config.highlightRings())
			{
				return;
			}

			final LocalPoint cameraPoint = new LocalPoint(client.getCameraX(), client.getCameraY());
			int distance = object.getLocalLocation().distanceTo(cameraPoint);
			if (tile.getPlane() == client.getPlane() &&
					(distance <= (OBJECT_INTERACTION_FAR - FUDGE_FACTOR) * Perspective.LOCAL_TILE_SIZE))
			{
				Area objectClickbox = object.getClickbox();
				if (objectClickbox != null)
				{
					Color configColor = config.getOverlayColor();
					if (objectClickbox.contains(mousePosition.getX(), mousePosition.getY()))
					{
						graphics.setColor(configColor.darker());
					}
					else
					{
						graphics.setColor(configColor);
					}

					graphics.draw(objectClickbox);
					graphics.setColor(new Color(configColor.getRed(), configColor.getGreen(), configColor.getBlue(), 50));
					graphics.fill(objectClickbox);
				}
			}
		});

		return null;
	}

}
