package net.runelite.client.plugins.runecraft;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ComponentOrientation;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

@Singleton
public class RunecraftOverlay extends Overlay
{
	private final RunecraftPlugin plugin;
	private final PanelComponent panel = new PanelComponent();

	@Inject
	RunecraftOverlay(final RunecraftPlugin plugin)
	{
		this.plugin = plugin;
		setPosition(OverlayPosition.CANVAS_TOP_RIGHT);
		panel.setOrientation(ComponentOrientation.VERTICAL);
	}

	public Dimension render(Graphics2D graphics)
	{
		String text = "Pouch Has Degraded";
		panel.getChildren().clear();
		if (plugin.isDegradedPouchInInventory())
		{
			panel.getChildren().add(TitleComponent.builder()
				.text("Pouch Has Degraded")
				.color(Color.red)
				.build());
			panel.setPreferredSize(new Dimension(graphics.getFontMetrics().stringWidth(text) + 5, 5));
			return panel.render(graphics);
		}
		else
		{
			return null;
		}
	}
}
