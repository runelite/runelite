package net.runelite.client.plugins.raids.bats;

import com.google.inject.Inject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.raids.RaidsConfig;
import net.runelite.client.plugins.raids.RaidsPlugin;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.ProgressPieComponent;

public class BatsOverlay extends Overlay
{
	private RaidsPlugin plugin;
	private RaidsConfig config;
	private Client client;
	private ProgressPieComponent pie = new ProgressPieComponent();

	@Inject
	public BatsOverlay(RaidsConfig config, RaidsPlugin plugin, Client client)
	{
		this.config = config;
		this.plugin = plugin;
		this.client = client;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		pie.setProgress(100);
		pie.setBorderColor(Color.black);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		Player player = client.getLocalPlayer();
		WorldPoint playerLocation = player == null ? null : player.getWorldLocation();

		if (playerLocation == null)
		{
			return null;
		}

		BatsLocator batsLocator = plugin.getBatsLocator();
		if (config.enableBatsLocator() && plugin.isInRaidChambers() && batsLocator.isDrawChestNumbers())
		{
			int[] chestCounts = batsLocator.getChestCounts();
			int i = -1;
			for (WorldPoint chestLocation : batsLocator.getChestLocations())
			{
				i++;
				Chest chest = batsLocator.getChestMap().get(chestLocation);
				if (chest.getState() == Chest.State.GRUBS)
				{
					continue;
				}
				if (playerLocation.distanceTo(chestLocation) <= client.getScene().getDrawDistance())
				{
					LocalPoint chestLocal = LocalPoint.fromWorld(client, chestLocation);
					if (chestLocal != null)
					{
						Point chestCanvas = Perspective.localToCanvas(client, chestLocal, client.getPlane());
						if (chestCanvas != null)
						{
							if (batsLocator.getSolutionSets().size() == 0 && (chest.getState() == Chest.State.POISON || chest.getState() == Chest.State.BATS))
							{
								OverlayUtil.renderTextLocation(graphics, chestCanvas, String.valueOf(i), chest.getState().getColor());
							}
							else
							{
								Color color;
								if (batsLocator.getHighestChestCountIndex() != -1 && chestCounts[i] != 0 && chestCounts[i] == chestCounts[batsLocator.getHighestChestCountIndex()])
								{
									pie.setDiameter(12);
									color = new Color(chest.getState().getColor().getRed(), chest.getState().getColor().getGreen(), chest.getState().getColor().getBlue(), 255);
								}
								else
								{
									pie.setDiameter(9);
									color = new Color(chest.getState().getColor().getRed(), chest.getState().getColor().getGreen(), chest.getState().getColor().getBlue(), 75);
								}
								pie.setFill(color);
								pie.setPosition(new Point(chestCanvas.getX(), chestCanvas.getY()));
								pie.render(graphics);
							}
						}
					}
				}
			}
		}
		return null;
	}
}
