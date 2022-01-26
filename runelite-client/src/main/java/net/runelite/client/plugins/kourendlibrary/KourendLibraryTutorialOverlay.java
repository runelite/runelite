/*
 * Copyright (c) 2019 Hydrox6 <ikada@protonmail.ch>
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
package net.runelite.client.plugins.kourendlibrary;

import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.LineComponent;

class KourendLibraryTutorialOverlay extends OverlayPanel
{
	private final Client client;
	private final KourendLibraryConfig config;
	private final Library library;

	private final LineComponent noDataMessageComponent;
	private final LineComponent incompleteMessageComponent;
	private final LineComponent completeMessageComponent;
	private final LineComponent sidebarMessageComponent;

	@Inject
	private KourendLibraryTutorialOverlay(Client client, KourendLibraryConfig config, Library library)
	{
		this.client = client;
		this.config = config;
		this.library = library;

		panelComponent.setPreferredSize(new Dimension(177, 0));

		noDataMessageComponent = LineComponent.builder().left("Click on the white squares to start finding books.").build();
		incompleteMessageComponent = LineComponent.builder().left("Some books have been found. Keep checking marked bookcases to find more.").build();
		completeMessageComponent = LineComponent.builder().left("All books found.").build();
		sidebarMessageComponent = LineComponent.builder().left("Locations are in the sidebar.").build();

		setPriority(OverlayPriority.LOW);
		setPosition(OverlayPosition.TOP_LEFT);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.showTutorialOverlay())
		{
			return null;
		}

		Player player = client.getLocalPlayer();
		if (player == null)
		{
			return null;
		}

		WorldPoint playerLoc = player.getWorldLocation();
		if (playerLoc.getRegionID() != KourendLibraryPlugin.REGION)
		{
			return null;
		}

		switch (library.getState())
		{
			case NO_DATA:
				panelComponent.getChildren().add(noDataMessageComponent);
				break;
			case INCOMPLETE:
				panelComponent.getChildren().add(incompleteMessageComponent);
				panelComponent.getChildren().add(sidebarMessageComponent);
				break;
			case COMPLETE:
				panelComponent.getChildren().add(completeMessageComponent);
				panelComponent.getChildren().add(sidebarMessageComponent);
				break;
		}

		return super.render(graphics);
	}
}
