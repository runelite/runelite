package net.runelite.client.plugins.inferno;

import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.table.TableAlignment;
import net.runelite.client.ui.overlay.components.table.TableComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

public class InfernoInfobox extends Overlay
{
	private final Client client;
	private final InfernoPlugin plugin;
	private final InfernoConfig config;

	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	public InfernoInfobox(Client client, InfernoConfig config, InfernoPlugin plugin)
	{
		this.client = client;
		this.config = config;
		this.plugin = plugin;
		setPosition(OverlayPosition.TOP_LEFT);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.showPrayerHelp() || client.getMapRegions()[0] != 9043) return null;

		panelComponent.getChildren().clear();
		TableComponent tableComponent = new TableComponent();
		tableComponent.setColumnAlignments(TableAlignment.LEFT, TableAlignment.RIGHT);

		for (int i = plugin.getPriorityNPC().length; i > 0; i--)
		{
			if (plugin.getPriorityNPC()[i - 1] == null)
			{
				tableComponent.addRow(Integer.toString(i), "-");
			}
			else
			{
				tableComponent.addRow(plugin.getPriorityNPC()[i - 1].getName(), plugin.getPriorityNPC()[i - 1 ].getAttackstyle().getName());
			}
		}

		panelComponent.getChildren().add(tableComponent);
		return panelComponent.render(graphics);
	}
}
