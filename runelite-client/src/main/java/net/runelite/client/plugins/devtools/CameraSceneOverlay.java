package net.runelite.client.plugins.devtools;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

class CameraSceneOverlay extends Overlay
{
	private final Client client;
	private final DevToolsPlugin plugin;

	@Inject
	CameraSceneOverlay(Client client, DevToolsPlugin plugin)
	{
		this.client = client;
		this.plugin = plugin;
		setLayer(OverlayLayer.ABOVE_SCENE);
		setPosition(OverlayPosition.DYNAMIC);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.getCameraPosition().isActive())
		{
			return null;
		}

		final int cameraX = client.getCameraX();
		final int cameraZ = client.getCameraY();

		Polygon canvasTilePoly = Perspective.getCanvasTilePoly(client, LocalPoint.fromScene(cameraX / 128, cameraZ / 128));
		if (canvasTilePoly != null)
		{
			graphics.draw(canvasTilePoly);
		}

		return null;
	}
}
