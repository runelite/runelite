package net.runelite.client.plugins.hydra;

import java.awt.*;
import javax.inject.Inject;

import net.runelite.api.*;
import net.runelite.api.Point;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.*;
import net.runelite.client.ui.overlay.components.PanelComponent;

public class HydraOverlay extends Overlay {
	private final HydraConfig config;
	private final HydraPlugin plugin;
	private final PanelComponent panelComponent = new PanelComponent();


	@Inject
	private Client client;

	@Inject
	private HydraOverlay(HydraConfig config, HydraPlugin plugin) {
		this.config = config;
		this.plugin = plugin;
		setLayer(OverlayLayer.ABOVE_SCENE);
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.MED);
		panelComponent.setPreferredSize(new Dimension(150, 0));
	}

	@Override
	public Dimension render(Graphics2D graphics) {
		if (!config.TextIndicator()) {
			return null;
		}

		for (NPC hydra : client.getNpcs()) {
			if (hydra == null || hydra.getName() == null) {
				continue;
			}
			if (hydra.getName().equalsIgnoreCase("Hydra")) {
				if (plugin.hydras.containsKey(hydra.getIndex())) {
					int val = plugin.hydras.get(hydra.getIndex());
					if (val != 0) {
						if (config.BoldText()) {
							graphics.setFont(FontManager.getRunescapeBoldFont());
						}
						if (plugin.hydraattacks.containsKey(hydra.getIndex())) {
							int attack = plugin.hydraattacks.get(hydra.getIndex());
							if (attack == 8261) {
								if (val == 3) {
									OverlayUtil.renderTextLocation(graphics, hydra.getCanvasTextLocation(graphics, "MAGE", hydra.getLogicalHeight() + 100), "MAGE", Color.BLUE);
								} else {
									OverlayUtil.renderTextLocation(graphics, hydra.getCanvasTextLocation(graphics, "RANGE", hydra.getLogicalHeight() + 100), "RANGE", Color.GREEN);
								}
							} else if (attack == 8262) {
								if (val == 3) {
									OverlayUtil.renderTextLocation(graphics, hydra.getCanvasTextLocation(graphics, "RANGE", hydra.getLogicalHeight() + 100), "RANGE", Color.GREEN);
								} else {
									OverlayUtil.renderTextLocation(graphics, hydra.getCanvasTextLocation(graphics, "MAGE", hydra.getLogicalHeight() + 100), "MAGE", Color.BLUE);
								}
							}
						}
						Point runelitepleaseexplainwhyineedtocheckthisfornullinsteadoftheentirehydravariablethisshitcostmelikeanhourofmylifeandiblameyouadam = hydra.getCanvasTextLocation(graphics, Integer.toString(val), hydra.getLogicalHeight() + 40);
						if (runelitepleaseexplainwhyineedtocheckthisfornullinsteadoftheentirehydravariablethisshitcostmelikeanhourofmylifeandiblameyouadam != null) {
							OverlayUtil.renderTextLocation(graphics, runelitepleaseexplainwhyineedtocheckthisfornullinsteadoftheentirehydravariablethisshitcostmelikeanhourofmylifeandiblameyouadam, Integer.toString(val), Color.WHITE);
						}
					}
				}
			}

		}
		graphics.setFont(FontManager.getRunescapeFont());
		return null;
	}
}
