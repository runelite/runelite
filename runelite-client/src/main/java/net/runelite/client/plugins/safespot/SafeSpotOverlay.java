/*
 *
 *  Copyright (c) 2019. PKLite
 *   Redistributions and modifications of this software are permitted as long as this notice remains in its original unmodified state at the top of this file. If there are any questions, comments, or feedback about this software, please direct all inquiries directly to the following authors.
 *   PKLite discord: https://discord.gg/Dp3HuFM
 *  Written by PKLite(ST0NEWALL, others) <stonewall@stonewall@pklite.xyz>, 2019
 *
 */

package net.runelite.client.plugins.safespot;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

@Singleton
public class SafeSpotOverlay extends Overlay
{

	private final Client client;
	private final SafeSpotPlugin safeSpotPlugin;

	@Inject
	public SafeSpotOverlay(final Client client, final SafeSpotPlugin safeSpotPlugin)
	{
		this.client = client;
		this.safeSpotPlugin = safeSpotPlugin;
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.LOW);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (safeSpotPlugin.isSafeSpotsRenderable() && safeSpotPlugin.getSafeSpotList() != null && safeSpotPlugin.getSafeSpotList().size() > 0)
		{
			safeSpotPlugin.getSafeSpotList().forEach(tile ->
			{
				if (tile != null && tile.getLocalLocation() != null)
				{
					final Polygon poly = Perspective.getCanvasTilePoly(client, tile.getLocalLocation());
					if (poly != null)
					{
						OverlayUtil.renderPolygon(graphics, poly, safeSpotPlugin.getTileColor());
					}
				}
			});
		}
		return null;
	}
}