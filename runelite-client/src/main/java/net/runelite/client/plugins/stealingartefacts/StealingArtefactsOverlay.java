package net.runelite.client.plugins.stealingartefacts;

import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

import javax.inject.Inject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;


public class StealingArtefactsOverlay extends Overlay
{
	private final StealingArtefactsPlugin plugin;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	private StealingArtefactsOverlay(StealingArtefactsPlugin plugin)
	{
		super(plugin);
		setPosition(OverlayPosition.TOP_LEFT);
		setPriority(OverlayPriority.LOW);
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{

		panelComponent.getChildren().clear();

		StealingArtefactState stealingArtefactState = plugin.getStealingArtefactState();

		if (!plugin.isInPortPiscariliusRegion() || stealingArtefactState == null)
		{
			return null;
		}

		panelComponent.getChildren().add(TitleComponent.builder()
			.text("Stealing Artefacts")
			.color(Color.WHITE)
			.build());

		panelComponent.getChildren().add(TitleComponent.builder()
			.text(stealingArtefactState.getDescription())
			.color(stealingArtefactState.getColor())
			.build());

		return panelComponent.render(graphics);
	}
}
