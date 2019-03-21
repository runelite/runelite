package net.runelite.client.plugins.masterfarmer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.Instant;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.widgets.Widget;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.ProgressPieComponent;

public class MasterFarmerOverlay extends Overlay
{

	private static final NumberFormat TIME_LEFT_FORMATTER = DecimalFormat.getInstance(Locale.US);

	static
	{
		((DecimalFormat)TIME_LEFT_FORMATTER).applyPattern("");
	}

	private final Client client;
	private final MasterFarmerPlugin plugin;
	private final MasterFarmerConfig config;

	@Inject
	MasterFarmerOverlay(Client client, MasterFarmerPlugin plugin, MasterFarmerConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.plugin = plugin;
		this.config = config;
		this.client = client;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{

		if (config.showOverlay())
		{
			for (NPC npc : client.getNpcs())
			{
				final String npcName = npc.getName();

				if (npcName == null)
				{
					continue;
				}

				if (npc.getId() == 3257)
				{
					final MasterFarmerNPC mf = plugin.getMasterfarmers().get(npc.getIndex());

					if (mf != null)
					{
						renderTimer(mf, graphics);
					}
				}
			}
		}

		return null;
	}

	private void renderTimer(final MasterFarmerNPC npc, final Graphics2D graphics)
	{
		final WorldPoint npcWorldPoint = npc.getCurrentLocation();

		final LocalPoint npcLocalPoint = LocalPoint.fromWorld(client, npcWorldPoint.getX(), npcWorldPoint.getY());

		if (npcLocalPoint == null)
		{
			return;
		}

		LocalPoint playerLocation = client.getLocalPlayer().getLocalLocation();

		if (playerLocation == null)
		{
			return;
		}

		final double timeLeft = Math.max(0.0, (300 - npc.getTimeWithoutMoving()));

		final String timeLeftString = TIME_LEFT_FORMATTER.format(timeLeft);

		final Point canvasPoint = npc.getNpc().getCanvasTextLocation(graphics, timeLeftString, npc.getNpc().getLogicalHeight() + config.timerHeight());

		if (canvasPoint != null && (config.maxDisplay() >= timeLeft))
		{
			OverlayUtil.renderTextLocation(graphics, canvasPoint, timeLeftString, config.timerColor());
		}
	}

}
