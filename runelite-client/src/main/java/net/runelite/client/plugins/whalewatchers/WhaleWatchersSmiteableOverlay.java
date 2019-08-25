/*******************************************************************************
 * Copyright (c) 2019. PKLite
 *  Redistributions and modifications of this software are permitted as long as this notice remains in its original unmodified state at the top of this file.
 *  If there are any questions comments, or feedback about this software, please direct all inquiries directly to the following authors:
 *
 *   PKLite discord: https://discord.gg/Dp3HuFM
 *   Written by PKLite(ST0NEWALL, others) <stonewall@stonewall@pklite.xyz>, 2019
 *
 ******************************************************************************/

package net.runelite.client.plugins.whalewatchers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

/**
 * The overlay for the smiteable warning
 */
@Singleton
public class WhaleWatchersSmiteableOverlay extends Overlay
{
	private final WhaleWatchersPlugin plugin;
	private final PanelComponent panelComponent;


	@Inject
	public WhaleWatchersSmiteableOverlay(final WhaleWatchersPlugin plugin)
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
				+ 20, 0));
		}
		else
		{
			panelComponent.getChildren().clear();
		}
		return panelComponent.render(graphics);
	}
}
