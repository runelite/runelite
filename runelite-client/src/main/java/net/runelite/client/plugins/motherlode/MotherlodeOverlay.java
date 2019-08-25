/*
 * Copyright (c) 2018, Seth <Sethtroll3@gmail.com>
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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.time.Duration;
import java.time.Instant;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.ui.overlay.components.table.TableAlignment;
import net.runelite.client.ui.overlay.components.table.TableComponent;

@Singleton
class MotherlodeOverlay extends Overlay
{
	private final MotherlodePlugin plugin;
	private final MotherlodeSession motherlodeSession;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	MotherlodeOverlay(final MotherlodePlugin plugin, final MotherlodeSession motherlodeSession)
	{
		super(plugin);
		setPosition(OverlayPosition.TOP_LEFT);
		this.plugin = plugin;
		this.motherlodeSession = motherlodeSession;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isInMlm() || !plugin.isShowMiningStats())
		{
			return null;
		}

		MotherlodeSession session = motherlodeSession;

		if (session.getLastPayDirtMined() == null)
		{
			return null;
		}

		Duration statTimeout = Duration.ofMinutes(plugin.getStatTimeout());
		Duration sinceCut = Duration.between(session.getLastPayDirtMined(), Instant.now());

		if (sinceCut.compareTo(statTimeout) >= 0)
		{
			return null;
		}

		panelComponent.getChildren().clear();

		if (plugin.isShowMiningState())
		{
			if (plugin.isMining())
			{
				panelComponent.getChildren().add(TitleComponent.builder()
					.text("Mining")
					.color(Color.GREEN)
					.build());
			}
			else
			{
				panelComponent.getChildren().add(TitleComponent.builder()
					.text("NOT mining")
					.color(Color.RED)
					.build());
			}
		}

		TableComponent tableComponent = new TableComponent();
		tableComponent.setColumnAlignments(TableAlignment.LEFT, TableAlignment.RIGHT);

		tableComponent.addRow("Pay-dirt mined:", Integer.toString(session.getTotalMined()));
		tableComponent.addRow("Pay-dirt/hr:", session.getRecentMined() > 2 ? Integer.toString(session.getPerHour()) : "");

		panelComponent.getChildren().add(tableComponent);

		return panelComponent.render(graphics);
	}
}
