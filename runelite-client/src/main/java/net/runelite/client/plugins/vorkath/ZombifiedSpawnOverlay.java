package net.runelite.client.plugins.vorkath;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

public class ZombifiedSpawnOverlay extends Overlay
{
	private VorkathPlugin plugin;

	@Inject
	public ZombifiedSpawnOverlay(VorkathPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (plugin.getSpawn() != null)
		{
			ZombifiedSpawn spawn = plugin.getSpawn();
			OverlayUtil.renderActorOverlayImage(graphics, spawn.getNpc(), VorkathPlugin.ICE, Color.green, 10);
		}

		return null;
	}
}