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
import java.time.Duration;
import java.time.Instant;
import javax.inject.Inject;
import javax.inject.Singleton;
import static net.runelite.api.MenuOpcode.RUNELITE_OVERLAY_CONFIG;
import net.runelite.client.ui.overlay.Overlay;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.ui.overlay.components.table.TableAlignment;
import net.runelite.client.ui.overlay.components.table.TableComponent;

@Singleton
public class MotherlodeGemOverlay extends Overlay
{
	private final MotherlodePlugin plugin;
	private final MotherlodeSession motherlodeSession;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	MotherlodeGemOverlay(final MotherlodePlugin plugin, final MotherlodeSession motherlodeSession)
	{
		super(plugin);
		setPosition(OverlayPosition.TOP_LEFT);
		this.plugin = plugin;
		this.motherlodeSession = motherlodeSession;
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Gem overlay"));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		MotherlodeSession session = motherlodeSession;

		if (session.getLastGemFound() == null || !plugin.isInMlm() || !plugin.isShowGemsFound())
		{
			return null;
		}

		Duration statTimeout = Duration.ofMinutes(plugin.getStatTimeout());
		Duration sinceCut = Duration.between(session.getLastGemFound(), Instant.now());

		if (sinceCut.compareTo(statTimeout) >= 0)
		{
			return null;
		}

		int diamondsFound = session.getDiamondsFound();
		int rubiesFound = session.getRubiesFound();
		int emeraldsFound = session.getEmeraldsFound();
		int sapphiresFound = session.getSapphiresFound();

		panelComponent.getChildren().clear();
		panelComponent.getChildren().add(TitleComponent.builder().text("Gems found").build());

		TableComponent tableComponent = new TableComponent();
		tableComponent.setColumnAlignments(TableAlignment.LEFT, TableAlignment.RIGHT);

		if (diamondsFound > 0)
		{
			tableComponent.addRow("Diamonds:", Integer.toString(diamondsFound));
		}

		if (rubiesFound > 0)
		{
			tableComponent.addRow("Rubies:", Integer.toString(rubiesFound));
		}

		if (emeraldsFound > 0)
		{
			tableComponent.addRow("Emeralds:", Integer.toString(emeraldsFound));
		}

		if (sapphiresFound > 0)
		{
			tableComponent.addRow("Sapphires:", Integer.toString(sapphiresFound));
		}

		panelComponent.getChildren().add(tableComponent);

		return panelComponent.render(graphics);
	}
}
