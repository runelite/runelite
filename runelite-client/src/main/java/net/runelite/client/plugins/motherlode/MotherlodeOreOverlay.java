/*
 * Copyright (c) 2018, Lars <lars.oernlo@gmail.com>
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
package net.runelite.client.plugins.motherlode;

import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

class MotherlodeOreOverlay extends Overlay
{
	private final MotherlodeSession session;
	private final MotherlodePlugin plugin;
	private final MotherlodeConfig config;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	MotherlodeOreOverlay(MotherlodeSession session, MotherlodePlugin plugin, MotherlodeConfig config)
	{
		setPosition(OverlayPosition.TOP_LEFT);
		this.session = session;
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isInMlm() || !config.showOresCollected())
		{
			return null;
		}

		MotherlodeSession session = plugin.getSession();

		int runiteCollected = session.getRuniteCollected();
		int adamantCollected = session.getAdamantCollected();
		int mithrilCollected = session.getMithrilCollected();
		int goldCollected = session.getGoldCollected();
		int coalCollected = session.getCoalCollected();
		int nuggetsCollected = session.getNuggetsCollected();

		if (runiteCollected == 0 && adamantCollected == 0 && mithrilCollected == 0 && goldCollected == 0
			&& coalCollected == 0 && nuggetsCollected == 0)
		{
			return null;
		}

		panelComponent.getChildren().clear();
		panelComponent.getChildren().add(TitleComponent.builder().text("Ores collected").build());

		if (runiteCollected > 0)
		{
			panelComponent.getChildren().add(LineComponent.builder()
				.left("Runite:")
				.right(Integer.toString(runiteCollected))
				.build());
		}

		if (adamantCollected > 0)
		{
			panelComponent.getChildren().add(LineComponent.builder()
				.left("Adamant:")
				.right(Integer.toString(adamantCollected))
				.build());
		}

		if (mithrilCollected > 0)
		{
			panelComponent.getChildren().add(LineComponent.builder()
				.left("Mithril:")
				.right(Integer.toString(mithrilCollected))
				.build());
		}

		if (goldCollected > 0)
		{
			panelComponent.getChildren().add(LineComponent.builder()
				.left("Gold:")
				.right(Integer.toString(goldCollected))
				.build());
		}

		if (coalCollected > 0)
		{
			panelComponent.getChildren().add(LineComponent.builder()
				.left("Coal:")
				.right(Integer.toString(coalCollected))
				.build());
		}

		if (nuggetsCollected > 0)
		{
			panelComponent.getChildren().add(LineComponent.builder()
				.left("Nuggets:")
				.right(Integer.toString(nuggetsCollected))
				.build());
		}


		return panelComponent.render(graphics);
	}
}
