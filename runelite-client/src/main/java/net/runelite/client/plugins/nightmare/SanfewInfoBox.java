package net.runelite.client.plugins.nightmare;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import net.runelite.api.Client;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.ImageComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

@Singleton
public class SanfewInfoBox extends Overlay
{
	private final Client client;
	private final NightmarePlugin plugin;
	private final NightmareConfig config;
	private final ItemManager itemManager;
	private final PanelComponent imagePanelComponent = new PanelComponent();

	@Inject
	private SanfewInfoBox(final Client client, final NightmarePlugin plugin, final ItemManager itemManager, final NightmareConfig config)
	{
		this.client = client;
		this.plugin = plugin;
		this.itemManager = itemManager;
		this.config = config;

		setLayer(OverlayLayer.ABOVE_WIDGETS);
		setPriority(OverlayPriority.HIGH);
		setPosition(OverlayPosition.BOTTOM_RIGHT);
	}

	public Dimension render(Graphics2D graphics)
	{
		imagePanelComponent.getChildren().clear();

		if (!plugin.isInFight() || !plugin.isParasite() || !config.sanfewReminder())
		{
			return null;
		}

		BufferedImage sanfewImage = itemManager.getImage(10925);
		imagePanelComponent.setBackgroundColor(new Color(150, 0, 0, 150));

		imagePanelComponent.getChildren().add(new ImageComponent(sanfewImage));
		return imagePanelComponent.render(graphics);
	}
}
