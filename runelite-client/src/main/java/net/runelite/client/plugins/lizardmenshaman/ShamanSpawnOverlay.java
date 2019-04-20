package net.runelite.client.plugins.lizardmenshaman;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.time.Duration;
import java.time.Instant;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ProgressPieComponent;

class ShamanSpawnOverlay extends Overlay
{
	private final Client client;
	private final LizardmenShamanPlugin plugin;

	@Inject
	private ShamanSpawnOverlay(Client client, LizardmenShamanPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.client = client;
		this.plugin = plugin;
	}
	@Override
	public Dimension render(Graphics2D graphics)
	{
		plugin.getSpawns().forEach((localPoint, spawn) ->
		{
			final Instant now = Instant.now();
			final long startCountdown = Duration.between(spawn.getStart(), now).getSeconds();
			final double certainSec = spawn.getCountdownTimer() - startCountdown;

			if (certainSec <= 0)
			{
				if (spawn.getEnd() == null)
				{
					spawn.setEnd(Instant.now());
				}
			}

			final ProgressPieComponent pieComponent = new ProgressPieComponent();
			final Point loc = Perspective.localToCanvas(client, localPoint, client.getPlane());

			if (loc == null || certainSec < 0)
			{
				return;
			}

			pieComponent.setPosition(loc);
			pieComponent.setProgress(certainSec / spawn.getCountdownTimer());
			if (certainSec >  4.8)
			{
				pieComponent.setFill(Color.GREEN);
				pieComponent.setBorderColor(Color.GREEN);
				pieComponent.render(graphics);
			}
			else if (certainSec > 3.6)
			{
				pieComponent.setFill(Color.YELLOW);
				pieComponent.setBorderColor(Color.YELLOW);
				pieComponent.render(graphics);
			}
			else if (certainSec > 2.4)
			{
				pieComponent.setFill(Color.ORANGE);
				pieComponent.setBorderColor(Color.ORANGE);
				pieComponent.render(graphics);
			}
			else if (certainSec > 1.2)
			{
				pieComponent.setFill(new Color(255, 140, 0));
				pieComponent.setBorderColor(new Color(255, 140, 0));
				pieComponent.render(graphics);
			}
			else
			{
				pieComponent.setFill(Color.RED);
				pieComponent.setBorderColor(Color.RED);
				pieComponent.render(graphics);
			}
		});
		return null;
	}
}
