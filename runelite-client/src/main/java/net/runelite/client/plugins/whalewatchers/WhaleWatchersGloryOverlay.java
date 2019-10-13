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
import net.runelite.api.ItemID;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.ImageComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.util.AsyncBufferedImage;

@Singleton
public class WhaleWatchersGloryOverlay extends Overlay
{
	private final WhaleWatchersPlugin plugin;
	private final PanelComponent panelComponent;

	@Inject
	private ItemManager itemManager;

	@Inject
	public WhaleWatchersGloryOverlay(final WhaleWatchersPlugin plugin)
	{
		this.plugin = plugin;
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		setPriority(OverlayPriority.HIGH);
		setPosition(OverlayPosition.DETACHED);
		panelComponent = new PanelComponent();
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		panelComponent.getChildren().clear();
		if (plugin.isDisplayGloryOverlay())
		{
			panelComponent.setBackgroundColor(Color.lightGray);
			final AsyncBufferedImage gloryImage = itemManager.getImage(ItemID.AMULET_OF_GLORY);

			panelComponent.getChildren().add(TitleComponent.builder()
				.text("Uncharged Glory")
				.color(Color.BLACK)
				.build());

			panelComponent.getChildren().add(new ImageComponent(gloryImage));
		}

		return panelComponent.render(graphics);
	}
}
