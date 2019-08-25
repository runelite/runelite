package net.runelite.client.plugins.clanmanmode;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

@Singleton
public class ClanManModeTileOverlay extends Overlay
{
	private final ClanManModeService ClanManModeService;
	private final ClanManModeConfig config;

	@Inject
	private ClanManModeTileOverlay(final ClanManModeConfig config, final ClanManModeService ClanManModeService)
	{
		this.config = config;
		this.ClanManModeService = ClanManModeService;
		setLayer(OverlayLayer.ABOVE_SCENE);
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.MED);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.drawTiles())
		{
			return null;
		}

		ClanManModeService.forEachPlayer((player, color) ->
		{
			final Polygon poly = player.getCanvasTilePoly();

			if (poly != null)
			{
				OverlayUtil.renderPolygon(graphics, poly, color);
			}
		});

		return null;
	}
}
