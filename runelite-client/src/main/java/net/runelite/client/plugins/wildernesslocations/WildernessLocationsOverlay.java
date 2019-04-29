package net.runelite.client.plugins.wildernesslocations;

import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.TextComponent;

public class WildernessLocationsOverlay extends Overlay
{
	private final WildernessLocationsPlugin plugin;
	private TextComponent textComponent;

	@Inject
	public WildernessLocationsOverlay(Client client, WildernessLocationsPlugin plugin)
	{
		this.plugin = plugin;
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		setPriority(OverlayPriority.HIGH);
		setPosition(OverlayPosition.BOTTOM_RIGHT);
		textComponent = new TextComponent();

	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (plugin.isRenderLocation())
		{
			textComponent.setText(plugin.getLocationString());
			return textComponent.render(graphics);
		}
		return null;
	}
}
