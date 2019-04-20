package net.runelite.client.plugins.whalewatchers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

public class WhaleWatchersSmiteableOverlay extends Overlay
{
	private Client client;
	private WhaleWatchersPlugin plugin;
	private PanelComponent panelComponent;


	@Inject
	public WhaleWatchersSmiteableOverlay( WhaleWatchersPlugin plugin)
	{
		this.plugin = plugin;
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		setPriority(OverlayPriority.HIGH);
		setPosition(OverlayPosition.BOTTOM_RIGHT);

		panelComponent = new PanelComponent();
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		String subText = "You could be smited in 1 tick";
		panelComponent.getChildren().clear();
		if (plugin.isDisplaySmiteOverlay())
		{
			panelComponent.setBackgroundColor(Color.WHITE);
			panelComponent.getChildren().add(TitleComponent.builder()
				.text("LOW PRAYER WARNING")
				.color(Color.BLACK)
				.build());
			panelComponent.getChildren().add(TitleComponent.builder()
				.text(subText)
				.color(Color.BLACK)
				.build());

			panelComponent.setPreferredSize(new Dimension(graphics.getFontMetrics().stringWidth(subText)
				+ 20 , 0));
		}
		else
		{
			panelComponent.getChildren().clear();
		}
		return panelComponent.render(graphics);
	}
}
