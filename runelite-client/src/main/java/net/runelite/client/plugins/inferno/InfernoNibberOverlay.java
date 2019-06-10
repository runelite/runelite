package net.runelite.client.plugins.inferno;

import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.table.TableAlignment;
import net.runelite.client.ui.overlay.components.table.TableComponent;

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
		TableComponent tableComponent = new TableComponent();
		tableComponent.setColumnAlignments(TableAlignment.LEFT, TableAlignment.RIGHT);

		tableComponent.addRow("Players Left: ", Integer.toString(plugin.getNibbers().size()));

		panelComponent.getChildren().add(tableComponent);

		return panelComponent.render(graphics);
	}
}
