package net.runelite.client.plugins.raids.bats;

import com.google.inject.Inject;
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
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

public class BatsOverlay extends Overlay
{
	private RaidsPlugin plugin;
	private RaidsConfig config;
	private Client client;

	@Inject
	public BatsOverlay(RaidsConfig config, RaidsPlugin plugin, Client client)
	{
		this.config = config;
		this.plugin = plugin;
		this.client = client;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
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
				Player player = client.getLocalPlayer();
				if (player != null)
				{
					WorldPoint playerLocation = player.getWorldLocation();
					if (playerLocation != null)
					{
						if (playerLocation.distanceTo(chestLocation) <= client.getScene().getDrawDistance())
						{
							LocalPoint chestLocal = LocalPoint.fromWorld(client, chestLocation);
							if (chestLocal != null)
							{
								String index = String.valueOf(i);
								if (chestCounts[i] != 0 && chestCounts[i] == chestCounts[batsLocator.getHighestChestCountIndex()] && !batsLocator.isEqualChestCounts())
								{
									graphics.setFont(batsLocator.getHighestChestCountFont());
								}
								else
								{
									graphics.setFont(FontManager.getRunescapeSmallFont());
								}
								Point chestCanvas = Perspective.getCanvasTextLocation(client, graphics, chestLocal, index, 0);
								if (chestCanvas != null)
								{
									OverlayUtil.renderTextLocation(graphics, chestCanvas, index, chest.getState().getColor());
								}
							}
						}
					}
				}
			}
		}
		return null;
	}
}
