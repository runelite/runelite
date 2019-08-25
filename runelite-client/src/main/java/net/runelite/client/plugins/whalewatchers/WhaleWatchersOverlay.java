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

import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.MenuOpcode;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.ComponentOrientation;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

/**
 * The overlay for the Damage Counter
 */

@Singleton
public class WhaleWatchersOverlay extends Overlay
{
	private final Client client;
	private final WhaleWatchersPlugin plugin;
	private final PanelComponent panelComponent;
	private String lastOpponent = "-";


	@Inject
	public WhaleWatchersOverlay(final Client client, final WhaleWatchersPlugin plugin)
	{
		OverlayMenuEntry resetMenuEntry = new OverlayMenuEntry(MenuOpcode.RUNELITE_OVERLAY,
			"Reset", "Damage Counter");
		this.getMenuEntries().add(resetMenuEntry);
		this.client = client;
		this.plugin = plugin;
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		setPriority(OverlayPriority.HIGHEST);
		setPosition(OverlayPosition.TOP_LEFT);
		this.setPreferredPosition(OverlayPosition.TOP_LEFT);
		panelComponent = new PanelComponent();
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		panelComponent.getChildren().clear();

		if (plugin.inCombat && plugin.isShowDamageCounter())
		{
			panelComponent.setOrientation(ComponentOrientation.HORIZONTAL);
			panelComponent.setWrapping(5);

			lastOpponent = client.getLocalPlayer().getInteracting() != null ?
				client.getLocalPlayer().getInteracting().getName() : lastOpponent;

			String damageTaken = "Damage Taken: " + plugin.damageTaken;
			String damageDealt = "Damage Dealt: " + plugin.damageDone;

			panelComponent.getChildren().add(TitleComponent.builder()
				.text(lastOpponent)
				.build());

			panelComponent.getChildren().add(TitleComponent.builder()
				.text(damageDealt)
				.build());

			panelComponent.getChildren().add(TitleComponent.builder()
				.text(damageTaken)
				.build());
		}
		else
		{
			panelComponent.getChildren().clear();
		}

		return panelComponent.render(graphics);
	}
}
