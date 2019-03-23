package net.runelite.client.plugins.masterfarmer;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.text.DecimalFormat;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import java.text.NumberFormat;

public class MasterFarmerOverlay extends Overlay
{

	private final Client client;
	private final MasterFarmerPlugin plugin;
	private final MasterFarmerConfig config;

	NumberFormat format = new DecimalFormat("#");

	int MASTER_FARMER_RESPAWN_TIME = 300;

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
			plugin.getMasterFarmers().forEach((id, npc) -> renderTimer(npc, graphics));
		}
		return null;
	}

	private void renderTimer(final MasterFarmerNPC npc, final Graphics2D graphics)
	{
		double timeLeft = MASTER_FARMER_RESPAWN_TIME - npc.getTimeWithoutMoving();

		if (timeLeft < 0)
		{
			timeLeft = 0;
		}

		final String timeLeftString = String.valueOf(format.format(timeLeft));

		final Point canvasPoint = npc.getNpc().getCanvasTextLocation(graphics, timeLeftString, npc.getNpc().getLogicalHeight() + config.timerHeight());

		if (canvasPoint != null && (config.maxDisplay() >= timeLeft))
		{
			OverlayUtil.renderTextLocation(graphics, canvasPoint, timeLeftString, config.timerColor());
		}
	}

}
