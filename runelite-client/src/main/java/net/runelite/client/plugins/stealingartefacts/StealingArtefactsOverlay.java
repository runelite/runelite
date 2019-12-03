/*
 * Copyright (c) 2017, honeyhoney <https://github.com/honeyhoney>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.stealingartefacts;

import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

import javax.inject.Inject;

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

		if (!plugin.isInPortPiscariliusRegion())
		{
			return null;
		}

		StealingArtefactState stealingArtefactState = plugin.getStealingArtefactState();

		final String stealingArtefactDescription = stealingArtefactState.getDescription();

		panelComponent.getChildren().add(TitleComponent.builder()
				.text("Stealing Artefacts")
				.build());

		if (stealingArtefactState == StealingArtefactState.FAILURE ||
				stealingArtefactState == StealingArtefactState.DELIVER_ARTEFACT ||
				stealingArtefactState == StealingArtefactState.NO_TASK)
		{
			panelComponent.getChildren().add(LineComponent.builder()
					.left("Status:")
					.right(stealingArtefactDescription)
					.build());
		}
		else
		{
			panelComponent.getChildren().add(LineComponent.builder()
					.left("Location:")
					.right(stealingArtefactDescription)
					.build());
		}

		return panelComponent.render(graphics);
	}
}
