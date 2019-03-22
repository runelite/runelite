package net.runelite.client.plugins.masterfarmer;

import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Point;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

public class MasterFarmerOverlay extends Overlay
{

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

				if (npc.getId() == 3257 || npc.getId() == 3258)
				{
					final MasterFarmerNPC mf = plugin.getMasterFarmers().get(npc.getIndex());

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
		double timeLeft = 300 - npc.getTimeWithoutMoving();

		if (timeLeft < 0)
		{
			timeLeft = 0;
		}

		final String timeLeftString = String.valueOf(timeLeft);

		final Point canvasPoint = npc.getNpc().getCanvasTextLocation(graphics, timeLeftString, npc.getNpc().getLogicalHeight() + config.timerHeight());

		if (canvasPoint != null && (config.maxDisplay() >= timeLeft))
		{
			OverlayUtil.renderTextLocation(graphics, canvasPoint, timeLeftString, config.timerColor());
		}
	}

}
