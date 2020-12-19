package net.runelite.client.plugins.inventoryvalue;

import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

import javax.inject.Inject;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;


public class InventoryValueOverlay extends Overlay {
	private Long inventoryValue;
	private final InventoryValueConfig inventoryValueConfig;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	private InventoryValueOverlay(InventoryValueConfig config) {
		setPosition(OverlayPosition.ABOVE_CHATBOX_RIGHT);
		this.inventoryValue = 0L;
		this.inventoryValueConfig = config;
	}

	@Override
	public Dimension render(Graphics2D graphics) {
		String titleText = "Inventory Value";
		String valueString = inventoryValueConfig.useHighAlchemyValue() ? "HA Price:" : "GE Price:";

		panelComponent.getChildren().clear();

		panelComponent.getChildren().add(TitleComponent.builder()
				.text(titleText)
				.color(Color.GREEN)
				.build());

		panelComponent.setPreferredSize(new Dimension(
				graphics.getFontMetrics().stringWidth(titleText) + 30,
				0
		));

		panelComponent.getChildren().add(LineComponent.builder()
				.left(valueString)
				.right(Long.toString(inventoryValue))
				.build());

		return panelComponent.render(graphics);
	}

	public void updateInventoryValue(final long newValue) {
		SwingUtilities.invokeLater(() -> inventoryValue = newValue);
	}
}
