package net.runelite.client.plugins.inferno;

import java.util.HashMap;
import java.util.Map;
import com.google.inject.Inject;
import net.runelite.client.ui.overlay.components.TitleComponent;
import java.awt.Graphics2D;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayPosition;
import java.awt.Dimension;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;

public class InfernoWaveOverlay extends Overlay
	{
	private final Client client;
	private final InfernoPlugin plugin;
	private final InfernoConfig config;
	private PanelComponent panelComponent;

	@Inject
	InfernoWaveOverlay(final Client client, final InfernoPlugin plugin, final InfernoConfig config)
		{
			(this.panelComponent = new PanelComponent()).setPreferredSize(new Dimension(150, 0));
			this.setPosition(OverlayPosition.TOP_RIGHT);
			this.setPriority(OverlayPriority.HIGH);
			this.client = client;
			this.plugin = plugin;
			this.config = config;
		}

	public Dimension render(final Graphics2D graphics)
		{
			if (!plugin.inInferno() || plugin.getCurrentWaveNumber() == 0)
				{
				return null;
				}
			panelComponent.getChildren().clear();
			if (config.waveDisplay() == InfernoWaveDisplayMode.CURRENT
					|| config.waveDisplay() == InfernoWaveDisplayMode.BOTH)
				{
				renderWave("Current Wave (Wave " + plugin.getCurrentWaveNumber() + ")", plugin.getCurrentWaveNumber());
				}
			if ((config.waveDisplay() == InfernoWaveDisplayMode.NEXT
					|| config.waveDisplay() == InfernoWaveDisplayMode.BOTH)
					&& plugin.isNotFinalWave())
				{
				renderWave("Next Wave (Wave " + plugin.getNextWaveNumber()  + ")", plugin.getCurrentWaveNumber());
				}
			return panelComponent.render(graphics);
		}

	private void renderWave(final String header, final int waveNumber)
		{
			panelComponent.getChildren().add(TitleComponent.builder().text(header).color(config.getWaveOverlayHeaderColor()).build());
			final HashMap<Integer, Integer> waveMap = (HashMap<Integer, Integer>) InfernoWaveMappings.intArrayToHashmap(plugin.getWaves().get(waveNumber));
			for (final Map.Entry<Integer, Integer> entry : waveMap.entrySet())
				{
				final int monsterID = entry.getKey();
				final int quantity = entry.getValue();
				if (quantity <= 0)
					{
					continue;
					}
				panelComponent.getChildren().add(TitleComponent.builder().text(quantity + "x " + plugin.getMonster().get(monsterID)).color(config.getWaveTextColor()).build());
				}
		}
	}
