package net.runelite.client.plugins.inferno;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import lombok.AccessLevel;
import lombok.Setter;
import static net.runelite.client.plugins.inferno.InfernoWaveMappings.addWaveComponent;
import net.runelite.client.plugins.inferno.displaymodes.InfernoWaveDisplayMode;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.PanelComponent;

@Singleton
public class InfernoWaveOverlay extends Overlay
{
	private final InfernoPlugin plugin;
	private final InfernoConfig config;
	private final PanelComponent panelComponent;

	@Setter(AccessLevel.PACKAGE)
	private Color waveHeaderColor;

	@Setter(AccessLevel.PACKAGE)
	private Color waveTextColor;

	@Setter(AccessLevel.PACKAGE)
	private InfernoWaveDisplayMode displayMode;

	@Inject
	InfernoWaveOverlay(final InfernoPlugin plugin, final InfernoConfig config)
	{
		this.plugin = plugin;
		this.config = config;
		this.panelComponent = new PanelComponent();
		determineLayer();
		setPosition(OverlayPosition.TOP_RIGHT);
		setPriority(OverlayPriority.HIGH);
		panelComponent.setPreferredSize(new Dimension(160, 0));
	}

	public Dimension render(final Graphics2D graphics)
	{
		panelComponent.getChildren().clear();

		if (displayMode == InfernoWaveDisplayMode.CURRENT ||
			displayMode == InfernoWaveDisplayMode.BOTH)
		{
			addWaveComponent(
				config,
				panelComponent,
				"Current Wave (Wave " + plugin.getCurrentWaveNumber() + ")",
				plugin.getCurrentWaveNumber(),
				waveHeaderColor,
				waveTextColor
			);
		}

		if (displayMode == InfernoWaveDisplayMode.NEXT ||
			displayMode == InfernoWaveDisplayMode.BOTH)
		{
			addWaveComponent(
				config,
				panelComponent,
				"Next Wave (Wave " + plugin.getNextWaveNumber() + ")",
				plugin.getNextWaveNumber(),
				waveHeaderColor,
				waveTextColor
			);
		}

		return panelComponent.render(graphics);
	}

	public void determineLayer()
	{

	}
}
