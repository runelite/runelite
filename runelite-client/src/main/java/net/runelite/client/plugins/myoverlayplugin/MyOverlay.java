package net.runelite.client.plugins.myoverlayplugin;

import java.awt.*;
import javax.inject.Inject;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

public class MyOverlay extends Overlay
{
	private MyOverlayPlugin plugin;

	private PanelComponent panelComponent = new PanelComponent();

	@Inject
	public MyOverlay(MyOverlayPlugin plugin){
		super(plugin);
		setPosition(OverlayPosition.TOP_LEFT);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics) {
		panelComponent.getChildren().clear();

		panelComponent.getChildren().add(LineComponent.builder()
		.left("Cooking Level")
		.right(Integer.toString(plugin.getCookingLevel()))
		.build());

		return panelComponent.render(graphics);
	}
}
