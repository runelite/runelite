package net.runelite.client.plugins.inferno;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

public class InfernoNibberOverlay extends Overlay
{
	private final Client client;
	private final InfernoPlugin plugin;
	private final InfernoConfig config;

	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	public InfernoNibberOverlay(Client client, InfernoConfig config, InfernoPlugin plugin)
	{
		this.client = client;
		this.config = config;
		this.plugin = plugin;
		setPosition(OverlayPosition.TOP_LEFT);
	}


	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.displayNibbaOverlay() || plugin.getNibbers().size() == 0 || client.getMapRegions()[0] != 9043)
		return null;

		panelComponent.getChildren().clear();

		panelComponent.getChildren().add(LineComponent.builder()
			.left("Nibbas Left: ")
			.right(Integer.toString(plugin.getNibbers().size()))
			.leftColor(Color.BLUE)
			.build());

		return panelComponent.render(graphics);
	}
}
