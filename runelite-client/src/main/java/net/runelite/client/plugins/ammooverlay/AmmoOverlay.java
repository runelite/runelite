package net.runelite.client.plugins.ammooverlay;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.ItemComposition;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.util.StackFormatter;
import javax.inject.Inject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;

@Slf4j
public class AmmoOverlay extends Overlay
{
	private final Client client;
	private final AmmoOverlayPlugin plugin;
	private final AmmoOverlayConfig config;

	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	private AmmoOverlay(Client client, AmmoOverlayPlugin plugin, AmmoOverlayConfig config)
	{
		setPosition(OverlayPosition.ABOVE_CHATBOX_RIGHT);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		panelComponent.getChildren().clear();

		if (config.showOnlyIfRangeWeaponEquipped())
		{
			final ItemComposition item = client.getItemDefinition(plugin.getEquippedWeaponID());

			if (item == null || !item.getName().toLowerCase().contains("bow"))
			{
				return null;
			}
		}

		final int ammoCount = plugin.getAmmoCount();
		final String ammoCountString = StackFormatter.quantityToStackSize(ammoCount);

		panelComponent.getChildren().add(LineComponent.builder()
				.left("Ammo:").leftColor(Color.WHITE)
				.right(ammoCountString)
				.rightColor(ammoCount > config.lowAmmoQuantity() ? Color.GREEN : Color.RED)
				.build());

		panelComponent.setPreferredSize(new Dimension(
				graphics.getFontMetrics().stringWidth("Ammo: " + ammoCountString) + 16,
				0));

		return panelComponent.render(graphics);
	}
}
