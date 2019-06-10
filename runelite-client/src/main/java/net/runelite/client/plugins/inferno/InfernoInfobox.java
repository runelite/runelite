package net.runelite.client.plugins.inferno;

import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
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

		for (int i = plugin.getPriorityNPC().length; i > 0; i--)
		{
			if (plugin.getPriorityNPC()[i-1] == null)
			{
				panelComponent.getChildren().add(LineComponent.builder()
					.left(Integer.toString(i))
					.right("-")
					.build());
			}
			else
			{
				panelComponent.getChildren().add(LineComponent.builder()
					.left(plugin.getPriorityNPC()[i-1].getName())
					.right(plugin.getPriorityNPC()[i-1].getAttackstyle().getName())
					.rightColor(plugin.getPriorityNPC()[i-1].getAttackstyle().getColor())
					.build());
			}
		}

		return panelComponent.render(graphics);
	}
}
